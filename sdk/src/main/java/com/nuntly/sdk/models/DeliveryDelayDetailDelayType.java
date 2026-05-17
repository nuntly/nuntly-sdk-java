package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum DeliveryDelayDetailDelayType {
  @SerializedName("InternalFailure")
  INTERNAL_FAILURE("InternalFailure"),
  @SerializedName("General")
  GENERAL("General"),
  @SerializedName("MailboxFull")
  MAILBOX_FULL("MailboxFull"),
  @SerializedName("SpamDetected")
  SPAM_DETECTED("SpamDetected"),
  @SerializedName("RecipientServerError")
  RECIPIENT_SERVER_ERROR("RecipientServerError"),
  @SerializedName("IPFailure")
  IPFAILURE("IPFailure"),
  @SerializedName("TransientCommunicationFailure")
  TRANSIENT_COMMUNICATION_FAILURE("TransientCommunicationFailure"),
  @SerializedName("BYOIPHostNameLookupUnavailable")
  BYOIPHOST_NAME_LOOKUP_UNAVAILABLE("BYOIPHostNameLookupUnavailable"),
  @SerializedName("Undetermined")
  UNDETERMINED("Undetermined"),
  @SerializedName("SendingDeferral")
  SENDING_DEFERRAL("SendingDeferral");

  private final String value;

  DeliveryDelayDetailDelayType(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static DeliveryDelayDetailDelayType fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown DeliveryDelayDetailDelayType: " + value);
  }
}
