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
    return client.post(
        "/templates/" + pathParam("templateId", templateId) + "/versions",
        body,
        TemplateVersionResponse.class,
        RequestOptions.none());
  }

  /** List the versions of a template. */
  public CursorPage<TemplateVersionsResponseItem> list(
      String templateId, TemplatesVersionsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list(
        "/templates/" + pathParam("templateId", templateId) + "/versions",
        TemplateVersionsResponseItem.class,
        query,
        RequestOptions.none());
  }

  public CursorPage<TemplateVersionsResponseItem> list(String templateId) {
    return list(templateId, TemplatesVersionsListParams.builder().build());
  }

  /** Publish a draft template version. */
  public TemplateVersionIdResponse publish(String templateId, String versionId) {
    return client.patch(
        "/templates/"
            + pathParam("templateId", templateId)
            + "/versions/"
            + pathParam("versionId", versionId)
            + "/publish",
        null,
        TemplateVersionIdResponse.class,
        RequestOptions.none());
  }

  /** Retrieve one content version. */
  public TemplateVersionResponse retrieve(String templateId, String versionId) {
    return client.get(
        "/templates/"
            + pathParam("templateId", templateId)
            + "/versions/"
            + pathParam("versionId", versionId)
            + "",
        TemplateVersionResponse.class,
        RequestOptions.none());
  }
}
