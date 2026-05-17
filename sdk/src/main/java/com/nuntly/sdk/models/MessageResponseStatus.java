package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum MessageResponseStatus {
  @SerializedName("received")
  RECEIVED("received"),
  @SerializedName("sent")
  SENT("sent"),
  @SerializedName("discarded")
  DISCARDED("discarded"),
  @SerializedName("failed")
  FAILED("failed");

  private final String value;

  MessageResponseStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static MessageResponseStatus fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown MessageResponseStatus: " + value);
  }
}
