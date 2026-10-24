package com.nuntly.sdk.models;

import java.util.Map;
import java.util.Optional;

/**
 * @param orgId The id of the organization
 * @param emailId The id of the email
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param occurredAt The date at which the event occurred
 * @param eventType An event
 */
public record EmailEventsResponseItem(
    String id,
    String orgId,
    String emailId,
    String createdAt,
    Optional<String> occurredAt,
    EventType eventType,
    Map<String, Object> payload) {}
