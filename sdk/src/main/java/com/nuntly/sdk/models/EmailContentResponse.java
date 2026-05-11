package com.nuntly.sdk.models;

public record EmailContentResponse(
    /** HTML content, or `null` if unavailable. */
    EmailContentItem html,
    /** Plain text content, or `null` if unavailable. */
    EmailContentItem text,
    /** Raw MIME (.eml) content, or `null` if unavailable. */
    EmailContentItem mime,
    /** Subject template content, or `null` if unavailable. Returned for failed emails only. */
    EmailContentItem subjectTemplate,
    /** HTML template content, or `null` if unavailable. Returned for failed emails only. */
    EmailContentItem htmlTemplate,
    /** Text template content, or `null` if unavailable. Returned for failed emails only. */
    EmailContentItem textTemplate) {}
