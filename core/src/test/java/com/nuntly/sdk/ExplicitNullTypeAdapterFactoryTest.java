package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ExplicitNullTypeAdapterFactoryTest {

  public record Patch(
      JsonNullable<String> templateId,
      JsonNullable<String> topicId,
      Optional<String> from,
      Map<String, Object> properties) {}

  private static final Gson GSON =
      new GsonBuilder()
          .registerTypeAdapterFactory(new OptionalTypeAdapterFactory())
          .registerTypeAdapterFactory(new ExplicitNullTypeAdapterFactory())
          .create();

  @Test
  void writesExplicitNullAndOmitsAbsentFields() {
    var json =
        GSON.toJson(
            new Patch(JsonNullable.ofNull(), JsonNullable.absent(), Optional.empty(), null));
    assertEquals("{\"templateId\":null}", json);
  }

  @Test
  void writesPresentValue() {
    var json =
        GSON.toJson(
            new Patch(
                JsonNullable.of("tpl_1"), JsonNullable.ofNull(), Optional.of("a@b.com"), null));
    assertEquals("{\"templateId\":\"tpl_1\",\"topicId\":null,\"from\":\"a@b.com\"}", json);
  }

  public record Item(JsonNullable<String> note, Optional<String> label) {}

  @Test
  void keepsAbsentFieldsInsideMapValuesOmitted() {
    var properties = new HashMap<String, Object>();
    properties.put("item", new Item(JsonNullable.absent(), Optional.empty()));
    var json =
        GSON.toJson(
            new Patch(JsonNullable.absent(), JsonNullable.absent(), Optional.empty(), properties));
    assertEquals("{\"properties\":{\"item\":{}}}", json);
  }

  @Test
  void ofNullableLeavesANullValueOut() {
    assertEquals(JsonNullable.absent(), JsonNullable.ofNullable(null));
    assertEquals(JsonNullable.of("x"), JsonNullable.ofNullable("x"));
  }

  @Test
  void dropsNullValuesOfAPlainMap() {
    var properties = new HashMap<String, Object>();
    properties.put("plan", null);
    var json =
        GSON.toJson(
            new Patch(JsonNullable.absent(), JsonNullable.absent(), Optional.empty(), properties));
    assertEquals("{\"properties\":{}}", json);
  }

  public record Contact(
      @JsonAdapter(ExplicitNullTypeAdapterFactory.MapNullValues.class)
          Map<String, Object> properties) {}

  @Test
  void writesNullValuesOfAMapMarkedForThem() {
    var properties = new HashMap<String, Object>();
    properties.put("plan", null);
    assertEquals("{\"properties\":{\"plan\":null}}", GSON.toJson(new Contact(properties)));
    assertEquals("{}", GSON.toJson(new Contact(null)));
  }
}
