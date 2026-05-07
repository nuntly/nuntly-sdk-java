package com.nuntly.sdk;

public non-sealed class ConnectionError extends NuntlyError {

  public ConnectionError(String message, Throwable cause) {
    super(message, cause);
  }

  public static final class TimeoutError extends ConnectionError {
    public TimeoutError(Throwable cause) {
      super("Request timed out", cause);
    }
  }
}
