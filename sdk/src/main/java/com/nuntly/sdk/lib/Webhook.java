package com.nuntly.sdk.lib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
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
  // Optional adapter is mandatory: webhook event records can contain
  // Optional<T> fields, and Gson's reflective fallback fails on JDK 17+
  // ("module java.base does not opens java.util to unnamed module").
  private static final Gson GSON =
      new GsonBuilder()
          .registerTypeAdapterFactory(new com.nuntly.sdk.OptionalTypeAdapterFactory())
          .create();

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

    return parseEvent(payload);
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

  private static WebhookEvent parseEvent(String payload) {
    var json = JsonParser.parseString(payload).getAsJsonObject();
    var type =
        json.has("type") && !json.get("type").isJsonNull() ? json.get("type").getAsString() : null;
    var recordClass = type != null ? WebhookEventRecords.BY_TYPE.get(type) : null;
    if (recordClass != null) {
      return GSON.fromJson(json, recordClass);
    }
    // Unknown event type: keep forward-compatibility by returning the raw shape.
    var id = json.has("id") && !json.get("id").isJsonNull() ? json.get("id").getAsString() : null;
    var createdAt =
        json.has("createdAt") && !json.get("createdAt").isJsonNull()
            ? json.get("createdAt").getAsString()
            : null;
    var data =
        json.has("data") && json.get("data").isJsonObject()
            ? json.get("data").getAsJsonObject()
            : new com.google.gson.JsonObject();
    return new UnknownWebhookEvent(id, createdAt, type, data);
  }
}
