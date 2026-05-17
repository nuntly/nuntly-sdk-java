package com.nuntly.sdk.models;

import java.util.Map;

public record WebhookEventDeliveriesResponseItem(
    String id,
    String deliveredAt,
    String code,
    WebhookEventDeliveriesResponseItemStatus status,
    Map<String, Object> response) {}
