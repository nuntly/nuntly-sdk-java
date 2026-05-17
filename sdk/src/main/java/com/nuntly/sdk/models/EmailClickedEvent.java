package com.nuntly.sdk.models;

public record EmailClickedEvent(
    String id, String createdAt, String type, EmailClickedEventData data) implements WebhookEvent {}
