package com.nuntly.sdk.models;

public record MessageContent(
    /** Plain text content, or `null` if not requested or unavailable. */
    MessageContentItem text,
    /** HTML content, or `null` if not requested or unavailable. */
    MessageContentItem html,
    /**
     * Raw MIME (.eml) content, or `null` if not requested or unavailable. Returned for received
     * messages only.
     */
    MessageContentItem mime) {}
