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

  /** Returns all organizations the authenticated user belongs to. */
  public CursorPage<OrganizationsResponseItem> list(
      Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    var response = client.rawRequest("GET", "/organizations", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), OrganizationsResponseItem[].class);
    var next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(java.util.List.of(items), next, (c) -> list(c, limit));
  }

  public CursorPage<OrganizationsResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }

  /** Returns the organization's profile, plan, region, and account status. */
  public OrganizationResponse retrieve(String id) {
    return client.get(
        "/organizations/" + id + "", OrganizationResponse.class, RequestOptions.none());
  }
}
