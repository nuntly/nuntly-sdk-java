package com.nuntly.sdk.models;

import java.util.Map;
import java.util.Optional;

/** A single item from WebhookEventsResponse. */
public record WebhookEventsResponseItem(
    /** The id of the webhook event */
    String id,
    /** The id of the webhook */
    String webhookId,
    /** The id of the organization */
    String orgId,
    /** An event */
    EventType event,
    /** The timestamp when the event was successfully delivered to the endpoint */
    Optional<String> successfulAt,
    Map<String, Object> data,
    /** Status of the webhook delivery attempt */
    WebhookEventsResponseItemStatus status) {}
