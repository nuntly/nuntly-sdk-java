package com.nuntly.sdk;

public record BackoffStrategy(long initialIntervalMs, long maxIntervalMs, double exponent) {
  public static final BackoffStrategy DEFAULT = new BackoffStrategy(500, 8000, 2.0);

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private long initialIntervalMs = 500;
    private long maxIntervalMs = 8000;
    private double exponent = 2.0;

    public Builder initialIntervalMs(long ms) {
      this.initialIntervalMs = ms;
      return this;
    }

    public Builder maxIntervalMs(long ms) {
      this.maxIntervalMs = ms;
      return this;
    }

    public Builder exponent(double exp) {
      this.exponent = exp;
      return this;
    }

    public BackoffStrategy build() {
      return new BackoffStrategy(initialIntervalMs, maxIntervalMs, exponent);
    }
  }
}
