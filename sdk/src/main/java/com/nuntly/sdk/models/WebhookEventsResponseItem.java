package com.nuntly.sdk.models;

import java.util.Map;
import java.util.Optional;

/**
 * A single item from WebhookEventsResponse.
 *
 * @param id The id of the webhook event
 * @param webhookId The id of the webhook
 * @param orgId The id of the organization
 * @param event An event
 * @param successfulAt The timestamp when the event was successfully delivered to the endpoint
 * @param status Status of the webhook delivery attempt
 */
public record WebhookEventsResponseItem(
    String id,
    String webhookId,
    String orgId,
    EventType event,
    Optional<String> successfulAt,
    Map<String, Object> data,
    WebhookEventsResponseItemStatus status) {}
