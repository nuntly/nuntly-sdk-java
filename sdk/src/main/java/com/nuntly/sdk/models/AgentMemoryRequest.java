package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.agents().memory().upsert(AgentMemoryRequest.builder()
 *     .memory("memory_value")
 *     .build());
 * }</pre>
 */
public record AgentMemoryRequest(
    /** The inbox id to scope the memory to. */
    java.util.Optional<String> inboxId,
    /** The thread id to scope the memory to. */
    java.util.Optional<String> threadId,
    /** The agent memory key-value data. */
    java.util.Map<String, Object> memory,
    /** A human-readable conversation summary. */
    java.util.Optional<String> summary) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String inboxId;
    private String threadId;
    private java.util.Map<String, Object> memory;
    private String summary;

    /** The inbox id to scope the memory to. */
    public Builder inboxId(String inboxId) {
      this.inboxId = inboxId;
      return this;
    }

    /** The thread id to scope the memory to. */
    public Builder threadId(String threadId) {
      this.threadId = threadId;
      return this;
    }

    /** The agent memory key-value data. */
    public Builder memory(java.util.Map<String, Object> memory) {
      this.memory = memory;
      return this;
    }

    /** A human-readable conversation summary. */
    public Builder summary(String summary) {
      this.summary = summary;
      return this;
    }

    public AgentMemoryRequest build() {
      return new AgentMemoryRequest(
          Optional.ofNullable(inboxId),
          Optional.ofNullable(threadId),
          memory,
          Optional.ofNullable(summary));
    }
  }
}
