package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.junit.jupiter.api.Test;

class OpenEnumTypeAdapterFactoryTest {

  @JsonAdapter(OpenEnumTypeAdapterFactory.class)
  public enum Status {
    @SerializedName("on")
    ON,
    UNKNOWN
  }

  public record Holder(Status status, List<Status> history) {}

  private static final Gson GSON = new Gson();

  @Test
  void readsAValueTheSdkDoesNotKnowAsUnknown() {
    var holder =
        GSON.fromJson("{\"status\":\"paused\",\"history\":[\"on\",\"archived\"]}", Holder.class);
    assertEquals(Status.UNKNOWN, holder.status());
    assertEquals(List.of(Status.ON, Status.UNKNOWN), holder.history());
  }

  @Test
  void readsAKnownValueAsItsMember() {
    assertEquals(Status.ON, GSON.fromJson("{\"status\":\"on\"}", Holder.class).status());
  }

  @Test
  void readsNullAsNull() {
    assertNull(GSON.fromJson("{\"status\":null}", Holder.class).status());
  }

  @Test
  void writesAKnownMemberAsItsWireValue() {
    assertEquals("\"on\"", GSON.toJson(Status.ON));
  }

  // UNKNOWN has no wire value to write back: a response read with one serializes it as null.
  @Test
  void writesUnknownAsNullWithoutThrowing() {
    var holder =
        GSON.fromJson("{\"status\":\"paused\",\"history\":[\"on\",\"archived\"]}", Holder.class);
    assertEquals("{\"history\":[\"on\",null]}", GSON.toJson(holder));
  }
}
