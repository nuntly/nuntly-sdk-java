package com.nuntly.sdk.resources.messages;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class MessagesContent extends Resource {

  public MessagesContent(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns temporary download URLs, valid for 2 minutes, for the HTML, plain-text or raw MIME
   * content of a message. Only HTML is returned by default.
   */
  public MessageContent retrieve(String messageId, MessagesContentRetrieveParams params) {
    var query = new HashMap<String, Object>();
    if (params.format() != null) query.put("format", params.format());
    return client.get(
        "/messages/" + pathParam("messageId", messageId) + "/content",
        MessageContent.class,
        query,
        RequestOptions.none());
  }

  public MessageContent retrieve(String messageId) {
    return retrieve(messageId, MessagesContentRetrieveParams.builder().build());
  }
}
