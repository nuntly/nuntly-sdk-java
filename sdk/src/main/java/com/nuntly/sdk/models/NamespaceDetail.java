package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * @param id The id of the namespace
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 * @param name The display name of the namespace.
 * @param externalId The external identifier for the namespace.
 * @param inboxCount The total number of inboxes in this namespace.
 * @param activeInboxCount The number of active inboxes in this namespace.
 */
public record NamespaceDetail(
    String id,
    String createdAt,
    Optional<String> updatedAt,
    String name,
    Optional<String> externalId,
    long inboxCount,
    long activeInboxCount) {}
