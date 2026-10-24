package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A single item from BroadcastsResponse.
 *
 * @param id The id of the broadcast.
 * @param name An internal label, shown only to your team.
 * @param templateId The id of the template.
 * @param templateVersionId The content version this broadcast sends. Frozen once queued.
 * @param domainId The id of the sending domain.
 * @param topicId The topic this broadcast targets.
 * @param segmentId The segment this broadcast targets.
 * @param subject The subject, falling back to the template version’s subject.
 * @param replyTo The email address where replies should be sent. If a recipient replies, the
 *     response will go to this address instead of the sender's email address
 * @param status The lifecycle state of the broadcast.
 * @param statusAt Date at which the broadcast reached its current state.
 * @param statusReason May provide more information about the status.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 * @param variables The stored variable values.
 */
public record BroadcastsResponseItem(
    String id,
    Optional<String> name,
    Optional<String> templateId,
    Optional<String> templateVersionId,
    Optional<String> domainId,
    Optional<String> topicId,
    Optional<String> segmentId,
    String from,
    Optional<String> subject,
    List<String> replyTo,
    BroadcastStatus status,
    String statusAt,
    Map<String, Object> statusReason,
    String createdAt,
    String updatedAt,
    Map<String, Object> variables) {}
