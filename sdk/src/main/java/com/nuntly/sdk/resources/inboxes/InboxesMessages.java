package com.nuntly.sdk.resources.inboxes;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class InboxesMessages extends Resource {

  public InboxesMessages(NuntlyClient client) {
    super(client);
  }

  /**
   * Sends a new email from an inbox to one or more recipients. The message is queued for delivery
   * and the response returns its id, thread id, and Message-ID.
   */
  public SendMessageResponse send(String inboxId, SendMessageRequest body) {
    return send(inboxId, body, RequestOptions.none());
  }

  public SendMessageResponse send(String inboxId, SendMessageRequest body, RequestOptions opts) {
    var idempotencyKey = opts.idempotencyKey().orElse(UUID.randomUUID().toString());
    var headers = new HashMap<String, String>(opts.headers());
    headers.putIfAbsent("Idempotency-Key", idempotencyKey);
    var optsWithKey =
        new RequestOptions(opts.timeout(), opts.maxRetries(), headers, Optional.of(idempotencyKey));
    return client.post(
        "/inboxes/" + pathParam("inboxId", inboxId) + "/messages",
        body,
        SendMessageResponse.class,
        optsWithKey);
  }
}
