package com.nuntly.sdk.models;

public record EmailContentResponse(
    /** HTML content, or `null` if unavailable. */
    java.util.Map<String, Object> html,
    /** Plain text content, or `null` if unavailable. */
    java.util.Map<String, Object> text,
    /** Raw MIME (.eml) content, or `null` if unavailable. */
    java.util.Map<String, Object> mime,
    /** Subject template content, or `null` if unavailable. Returned for failed emails only. */
    java.util.Map<String, Object> subjectTemplate,
    /** HTML template content, or `null` if unavailable. Returned for failed emails only. */
    java.util.Map<String, Object> htmlTemplate,
    /** Text template content, or `null` if unavailable. Returned for failed emails only. */
    java.util.Map<String, Object> textTemplate) {}
