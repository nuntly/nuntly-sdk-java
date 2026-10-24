package com.nuntly.sdk.models;

import java.util.List;

/**
 * A single item from ThreadMessagesResponse.
 *
 * @param id The id of the message
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param threadId The id of the thread.
 * @param messageId The email Message-ID header.
 * @param from The sender address (RFC 5322 format, e.g. "Jane Doe &lt;jane@example.com&gt;" or
 *     "jane@example.com").
 * @param to The recipient addresses.
 * @param cc The CC addresses.
 * @param bcc The BCC addresses.
 * @param replyTo The Reply-To addresses.
 * @param subject The message subject.
 * @param receivedAt The original date of the message.
 * @param status The status of the message
 * @param labels The message labels.
 * @param attachmentCount The number of attachments.
 */
public record ThreadMessagesResponseItem(
    String id,
    String createdAt,
    String threadId,
    String messageId,
    String from,
    List<String> to,
    List<String> cc,
    List<String> bcc,
    List<String> replyTo,
    String subject,
    String receivedAt,
    MessageResponseStatus status,
    List<String> labels,
    long attachmentCount) {}
