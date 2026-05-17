package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum WebhookEventsResponseItemStatus {
  @SerializedName("success")
  SUCCESS("success"),
  @SerializedName("pending")
  PENDING("pending"),
  @SerializedName("failed")
  FAILED("failed");

  private final String value;

  WebhookEventsResponseItemStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static WebhookEventsResponseItemStatus fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown WebhookEventsResponseItemStatus: " + value);
  }
}
