package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * Query parameters of {@code nuntly.inboxes().list(...)}.
 *
 * @param cursor The cursor to retrieve the next page of results
 * @param limit The maximum number of results to return
 * @param namespaceId Filter by namespace.
 */
public record InboxesListParams(
    Optional<String> cursor, Optional<Integer> limit, Optional<String> namespaceId) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String cursor;
    private Integer limit;
    private String namespaceId;

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

    /** Filter by namespace. */
    public Builder namespaceId(String namespaceId) {
      this.namespaceId = namespaceId;
      return this;
    }

    public InboxesListParams build() {
      return new InboxesListParams(
          Optional.ofNullable(cursor),
          Optional.ofNullable(limit),
          Optional.ofNullable(namespaceId));
    }
  }
}
