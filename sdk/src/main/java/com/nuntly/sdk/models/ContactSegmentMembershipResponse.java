package com.nuntly.sdk.models;

/**
 * @param contactId The id of the contact.
 * @param segmentId The id of the segment.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 */
public record ContactSegmentMembershipResponse(
    String contactId, String segmentId, String createdAt) {}
