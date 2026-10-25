package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.messages().reply("imsg_01kabn43yqyxn2bx4ve84mczd3", ReplyMessageRequest.builder()
 *     .text("Thank you for signing up! Please verify your email address.")
 *     .html("<h1>Welcome</h1><p>Thank you for signing up! Please verify your email address.</p>")
 *     .build());
 * }</pre>
 *
 * @param text The plain text body.
 * @param html The HTML body.
 * @param replyAll Whether to reply to all recipients.
 */
public record ReplyMessageRequest(
    Optional<String> text, Optional<String> html, Optional<Boolean> replyAll) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String text;
    private String html;
    private Boolean replyAll;

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

    /** Whether to reply to all recipients. */
    public Builder replyAll(Boolean replyAll) {
      this.replyAll = replyAll;
      return this;
    }

    public ReplyMessageRequest build() {
      return new ReplyMessageRequest(
          Optional.ofNullable(text), Optional.ofNullable(html), Optional.ofNullable(replyAll));
    }
  }
}
