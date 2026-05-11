package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.messages.*;
import java.util.*;

public final class Messages extends Resource {
  private MessagesAttachments attachments;
  private MessagesContent content;

  public Messages(NuntlyClient client) {
    super(client);
  }

  public MessagesAttachments attachments() {
    if (attachments == null) attachments = new MessagesAttachments(client);
    return attachments;
  }

  public MessagesContent content() {
    if (content == null) content = new MessagesContent(client);
    return content;
  }

  /** Forward a message to new recipients. */
  public SendMessageResponse forward(String messageId, ForwardMessageRequest body) {
    return client.post(
        "/messages/" + messageId + "/forward",
        body,
        SendMessageResponse.class,
        RequestOptions.none());
  }

  /** List all received messages across inboxes. */
  public CursorPage<MessagesResponseItem> list(Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    return client.list("/messages", MessagesResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<MessagesResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }

  /** Reply to a message. Set replyAll to true to reply to all recipients. */
  public SendMessageResponse reply(String messageId, ReplyMessageRequest body) {
    return client.post(
        "/messages/" + messageId + "/reply",
        body,
        SendMessageResponse.class,
        RequestOptions.none());
  }

  /** Retrieve a single message with inbox enrichment. */
  public MessageResponse retrieve(String messageId) {
    return client.get("/messages/" + messageId + "", MessageResponse.class, RequestOptions.none());
  }

  /** Update message labels. Only available for messages in user-created inboxes. */
  public IdResponse update(String messageId, UpdateMessageRequest body) {
    return client.patch(
        "/messages/" + messageId + "", body, IdResponse.class, RequestOptions.none());
  }
}
