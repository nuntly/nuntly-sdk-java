package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class DefaultGsonNumbersTest {

  private static final long ABOVE_2_POW_53 = 9_007_199_254_740_993L;

  @Test
  void anIntegerAboveTwoToThe53InAMapValueKeepsItsExactValue() {
    Map<String, Object> memory =
        NuntlyClient.defaultGson()
            .fromJson(
                "{\"orderNumber\":9007199254740993,\"ratio\":1.5,\"ids\":[9007199254740993,7]}",
                new TypeToken<Map<String, Object>>() {}.getType());

    assertEquals(ABOVE_2_POW_53, memory.get("orderNumber"));
    assertEquals(1.5, memory.get("ratio"));
    assertEquals(List.of(ABOVE_2_POW_53, 7L), memory.get("ids"));
  }

  @Test
  void aNumberFieldReadsAnIntegerAsALong() {
    assertEquals(
        ABOVE_2_POW_53, NuntlyClient.defaultGson().fromJson("9007199254740993", Number.class));
  }
}
