package com.nuntly.sdk.models;

public record EmailDeliveredEvent(
    String id, String createdAt, String type, EmailDeliveredEventData data)
    implements WebhookEvent {}
