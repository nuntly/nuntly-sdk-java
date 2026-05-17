package com.nuntly.sdk.models;

public record MessageSecurityFlaggedEvent(
    String id, String createdAt, String type, InboundEventData data) implements WebhookEvent {}
