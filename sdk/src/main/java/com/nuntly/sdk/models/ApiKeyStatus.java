package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
public enum ApiKeyStatus {
  @SerializedName("enabled")
  ENABLED("enabled"),
  @SerializedName("disabled")
  DISABLED("disabled"),
  @SerializedName("revoked")
  REVOKED("revoked"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  ApiKeyStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static ApiKeyStatus fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
