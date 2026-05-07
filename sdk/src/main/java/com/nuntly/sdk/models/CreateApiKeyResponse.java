package com.nuntly.sdk.models;

public record CreateApiKeyResponse(
    /** The id of the api key */
    String id,
    /** The name of the api key */
    java.util.Optional<String> name,
    /** The content of the api key */
    String apiKey,
    /** The last 6 characters of the api key token */
    String shortToken,
    /** The status for the api key */
    String status) {}
