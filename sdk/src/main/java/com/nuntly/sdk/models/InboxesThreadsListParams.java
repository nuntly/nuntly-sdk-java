package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * Query parameters of {@code nuntly.inboxes().threads().list(...)}.
 *
 * @param cursor The cursor to retrieve the next page of results
 * @param limit The maximum number of results to return, from 1 to 30. Defaults to 30.
 * @param labels Comma-separated labels to filter by (AND logic). Threads with spam/trash are
 *     excluded by default unless explicitly requested via ?labels=spam or ?labels=trash.
 */
public record InboxesThreadsListParams(
    Optional<String> cursor, Optional<Integer> limit, Optional<String> labels) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String cursor;
    private Integer limit;
    private String labels;

    /** The cursor to retrieve the next page of results */
    public Builder cursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    /** The maximum number of results to return, from 1 to 30. Defaults to 30. */
    public Builder limit(Integer limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Comma-separated labels to filter by (AND logic). Threads with spam/trash are excluded by
     * default unless explicitly requested via ?labels=spam or ?labels=trash.
     */
    public Builder labels(String labels) {
      this.labels = labels;
      return this;
    }

    public InboxesThreadsListParams build() {
      return new InboxesThreadsListParams(
          Optional.ofNullable(cursor), Optional.ofNullable(limit), Optional.ofNullable(labels));
    }
  }
}
