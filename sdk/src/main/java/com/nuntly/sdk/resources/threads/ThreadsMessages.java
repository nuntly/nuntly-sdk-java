package com.nuntly.sdk.resources.threads;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class ThreadsMessages extends Resource {

  public ThreadsMessages(NuntlyClient client) {
    super(client);
  }

  /** List messages in a thread (chronological order). */
  public CursorPage<ThreadMessagesResponseItem> list(
      String threadId, Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    return client.list(
        "/threads/" + threadId + "/messages",
        ThreadMessagesResponseItem.class,
        query,
        RequestOptions.none());
  }

  public CursorPage<ThreadMessagesResponseItem> list(String threadId) {
    return list(threadId, Optional.empty(), Optional.empty());
  }
}
