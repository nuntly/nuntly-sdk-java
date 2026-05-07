package com.nuntly.sdk.models;

/** A single item from WebhooksResponse. */
public record WebhooksResponseItem(
    /** The id of the webhook */
    String id,
    /** The name of the webhook */
    java.util.Optional<String> name,
    /** The endpoint URL of the webhook */
    String endpointUrl,
    /** The status of the webhook. */
    String status,
    /** The event types to subscribe to */
    java.util.List<String> events,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt) {}
