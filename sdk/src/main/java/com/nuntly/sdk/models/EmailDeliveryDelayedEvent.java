package com.nuntly.sdk.models;

public record EmailDeliveryDelayedEvent(
    String id, String createdAt, String type, java.util.Map<String, Object> data) {}
