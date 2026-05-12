package com.nuntly.sdk.models;

public record EmailComplainedEvent(
    String id, String createdAt, String type, java.util.Map<String, Object> data) {}
