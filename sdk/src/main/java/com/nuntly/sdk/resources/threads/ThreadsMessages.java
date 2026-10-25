package com.nuntly.sdk.resources.threads;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class ThreadsMessages extends Resource {

  public ThreadsMessages(NuntlyClient client) {
    super(client);
  }

  /**
   * Lists the messages in a thread in chronological order, oldest first, with cursor pagination.
   * Returns up to 30 messages per page.
   */
  public CursorPage<ThreadMessagesResponseItem> list(
      String threadId, ThreadsMessagesListParams params) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list(
        "/threads/" + pathParam("threadId", threadId) + "/messages",
        ThreadMessagesResponseItem.class,
        query,
        RequestOptions.none());
  }

  public CursorPage<ThreadMessagesResponseItem> list(String threadId) {
    return list(threadId, ThreadsMessagesListParams.builder().build());
  }
}
