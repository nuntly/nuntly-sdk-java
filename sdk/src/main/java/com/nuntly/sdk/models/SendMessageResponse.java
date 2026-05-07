package com.nuntly.sdk.models;

public record SendMessageResponse(
    /** The id of the message */
    String id,
    /** The id of the thread. */
    String threadId,
    /** The RFC 5322 Message-ID header. */
    String messageId,
    /** The subject of the message. */
    String subject) {}
