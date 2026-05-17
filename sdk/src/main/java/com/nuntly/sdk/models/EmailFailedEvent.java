package com.nuntly.sdk.models;

public record EmailFailedEvent(String id, String createdAt, String type, EmailFailedEventData data)
    implements WebhookEvent {}
