package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

public record ComplaintDetail(
    String complainedAt,
    List<ComplainedRecipientsItem> complainedRecipients,
    Optional<String> complaintSubType,
    Optional<ComplaintDetailComplaintFeedbackType> complaintFeedbackType,
    String feedbackId,
    Optional<String> userAgent,
    Optional<String> receivedAt) {

  public record ComplainedRecipientsItem(String email) {}
}
