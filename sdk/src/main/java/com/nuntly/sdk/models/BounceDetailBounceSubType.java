package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum BounceDetailBounceSubType {
  @SerializedName("Undetermined")
  UNDETERMINED("Undetermined"),
  @SerializedName("General")
  GENERAL("General"),
  @SerializedName("NoEmail")
  NO_EMAIL("NoEmail"),
  @SerializedName("Suppressed")
  SUPPRESSED("Suppressed"),
  @SerializedName("OnAccountSuppressionList")
  ON_ACCOUNT_SUPPRESSION_LIST("OnAccountSuppressionList"),
  @SerializedName("MailboxFull")
  MAILBOX_FULL("MailboxFull"),
  @SerializedName("MessageTooLarge")
  MESSAGE_TOO_LARGE("MessageTooLarge"),
  @SerializedName("CustomTimeoutExceeded")
  CUSTOM_TIMEOUT_EXCEEDED("CustomTimeoutExceeded"),
  @SerializedName("ContentRejected")
  CONTENT_REJECTED("ContentRejected"),
  @SerializedName("AttachmentRejected")
  ATTACHMENT_REJECTED("AttachmentRejected");

  private final String value;

  BounceDetailBounceSubType(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static BounceDetailBounceSubType fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown BounceDetailBounceSubType: " + value);
  }
}
