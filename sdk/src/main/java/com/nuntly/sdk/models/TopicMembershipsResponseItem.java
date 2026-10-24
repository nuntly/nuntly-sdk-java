package com.nuntly.sdk.models;

/**
 * A single item from TopicMembershipsResponse.
 *
 * @param contactId The id of the contact.
 * @param state The subscribe/unsubscribe state.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 */
public record TopicMembershipsResponseItem(
    String contactId, TopicMembershipState state, String createdAt, String updatedAt) {}
