package com.nuntly.sdk.models;

public record EmailBouncedEvent(
    String id, String createdAt, String type, EmailBouncedEventData data) implements WebhookEvent {}
