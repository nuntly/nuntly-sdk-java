package com.nuntly.sdk.models;

public record EmailSentEvent(
    String id, String createdAt, String type, java.util.Map<String, Object> data) {}
