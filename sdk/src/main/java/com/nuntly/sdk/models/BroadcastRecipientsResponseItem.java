package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * A single item from BroadcastRecipientsResponse.
 *
 * @param id The id of the recipient record.
 * @param contactId The source contact, absent once deleted.
 * @param email The recipient address, kept until your retention window ends.
 * @param outcome The current status of the recipient’s email.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 */
public record BroadcastRecipientsResponseItem(
    String id, Optional<String> contactId, String email, EmailStatus outcome, String createdAt) {}
