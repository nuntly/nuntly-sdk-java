package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
public enum BroadcastStatus {
  @SerializedName("draft")
  DRAFT("draft"),
  @SerializedName("scheduled")
  SCHEDULED("scheduled"),
  @SerializedName("queued")
  QUEUED("queued"),
  @SerializedName("sending")
  SENDING("sending"),
  @SerializedName("sent")
  SENT("sent"),
  @SerializedName("paused")
  PAUSED("paused"),
  @SerializedName("failed")
  FAILED("failed"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  BroadcastStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static BroadcastStatus fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
