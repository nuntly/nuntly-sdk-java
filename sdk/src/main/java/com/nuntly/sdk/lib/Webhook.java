package com.nuntly.sdk.lib;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.nuntly.sdk.NuntlyClient;
import com.nuntly.sdk.models.UnknownWebhookEvent;
import com.nuntly.sdk.models.WebhookEvent;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Clock;
import java.time.Duration;
import java.util.Arrays;
import java.util.HexFormat;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Verify the signature of an incoming Nuntly webhook and decode the typed event.
 *
 * <p>The signature header has the form:
 *
 * <pre>{@code
 * t=<unix-seconds>,v0=<sig1>[,<sig2>...]
 * }</pre>
 *
 * <p>During a signing secret rotation the header carries one signature per secret, so verification
 * succeeds with either the old or the new secret.
 *
 * <p>The signing secret may be passed with or without the {@code whsec_} prefix.
 *
 * <p>The returned {@link WebhookEvent} is a sealed type. Pattern-match on the concrete subtype to
 * handle each event, with {@link UnknownWebhookEvent} as a forward-compatible fallback for event
 * types this SDK version does not model as webhook events:
 *
 * <pre>{@code
 * var event = Webhook.verify(payload, signatureHeader, secret);
 * switch (event) {
 *   case EmailBouncedEvent e -> handleBounce(e);
 *   case MessageReceivedEvent e -> handleReceive(e);
 *   case UnknownWebhookEvent e -> log.warn("unknown event type: {}", e.type());
 *   default -> log.warn("unhandled event type: {}", event.type());
 * }
 * }</pre>
 */
public final class Webhook {
  static final Duration DEFAULT_TOLERANCE = Duration.ofMinutes(5);
  private static final String SECRET_PREFIX = "whsec_";
  // An event decodes like an API response, with the same adapters (Optional, JsonNullable).
  static final Gson GSON = NuntlyClient.defaultGson();

  private Webhook() {}

  public static WebhookEvent verify(String payload, String signatureHeader, String secret) {
    return verify(payload, signatureHeader, secret, DEFAULT_TOLERANCE);
  }

  public static WebhookEvent verify(
      String payload, String signatureHeader, String secret, Duration tolerance) {
    return verify(payload, signatureHeader, secret, tolerance, Clock.systemUTC());
  }

  static WebhookEvent verify(
      String payload, String signatureHeader, String secret, Duration tolerance, Clock clock) {
    if (signatureHeader == null || signatureHeader.isBlank()) {
      throw new WebhookVerificationError("Missing webhook signature header");
    }
    if (secret == null || secret.isBlank()) {
      throw new WebhookVerificationError("Missing webhook signing secret");
    }
    if (payload == null) {
      throw new WebhookVerificationError("Missing webhook payload");
    }

    var rawKey =
        secret.startsWith(SECRET_PREFIX) ? secret.substring(SECRET_PREFIX.length()) : secret;

    var parts = signatureHeader.split(",");
    if (parts.length < 2) {
      throw new WebhookVerificationError("Invalid signature header format");
    }
    var tsPart = parts[0];
    if (!tsPart.startsWith("t=")) {
      throw new WebhookVerificationError("Invalid signature header: missing timestamp");
    }
    var timestamp = tsPart.substring(2);
    long ts;
    try {
      ts = Long.parseLong(timestamp);
    } catch (NumberFormatException e) {
      throw new WebhookVerificationError("Invalid timestamp");
    }
    if (!withinTolerance(clock.instant().getEpochSecond(), ts, tolerance)) {
      throw new WebhookVerificationError("Webhook timestamp outside tolerance window");
    }

    // The server prefixes the signature list once (`v0=<sig1>,<sig2>`); other `key=` parts are
    // ignored.
    var candidates =
        Arrays.stream(parts, 1, parts.length)
            .map(s -> s.startsWith("v0=") ? s.substring(3) : s)
            .filter(s -> !s.isEmpty() && !s.contains("="))
            .toArray(String[]::new);
    if (candidates.length == 0) {
      throw new WebhookVerificationError("No v0 signature found in header");
    }

    var signedContent = timestamp + "." + payload;
    var expected = hmacSha256Hex(rawKey, signedContent);

    var matched = false;
    for (var sig : candidates) {
      if (timingSafeEquals(sig, expected)) {
        matched = true;
        break;
      }
    }
    if (!matched) {
      throw new WebhookVerificationError("Webhook signature verification failed");
    }

    return decode(payload, GSON);
  }

  // Only a malformed payload (JsonSyntaxException, also Gson's report of a wrong token type) is a
  // verification error. Anything else, JsonIOException included, is an SDK or setup bug and stays
  // visible as is.
  static WebhookEvent decode(String payload, Gson gson) {
    try {
      return parseEvent(payload, gson);
    } catch (JsonSyntaxException e) {
      throw new WebhookVerificationError("Invalid webhook payload", e);
    }
  }

  private static boolean withinTolerance(long now, long ts, Duration tolerance) {
    try {
      return Math.abs(Math.subtractExact(now, ts)) <= tolerance.toSeconds();
    } catch (ArithmeticException overflow) {
      return false;
    }
  }

  private static String hmacSha256Hex(String key, String data) {
    try {
      var mac = Mac.getInstance("HmacSHA256");
      mac.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
      var digest = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
      return HexFormat.of().formatHex(digest);
    } catch (Exception e) {
      throw new WebhookVerificationError("Failed to compute HMAC-SHA256: " + e.getMessage());
    }
  }

  private static boolean timingSafeEquals(String a, String b) {
    if (a.length() != b.length()) return false;
    return MessageDigest.isEqual(
        a.getBytes(StandardCharsets.UTF_8), b.getBytes(StandardCharsets.UTF_8));
  }

  private static WebhookEvent parseEvent(String payload, Gson gson) {
    var root = JsonParser.parseString(payload);
    if (!root.isJsonObject()) throw new JsonSyntaxException("Webhook payload is not a JSON object");
    var json = root.getAsJsonObject();
    var type = stringField(json, "type");
    var recordClass = type != null ? WebhookEventRecords.BY_TYPE.get(type) : null;
    if (recordClass != null) {
      return gson.fromJson(json, recordClass);
    }
    // Unknown event type: keep forward-compatibility by returning the raw shape.
    var data =
        json.has("data") && json.get("data").isJsonObject()
            ? json.get("data").getAsJsonObject()
            : new JsonObject();
    return new UnknownWebhookEvent(
        stringField(json, "id"), stringField(json, "createdAt"), type, data);
  }

  private static String stringField(JsonObject json, String name) {
    var value = json.get(name);
    if (value == null || value.isJsonNull()) return null;
    if (!value.isJsonPrimitive()) {
      throw new JsonSyntaxException("Webhook event " + name + " is not a string");
    }
    return value.getAsString();
  }
}
