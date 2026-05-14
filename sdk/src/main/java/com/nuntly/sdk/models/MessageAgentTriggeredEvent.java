package com.nuntly.sdk.models;

public record MessageAgentTriggeredEvent(
    String id, String createdAt, String type, InboundEventData data) {}
