package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

public record DeliveryDelayDetail(
    String delayedAt,
    DeliveryDelayDetailDelayType delayType,
    List<DelayedRecipientsItem> delayedRecipients,
    String deliveryStoppedAt,
    String reportingMta) {

  public record DelayedRecipientsItem(
      String email, Optional<String> status, Optional<String> diagnosticCode) {}
}
