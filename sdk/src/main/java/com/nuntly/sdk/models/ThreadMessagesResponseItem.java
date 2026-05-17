package com.nuntly.sdk.models;

import java.util.List;

/** A single item from ThreadMessagesResponse. */
public record ThreadMessagesResponseItem(
    /** The id of the message */
    String id,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** The id of the thread. */
    String threadId,
    /** The email Message-ID header. */
    String messageId,
    /**
     * The sender address (RFC 5322 format, e.g. "Jane Doe <jane@example.com>" or
     * "jane@example.com").
     */
    String from,
    /** The recipient addresses. */
    List<String> to,
    /** The CC addresses. */
    List<String> cc,
    /** The BCC addresses. */
    List<String> bcc,
    /** The Reply-To addresses. */
    List<String> replyTo,
    /** The message subject. */
    String subject,
    /** The original date of the message. */
    String receivedAt,
    /** The status of the message */
    MessageResponseStatus status,
    /** The message labels. */
    List<String> labels,
    /** The number of attachments. */
    long attachmentCount) {}
