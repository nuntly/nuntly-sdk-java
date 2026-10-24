package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
public enum VariableDeclarationType {
  @SerializedName("string")
  STRING("string"),
  @SerializedName("number")
  NUMBER("number"),
  @SerializedName("boolean")
  BOOLEAN("boolean"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  VariableDeclarationType(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static VariableDeclarationType fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
