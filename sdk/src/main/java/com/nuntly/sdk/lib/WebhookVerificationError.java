package com.nuntly.sdk.lib;

public final class WebhookVerificationError extends RuntimeException {
  public WebhookVerificationError(String message) {
    super(message);
  }
}
