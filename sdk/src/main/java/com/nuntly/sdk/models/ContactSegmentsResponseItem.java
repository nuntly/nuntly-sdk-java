package com.nuntly.sdk.models;

/**
 * @param segmentId The id of the segment.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 */
public record ContactSegmentsResponseItem(String segmentId, String createdAt) {}
