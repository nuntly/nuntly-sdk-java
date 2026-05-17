package com.nuntly.sdk.models;

public record EmailRejectedEvent(
    String id, String createdAt, String type, EmailRejectedEventData data)
    implements WebhookEvent {}
