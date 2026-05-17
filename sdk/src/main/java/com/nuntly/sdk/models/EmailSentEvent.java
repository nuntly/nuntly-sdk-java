package com.nuntly.sdk.models;

public record EmailSentEvent(String id, String createdAt, String type, EmailSentEventData data)
    implements WebhookEvent {}
