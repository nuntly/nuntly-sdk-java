package com.nuntly.sdk.models;

public record EmailSendingEvent(
    String id, String createdAt, String type, java.util.Map<String, Object> data) {}
