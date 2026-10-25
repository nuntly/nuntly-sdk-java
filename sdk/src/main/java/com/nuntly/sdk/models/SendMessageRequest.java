package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.inboxes().messages().send("ibx_01kabn43yqyxn2bx4ve84mczd3", SendMessageRequest.builder()
 *     .to(List.of("brian67@gmail.com"))
 *     .subject("Verify your email address")
 *     .text("Thank you for signing up! Please verify your email address.")
 *     .html("<h1>Welcome</h1><p>Thank you for signing up! Please verify your email address.</p>")
 *     .build());
 * }</pre>
 *
 * @param to The recipient addresses.
 * @param cc The CC addresses.
 * @param bcc The BCC addresses.
 * @param subject The message subject.
 * @param text The plain text body.
 * @param html The HTML body.
 */
public record SendMessageRequest(
    List<String> to,
    List<String> cc,
    List<String> bcc,
    String subject,
    Optional<String> text,
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
