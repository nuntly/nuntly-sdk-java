package com.nuntly.sdk.models;

public record EmailScheduledEvent(
    String id, String createdAt, String type, EmailScheduledEventData data)
    implements WebhookEvent {}
