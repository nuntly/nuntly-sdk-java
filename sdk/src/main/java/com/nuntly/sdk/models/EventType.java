package com.nuntly.sdk.models;

public enum EventType {
  EMAIL_QUEUED("email.queued"),
  EMAIL_SCHEDULED("email.scheduled"),
  EMAIL_PROCESSED("email.processed"),
  EMAIL_SENDING("email.sending"),
  EMAIL_SENT("email.sent"),
  EMAIL_DELIVERED("email.delivered"),
  EMAIL_OPENED("email.opened"),
  EMAIL_CLICKED("email.clicked"),
  EMAIL_BOUNCED("email.bounced"),
  EMAIL_COMPLAINED("email.complained"),
  EMAIL_REJECTED("email.rejected"),
  EMAIL_DELIVERYDELAYED("email.deliveryDelayed"),
  EMAIL_FAILED("email.failed"),
  EMAIL_RENDERINGFAILED("email.renderingFailed"),
  EMAIL_SUBSCRIBED("email.subscribed"),
  EMAIL_UNSUBSCRIBED("email.unsubscribed"),
  MESSAGE_RECEIVED("message.received"),
  MESSAGE_SECURITY_FLAGGED("message.security.flagged"),
  MESSAGE_AGENT_TRIGGERED("message.agent.triggered"),
  MESSAGE_SENT("message.sent"),
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
