package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.emails().bulk().send(CreateBulkEmailsRequest.builder()
 *     .emails(List.of(CreateBulkEmail.builder().from("Tomlinson AI <ray@info.tomlinson.ai>").to(List.of("brian67@gmail.com")).subject("Verify your email address").text("Thank you for signing up! Please verify your email address.").build()))
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
