package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

public record DeliveryDetail(
    String deliveredAt,
    List<String> recipients,
    String smtpResponse,
    String remoteMtaIp,
    String reportingMta,
    Optional<Long> processingTime) {}
