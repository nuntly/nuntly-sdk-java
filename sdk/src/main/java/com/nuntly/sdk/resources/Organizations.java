package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.organizations.*;
import java.util.*;

public final class Organizations extends Resource {
  private OrganizationsUsage usage;

  public Organizations(NuntlyClient client) {
    super(client);
  }

  public OrganizationsUsage usage() {
    if (usage == null) usage = new OrganizationsUsage(client);
    return usage;
  }

  /**
   * Lists the organization that the API key belongs to, with its id, name, and status. The result
   * is paginated with a cursor like other list endpoints.
   */
  public CursorPage<OrganizationsResponseItem> list(OrganizationsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list(
        "/organizations", OrganizationsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<OrganizationsResponseItem> list() {
    return list(OrganizationsListParams.builder().build());
  }

  /**
   * Retrieves the organization that the API key belongs to by id, returning its name and its status
   * (enabled or disabled).
   */
  public OrganizationResponse retrieve(String id) {
    return client.get(
        "/organizations/" + pathParam("id", id) + "",
        OrganizationResponse.class,
        RequestOptions.none());
  }
}
