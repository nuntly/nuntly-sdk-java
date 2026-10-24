package com.nuntly.sdk.models;

/**
 * @param id The id of the message
 * @param threadId The id of the thread.
 * @param messageId The RFC 5322 Message-ID header.
 * @param subject The subject of the message.
 */
public record SendMessageResponse(String id, String threadId, String messageId, String subject) {}
