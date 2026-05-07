package com.nuntly.sdk;

import com.google.gson.JsonObject;

/**
 * A verified Nuntly webhook event.
 *
 * <p>Switch on {@link #type()} to handle specific events and read fields from {@link #data()},
 * which is the raw JSON object emitted by the API.
 */
public record WebhookEvent(String id, String createdAt, String type, JsonObject data) {}
