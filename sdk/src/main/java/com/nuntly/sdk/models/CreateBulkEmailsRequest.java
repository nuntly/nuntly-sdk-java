package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.emails().bulk().send(CreateBulkEmailsRequest.builder()
 *     .emails(List.of())
 *     .build());
 * }</pre>
 */
public record CreateBulkEmailsRequest(
    /** Used as a fallback field email value if no value is present in emails */
    Map<String, Object> fallback,
    /** The bulk emails to send */
    List<Map<String, Object>> emails) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Map<String, Object> fallback;
    private List<Map<String, Object>> emails;

    /** Used as a fallback field email value if no value is present in emails */
    public Builder fallback(Map<String, Object> fallback) {
      this.fallback = fallback;
      return this;
    }

    /** The bulk emails to send */
    public Builder emails(List<Map<String, Object>> emails) {
      this.emails = emails;
      return this;
    }

    public CreateBulkEmailsRequest build() {
      return new CreateBulkEmailsRequest(fallback, emails);
    }
  }
}
