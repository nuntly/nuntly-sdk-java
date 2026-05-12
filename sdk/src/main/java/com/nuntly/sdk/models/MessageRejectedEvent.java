package com.nuntly.sdk.models;

public record MessageRejectedEvent(
    String id, String createdAt, String type, java.util.Map<String, Object> data) {}
