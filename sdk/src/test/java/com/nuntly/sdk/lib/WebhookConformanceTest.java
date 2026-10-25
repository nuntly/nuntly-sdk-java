package com.nuntly.sdk.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.gson.JsonObject;
import com.nuntly.sdk.Conformance;
import java.io.IOException;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/** Runs conformance/webhook.json against {@link Webhook#verify}. */
class WebhookConformanceTest {

  @TestFactory
  Stream<DynamicTest> webhook() throws IOException {
    return Conformance.each("webhook.json", WebhookConformanceTest::run);
  }

  private static void run(JsonObject c) {
    var input = c.getAsJsonObject("input");
    var expected = c.getAsJsonObject("expected");
    var clock = Clock.fixed(Instant.ofEpochSecond(input.get("now").getAsLong()), ZoneOffset.UTC);
    var tolerance =
        input.has("toleranceSeconds")
            ? Duration.ofSeconds(input.get("toleranceSeconds").getAsLong())
            : Webhook.DEFAULT_TOLERANCE;
    var payload = input.get("payload").getAsString();
    var header = input.get("header").getAsString();
    var secret = input.get("secret").getAsString();

    if (expected.get("outcome").getAsString().equals("reject")) {
      Conformance.assertAsserted(expected, "outcome");
      assertThrows(
          WebhookVerificationError.class,
          () -> Webhook.verify(payload, header, secret, tolerance, clock));
      return;
    }
    Conformance.assertAsserted(expected, "outcome", "eventType", "eventId");
    var event = Webhook.verify(payload, header, secret, tolerance, clock);
    assertEquals(expected.get("eventType").getAsString(), event.type());
    assertEquals(expected.get("eventId").getAsString(), event.id());
  }
}
