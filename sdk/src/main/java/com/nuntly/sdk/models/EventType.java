package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum EventType {
  @SerializedName("email.queued")
  EMAIL_QUEUED("email.queued"),
  @SerializedName("email.scheduled")
  EMAIL_SCHEDULED("email.scheduled"),
  @SerializedName("email.processed")
  EMAIL_PROCESSED("email.processed"),
  @SerializedName("email.sending")
  EMAIL_SENDING("email.sending"),
  @SerializedName("email.sent")
  EMAIL_SENT("email.sent"),
  @SerializedName("email.delivered")
  EMAIL_DELIVERED("email.delivered"),
  @SerializedName("email.opened")
  EMAIL_OPENED("email.opened"),
  @SerializedName("email.clicked")
  EMAIL_CLICKED("email.clicked"),
  @SerializedName("email.bounced")
  EMAIL_BOUNCED("email.bounced"),
  @SerializedName("email.complained")
  EMAIL_COMPLAINED("email.complained"),
  @SerializedName("email.rejected")
  EMAIL_REJECTED("email.rejected"),
  @SerializedName("email.deliveryDelayed")
  EMAIL_DELIVERY_DELAYED("email.deliveryDelayed"),
  @SerializedName("email.failed")
  EMAIL_FAILED("email.failed"),
  @SerializedName("email.renderingFailed")
  EMAIL_RENDERING_FAILED("email.renderingFailed"),
  @SerializedName("email.subscribed")
  EMAIL_SUBSCRIBED("email.subscribed"),
  @SerializedName("email.unsubscribed")
  EMAIL_UNSUBSCRIBED("email.unsubscribed"),
  @SerializedName("message.received")
  MESSAGE_RECEIVED("message.received"),
  @SerializedName("message.security.flagged")
  MESSAGE_SECURITY_FLAGGED("message.security.flagged"),
  @SerializedName("message.agent.triggered")
  MESSAGE_AGENT_TRIGGERED("message.agent.triggered"),
  @SerializedName("message.sent")
  MESSAGE_SENT("message.sent"),
  @SerializedName("message.rejected")
  MESSAGE_REJECTED("message.rejected");

  private final String value;

  EventType(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static EventType fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown EventType: " + value);
  }
}
