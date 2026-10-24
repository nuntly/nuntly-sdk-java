package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.templates.*;
import java.util.*;

public final class Templates extends Resource {
  private TemplatesVersions versions;

  public Templates(NuntlyClient client) {
    super(client);
  }

  public TemplatesVersions versions() {
    if (versions == null) versions = new TemplatesVersions(client);
    return versions;
  }

  /** Create a template. */
  public TemplateResponse create(CreateTemplateRequest body) {
    return client.post("/templates", body, TemplateResponse.class, RequestOptions.none());
  }

  /** Delete a template and its versions. */
  public IdResponse delete(String templateId) {
    return client.delete(
        "/templates/" + pathParam("templateId", templateId) + "",
        IdResponse.class,
        RequestOptions.none());
  }

  /** List the organization templates. */
  public CursorPage<TemplatesResponseItem> list(TemplatesListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list("/templates", TemplatesResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<TemplatesResponseItem> list() {
    return list(TemplatesListParams.builder().build());
  }

  /** Retrieve one template. */
  public TemplateResponse retrieve(String templateId) {
    return client.get(
        "/templates/" + pathParam("templateId", templateId) + "",
        TemplateResponse.class,
        RequestOptions.none());
  }

  /** Rename a template. */
  public IdResponse update(String templateId, UpdateTemplateRequest body) {
    return client.patch(
        "/templates/" + pathParam("templateId", templateId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
