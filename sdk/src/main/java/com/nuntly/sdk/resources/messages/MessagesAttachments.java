package com.nuntly.sdk.resources.messages;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class MessagesAttachments extends Resource {

  public MessagesAttachments(NuntlyClient client) {
    super(client);
  }

  /**
   * Lists the attachments of a message with their filename, content type, size, disposition and
   * content id. Download links are not included.
   */
  public List<AttachmentResponse> list(String messageId) {
    return List.of(
        client.get(
            "/messages/" + pathParam("messageId", messageId) + "/attachments",
            AttachmentResponse[].class,
            RequestOptions.none()));
  }

  /**
   * Retrieves the metadata of an attachment and a temporary download URL that expires after 15
   * minutes. Use it to fetch the attachment file itself.
   */
  public AttachmentResponse retrieve(String messageId, String attachmentId) {
    return client.get(
        "/messages/"
            + pathParam("messageId", messageId)
            + "/attachments/"
            + pathParam("attachmentId", attachmentId)
            + "",
        AttachmentResponse.class,
        RequestOptions.none());
  }
}
