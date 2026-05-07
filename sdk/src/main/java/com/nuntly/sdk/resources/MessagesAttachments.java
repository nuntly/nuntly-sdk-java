package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class MessagesAttachments extends Resource {

  public MessagesAttachments(NuntlyClient client) {
    super(client);
  }

  /** List all attachments for a message. */
  public java.util.List<AttachmentResponse> list(String messageId) {
    var response =
        client.rawRequest(
            "GET", "/messages/" + messageId + "/attachments", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), AttachmentResponse[].class);
    return java.util.List.of(items);
  }

  /** Retrieve an attachment with a presigned download URL. */
  public AttachmentResponse retrieve(String messageId, String attachmentId) {
    return client.get(
        "/messages/" + messageId + "/attachments/" + attachmentId + "",
        AttachmentResponse.class,
        RequestOptions.none());
  }
}
