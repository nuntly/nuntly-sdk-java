package com.nuntly.sdk.models;

/**
 * @param topicId The id of the topic.
 * @param state The subscribe/unsubscribe state.
 * @param source How this state was derived: an explicit membership record, the organization default
 *     (subscribed, when no record exists), or a platform-wide opt-out, which overrides every other
 *     source.
 */
public record ContactTopicMembershipsResponseItem(
    String topicId, TopicMembershipState state, TopicMembershipSource source) {}
