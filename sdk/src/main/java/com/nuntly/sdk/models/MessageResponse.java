package com.nuntly.sdk.models;

public record MessageResponse(
    /** The id of the message */
    String id,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** The id of the inbox, or null if routed to the default catch-all. */
    String inboxId,
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
    java.util.List<String> to,
    /** The CC addresses. */
    java.util.List<String> cc,
    /** The BCC addresses. */
    java.util.List<String> bcc,
    /** The Reply-To addresses. */
    java.util.List<String> replyTo,
    /** The message subject. */
    String subject,
    /** The original date of the message. */
    String receivedAt,
    /** The status of the message */
    String status,
    /** The message labels. */
    java.util.List<String> labels,
    /** The number of attachments. */
    long attachmentCount,
    /** The raw email headers. */
    java.util.Map<String, Object> headers) {}
