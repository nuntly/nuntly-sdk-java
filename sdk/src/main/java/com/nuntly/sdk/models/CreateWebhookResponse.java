package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 * @param id The id of the webhook
 * @param name The name of the webhook
 * @param endpointUrl The endpoint URL of the webhook
 * @param status The status of the webhook.
 * @param disabledReason The reason the webhook was disabled, or `null` if it is not disabled.
 * @param disabledAt The timestamp when the webhook was disabled, or `null` if it is not disabled.
 * @param events The event types to subscribe to
 * @param signingSecret The signing secret of the webhook.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 */
public record CreateWebhookResponse(
    String id,
    Optional<String> name,
    String endpointUrl,
    WebhookStatus status,
    Optional<WebhookDisabledReason> disabledReason,
    Optional<String> disabledAt,
    List<EventType> events,
    String signingSecret,
    String createdAt) {}
