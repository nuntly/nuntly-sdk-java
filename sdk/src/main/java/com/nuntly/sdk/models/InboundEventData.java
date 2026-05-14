package com.nuntly.sdk.models;

public record InboundEventData(
    String orgId,
    String domainId,
    String domainName,
    String inboxId,
    String threadId,
    String messageId,
    String from,
    String subject,
    java.util.Optional<String> agentId) {}
