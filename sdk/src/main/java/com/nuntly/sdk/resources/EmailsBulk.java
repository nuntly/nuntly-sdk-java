package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class EmailsBulk extends Resource {

  public EmailsBulk(NuntlyClient client) {
    super(client);
  }

  /**
   * Send up to 20 emails in a single request. Use `fallback` to set default values shared across
   * all messages.
   */
  public CreateBulkEmailsResponse send(CreateBulkEmailsRequest body) {
    return client.post("/emails/bulk", body, CreateBulkEmailsResponse.class, RequestOptions.none());
  }

  /** Returns the delivery status of all emails submitted in a bulk request. */
  public BulkEmailsResponse list(String bulkId) {
    return client.get(
        "/emails/bulk/" + bulkId + "", BulkEmailsResponse.class, RequestOptions.none());
  }
}
