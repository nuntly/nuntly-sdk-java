package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.emails().bulk().send(CreateBulkEmailsRequest.builder()
 *     .emails(List.of())
 *     .build());
 * }</pre>
 *
 * @param fallback Used as a fallback field email value if no value is present in emails.
 * @param emails The bulk emails to send.
 */
public record CreateBulkEmailsRequest(
    Optional<CreateBulkFallback> fallback, List<CreateBulkEmail> emails) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private CreateBulkFallback fallback;
    private List<CreateBulkEmail> emails;

    /** Used as a fallback field email value if no value is present in emails. */
    public Builder fallback(CreateBulkFallback fallback) {
      this.fallback = fallback;
      return this;
    }

    /** The bulk emails to send. */
    public Builder emails(List<CreateBulkEmail> emails) {
      this.emails = emails;
      return this;
    }

    public CreateBulkEmailsRequest build() {
      return new CreateBulkEmailsRequest(Optional.ofNullable(fallback), emails);
    }
  }
}
