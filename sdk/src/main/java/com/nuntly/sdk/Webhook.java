package com.nuntly.sdk;

import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
 * t=<unix-seconds>,v0=<hex-signature>[,v0=<additional-hex-signatures>]
 * }</pre>
 *
 * <p>The signing secret may be passed with or without the {@code whsec_} prefix.
 */
public final class Webhook {
  private static final Duration DEFAULT_TOLERANCE = Duration.ofMinutes(5);
  private static final String SECRET_PREFIX = "whsec_";

  private Webhook() {}

  public static WebhookEvent verify(String payload, String signatureHeader, String secret) {
    return verify(payload, signatureHeader, secret, DEFAULT_TOLERANCE);
  }

  public static WebhookEvent verify(
      String payload, String signatureHeader, String secret, Duration tolerance) {
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
    long ts;
    try {
      ts = Long.parseLong(tsPart.substring(2));
    } catch (NumberFormatException e) {
      throw new WebhookVerificationError("Invalid timestamp");
    }
    var ageSeconds = (System.currentTimeMillis() / 1000L) - ts;
    if (ageSeconds > tolerance.toSeconds()) {
      throw new WebhookVerificationError("Webhook timestamp is too old");
    }

    var candidates =
        Arrays.stream(parts, 1, parts.length)
            .filter(s -> s.startsWith("v0="))
            .map(s -> s.substring(3))
            .toArray(String[]::new);
    if (candidates.length == 0) {
      throw new WebhookVerificationError("No v0 signature found in header");
    }

    var signedContent = ts + "." + payload;
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
    var id = json.has("id") ? json.get("id").getAsString() : null;
    var createdAt = json.has("createdAt") ? json.get("createdAt").getAsString() : null;
    var type = json.has("type") ? json.get("type").getAsString() : null;
    var data =
        json.has("data") ? json.get("data").getAsJsonObject() : new com.google.gson.JsonObject();
    return new WebhookEvent(id, createdAt, type, data);
  }
}
