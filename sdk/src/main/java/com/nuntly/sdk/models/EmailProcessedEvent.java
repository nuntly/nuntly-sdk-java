package com.nuntly.sdk.models;

public record EmailProcessedEvent(
    String id, String createdAt, String type, java.util.Map<String, Object> data) {}
