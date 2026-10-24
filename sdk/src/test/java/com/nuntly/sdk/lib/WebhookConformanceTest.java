package com.nuntly.sdk.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/** Runs conformance/webhook.json against {@link Webhook#verify}. */
class WebhookConformanceTest {

  // The vectors are in conformance/ at the repository root, the nearest ancestor that has one.
  private static JsonObject vectors(String file) throws IOException {
    for (var dir = Path.of("").toAbsolutePath(); dir != null; dir = dir.getParent()) {
      var path = dir.resolve("conformance").resolve(file);
      if (Files.exists(path))
        return JsonParser.parseString(Files.readString(path)).getAsJsonObject();
    }
    throw new IOException("conformance/" + file + " not found");
  }

  @TestFactory
  Stream<DynamicTest> webhook() throws IOException {
    return vectors("webhook.json").getAsJsonArray("cases").asList().stream()
        .map(JsonElement::getAsJsonObject)
        .filter(
            c ->
                !c.has("runtimes")
                    || c.getAsJsonArray("runtimes").asList().stream()
                        .anyMatch(r -> r.getAsString().equals("java")))
        .map(c -> DynamicTest.dynamicTest(c.get("name").getAsString(), () -> run(c)));
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
      assertThrows(
          WebhookVerificationError.class,
          () -> Webhook.verify(payload, header, secret, tolerance, clock));
      return;
    }
    var event = Webhook.verify(payload, header, secret, tolerance, clock);
    assertEquals(expected.get("eventType").getAsString(), event.type());
    assertEquals(expected.get("eventId").getAsString(), event.id());
  }
}
