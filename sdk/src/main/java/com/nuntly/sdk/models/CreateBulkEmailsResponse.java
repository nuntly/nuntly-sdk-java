package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record CreateBulkEmailsResponse(
    /** The bulk id */
    Optional<String> id, List<Map<String, Object>> emails) {}
