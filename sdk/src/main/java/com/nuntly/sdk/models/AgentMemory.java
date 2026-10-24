package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.nuntly.sdk.ExplicitNullTypeAdapterFactory;
import java.util.Map;
import java.util.Optional;

/**
 * @param id The agent memory record id.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 * @param agentId The agent identifier.
 * @param inboxId The inbox id.
 * @param threadId The thread id.
 * @param memory The agent memory data.
 * @param summary The conversation summary.
 */
public record AgentMemory(
    Optional<String> id,
    Optional<String> createdAt,
    Optional<String> updatedAt,
    String agentId,
    Optional<String> inboxId,
    Optional<String> threadId,
    @JsonAdapter(ExplicitNullTypeAdapterFactory.MapNullValues.class) Map<String, Object> memory,
    Optional<String> summary) {}
