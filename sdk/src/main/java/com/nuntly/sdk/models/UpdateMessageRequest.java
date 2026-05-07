package com.nuntly.sdk.models;

import java.util.Optional;

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
    java.util.Optional<java.util.List<String>> addLabels,
    /** Labels to remove from the message. */
    java.util.Optional<java.util.List<String>> removeLabels) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private java.util.List<String> addLabels;
    private java.util.List<String> removeLabels;

    /** Labels to add to the message. */
    public Builder addLabels(java.util.List<String> addLabels) {
      this.addLabels = addLabels;
      return this;
    }

    /** Labels to remove from the message. */
    public Builder removeLabels(java.util.List<String> removeLabels) {
      this.removeLabels = removeLabels;
      return this;
    }

    public UpdateMessageRequest build() {
      return new UpdateMessageRequest(
          Optional.ofNullable(addLabels), Optional.ofNullable(removeLabels));
    }
  }
}
