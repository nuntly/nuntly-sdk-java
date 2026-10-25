package com.nuntly.sdk.models;

import com.nuntly.sdk.JsonNullable;
import java.util.List;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.threads().update("thr_01kabn43yqyxn2bx4ve84mczd3", UpdateThreadRequest.builder()
 *     .addLabels(List.of("urgent"))
 *     .build());
 * }</pre>
 *
 * @param addLabels Labels to add to all messages in the thread.
 * @param removeLabels Labels to remove from all messages in the thread.
 * @param agentId The AI agent identifier.
 */
public record UpdateThreadRequest(
    List<String> addLabels, List<String> removeLabels, JsonNullable<String> agentId) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private List<String> addLabels;
    private List<String> removeLabels;
    private JsonNullable<String> agentId = JsonNullable.absent();

    /** Labels to add to all messages in the thread. */
    public Builder addLabels(List<String> addLabels) {
      this.addLabels = addLabels;
      return this;
    }

    /** Labels to remove from all messages in the thread. */
    public Builder removeLabels(List<String> removeLabels) {
      this.removeLabels = removeLabels;
      return this;
    }

    /**
     * Sets {@code agentId}; {@code null} leaves it unset. Use {@link #clearAgentId()} to send null.
     */
    public Builder agentId(String agentId) {
      this.agentId = JsonNullable.ofNullable(agentId);
      return this;
    }

    /** Sends {@code agentId} as null. The AI agent identifier. */
    public Builder clearAgentId() {
      this.agentId = JsonNullable.ofNull();
      return this;
    }

    public UpdateThreadRequest build() {
      return new UpdateThreadRequest(addLabels, removeLabels, agentId);
    }
  }
}
