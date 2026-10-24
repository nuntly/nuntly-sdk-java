package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Data payload for EmailRejectedEvent. */
public record EmailRejectedEventData(
    Optional<String> id,
    Optional<String> orgId,
    Optional<String> bulkId,
    Optional<String> broadcastId,
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
    List<HeadersItem> headers,
    Map<String, Object> tags,
    RejectDetail reject) {

  public record HeadersItem(String name, String value) {}
}
