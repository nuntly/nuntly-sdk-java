package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum UpdateApiKeyRequestStatus {
  @SerializedName("enabled")
  ENABLED("enabled"),
  @SerializedName("disabled")
  DISABLED("disabled");

  private final String value;

  UpdateApiKeyRequestStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static UpdateApiKeyRequestStatus fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown UpdateApiKeyRequestStatus: " + value);
  }
}
