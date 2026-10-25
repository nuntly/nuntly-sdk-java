package com.nuntly.sdk.resources.namespaces;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class NamespacesInboxes extends Resource {

  public NamespacesInboxes(NuntlyClient client) {
    super(client);
  }

  /**
   * Lists the active inboxes assigned to a namespace, newest first, with cursor pagination. Returns
   * the same inbox objects as the inbox list.
   */
  public CursorPage<InboxesResponseItem> list(
      String namespaceId, NamespacesInboxesListParams params) {
    return list(namespaceId, params, RequestOptions.none());
  }

  public CursorPage<InboxesResponseItem> list(
      String namespaceId, NamespacesInboxesListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list(
        "/namespaces/" + pathParam("namespaceId", namespaceId) + "/inboxes",
        InboxesResponseItem.class,
        query,
        opts);
  }

  public CursorPage<InboxesResponseItem> list(String namespaceId) {
    return list(namespaceId, NamespacesInboxesListParams.builder().build());
  }

  public CursorPage<InboxesResponseItem> list(String namespaceId, RequestOptions opts) {
    return list(namespaceId, NamespacesInboxesListParams.builder().build(), opts);
  }
}
