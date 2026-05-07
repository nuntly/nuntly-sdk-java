package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class MessagesContent extends Resource {

  public MessagesContent(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns presigned URLs to download the HTML, plain-text, and raw MIME source of a received
   * message.
   */
  public MessageContent retrieve(String messageId) {
    return client.get(
        "/messages/" + messageId + "/content", MessageContent.class, RequestOptions.none());
  }
}
