package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * Query parameters of {@code nuntly.threads().retrieve(...)}.
 *
 * @param markRead When true, removes the unread label from all messages in the thread.
 */
public record ThreadsRetrieveParams(Optional<Boolean> markRead) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Boolean markRead;

    /** When true, removes the unread label from all messages in the thread. */
    public Builder markRead(Boolean markRead) {
      this.markRead = markRead;
      return this;
    }

    public ThreadsRetrieveParams build() {
      return new ThreadsRetrieveParams(Optional.ofNullable(markRead));
    }
  }
}
