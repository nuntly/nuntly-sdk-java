package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
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
  TEMPORARY_FAILURE("temporary_failure"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  DomainStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static DomainStatus fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
