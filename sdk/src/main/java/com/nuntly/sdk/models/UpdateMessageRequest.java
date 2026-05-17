package com.nuntly.sdk.models;

import java.util.List;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.messages().update(UpdateMessageRequest.builder()
 *     .build());
 * }</pre>
 */
public record UpdateMessageRequest(
    /** Labels to add to the message. */
    List<String> addLabels,
    /** Labels to remove from the message. */
    List<String> removeLabels) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private List<String> addLabels;
    private List<String> removeLabels;

    /** Labels to add to the message. */
    public Builder addLabels(List<String> addLabels) {
      this.addLabels = addLabels;
      return this;
    }

    /** Labels to remove from the message. */
    public Builder removeLabels(List<String> removeLabels) {
      this.removeLabels = removeLabels;
      return this;
    }

    public UpdateMessageRequest build() {
      return new UpdateMessageRequest(addLabels, removeLabels);
    }
  }
}
