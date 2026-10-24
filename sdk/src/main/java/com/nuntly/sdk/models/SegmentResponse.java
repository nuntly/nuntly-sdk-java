package com.nuntly.sdk.models;

/**
 * @param id The id of the segment.
 * @param name A name for the segment, shown to your team. Stored lowercased and trimmed.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 */
public record SegmentResponse(String id, String name, String createdAt, String updatedAt) {}
