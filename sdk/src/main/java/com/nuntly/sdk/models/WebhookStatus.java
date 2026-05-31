package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum WebhookStatus {
  @SerializedName("enabled")
  ENABLED("enabled"),
  @SerializedName("disabled")
  DISABLED("disabled"),
  @SerializedName("revoked")
  REVOKED("revoked");

  private final String value;

  WebhookStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static WebhookStatus fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown WebhookStatus: " + value);
  }
}
