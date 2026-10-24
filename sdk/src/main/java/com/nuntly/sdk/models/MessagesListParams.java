package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * Query parameters of {@code nuntly.messages().list(...)}.
 *
 * @param cursor The cursor to retrieve the next page of results
 * @param limit The maximum number of results to return
 * @param domainId Filter by domain.
 * @param from Filter by sender address.
 */
public record MessagesListParams(
    Optional<String> cursor,
    Optional<Integer> limit,
    Optional<String> domainId,
    Optional<String> from) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String cursor;
    private Integer limit;
    private String domainId;
    private String from;

    /** The cursor to retrieve the next page of results */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    /** The maximum number of results to return */
    public Builder limit(Integer limit) {
      this.limit = limit;
      return this;
    }

    /** Filter by domain. */
    public Builder domainId(String domainId) {
      this.domainId = domainId;
      return this;
    }

    /** Filter by sender address. */
    public Builder from(String from) {
      this.from = from;
      return this;
    }

    public MessagesListParams build() {
      return new MessagesListParams(
          Optional.ofNullable(cursor),
          Optional.ofNullable(limit),
          Optional.ofNullable(domainId),
          Optional.ofNullable(from));
    }
  }
}
