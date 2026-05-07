package com.nuntly.sdk;

public sealed class NuntlyError extends RuntimeException permits ApiError, ConnectionError {

  public NuntlyError(String message) {
    super(message);
  }

  public NuntlyError(String message, Throwable cause) {
    super(message, cause);
  }
}
