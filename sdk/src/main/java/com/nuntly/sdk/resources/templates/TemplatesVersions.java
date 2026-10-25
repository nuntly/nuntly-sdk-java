package com.nuntly.sdk.resources.templates;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class TemplatesVersions extends Resource {
  private TemplatesVersionsContent content;

  public TemplatesVersions(NuntlyClient client) {
    super(client);
  }

  public TemplatesVersionsContent content() {
    if (content == null) content = new TemplatesVersionsContent(client);
    return content;
  }

  /** Create a draft version of a template. */
  public TemplateVersionResponse create(String templateId, CreateTemplateVersionRequest body) {
    return create(templateId, body, RequestOptions.none());
  }

  public TemplateVersionResponse create(
      String templateId, CreateTemplateVersionRequest body, RequestOptions opts) {
    return client.post(
        "/templates/" + pathParam("templateId", templateId) + "/versions",
        body,
        TemplateVersionResponse.class,
        opts);
  }

  /** List the versions of a template. */
  public CursorPage<TemplateVersionsResponseItem> list(
      String templateId, TemplatesVersionsListParams params) {
    return list(templateId, params, RequestOptions.none());
  }

  public CursorPage<TemplateVersionsResponseItem> list(
      String templateId, TemplatesVersionsListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list(
        "/templates/" + pathParam("templateId", templateId) + "/versions",
        TemplateVersionsResponseItem.class,
        query,
        opts);
  }

  public CursorPage<TemplateVersionsResponseItem> list(String templateId) {
    return list(templateId, TemplatesVersionsListParams.builder().build());
  }

  public CursorPage<TemplateVersionsResponseItem> list(String templateId, RequestOptions opts) {
    return list(templateId, TemplatesVersionsListParams.builder().build(), opts);
  }

  /** Publish a draft template version. */
  public TemplateVersionIdResponse publish(String templateId, String versionId) {
    return publish(templateId, versionId, RequestOptions.none());
  }

  public TemplateVersionIdResponse publish(
      String templateId, String versionId, RequestOptions opts) {
    return client.patch(
        "/templates/"
            + pathParam("templateId", templateId)
            + "/versions/"
            + pathParam("versionId", versionId)
            + "/publish",
        null,
        TemplateVersionIdResponse.class,
        opts);
  }

  /** Retrieve one content version. */
  public TemplateVersionResponse retrieve(String templateId, String versionId) {
    return retrieve(templateId, versionId, RequestOptions.none());
  }

  public TemplateVersionResponse retrieve(
      String templateId, String versionId, RequestOptions opts) {
    return client.get(
        "/templates/"
            + pathParam("templateId", templateId)
            + "/versions/"
            + pathParam("versionId", versionId)
            + "",
        TemplateVersionResponse.class,
        opts);
  }
}
