package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Data payload for EmailRejectedEvent. */
public record EmailRejectedEventData(
    Optional<String> id,
    Optional<String> orgId,
    Optional<String> bulkId,
    Optional<String> messageId,
    Optional<String> sentAt,
    Optional<String> enqueuedAt,
    Optional<String> domainName,
    Optional<String> domainId,
    Optional<String> from,
    List<String> to,
    List<String> cc,
    List<String> bcc,
    List<String> replyTo,
    Optional<String> subject,
    List<Map<String, Object>> headers,
    Map<String, Object> tags,
    RejectDetail reject) {}
