package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.threads().update(UpdateThreadRequest.builder()
 *     .build());
 * }</pre>
 */
public record UpdateThreadRequest(
    /** Labels to add to all messages in the thread. */
    List<String> addLabels,
    /** Labels to remove from all messages in the thread. */
    List<String> removeLabels,
    /** The AI agent identifier. */
    Optional<String> agentId) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private List<String> addLabels;
    private List<String> removeLabels;
    private String agentId;

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

    /** The AI agent identifier. */
    public Builder agentId(String agentId) {
      this.agentId = agentId;
      return this;
    }

    public UpdateThreadRequest build() {
      return new UpdateThreadRequest(addLabels, removeLabels, Optional.ofNullable(agentId));
    }
  }
}
