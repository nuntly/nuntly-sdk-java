package com.nuntly.sdk;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;

public record RequestOptions(
    Optional<Duration> timeout,
    Optional<Integer> maxRetries,
    Map<String, String> headers,
    Optional<String> idempotencyKey) {
  public static RequestOptions none() {
    return new RequestOptions(Optional.empty(), Optional.empty(), Map.of(), Optional.empty());
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Duration timeout;
    private Integer maxRetries;
    private Map<String, String> headers = Map.of();
    private String idempotencyKey;

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

    /**
     * Set an explicit idempotency key for endpoints that support server-side deduplication. When
     * omitted, the SDK auto-generates a UUID v4 for {@code emails().send()} and {@code
     * emails().bulk().send()} so transient retries replay safely without duplicate sends.
     */
    public Builder idempotencyKey(String idempotencyKey) {
      this.idempotencyKey = idempotencyKey;
      return this;
    }

    public RequestOptions build() {
      return new RequestOptions(
          Optional.ofNullable(timeout),
          Optional.ofNullable(maxRetries),
          headers,
          Optional.ofNullable(idempotencyKey));
    }
  }
}
