package com.nuntly.sdk.models;

public record EmailEvent(
    String id,
    String orgId,
    java.util.Optional<String> bulkId,
    String messageId,
    String sentAt,
    String enqueuedAt,
    String domainName,
    String domainId,
    String from,
    java.util.List<String> to,
    java.util.Optional<java.util.List<String>> cc,
    java.util.Optional<java.util.List<String>> bcc,
    java.util.Optional<java.util.List<String>> replyTo,
    String subject,
    java.util.Optional<java.util.List<java.util.Map<String, Object>>> headers,
    java.util.Optional<java.util.Map<String, Object>> tags) {}
