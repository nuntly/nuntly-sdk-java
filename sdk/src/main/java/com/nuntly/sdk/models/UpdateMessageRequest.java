package com.nuntly.sdk.models;

import java.util.List;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.messages().update(UpdateMessageRequest.builder()
 *     .build());
 * }</pre>
 *
 * @param addLabels Labels to add to the message.
 * @param removeLabels Labels to remove from the message.
 */
public record UpdateMessageRequest(List<String> addLabels, List<String> removeLabels) {

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
