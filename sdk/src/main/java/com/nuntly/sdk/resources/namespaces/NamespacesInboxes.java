package com.nuntly.sdk.resources.namespaces;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class NamespacesInboxes extends Resource {

  public NamespacesInboxes(NuntlyClient client) {
    super(client);
  }

  /** List inboxes in a namespace. */
  public CursorPage<InboxesResponseItem> list(
      String namespaceId, Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    var response =
        client.rawRequest(
            "GET", "/namespaces/" + namespaceId + "/inboxes", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), InboxesResponseItem[].class);
    var next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(java.util.List.of(items), next, (c) -> list(namespaceId, c, limit));
  }

  public CursorPage<InboxesResponseItem> list(String namespaceId) {
    return list(namespaceId, Optional.empty(), Optional.empty());
  }
}
