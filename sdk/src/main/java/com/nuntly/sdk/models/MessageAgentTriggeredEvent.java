package com.nuntly.sdk.models;

public record MessageAgentTriggeredEvent(
    String id, String createdAt, String type, java.util.Map<String, Object> data) {}
