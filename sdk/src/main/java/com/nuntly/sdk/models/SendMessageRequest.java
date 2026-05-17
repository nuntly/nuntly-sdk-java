package com.nuntly.sdk.models;

import java.util.List;
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
    List<String> to,
    /** The CC addresses. */
    List<String> cc,
    /** The BCC addresses. */
    List<String> bcc,
    /** The message subject. */
    String subject,
    /** The plain text body. */
    Optional<String> text,
    /** The HTML body. */
    Optional<String> html) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private String text;
    private String html;

    /** The recipient addresses. */
    public Builder to(List<String> to) {
      this.to = to;
      return this;
    }

    /** The CC addresses. */
    public Builder cc(List<String> cc) {
      this.cc = cc;
      return this;
    }

    /** The BCC addresses. */
    public Builder bcc(List<String> bcc) {
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
          to, cc, bcc, subject, Optional.ofNullable(text), Optional.ofNullable(html));
    }
  }
}
