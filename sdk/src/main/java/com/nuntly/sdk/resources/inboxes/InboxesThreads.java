package com.nuntly.sdk.resources.inboxes;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class InboxesThreads extends Resource {

  public InboxesThreads(NuntlyClient client) {
    super(client);
  }

  /**
   * Lists the threads in an inbox, most recently active first, with cursor pagination. Filter by
   * labels; spam and trash threads are excluded by default.
   */
  public CursorPage<ThreadsResponseItem> list(String inboxId, InboxesThreadsListParams params) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    params.labels().ifPresent(v -> query.put("labels", v));
    return client.list(
        "/inboxes/" + pathParam("inboxId", inboxId) + "/threads",
        ThreadsResponseItem.class,
        query,
        RequestOptions.none());
  }

  public CursorPage<ThreadsResponseItem> list(String inboxId) {
    return list(inboxId, InboxesThreadsListParams.builder().build());
  }
}
