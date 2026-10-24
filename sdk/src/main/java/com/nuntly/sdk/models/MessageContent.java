package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * @param text Plain text content, or `null` if not requested or unavailable.
 * @param html HTML content, or `null` if not requested or unavailable.
 * @param mime Raw MIME (.eml) content, or `null` if not requested or unavailable. Returned for
 *     received messages only.
 */
public record MessageContent(
    Optional<MessageContentItem> text,
    Optional<MessageContentItem> html,
    Optional<MessageContentItem> mime) {}
