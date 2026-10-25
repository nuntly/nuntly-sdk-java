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
    return create(body, RequestOptions.none());
  }

  public TemplateResponse create(CreateTemplateRequest body, RequestOptions opts) {
    return client.post("/templates", body, TemplateResponse.class, opts);
  }

  /** Delete a template and its versions. */
  public IdResponse delete(String templateId) {
    return delete(templateId, RequestOptions.none());
  }

  public IdResponse delete(String templateId, RequestOptions opts) {
    return client.delete(
        "/templates/" + pathParam("templateId", templateId) + "", IdResponse.class, opts);
  }

  /** List the organization templates. */
  public CursorPage<TemplatesResponseItem> list(TemplatesListParams params) {
    return list(params, RequestOptions.none());
  }

  public CursorPage<TemplatesResponseItem> list(TemplatesListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list("/templates", TemplatesResponseItem.class, query, opts);
  }

  public CursorPage<TemplatesResponseItem> list() {
    return list(TemplatesListParams.builder().build());
  }

  public CursorPage<TemplatesResponseItem> list(RequestOptions opts) {
    return list(TemplatesListParams.builder().build(), opts);
  }

  /** Retrieve one template. */
  public TemplateResponse retrieve(String templateId) {
    return retrieve(templateId, RequestOptions.none());
  }

  public TemplateResponse retrieve(String templateId, RequestOptions opts) {
    return client.get(
        "/templates/" + pathParam("templateId", templateId) + "", TemplateResponse.class, opts);
  }

  /** Rename a template. */
  public IdResponse update(String templateId, UpdateTemplateRequest body) {
    return update(templateId, body, RequestOptions.none());
  }

  public IdResponse update(String templateId, UpdateTemplateRequest body, RequestOptions opts) {
    return client.patch(
        "/templates/" + pathParam("templateId", templateId) + "", body, IdResponse.class, opts);
  }
}
