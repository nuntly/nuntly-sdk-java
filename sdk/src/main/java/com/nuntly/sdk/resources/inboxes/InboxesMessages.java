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
    return send(inboxId, body, IdempotentRequestOptions.none());
  }

  public SendMessageResponse send(
      String inboxId, SendMessageRequest body, IdempotentRequestOptions opts) {
    return postIdempotent(
        "/inboxes/" + pathParam("inboxId", inboxId) + "/messages",
        body,
        SendMessageResponse.class,
        opts);
  }
}
