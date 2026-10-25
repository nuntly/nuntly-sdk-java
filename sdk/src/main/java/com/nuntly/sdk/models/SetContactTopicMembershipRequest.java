package com.nuntly.sdk.models;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.contacts().topics().update("ct_01kabn43yqyxn2bx4ve84mczd3", "tpc_01kabn43yqyxn2bx4ve84mczd3", SetContactTopicMembershipRequest.builder()
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
