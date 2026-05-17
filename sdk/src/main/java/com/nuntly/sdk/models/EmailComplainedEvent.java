package com.nuntly.sdk.models;

public record EmailComplainedEvent(
    String id, String createdAt, String type, EmailComplainedEventData data)
    implements WebhookEvent {}
