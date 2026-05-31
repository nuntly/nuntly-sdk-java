package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

public record CreateWebhookResponse(
    /** The id of the webhook */
    String id,
    /** The name of the webhook */
    Optional<String> name,
    /** The endpoint URL of the webhook */
    String endpointUrl,
    /** The status of the webhook. */
    WebhookStatus status,
    /** The event types to subscribe to */
    List<EventType> events,
    /** The signing secret of the webhook. */
    String signingSecret,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt) {}
