package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 * @param id The bulk id
 */
public record CreateBulkEmailsResponse(Optional<String> id, List<EmailsItem> emails) {

  /**
   * @param id The id of the email
   * @param status The status of the email.
   */
  public record EmailsItem(Optional<String> id, EmailStatus status) {}
}
