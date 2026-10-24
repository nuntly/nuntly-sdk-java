package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
public enum EmailStatus {
  @SerializedName("queued")
  QUEUED("queued"),
  @SerializedName("scheduled")
  SCHEDULED("scheduled"),
  @SerializedName("processed")
  PROCESSED("processed"),
  @SerializedName("failed")
  FAILED("failed"),
  @SerializedName("sending")
  SENDING("sending"),
  @SerializedName("sent")
  SENT("sent"),
  @SerializedName("delivered")
  DELIVERED("delivered"),
  @SerializedName("bounced")
  BOUNCED("bounced"),
  @SerializedName("complained")
  COMPLAINED("complained"),
  @SerializedName("canceled")
  CANCELED("canceled"),
  @SerializedName("rejected")
  REJECTED("rejected"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  EmailStatus(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static EmailStatus fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
