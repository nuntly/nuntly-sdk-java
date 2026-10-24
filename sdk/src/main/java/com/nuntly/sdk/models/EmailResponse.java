package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.nuntly.sdk.ExplicitNullTypeAdapterFactory;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @param id The id of the email
 * @param orgId The id of the organization
 * @param messageId The id from email provider
 * @param bulkId The bulk id
 * @param from The e-mail address of the sender
 * @param to The primary recipient(s) of the email
 * @param cc The carbon copy recipient(s) of the email
 * @param bcc The blind carbon copy recipient(s) of the email
 * @param status The status of the email.
 * @param statusReason May provide more informations about the status
 * @param subject The subject of the e-mail
 * @param replyTo The email address where replies should be sent. If a recipient replies, the
 *     response will go to this address instead of the sender's email address
 * @param headers The headers to add to the email
 * @param tags The tags to add to the email
 * @param attachments The attachements
 * @param variables The variables for the template
 * @param scheduledAt The date at which the email is scheduled to be sent
 * @param createdAt Date at which the object was created (ISO 8601 format)
 */
public record EmailResponse(
    String id,
    String orgId,
    Optional<String> messageId,
    Optional<String> bulkId,
    String from,
    List<String> to,
    List<String> cc,
    List<String> bcc,
    EmailStatus status,
    Map<String, Object> statusReason,
    String subject,
    List<String> replyTo,
    Map<String, String> headers,
    List<Tag> tags,
    List<AttachmentsItem> attachments,
    @JsonAdapter(ExplicitNullTypeAdapterFactory.MapNullValues.class) Map<String, Object> variables,
    Optional<String> scheduledAt,
    String createdAt) {

  /**
   * @param filename The name of the attached file to be displayed to the recipient
   * @param contentType Content type of the attachment (the MIME type)
   * @param size The size of the attachment in bytes
   */
  public record AttachmentsItem(
      Optional<String> filename, Optional<String> contentType, Optional<Long> size) {}
}
