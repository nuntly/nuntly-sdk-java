package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
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
  FAILED("failed"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  DomainReceivingStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static DomainReceivingStatus fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
