package com.nuntly.sdk.models;

/** A single item from EmailsResponse. */
public record EmailsResponseItem(
    /** The id of the email */
    String id,
    /** The e-mail address of the sender */
    String from,
    /** The primary recipient(s) of the email */
    java.util.List<String> to,
    /** The subject of the e-mail */
    String subject,
    /** The status of the email. */
    String status,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** The date at which the email is scheduled to be sent */
    java.util.Optional<String> scheduledAt) {}
