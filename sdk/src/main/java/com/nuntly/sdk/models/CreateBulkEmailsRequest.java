package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.emails().bulk().send(CreateBulkEmailsRequest.builder()
 *     .emails("emails_value")
 *     .build());
 * }</pre>
 */
public record CreateBulkEmailsRequest(
    /** Used as a fallback field email value if no value is present in emails */
    java.util.Optional<java.util.Map<String, Object>> fallback,
    /** The bulk emails to send */
    java.util.List<java.util.Map<String, Object>> emails) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private java.util.Map<String, Object> fallback;
    private java.util.List<java.util.Map<String, Object>> emails;

    /** Used as a fallback field email value if no value is present in emails */
    public Builder fallback(java.util.Map<String, Object> fallback) {
      this.fallback = fallback;
      return this;
    }

    /** The bulk emails to send */
    public Builder emails(java.util.List<java.util.Map<String, Object>> emails) {
      this.emails = emails;
      return this;
    }

    public CreateBulkEmailsRequest build() {
      return new CreateBulkEmailsRequest(Optional.ofNullable(fallback), emails);
    }
  }
}
