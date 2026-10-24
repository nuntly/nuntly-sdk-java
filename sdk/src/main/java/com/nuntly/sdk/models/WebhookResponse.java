package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 * @param id The id of the webhook
 * @param name The name of the webhook
 * @param endpointUrl The endpoint URL of the webhook
 * @param events The event types to subscribe to
 * @param status The status of the webhook.
 * @param disabledReason The reason the webhook was disabled, or `null` if it is not disabled.
 * @param disabledAt The timestamp when the webhook was disabled, or `null` if it is not disabled.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 */
public record WebhookResponse(
    String id,
    Optional<String> name,
    String endpointUrl,
    List<EventType> events,
    WebhookStatus status,
    Optional<WebhookDisabledReason> disabledReason,
    Optional<String> disabledAt,
    String createdAt) {}
