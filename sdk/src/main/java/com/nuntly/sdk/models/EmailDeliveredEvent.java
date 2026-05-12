package com.nuntly.sdk.models;

public record EmailDeliveredEvent(
    String id, String createdAt, String type, java.util.Map<String, Object> data) {}
