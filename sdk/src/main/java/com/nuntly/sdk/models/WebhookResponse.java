package com.nuntly.sdk.models;

public record WebhookResponse(
    /** The id of the webhook */
    String id,
    /** The name of the webhook */
    java.util.Optional<String> name,
    /** The endpoint URL of the webhook */
    String endpointUrl,
    /** The event types to subscribe to */
    java.util.List<String> events,
    /** The status of the webhook. */
    String status,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt) {}
