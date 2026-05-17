package com.nuntly.sdk.models;

import java.util.Optional;

/** A single item from NamespacesResponse. */
public record NamespacesResponseItem(
    /** The id of the namespace */
    String id,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** Date at which the object was updated (ISO 8601 format) */
    Optional<String> updatedAt,
    /** The display name of the namespace. */
    String name,
    /** The external identifier for the namespace. */
    String externalId) {}
