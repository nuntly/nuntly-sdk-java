package com.nuntly.sdk.models;

/** A single item from ThreadsResponse. */
public record ThreadsResponseItem(
    /** The id of the thread */
    String id,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** Date at which the object was updated (ISO 8601 format) */
    java.util.Optional<String> updatedAt,
    /** The id of the domain. */
    String domainId,
    /** The domain name. */
    String domainName,
    /** The id of the inbox. */
    String inboxId,
    /** The original subject line. */
    String subject,
    /** The timestamp of the most recent message. */
    String lastMessageAt,
    /** The number of messages in the thread. */
    long messageCount,
    /** Aggregated labels from all messages in the thread. */
    java.util.List<String> labels,
    /** The AI agent identifier. */
    String agentId) {}
