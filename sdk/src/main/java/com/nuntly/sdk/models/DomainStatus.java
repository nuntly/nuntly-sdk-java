package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum DomainStatus {
  @SerializedName("bootstrapping")
  BOOTSTRAPPING("bootstrapping"),
  @SerializedName("pending")
  PENDING("pending"),
  @SerializedName("success")
  SUCCESS("success"),
  @SerializedName("failed")
  FAILED("failed"),
  @SerializedName("temporary_failure")
  TEMPORARY_FAILURE("temporary_failure");

  private final String value;

  DomainStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static DomainStatus fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown DomainStatus: " + value);
  }
}
