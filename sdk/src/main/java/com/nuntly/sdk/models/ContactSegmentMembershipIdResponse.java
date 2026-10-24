package com.nuntly.sdk.models;

/**
 * @param id The id of the contact removed from the segment.
 * @param segmentId The id of the segment the contact was removed from. The segment itself is not
 *     deleted.
 */
public record ContactSegmentMembershipIdResponse(String id, String segmentId) {}
