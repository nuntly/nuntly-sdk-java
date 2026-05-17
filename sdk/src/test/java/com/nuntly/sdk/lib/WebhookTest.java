package com.nuntly.sdk.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nuntly.sdk.models.EmailDeliveredEvent;
import com.nuntly.sdk.models.MessageReceivedEvent;
import com.nuntly.sdk.models.UnknownWebhookEvent;
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
    var delivered = assertInstanceOf(EmailDeliveredEvent.class, event);
    assertEquals("email.delivered", delivered.type());
    assertEquals("evt_1", delivered.id());
    // `data` is a typed EmailDeliveredEventData record now (was Map<String, Object>).
    // Missing JSON fields land as null; the `id` field is the one set in PAYLOAD.
    assertEquals("em_1", delivered.data().id());
  }

  @Test
  void decodesInboundEventDataForMessageEvents() throws Exception {
    var inboundPayload =
        "{\"id\":\"evt_in_1\",\"createdAt\":\"2026-03-29T00:00:00Z\","
            + "\"type\":\"message.received\","
            + "\"data\":{\"orgId\":\"org_1\",\"domainId\":\"dom_1\",\"domainName\":\"example.com\","
            + "\"inboxId\":\"in_1\",\"threadId\":\"th_1\",\"messageId\":\"imsg_1\","
            + "\"from\":\"sender@example.com\",\"subject\":\"hi\"}}";
    var ts = System.currentTimeMillis() / 1000L;
    var event = Webhook.verify(inboundPayload, header(inboundPayload, SECRET, ts), SECRET);
    var received = assertInstanceOf(MessageReceivedEvent.class, event);
    assertEquals("message.received", received.type());
    assertEquals("evt_in_1", received.id());
    assertEquals("imsg_1", received.data().messageId());
    assertEquals("dom_1", received.data().domainId());
  }

  @Test
  void unknownEventTypeFallsBackToUnknownWebhookEvent() throws Exception {
    var unknownPayload =
        "{\"id\":\"evt_x\",\"createdAt\":\"2026-03-29T00:00:00Z\","
            + "\"type\":\"email.totallyNew\",\"data\":{\"id\":\"em_x\"}}";
    var ts = System.currentTimeMillis() / 1000L;
    var event = Webhook.verify(unknownPayload, header(unknownPayload, SECRET, ts), SECRET);
    var unknown = assertInstanceOf(UnknownWebhookEvent.class, event);
    assertEquals("email.totallyNew", unknown.type());
    assertEquals("evt_x", unknown.id());
    assertEquals("em_x", unknown.data().get("id").getAsString());
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
