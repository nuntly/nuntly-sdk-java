package com.nuntly.sdk.resources.emails;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class EmailsBulk extends Resource {

  public EmailsBulk(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns the emails created by a bulk request, with the id and current status of each one,
   * looked up by the bulk id returned when it was sent.
   */
  public BulkEmailsResponse retrieve(String bulkId) {
    return retrieve(bulkId, RequestOptions.none());
  }

  public BulkEmailsResponse retrieve(String bulkId, RequestOptions opts) {
    return client.get(
        "/emails/bulk/" + pathParam("bulkId", bulkId) + "", BulkEmailsResponse.class, opts);
  }

  /**
   * Queues 1 to 20 emails in one request with optional shared fallback values, and returns a bulk
   * id plus the id and status of each email. No scheduling.
   */
  public CreateBulkEmailsResponse send(CreateBulkEmailsRequest body) {
    return send(body, IdempotentRequestOptions.none());
  }

  public CreateBulkEmailsResponse send(
      CreateBulkEmailsRequest body, IdempotentRequestOptions opts) {
    return postIdempotent("/emails/bulk", body, CreateBulkEmailsResponse.class, opts);
  }
}
