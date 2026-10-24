package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * A single item from ContactPropertiesResponse.
 *
 * @param id The id of the contact property.
 * @param name A name for the property, used as its key in a contact's properties. Stored trimmed,
 *     with the letter case it was typed with.
 * @param type The declared type of the property. Immutable after creation.
 * @param description An optional description of the property.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 */
public record ContactPropertiesResponseItem(
    String id,
    String name,
    ContactPropertyType type,
    Optional<String> description,
    Optional<Object> defaultValue,
    String createdAt,
    String updatedAt) {}
