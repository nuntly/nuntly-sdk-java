package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class EmailsContent extends Resource {

  public EmailsContent(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns presigned URLs to download the HTML, plain-text, and raw MIME source of a sent email.
   */
  public EmailContentResponse retrieve(String id) {
    return client.get(
        "/emails/" + id + "/content", EmailContentResponse.class, RequestOptions.none());
  }
}
