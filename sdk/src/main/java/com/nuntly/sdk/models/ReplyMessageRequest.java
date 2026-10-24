package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.messages().reply(ReplyMessageRequest.builder()
 *     .replyAll(false)
 *     .build());
 * }</pre>
 *
 * @param text The plain text body.
 * @param html The HTML body.
 * @param replyAll Whether to reply to all recipients.
 */
public record ReplyMessageRequest(Optional<String> text, Optional<String> html, boolean replyAll) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String text;
    private String html;
    private boolean replyAll;

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
    public Builder replyAll(boolean replyAll) {
      this.replyAll = replyAll;
      return this;
    }

    public ReplyMessageRequest build() {
      return new ReplyMessageRequest(
          Optional.ofNullable(text), Optional.ofNullable(html), replyAll);
    }
  }
}
