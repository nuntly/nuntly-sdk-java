package com.nuntly.sdk.resources.inboxes;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class InboxesThreads extends Resource {

  public InboxesThreads(NuntlyClient client) {
    super(client);
  }

  /** List threads in an inbox. */
  public CursorPage<ThreadsResponseItem> list(
      String inboxId, Optional<String> cursor, Optional<Integer> limit, Optional<String> labels) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    labels.ifPresent(v -> query.put("labels", v.toString()));
    return client.list(
        "/inboxes/" + inboxId + "/threads",
        ThreadsResponseItem.class,
        query,
        RequestOptions.none());
  }

  public CursorPage<ThreadsResponseItem> list(String inboxId) {
    return list(inboxId, Optional.empty(), Optional.empty(), Optional.empty());
  }
}
