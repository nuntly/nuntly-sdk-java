package com.nuntly.sdk.resources.inboxes;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class InboxesMessages extends Resource {

  public InboxesMessages(NuntlyClient client) {
    super(client);
  }

  /** Send a new message from an inbox. */
  public SendMessageResponse send(String inboxId, SendMessageRequest body) {
    return client.post(
        "/inboxes/" + inboxId + "/messages",
        body,
        SendMessageResponse.class,
        RequestOptions.none());
  }
}
