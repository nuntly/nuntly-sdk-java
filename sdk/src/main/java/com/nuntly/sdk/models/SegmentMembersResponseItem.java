package com.nuntly.sdk.models;

/**
 * A single item from SegmentMembersResponse.
 *
 * @param contactId The id of the contact.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 */
public record SegmentMembersResponseItem(String contactId, String createdAt) {}
