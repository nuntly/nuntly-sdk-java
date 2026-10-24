package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.nuntly.sdk.ExplicitNullTypeAdapterFactory;
import com.nuntly.sdk.JsonNullable;
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
 *
 * @param inboxId The id of an inbox in your organization. Scopes memory to that inbox.
 * @param threadId The id of a thread in your organization. Scopes memory to that thread.
 * @param memory The agent memory key-value data.
 * @param summary A human-readable conversation summary.
 */
public record AgentMemoryRequest(
    Optional<String> inboxId,
    Optional<String> threadId,
    @JsonAdapter(ExplicitNullTypeAdapterFactory.MapNullValues.class) Map<String, Object> memory,
    JsonNullable<String> summary) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String inboxId;
    private String threadId;
    private Map<String, Object> memory;
    private JsonNullable<String> summary = JsonNullable.absent();

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

    /** The agent memory key-value data. */
    public Builder memory(Map<String, Object> memory) {
      this.memory = memory;
      return this;
    }

    /**
     * Sets {@code summary}; {@code null} leaves it unset. Use {@link #clearSummary()} to send null.
     */
    public Builder summary(String summary) {
      this.summary = JsonNullable.ofNullable(summary);
      return this;
    }

    /** Sends {@code summary} as null. A human-readable conversation summary. */
    public Builder clearSummary() {
      this.summary = JsonNullable.ofNull();
      return this;
    }

    public AgentMemoryRequest build() {
      return new AgentMemoryRequest(
          Optional.ofNullable(inboxId), Optional.ofNullable(threadId), memory, summary);
    }
  }
}
