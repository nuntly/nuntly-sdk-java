package com.nuntly.sdk.models;

public record EmailSendingEvent(
    String id, String createdAt, String type, EmailSendingEventData data) implements WebhookEvent {}
