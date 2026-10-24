package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Data payload for EmailBouncedEvent. */
public record EmailBouncedEventData(
    String id,
    String orgId,
    Optional<String> bulkId,
    Optional<String> broadcastId,
    String messageId,
    String sentAt,
    String enqueuedAt,
    String domainName,
    String domainId,
    String from,
    List<String> to,
    List<String> cc,
    List<String> bcc,
    List<String> replyTo,
    String subject,
    List<EmailEvent.HeadersItem> headers,
    Map<String, Object> tags,
    BounceDetail bounce) {}
