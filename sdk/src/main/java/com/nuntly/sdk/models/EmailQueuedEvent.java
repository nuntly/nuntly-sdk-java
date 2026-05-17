package com.nuntly.sdk.models;

import java.util.Map;

public record EmailQueuedEvent(String id, String createdAt, String type, Map<String, Object> data)
    implements WebhookEvent {}
