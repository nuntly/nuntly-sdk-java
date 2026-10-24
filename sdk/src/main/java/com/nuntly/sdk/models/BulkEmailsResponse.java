package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

public record BulkEmailsResponse(String id, List<EmailsItem> emails) {

  /**
   * @param id The id of the email
   * @param status The status of the email.
   */
  public record EmailsItem(String id, EmailStatus status, Optional<String> detail) {}
}
