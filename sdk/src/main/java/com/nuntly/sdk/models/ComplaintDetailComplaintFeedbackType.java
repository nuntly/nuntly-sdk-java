package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
public enum ComplaintDetailComplaintFeedbackType {
  @SerializedName("abuse")
  ABUSE("abuse"),
  @SerializedName("auth-failure")
  AUTH_FAILURE("auth-failure"),
  @SerializedName("fraud")
  FRAUD("fraud"),
  @SerializedName("not-spam")
  NOT_SPAM("not-spam"),
  @SerializedName("other")
  OTHER("other"),
  @SerializedName("virus")
  VIRUS("virus"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  ComplaintDetailComplaintFeedbackType(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static ComplaintDetailComplaintFeedbackType fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
