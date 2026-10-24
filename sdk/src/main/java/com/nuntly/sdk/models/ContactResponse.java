package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.nuntly.sdk.ExplicitNullTypeAdapterFactory;
import java.util.Map;

/**
 * @param id The id of the contact.
 * @param email The contact email address. Stored lowercased and trimmed.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 * @param properties The contact's properties, keyed by property name.
 */
public record ContactResponse(
    String id,
    String email,
    String createdAt,
    String updatedAt,
    @JsonAdapter(ExplicitNullTypeAdapterFactory.MapNullValues.class)
        Map<String, Object> properties) {}
