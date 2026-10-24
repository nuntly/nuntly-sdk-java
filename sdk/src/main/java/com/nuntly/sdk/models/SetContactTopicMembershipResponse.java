package com.nuntly.sdk.models;

/**
 * @param contactId The id of the contact.
 * @param topicId The id of the topic.
 * @param state The subscribe/unsubscribe state.
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 */
public record SetContactTopicMembershipResponse(
    String contactId, String topicId, TopicMembershipState state, String updatedAt) {}
