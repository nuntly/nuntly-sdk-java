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
   * Retrieve a thread. Pass ?markRead=true to automatically remove the unread label from all
   * messages.
   */
  public ThreadResponse retrieve(String threadId) {
    return client.get("/threads/" + threadId + "", ThreadResponse.class, RequestOptions.none());
  }

  /**
   * Update thread labels and agent assignment. Label operations apply to all messages in the
   * thread.
   */
  public IdResponse update(String threadId, UpdateThreadRequest body) {
    return client.patch("/threads/" + threadId + "", body, IdResponse.class, RequestOptions.none());
  }
}
