package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/** A single item from WebhooksResponse. */
public record WebhooksResponseItem(
    /** The id of the webhook */
    String id,
    /** The name of the webhook */
    Optional<String> name,
    /** The endpoint URL of the webhook */
    String endpointUrl,
    /** The status of the webhook. */
    CreateWebhookResponseStatus status,
    /** The event types to subscribe to */
    List<EventType> events,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt) {}
