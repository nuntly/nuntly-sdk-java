package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

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
  VIRUS("virus");

  private final String value;

  ComplaintDetailComplaintFeedbackType(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static ComplaintDetailComplaintFeedbackType fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown ComplaintDetailComplaintFeedbackType: " + value);
  }
}
