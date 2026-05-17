package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;

public record BulkEmailsResponse(String id, List<Map<String, Object>> emails) {}
