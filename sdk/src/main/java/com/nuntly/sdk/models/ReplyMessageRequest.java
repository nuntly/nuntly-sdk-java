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
 */
public record ReplyMessageRequest(
    /** The plain text body. */
    Optional<String> text,
    /** The HTML body. */
    Optional<String> html,
    /** Whether to reply to all recipients. */
    boolean replyAll) {

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
