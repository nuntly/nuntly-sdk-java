package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Data payload for EmailDeliveredEvent. */
public record EmailDeliveredEventData(
    String id,
    String orgId,
    Optional<String> bulkId,
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
    List<Map<String, Object>> headers,
    Map<String, Object> tags,
    DeliveryDetail delivery) {}
