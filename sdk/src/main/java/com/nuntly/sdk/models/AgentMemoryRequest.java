package com.nuntly.sdk.models;

import java.util.Map;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.agents().memory().upsert(AgentMemoryRequest.builder()
 *     .memory(Map.of())
 *     .build());
 * }</pre>
 */
public record AgentMemoryRequest(
    /** The inbox id to scope the memory to. */
    Optional<String> inboxId,
    /** The thread id to scope the memory to. */
    Optional<String> threadId,
    /** The agent memory key-value data. */
    Map<String, Object> memory,
    /** A human-readable conversation summary. */
    Optional<String> summary) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String inboxId;
    private String threadId;
    private Map<String, Object> memory;
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
    public Builder memory(Map<String, Object> memory) {
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
