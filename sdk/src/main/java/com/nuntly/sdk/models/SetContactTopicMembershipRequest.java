package com.nuntly.sdk.models;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.contacts().topics().update(SetContactTopicMembershipRequest.builder()
 *     .state(TopicMembershipState.SUBSCRIBED)
 *     .build());
 * }</pre>
 *
 * @param state The subscribe/unsubscribe state.
 */
public record SetContactTopicMembershipRequest(TopicMembershipState state) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private TopicMembershipState state;

    /** The subscribe/unsubscribe state. */
    public Builder state(TopicMembershipState state) {
      this.state = state;
      return this;
    }

    public SetContactTopicMembershipRequest build() {
      return new SetContactTopicMembershipRequest(state);
    }
  }
}
