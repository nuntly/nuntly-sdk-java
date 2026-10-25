package com.nuntly.sdk;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;

/**
 * Options of the methods whose endpoint deduplicates requests by {@code Idempotency-Key}: {@code
 * emails().send()}, {@code emails().bulk().send()}, {@code messages().reply()}, {@code
 * messages().forward()}, {@code inboxes().messages().send()}, {@code inboxes().create()}, {@code
 * broadcasts().create()} and {@code broadcasts().send()}.
 */
public record IdempotentRequestOptions(
    Optional<Duration> timeout,
    Optional<Integer> maxRetries,
    Map<String, String> headers,
    Optional<String> idempotencyKey) {
  public static IdempotentRequestOptions none() {
    return new IdempotentRequestOptions(
        Optional.empty(), Optional.empty(), Map.of(), Optional.empty());
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Duration timeout;
    private Integer maxRetries;
    private Map<String, String> headers = Map.of();
    private String idempotencyKey;

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

    /**
     * Key that deduplicates the request server-side. When omitted, the SDK generates a UUID v4 per
     * call and reuses it across that call's retries. Pass your own value to deduplicate across
     * processes.
     */
    public Builder idempotencyKey(String idempotencyKey) {
      this.idempotencyKey = idempotencyKey;
      return this;
    }

    public IdempotentRequestOptions build() {
      return new IdempotentRequestOptions(
          Optional.ofNullable(timeout),
          Optional.ofNullable(maxRetries),
          headers,
          Optional.ofNullable(idempotencyKey));
    }
  }
}
