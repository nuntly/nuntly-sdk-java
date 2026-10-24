package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum WebhookEventType {
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

  WebhookEventType(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static WebhookEventType fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown WebhookEventType: " + value);
  }
}
