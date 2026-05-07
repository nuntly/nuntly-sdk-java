package com.nuntly.sdk.models;

public record WebhookEventDeliveriesResponseItem(
    String id,
    String deliveredAt,
    String code,
    String status,
    java.util.Map<String, Object> response) {}
