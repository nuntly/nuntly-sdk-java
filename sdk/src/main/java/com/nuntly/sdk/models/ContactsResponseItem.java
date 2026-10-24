package com.nuntly.sdk.models;

/**
 * A single item from ContactsResponse.
 *
 * @param id The id of the contact.
 * @param email The contact email address. Stored lowercased and trimmed.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 */
public record ContactsResponseItem(String id, String email, String createdAt, String updatedAt) {}
