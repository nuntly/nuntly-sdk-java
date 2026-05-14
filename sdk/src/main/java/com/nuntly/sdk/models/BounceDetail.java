package com.nuntly.sdk.models;

public record BounceDetail(
    String bounceType,
    String bounceSubType,
    java.util.List<java.util.Map<String, Object>> bouncedRecipients,
    String bouncedAt,
    String feedbackId,
    java.util.Optional<String> reportingMta) {}
