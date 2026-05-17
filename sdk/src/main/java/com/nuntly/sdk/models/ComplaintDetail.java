package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record ComplaintDetail(
    String complainedAt,
    List<Map<String, Object>> complainedRecipients,
    Optional<String> complaintSubType,
    Optional<ComplaintDetailComplaintFeedbackType> complaintFeedbackType,
    String feedbackId,
    Optional<String> userAgent,
    Optional<String> receivedAt) {}
