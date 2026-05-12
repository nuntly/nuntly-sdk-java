package com.nuntly.sdk.models;

public record EmailEventsResponseItem(
    String id,
    /** The id of the organization */
    String orgId,
    /** The id of the email */
    String emailId,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** The date at which the event occurred */
    java.util.Optional<String> occurredAt,
    /** An event */
    EventType eventType,
    java.util.Map<String, Object> payload) {}
