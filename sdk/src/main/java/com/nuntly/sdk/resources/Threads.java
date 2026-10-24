package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.threads.*;
import java.util.*;

public final class Threads extends Resource {
  private ThreadsMessages messages;

  public Threads(NuntlyClient client) {
    super(client);
  }

  public ThreadsMessages messages() {
    if (messages == null) messages = new ThreadsMessages(client);
    return messages;
  }

  /**
   * Retrieves a thread with its subject, message count, last activity and labels from all its
   * messages. Pass markRead=true to clear unread labels.
   */
  public ThreadResponse retrieve(String threadId, ThreadsRetrieveParams params) {
    var query = new HashMap<String, Object>();
    params.markRead().ifPresent(v -> query.put("markRead", v));
    return client.get(
        "/threads/" + pathParam("threadId", threadId) + "",
        ThreadResponse.class,
        query,
        RequestOptions.none());
  }

  public ThreadResponse retrieve(String threadId) {
    return retrieve(threadId, ThreadsRetrieveParams.builder().build());
  }

  /**
   * Adds or removes labels on every message in a thread, or sets its agent. Label operations only
   * work on threads in user-created inboxes.
   */
  public IdResponse update(String threadId, UpdateThreadRequest body) {
    return client.patch(
        "/threads/" + pathParam("threadId", threadId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
