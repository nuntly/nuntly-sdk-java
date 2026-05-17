package com.nuntly.sdk.models;

import com.google.gson.JsonObject;

/**
 * Fallback {@link WebhookEvent} returned by {@code com.nuntly.sdk.lib.Webhook#verify(String,
 * String, String)} when the payload {@code type} field does not match any known event record (e.g.
 * a new event type added by the Nuntly API that this SDK version does not yet model).
 *
 * <p>Consumers can still read the raw JSON {@code data} payload to handle unknown events
 * defensively.
 */
public record UnknownWebhookEvent(String id, String createdAt, String type, JsonObject data)
    implements WebhookEvent {}
