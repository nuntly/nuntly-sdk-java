package com.nuntly.sdk.resources.templates;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class TemplatesVersionsContent extends Resource {

  public TemplatesVersionsContent(NuntlyClient client) {
    super(client);
  }

  /** Get download links for a version's HTML and text. */
  public TemplateVersionContentResponse retrieve(String templateId, String versionId) {
    return client.get(
        "/templates/"
            + pathParam("templateId", templateId)
            + "/versions/"
            + pathParam("versionId", versionId)
            + "/content",
        TemplateVersionContentResponse.class,
        RequestOptions.none());
  }
}
