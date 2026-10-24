package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * Query parameters of {@code nuntly.emails().list(...)}.
 *
 * @param cursor The cursor to retrieve the next page of results
 * @param limit The maximum number of results to return
 */
public record EmailsListParams(Optional<String> cursor, Optional<Integer> limit) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String cursor;
    private Integer limit;

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

    public EmailsListParams build() {
      return new EmailsListParams(Optional.ofNullable(cursor), Optional.ofNullable(limit));
    }
  }
}
