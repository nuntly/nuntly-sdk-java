package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum CreateApiKeyRequestPermission {
  @SerializedName("fullAccess")
  FULL_ACCESS("fullAccess"),
  @SerializedName("sendingAccess")
  SENDING_ACCESS("sendingAccess");

  private final String value;

  CreateApiKeyRequestPermission(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static CreateApiKeyRequestPermission fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown CreateApiKeyRequestPermission: " + value);
  }
}
