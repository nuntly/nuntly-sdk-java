package com.nuntly.sdk.models;

public record MessageRejectedEvent(
    String id, String createdAt, String type, MessageRejectedEventData data)
    implements WebhookEvent {}
