package com.nuntly.sdk.models;

public record ComplaintDetail(
    String complainedAt,
    java.util.Optional<java.util.List<java.util.Map<String, Object>>> complainedRecipients,
    java.util.Optional<String> complaintSubType,
    java.util.Optional<String> complaintFeedbackType,
    String feedbackId,
    java.util.Optional<String> userAgent,
    java.util.Optional<String> receivedAt) {}
