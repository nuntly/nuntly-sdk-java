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

  /**
   * Sends a message with a Fwd: subject from the inbox of the original message to one or more new
   * recipients, in a new thread, with an optional text note.
   */
  public SendMessageResponse forward(String messageId, ForwardMessageRequest body) {
    return forward(messageId, body, IdempotentRequestOptions.none());
  }

  public SendMessageResponse forward(
      String messageId, ForwardMessageRequest body, IdempotentRequestOptions opts) {
    return postIdempotent(
        "/messages/" + pathParam("messageId", messageId) + "/forward",
        body,
        SendMessageResponse.class,
        opts);
  }

  /**
   * Lists messages newest first, with cursor pagination and optional filters by domain and sender.
   * Each item includes its labels, status and attachment count.
   */
  public CursorPage<MessagesResponseItem> list(MessagesListParams params) {
    return list(params, RequestOptions.none());
  }

  public CursorPage<MessagesResponseItem> list(MessagesListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    params.domainId().ifPresent(v -> query.put("domainId", v));
    params.from().ifPresent(v -> query.put("from", v));
    return client.list("/messages", MessagesResponseItem.class, query, opts);
  }

  public CursorPage<MessagesResponseItem> list() {
    return list(MessagesListParams.builder().build());
  }

  public CursorPage<MessagesResponseItem> list(RequestOptions opts) {
    return list(MessagesListParams.builder().build(), opts);
  }

  /**
   * Replies from the inbox that holds the message, in the same thread. Set replyAll to true to also
   * copy the other recipients. The send is queued.
   */
  public SendMessageResponse reply(String messageId, ReplyMessageRequest body) {
    return reply(messageId, body, IdempotentRequestOptions.none());
  }

  public SendMessageResponse reply(
      String messageId, ReplyMessageRequest body, IdempotentRequestOptions opts) {
    return postIdempotent(
        "/messages/" + pathParam("messageId", messageId) + "/reply",
        body,
        SendMessageResponse.class,
        opts);
  }

  /**
   * Retrieves a received or sent message by id, including its sender, recipients, subject, labels,
   * status, attachment count and raw headers.
   */
  public MessageResponse retrieve(String messageId) {
    return retrieve(messageId, RequestOptions.none());
  }

  public MessageResponse retrieve(String messageId, RequestOptions opts) {
    return client.get(
        "/messages/" + pathParam("messageId", messageId) + "", MessageResponse.class, opts);
  }

  /**
   * Adds or removes labels on a message. Only messages in user-created inboxes accept labels, and a
   * message can hold at most 10 labels.
   */
  public IdResponse update(String messageId, UpdateMessageRequest body) {
    return update(messageId, body, RequestOptions.none());
  }

  public IdResponse update(String messageId, UpdateMessageRequest body, RequestOptions opts) {
    return client.patch(
        "/messages/" + pathParam("messageId", messageId) + "", body, IdResponse.class, opts);
  }
}
