package com.nuntly.sdk.models;

import java.util.Optional;

public record ApiKeyResponse(
    /** The id of the api key */
    String id,
    /** The name of the api key */
    Optional<String> name,
    /** The last 6 characters of the api key token */
    String shortToken,
    /** The status for the api key */
    ApiKeyStatus status,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt) {}
