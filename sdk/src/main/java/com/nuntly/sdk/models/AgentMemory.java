package com.nuntly.sdk.models;

import java.util.Map;
import java.util.Optional;

public record AgentMemory(
    /** The agent memory record id. */
    String id,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** Date at which the object was updated (ISO 8601 format) */
    Optional<String> updatedAt,
    /** The agent identifier. */
    String agentId,
    /** The inbox id. */
    String inboxId,
    /** The thread id. */
    String threadId,
    /** The agent memory data. */
    Map<String, Object> memory,
    /** The conversation summary. */
    String summary) {}
