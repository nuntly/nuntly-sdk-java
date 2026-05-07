package com.nuntly.sdk.resources;

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
    var response =
        client.rawRequest("GET", "/threads/" + threadId + "/messages", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), ThreadMessagesResponseItem[].class);
    var next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(java.util.List.of(items), next, (c) -> list(threadId, c, limit));
  }

  public CursorPage<ThreadMessagesResponseItem> list(String threadId) {
    return list(threadId, Optional.empty(), Optional.empty());
  }
}
