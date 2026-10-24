package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * @param id The id of the api key
 * @param name The name of the api key
 * @param apiKey The content of the api key
 * @param shortToken The last 6 characters of the api key token
 * @param status The status for the api key
 */
public record CreateApiKeyResponse(
    String id, Optional<String> name, String apiKey, String shortToken, ApiKeyStatus status) {}
