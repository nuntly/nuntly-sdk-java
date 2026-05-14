package com.nuntly.sdk.models;

public record DeliveryDetail(
    String deliveredAt,
    java.util.List<String> recipients,
    String smtpResponse,
    String remoteMtaIp,
    String reportingMta,
    java.util.Optional<Long> processingTime) {}
