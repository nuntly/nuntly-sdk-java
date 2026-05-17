package com.nuntly.sdk.models;

public record EmailOpenedEvent(String id, String createdAt, String type, EmailOpenedEventData data)
    implements WebhookEvent {}
