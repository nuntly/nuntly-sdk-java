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
    return client.list(
        "/namespaces/" + namespaceId + "/inboxes",
        InboxesResponseItem.class,
        query,
        RequestOptions.none());
  }

  public CursorPage<InboxesResponseItem> list(String namespaceId) {
    return list(namespaceId, Optional.empty(), Optional.empty());
  }
}
