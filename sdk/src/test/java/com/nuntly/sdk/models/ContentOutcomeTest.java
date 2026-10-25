package com.nuntly.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.nuntly.sdk.NuntlyClient;
import org.junit.jupiter.api.Test;

class ContentOutcomeTest {

  @Test
  void readsAVariantByItsStatus() {
    assertEquals(
        new ContentOutcome.Absent(),
        NuntlyClient.defaultGson().fromJson("{\"status\":\"absent\"}", ContentOutcome.class));
  }

  // The deserializer itself, as a JsonDeserializer caller other than Gson.fromJson invokes it.
  @Test
  void aValueThatIsNotAnObjectIsAJsonSyntaxException() {
    for (var json : new String[] {"\"absent\"", "[]", "42"}) {
      var error =
          assertThrows(
              JsonSyntaxException.class,
              () ->
                  new ContentOutcome.Deserializer()
                      .deserialize(JsonParser.parseString(json), ContentOutcome.class, null),
              json);
      assertEquals("ContentOutcome is not an object", error.getMessage());
    }
  }
}
