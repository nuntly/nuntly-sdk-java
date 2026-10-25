package com.nuntly.sdk;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;

/**
 * Options of one call, taken by every resource method except those that take {@link
 * IdempotentRequestOptions}.
 */
public record RequestOptions(
    Optional<Duration> timeout, Optional<Integer> maxRetries, Map<String, String> headers) {
  public static RequestOptions none() {
    return new RequestOptions(Optional.empty(), Optional.empty(), Map.of());
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Duration timeout;
    private Integer maxRetries;
    private Map<String, String> headers = Map.of();

    /**
     * Timeout of each attempt of this call, in place of the client timeout. {@link Duration#ZERO}
     * sets none for the attempt; opening a connection still follows the client timeout, which the
     * HTTP client applies to every call. A negative one throws {@link NuntlyError} when the call is
     * made.
     */
    public Builder timeout(Duration timeout) {
      this.timeout = timeout;
      return this;
    }

    public Builder maxRetries(int maxRetries) {
      this.maxRetries = maxRetries;
      return this;
    }

    public Builder headers(Map<String, String> headers) {
      this.headers = headers;
      return this;
    }

    public RequestOptions build() {
      return new RequestOptions(
          Optional.ofNullable(timeout), Optional.ofNullable(maxRetries), headers);
    }
  }
}
