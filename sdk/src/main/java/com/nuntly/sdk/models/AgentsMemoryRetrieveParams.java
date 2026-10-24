package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * Query parameters of {@code nuntly.agents().memory().retrieve(...)}.
 *
 * @param inboxId The id of an inbox in your organization. Scopes memory to that inbox.
 * @param threadId The id of a thread in your organization. Scopes memory to that thread.
 */
public record AgentsMemoryRetrieveParams(Optional<String> inboxId, Optional<String> threadId) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String inboxId;
    private String threadId;

    /** The id of an inbox in your organization. Scopes memory to that inbox. */
    public Builder inboxId(String inboxId) {
      this.inboxId = inboxId;
      return this;
    }

    /** The id of a thread in your organization. Scopes memory to that thread. */
    public Builder threadId(String threadId) {
      this.threadId = threadId;
      return this;
    }

    public AgentsMemoryRetrieveParams build() {
      return new AgentsMemoryRetrieveParams(
          Optional.ofNullable(inboxId), Optional.ofNullable(threadId));
    }
  }
}
