package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum WebhookEventDeliveriesResponseItemStatus {
  @SerializedName("pending")
  PENDING("pending"),
  @SerializedName("success")
  SUCCESS("success"),
  @SerializedName("failed")
  FAILED("failed");

  private final String value;

  WebhookEventDeliveriesResponseItemStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static WebhookEventDeliveriesResponseItemStatus fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException(
        "Unknown WebhookEventDeliveriesResponseItemStatus: " + value);
  }
}
