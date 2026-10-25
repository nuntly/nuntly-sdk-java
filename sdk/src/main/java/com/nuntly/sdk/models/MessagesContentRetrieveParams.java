package com.nuntly.sdk.models;

import com.nuntly.sdk.NuntlyError;
import java.util.List;

/**
 * Query parameters of {@code nuntly.messages().content().retrieve(...)}.
 *
 * @param format Content formats to retrieve. Defaults to `html` only.
 */
public record MessagesContentRetrieveParams(List<MessageContentQueryFormat> format) {
  public MessagesContentRetrieveParams {
    if (format != null) {
      try {
        format = List.copyOf(format);
      } catch (NullPointerException e) {
        throw new NuntlyError("format must not contain null.");
      }
      if (format.isEmpty()) {
        throw new NuntlyError("format must not be empty: leave it out to get the default.");
      }
    }
  }

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
