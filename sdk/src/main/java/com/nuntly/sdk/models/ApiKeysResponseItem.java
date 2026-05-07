package com.nuntly.sdk.models;

/** A single item from ApiKeysResponse. */
public record ApiKeysResponseItem(
    /** The id of the api key */
    String id,
    /** The name of the api key */
    java.util.Optional<String> name,
    /** The last 6 characters of the api key token */
    String shortToken,
    /** The status for the api key */
    String status,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt) {}
