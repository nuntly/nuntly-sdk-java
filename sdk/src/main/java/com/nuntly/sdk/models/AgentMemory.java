package com.nuntly.sdk.models;

public record AgentMemory(
    /** The agent memory record id. */
    String id,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** Date at which the object was updated (ISO 8601 format) */
    java.util.Optional<String> updatedAt,
    /** The agent identifier. */
    String agentId,
    /** The inbox id. */
    String inboxId,
    /** The thread id. */
    String threadId,
    /** The agent memory data. */
    java.util.Map<String, Object> memory,
    /** The conversation summary. */
    String summary) {}
