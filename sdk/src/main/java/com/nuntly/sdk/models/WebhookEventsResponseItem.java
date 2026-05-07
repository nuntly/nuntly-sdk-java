package com.nuntly.sdk.models;

/** A single item from WebhookEventsResponse. */
public record WebhookEventsResponseItem(
    /** The id of the webhook event */
    String id,
    /** The id of the webhook */
    String webhookId,
    /** The id of the organization */
    String orgId,
    /** An event */
    String event,
    /** The timestamp when the event was successfully delivered to the endpoint */
    java.util.Optional<String> successfulAt,
    java.util.Map<String, Object> data,
    /** Status of the webhook delivery attempt */
    String status) {}
