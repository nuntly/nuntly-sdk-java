package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * @param id The id of the api key
 * @param name The name of the api key
 * @param shortToken The last 6 characters of the api key token
 * @param status The status for the api key
 * @param createdAt Date at which the object was created (ISO 8601 format)
 */
public record ApiKeyResponse(
    String id, Optional<String> name, String shortToken, ApiKeyStatus status, String createdAt) {}
