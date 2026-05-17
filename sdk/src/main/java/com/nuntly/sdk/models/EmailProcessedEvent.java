package com.nuntly.sdk.models;

import java.util.Map;

public record EmailProcessedEvent(
    String id, String createdAt, String type, Map<String, Object> data) implements WebhookEvent {}
