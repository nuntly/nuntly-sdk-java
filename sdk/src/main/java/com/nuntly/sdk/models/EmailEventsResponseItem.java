package com.nuntly.sdk.models;

import java.util.Map;
import java.util.Optional;

public record EmailEventsResponseItem(
    String id,
    /** The id of the organization */
    String orgId,
    /** The id of the email */
    String emailId,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** The date at which the event occurred */
    Optional<String> occurredAt,
    /** An event */
    EventType eventType,
    Map<String, Object> payload) {}
