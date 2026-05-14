package com.nuntly.sdk.models;

public record MessageSentEvent(String id, String createdAt, String type, InboundEventData data) {}
