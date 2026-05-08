package com.nuntly.sdk.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HexFormat;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.junit.jupiter.api.Test;

class WebhookTest {

  private static final String SECRET = "whsec_test_secret";
  private static final String PAYLOAD =
      "{\"id\":\"evt_1\",\"createdAt\":\"2026-03-29T00:00:00Z\","
          + "\"type\":\"email.delivered\",\"data\":{\"id\":\"em_1\"}}";

  private static String sign(String payload, long ts, String secret) throws Exception {
    var rawKey = secret.startsWith("whsec_") ? secret.substring(6) : secret;
    var mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec(rawKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
    var digest = mac.doFinal((ts + "." + payload).getBytes(StandardCharsets.UTF_8));
    return HexFormat.of().formatHex(digest);
  }

  private static String header(String payload, String secret, long ts) throws Exception {
    return "t=" + ts + ",v0=" + sign(payload, ts, secret);
  }

  @Test
  void verifiesValidSignatureAndReturnsTypedEvent() throws Exception {
    var ts = System.currentTimeMillis() / 1000L;
    var event = Webhook.verify(PAYLOAD, header(PAYLOAD, SECRET, ts), SECRET);
    assertEquals("email.delivered", event.type());
    assertEquals("evt_1", event.id());
    assertEquals("em_1", event.data().get("id").getAsString());
  }

  @Test
  void acceptsSecretWithoutWhsecPrefix() throws Exception {
    var ts = System.currentTimeMillis() / 1000L;
    var headerWithPrefix = header(PAYLOAD, SECRET, ts);
    var event = Webhook.verify(PAYLOAD, headerWithPrefix, "test_secret");
    assertEquals("email.delivered", event.type());
  }

  @Test
  void acceptsSecondSignatureForKeyRotation() throws Exception {
    var ts = System.currentTimeMillis() / 1000L;
    var validSig = sign(PAYLOAD, ts, SECRET);
    var headerWithRotation = "t=" + ts + ",v0=00deadbeef,v0=" + validSig;
    var event = Webhook.verify(PAYLOAD, headerWithRotation, SECRET);
    assertEquals("email.delivered", event.type());
  }

  @Test
  void rejectsInvalidSignature() {
    var ts = System.currentTimeMillis() / 1000L;
    assertThrows(
        WebhookVerificationError.class,
        () -> Webhook.verify(PAYLOAD, "t=" + ts + ",v0=deadbeef", SECRET));
  }

  @Test
  void rejectsExpiredTimestamp() throws Exception {
    var old = (System.currentTimeMillis() / 1000L) - 600;
    var headerOld = header(PAYLOAD, SECRET, old);
    var ex =
        assertThrows(
            WebhookVerificationError.class, () -> Webhook.verify(PAYLOAD, headerOld, SECRET));
    assertTrue(ex.getMessage().contains("too old"));
  }

  @Test
  void rejectsHeaderMissingTimestamp() {
    assertThrows(
        WebhookVerificationError.class,
        () -> Webhook.verify(PAYLOAD, "v0=deadbeef,v0=cafebabe", SECRET));
  }

  @Test
  void rejectsHeaderMissingV0Signature() {
    var ts = System.currentTimeMillis() / 1000L;
    var ex =
        assertThrows(
            WebhookVerificationError.class,
            () -> Webhook.verify(PAYLOAD, "t=" + ts + ",v1=deadbeef", SECRET));
    assertTrue(ex.getMessage().contains("No v0 signature"));
  }

  @Test
  void respectsCustomTolerance() throws Exception {
    var old = (System.currentTimeMillis() / 1000L) - 60;
    var headerOld = header(PAYLOAD, SECRET, old);

    // 30s tolerance: 60s old should fail
    assertThrows(
        WebhookVerificationError.class,
        () -> Webhook.verify(PAYLOAD, headerOld, SECRET, Duration.ofSeconds(30)));

    // 120s tolerance: 60s old should pass
    var event = Webhook.verify(PAYLOAD, headerOld, SECRET, Duration.ofSeconds(120));
    assertEquals("email.delivered", event.type());
  }
}
