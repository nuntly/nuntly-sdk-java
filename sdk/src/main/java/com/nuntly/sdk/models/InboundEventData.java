package com.nuntly.sdk.models;

import java.util.Optional;

public record InboundEventData(
    String orgId,
    String domainId,
    String domainName,
    String inboxId,
    String threadId,
    String messageId,
    String from,
    String subject,
    Optional<String> agentId) {}
