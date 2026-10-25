package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
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

  private enum Plan {
    @SerializedName("pro")
    PRO
  }

  // An Iterable that is not a collection, like java.nio.file.Path, which iterates over itself.
  public record Labels(List<String> names) implements Iterable<String> {
    @Override
    public java.util.Iterator<String> iterator() {
      return names.iterator();
    }
  }

  @Test
  void writesAnIterableThatIsNotACollectionWithItsOwnAdapter() {
    var properties = new HashMap<String, Object>();
    properties.put("labels", new Labels(List.of("vip")));

    assertEquals(
        "{\"properties\":{\"labels\":{\"names\":[\"vip\"]}}}",
        GSON.toJson(new Contact(properties)));
  }

  @Test
  void writesNullsNestedInAnArray() {
    var address = new HashMap<String, Object>();
    address.put("line2", null);
    var properties = new HashMap<String, Object>();
    properties.put("history", new Object[] {address, null});

    assertEquals(
        "{\"properties\":{\"history\":[{\"line2\":null},null]}}",
        GSON.toJson(new Contact(properties)));
  }

  public record Tier(JsonNullable<Plan> plan) {}

  // Gson's enum adapter reads a value it does not know as null. Reading it as JsonNullable.ofNull()
  // would clear the field on the server when the record is copied into an update.
  @Test
  void readsAValueTheInnerAdapterCannotDecodeAsAbsent() {
    var tier = GSON.fromJson("{\"plan\":\"enterprise\"}", Tier.class);

    assertEquals(JsonNullable.absent(), tier.plan());
    assertEquals("{}", GSON.toJson(tier));
  }

  // Like JSON.stringify in the TypeScript SDK: a null at any depth is sent, an enum as its value.
  @Test
  void writesNullsNestedInAMapMarkedForThemAndEnumsAsTheirValue() {
    var address = new HashMap<String, Object>();
    address.put("line2", null);
    address.put("plan", Plan.PRO);
    var properties = new HashMap<String, Object>();
    properties.put("address", address);
    properties.put("history", List.of(address));

    assertEquals(
        "{\"properties\":{\"address\":{\"line2\":null,\"plan\":\"pro\"},"
            + "\"history\":[{\"line2\":null,\"plan\":\"pro\"}]}}",
        GSON.toJson(new Contact(properties)));
  }
}
