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

  /**
   * Creates a namespace to group inboxes, with a display name and an optional external id that maps
   * it to a customer or tenant in your own system.
   */
  public NamespaceResponse create(CreateNamespaceRequest body) {
    return client.post("/namespaces", body, NamespaceResponse.class, RequestOptions.none());
  }

  /**
   * Deletes a namespace by id. The request is rejected with a validation error while the namespace
   * still has active inboxes, so delete them first.
   */
  public IdResponse delete(String namespaceId) {
    return client.delete(
        "/namespaces/" + pathParam("namespaceId", namespaceId) + "",
        IdResponse.class,
        RequestOptions.none());
  }

  /**
   * Lists the namespaces of your organization, newest first, with cursor pagination. Each item
   * includes the name and the optional external id.
   */
  public CursorPage<NamespacesResponseItem> list(NamespacesListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list("/namespaces", NamespacesResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<NamespacesResponseItem> list() {
    return list(NamespacesListParams.builder().build());
  }

  /**
   * Retrieves a namespace by id with its name, its optional external id, and inbox counts,
   * including how many of its inboxes are currently active.
   */
  public NamespaceDetail retrieve(String namespaceId) {
    return client.get(
        "/namespaces/" + pathParam("namespaceId", namespaceId) + "",
        NamespaceDetail.class,
        RequestOptions.none());
  }

  /**
   * Updates the display name or external id of a namespace. Set the external id to null to clear
   * it. Returns the id of the updated namespace.
   */
  public IdResponse update(String namespaceId, UpdateNamespaceRequest body) {
    return client.patch(
        "/namespaces/" + pathParam("namespaceId", namespaceId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
