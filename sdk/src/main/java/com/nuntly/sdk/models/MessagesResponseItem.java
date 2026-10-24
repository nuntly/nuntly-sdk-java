package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 * A single item from MessagesResponse.
 *
 * @param id The id of the message
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param inboxId The id of the inbox, or null if routed to the default catch-all.
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
public record MessagesResponseItem(
    String id,
    String createdAt,
    Optional<String> inboxId,
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
