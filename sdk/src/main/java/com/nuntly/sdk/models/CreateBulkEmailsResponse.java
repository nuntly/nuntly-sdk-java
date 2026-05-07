package com.nuntly.sdk.models;

public record CreateBulkEmailsResponse(
    /** The bulk id */
    java.util.Optional<String> id, java.util.List<java.util.Map<String, Object>> emails) {}
