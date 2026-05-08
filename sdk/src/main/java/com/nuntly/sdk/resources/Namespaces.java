package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.namespaces.*;
import java.util.*;

public final class Namespaces extends Resource {
  private NamespacesInboxes inboxes;

  public Namespaces(NuntlyClient client) {
    super(client);
  }

  public NamespacesInboxes inboxes() {
    if (inboxes == null) inboxes = new NamespacesInboxes(client);
    return inboxes;
  }

  /** Create a new namespace. */
  public NamespaceResponse create(CreateNamespaceRequest body) {
    return client.post("/namespaces", body, NamespaceResponse.class, RequestOptions.none());
  }

  /** List all namespaces. */
  public CursorPage<NamespacesResponseItem> list(Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    var response = client.rawRequest("GET", "/namespaces", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), NamespacesResponseItem[].class);
    var next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(java.util.List.of(items), next, (c) -> list(c, limit));
  }

  public CursorPage<NamespacesResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }

  /** Retrieve a namespace with inbox stats. */
  public NamespaceDetail retrieve(String namespaceId) {
    return client.get(
        "/namespaces/" + namespaceId + "", NamespaceDetail.class, RequestOptions.none());
  }

  /** Update a namespace. */
  public IdResponse update(String namespaceId, UpdateNamespaceRequest body) {
    return client.patch(
        "/namespaces/" + namespaceId + "", body, IdResponse.class, RequestOptions.none());
  }

  /** Soft-delete a namespace. Rejects if it has active inboxes. */
  public IdResponse delete(String namespaceId) {
    return client.delete(
        "/namespaces/" + namespaceId + "", IdResponse.class, RequestOptions.none());
  }
}
