package com.nuntly.sdk.models;

public record EmailResponse(
    /** The id of the email */
    String id,
    /** The id of the organization */
    String orgId,
    /** The id from email provider */
    java.util.Optional<String> messageId,
    /** The bulk id */
    java.util.Optional<String> bulkId,
    /** The e-mail address of the sender */
    String from,
    /** The primary recipient(s) of the email */
    java.util.List<String> to,
    /** The carbon copy recipient(s) of the email */
    java.util.Optional<java.util.List<String>> cc,
    /** The blind carbon copy recipient(s) of the email */
    java.util.Optional<java.util.List<String>> bcc,
    /** The status of the email. */
    String status,
    /** May provide more informations about the status */
    java.util.Optional<java.util.Map<String, Object>> statusReason,
    /** The subject of the e-mail */
    String subject,
    /**
     * The email address where replies should be sent. If a recipient replies, the response will go
     * to this address instead of the sender's email address
     */
    java.util.Optional<java.util.List<String>> replyTo,
    /** The headers to add to the email */
    java.util.Optional<java.util.Map<String, Object>> headers,
    /** The tags to add to the email */
    java.util.Optional<java.util.List<java.util.Map<String, Object>>> tags,
    /** The attachements */
    java.util.Optional<java.util.List<java.util.Map<String, Object>>> attachments,
    /** The variables for the template */
    java.util.Optional<java.util.Map<String, Object>> variables,
    /** The date at which the email is scheduled to be sent */
    java.util.Optional<String> scheduledAt,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt) {}
