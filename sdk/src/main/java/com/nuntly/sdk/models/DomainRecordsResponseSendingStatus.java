package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum DomainRecordsResponseSendingStatus {
  @SerializedName("enabled")
  ENABLED("enabled"),
  @SerializedName("disabled")
  DISABLED("disabled"),
  @SerializedName("paused")
  PAUSED("paused");

  private final String value;

  DomainRecordsResponseSendingStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static DomainRecordsResponseSendingStatus fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown DomainRecordsResponseSendingStatus: " + value);
  }
}
