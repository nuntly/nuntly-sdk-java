package com.nuntly.sdk.models;

public record MessageReceivedEvent(
    String id, String createdAt, String type, java.util.Map<String, Object> data) {}
