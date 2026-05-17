package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum MessageRejectedEventDataReason {
  @SerializedName("inbox_storage_limit_exceeded")
  INBOX_STORAGE_LIMIT_EXCEEDED("inbox_storage_limit_exceeded"),
  @SerializedName("message_too_large")
  MESSAGE_TOO_LARGE("message_too_large");

  private final String value;

  MessageRejectedEventDataReason(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static MessageRejectedEventDataReason fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown MessageRejectedEventDataReason: " + value);
  }
}
