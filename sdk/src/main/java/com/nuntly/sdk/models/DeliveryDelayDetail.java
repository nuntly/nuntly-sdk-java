package com.nuntly.sdk.models;

public record DeliveryDelayDetail(
    String delayedAt,
    String delayType,
    java.util.List<java.util.Map<String, Object>> delayedRecipients,
    String deliveryStoppedAt,
    String reportingMta) {}
