package com.nuntly.sdk.resources.emails;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class EmailsContent extends Resource {

  public EmailsContent(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns download links, valid for 2 minutes, for the HTML, plain-text and raw MIME versions of
   * an email, plus its stored subject and body templates.
   */
  public EmailContentResponse retrieve(String id) {
    return client.get(
        "/emails/" + pathParam("id", id) + "/content",
        EmailContentResponse.class,
        RequestOptions.none());
  }
}
