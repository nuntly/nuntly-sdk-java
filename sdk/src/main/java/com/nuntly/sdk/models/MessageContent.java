package com.nuntly.sdk.models;

public record MessageContent(
    /** Plain text content, or `null` if not requested or unavailable. */
    java.util.Map<String, Object> text,
    /** HTML content, or `null` if not requested or unavailable. */
    java.util.Map<String, Object> html,
    /**
     * Raw MIME (.eml) content, or `null` if not requested or unavailable. Returned for received
     * messages only.
     */
    java.util.Map<String, Object> mime) {}
