package com.nuntly.sdk;

public final class WebhookVerificationError extends RuntimeException {
  public WebhookVerificationError(String message) {
    super(message);
  }
}
