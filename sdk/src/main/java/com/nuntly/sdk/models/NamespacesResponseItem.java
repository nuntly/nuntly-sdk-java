package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * A single item from NamespacesResponse.
 *
 * @param id The id of the namespace
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 * @param name The display name of the namespace.
 * @param externalId The external identifier for the namespace.
 */
public record NamespacesResponseItem(
    String id,
    String createdAt,
    Optional<String> updatedAt,
    String name,
    Optional<String> externalId) {}
