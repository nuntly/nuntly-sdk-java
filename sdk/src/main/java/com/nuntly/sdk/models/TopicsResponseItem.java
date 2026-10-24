package com.nuntly.sdk.models;

/**
 * A single item from TopicsResponse.
 *
 * @param id The id of the topic.
 * @param name A name for the topic, shown to your team. Stored lowercased and trimmed.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 */
public record TopicsResponseItem(String id, String name, String createdAt, String updatedAt) {}
