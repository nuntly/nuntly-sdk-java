package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;

public record DeliveryDelayDetail(
    String delayedAt,
    DeliveryDelayDetailDelayType delayType,
    List<Map<String, Object>> delayedRecipients,
    String deliveryStoppedAt,
    String reportingMta) {}
