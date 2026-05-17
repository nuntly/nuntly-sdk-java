package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record EmailResponse(
    /** The id of the email */
    String id,
    /** The id of the organization */
    String orgId,
    /** The id from email provider */
    Optional<String> messageId,
    /** The bulk id */
    Optional<String> bulkId,
    /** The e-mail address of the sender */
    String from,
    /** The primary recipient(s) of the email */
    List<String> to,
    /** The carbon copy recipient(s) of the email */
    List<String> cc,
    /** The blind carbon copy recipient(s) of the email */
    List<String> bcc,
    /** The status of the email. */
    EmailStatus status,
    /** May provide more informations about the status */
    Map<String, Object> statusReason,
    /** The subject of the e-mail */
    String subject,
    /**
     * The email address where replies should be sent. If a recipient replies, the response will go
     * to this address instead of the sender's email address
     */
    List<String> replyTo,
    /** The headers to add to the email */
    Map<String, String> headers,
    /** The tags to add to the email */
    List<Tag> tags,
    /** The attachements */
    List<Map<String, Object>> attachments,
    /** The variables for the template */
    Map<String, Object> variables,
    /** The date at which the email is scheduled to be sent */
    Optional<String> scheduledAt,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt) {}
