package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record BounceDetail(
    BounceDetailBounceType bounceType,
    BounceDetailBounceSubType bounceSubType,
    List<Map<String, Object>> bouncedRecipients,
    String bouncedAt,
    String feedbackId,
    Optional<String> reportingMta) {}
