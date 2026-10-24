package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.messages().forward(ForwardMessageRequest.builder()
 *     .to(List.of("user@example.com"))
 *     .build());
 * }</pre>
 *
 * @param to The recipient addresses to forward to.
 * @param text An optional comment to prepend.
 */
public record ForwardMessageRequest(List<String> to, Optional<String> text) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private List<String> to;
    private String text;

    /** The recipient addresses to forward to. */
    public Builder to(List<String> to) {
      this.to = to;
      return this;
    }

    /** An optional comment to prepend. */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public ForwardMessageRequest build() {
      return new ForwardMessageRequest(to, Optional.ofNullable(text));
    }
  }
}
