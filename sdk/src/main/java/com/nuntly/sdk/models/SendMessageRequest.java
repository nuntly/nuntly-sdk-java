package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.inboxes().messages().send(SendMessageRequest.builder()
 *     .to(List.of("user@example.com"))
 *     .subject("Welcome to Nuntly")
 *     .build());
 * }</pre>
 */
public record SendMessageRequest(
    /** The recipient addresses. */
    java.util.List<String> to,
    /** The CC addresses. */
    java.util.Optional<java.util.List<String>> cc,
    /** The BCC addresses. */
    java.util.Optional<java.util.List<String>> bcc,
    /** The message subject. */
    String subject,
    /** The plain text body. */
    java.util.Optional<String> text,
    /** The HTML body. */
    java.util.Optional<String> html) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private java.util.List<String> to;
    private java.util.List<String> cc;
    private java.util.List<String> bcc;
    private String subject;
    private String text;
    private String html;

    /** The recipient addresses. */
    public Builder to(java.util.List<String> to) {
      this.to = to;
      return this;
    }

    /** The CC addresses. */
    public Builder cc(java.util.List<String> cc) {
      this.cc = cc;
      return this;
    }

    /** The BCC addresses. */
    public Builder bcc(java.util.List<String> bcc) {
      this.bcc = bcc;
      return this;
    }

    /** The message subject. */
    public Builder subject(String subject) {
      this.subject = subject;
      return this;
    }

    /** The plain text body. */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /** The HTML body. */
    public Builder html(String html) {
      this.html = html;
      return this;
    }

    public SendMessageRequest build() {
      return new SendMessageRequest(
          to,
          Optional.ofNullable(cc),
          Optional.ofNullable(bcc),
          subject,
          Optional.ofNullable(text),
          Optional.ofNullable(html));
    }
  }
}
