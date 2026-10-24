package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 * @param id The id of the thread
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 * @param domainId The id of the domain.
 * @param domainName The domain name.
 * @param inboxId The id of the inbox.
 * @param subject The original subject line.
 * @param lastMessageAt The timestamp of the most recent message.
 * @param messageCount The number of messages in the thread.
 * @param labels Aggregated labels from all messages in the thread.
 * @param agentId The AI agent identifier.
 */
public record ThreadResponse(
    String id,
    String createdAt,
    Optional<String> updatedAt,
    Optional<String> domainId,
    String domainName,
    String inboxId,
    String subject,
    String lastMessageAt,
    long messageCount,
    List<String> labels,
    Optional<String> agentId) {}
