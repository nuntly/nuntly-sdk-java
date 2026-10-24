package com.nuntly.sdk.models;

import java.util.List;

/**
 * Query parameters of {@code nuntly.messages().content().retrieve(...)}.
 *
 * @param format Content formats to retrieve. Defaults to `html` only.
 */
public record MessagesContentRetrieveParams(List<MessageContentQueryFormat> format) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private List<MessageContentQueryFormat> format;

    /** Content formats to retrieve. Defaults to `html` only. */
    public Builder format(List<MessageContentQueryFormat> format) {
      this.format = format;
      return this;
    }

    public MessagesContentRetrieveParams build() {
      return new MessagesContentRetrieveParams(format);
    }
  }
}
