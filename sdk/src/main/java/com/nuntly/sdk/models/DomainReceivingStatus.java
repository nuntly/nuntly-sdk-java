package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum DomainReceivingStatus {
  @SerializedName("disabled")
  DISABLED("disabled"),
  @SerializedName("bootstrapping")
  BOOTSTRAPPING("bootstrapping"),
  @SerializedName("pending")
  PENDING("pending"),
  @SerializedName("active")
  ACTIVE("active"),
  @SerializedName("failed")
  FAILED("failed");

  private final String value;

  DomainReceivingStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static DomainReceivingStatus fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown DomainReceivingStatus: " + value);
  }
}
