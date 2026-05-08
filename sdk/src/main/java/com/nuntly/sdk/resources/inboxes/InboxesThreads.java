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
      String inboxId, Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    var response =
        client.rawRequest("GET", "/inboxes/" + inboxId + "/threads", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), ThreadsResponseItem[].class);
    var next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(java.util.List.of(items), next, (c) -> list(inboxId, c, limit));
  }

  public CursorPage<ThreadsResponseItem> list(String inboxId) {
    return list(inboxId, Optional.empty(), Optional.empty());
  }
}
