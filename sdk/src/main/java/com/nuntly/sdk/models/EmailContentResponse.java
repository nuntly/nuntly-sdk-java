package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * @param html HTML content, or `null` if unavailable.
 * @param text Plain text content, or `null` if unavailable.
 * @param mime Raw MIME (.eml) content, or `null` if unavailable.
 * @param subjectTemplate Subject template content, or `null` if unavailable. Returned for failed
 *     emails only.
 * @param htmlTemplate HTML template content, or `null` if unavailable. Returned for failed emails
 *     only.
 * @param textTemplate Text template content, or `null` if unavailable. Returned for failed emails
 *     only.
 */
public record EmailContentResponse(
    Optional<EmailContentItem> html,
    Optional<EmailContentItem> text,
    Optional<EmailContentItem> mime,
    Optional<EmailContentItem> subjectTemplate,
    Optional<EmailContentItem> htmlTemplate,
    Optional<EmailContentItem> textTemplate) {}
