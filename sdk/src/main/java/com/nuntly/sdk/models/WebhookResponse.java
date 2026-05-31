package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

public record WebhookResponse(
    /** The id of the webhook */
    String id,
    /** The name of the webhook */
    Optional<String> name,
    /** The endpoint URL of the webhook */
    String endpointUrl,
    /** The event types to subscribe to */
    List<EventType> events,
    /** The status of the webhook. */
    WebhookStatus status,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt) {}
