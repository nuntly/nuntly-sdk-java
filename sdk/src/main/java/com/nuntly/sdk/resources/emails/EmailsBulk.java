package com.nuntly.sdk.resources.emails;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class EmailsBulk extends Resource {

  public EmailsBulk(NuntlyClient client) {
    super(client);
  }

  /** Returns the delivery status of all emails submitted in a bulk request. */
  public BulkEmailsResponse list(String bulkId) {
    return client.get(
        "/emails/bulk/" + bulkId + "", BulkEmailsResponse.class, RequestOptions.none());
  }

  /**
   * Send up to 20 emails in a single request. Use `fallback` to set default values shared across
   * all messages.
   */
  public CreateBulkEmailsResponse send(CreateBulkEmailsRequest body) {
    return send(body, RequestOptions.none());
  }

  public CreateBulkEmailsResponse send(CreateBulkEmailsRequest body, RequestOptions opts) {
    var idempotencyKey = opts.idempotencyKey().orElse(java.util.UUID.randomUUID().toString());
    var headers = new java.util.HashMap<String, String>(opts.headers());
    headers.putIfAbsent("Idempotency-Key", idempotencyKey);
    var optsWithKey =
        new RequestOptions(
            opts.timeout(), opts.maxRetries(), headers, java.util.Optional.of(idempotencyKey));
    return client.post("/emails/bulk", body, CreateBulkEmailsResponse.class, optsWithKey);
  }
}
