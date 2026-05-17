package com.nuntly.sdk.models;

public record EmailDeliveryDelayedEvent(
    String id, String createdAt, String type, EmailDeliveryDelayedEventData data)
    implements WebhookEvent {}
