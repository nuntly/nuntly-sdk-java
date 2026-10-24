package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 * A single item from EmailsResponse.
 *
 * @param id The id of the email
 * @param from The e-mail address of the sender
 * @param to The primary recipient(s) of the email
 * @param subject The subject of the e-mail
 * @param status The status of the email.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param scheduledAt The date at which the email is scheduled to be sent
 */
public record EmailsResponseItem(
    String id,
    String from,
    List<String> to,
    String subject,
    EmailStatus status,
    String createdAt,
    Optional<String> scheduledAt) {}
