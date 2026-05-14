package com.nuntly.sdk.models;

public record MessageRejectedEventData(
    String orgId,
    String domainId,
    String domainName,
    String inboxId,
    String from,
    String subject,
    String reason) {}
