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
    return forward(messageId, body, RequestOptions.none());
  }

  public SendMessageResponse forward(
      String messageId, ForwardMessageRequest body, RequestOptions opts) {
    var idempotencyKey = opts.idempotencyKey().orElse(UUID.randomUUID().toString());
    var headers = new HashMap<String, String>(opts.headers());
    headers.putIfAbsent("Idempotency-Key", idempotencyKey);
    var optsWithKey =
        new RequestOptions(opts.timeout(), opts.maxRetries(), headers, Optional.of(idempotencyKey));
    return client.post(
        "/messages/" + pathParam("messageId", messageId) + "/forward",
        body,
        SendMessageResponse.class,
        optsWithKey);
  }

  /**
   * Lists messages newest first, with cursor pagination and optional filters by domain and sender.
   * Each item includes its labels, status and attachment count.
   */
  public CursorPage<MessagesResponseItem> list(MessagesListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    params.domainId().ifPresent(v -> query.put("domainId", v));
    params.from().ifPresent(v -> query.put("from", v));
    return client.list("/messages", MessagesResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<MessagesResponseItem> list() {
    return list(MessagesListParams.builder().build());
  }

  /**
   * Replies from the inbox that holds the message, in the same thread. Set replyAll to true to also
   * copy the other recipients. The send is queued.
   */
  public SendMessageResponse reply(String messageId, ReplyMessageRequest body) {
    return reply(messageId, body, RequestOptions.none());
  }

  public SendMessageResponse reply(
      String messageId, ReplyMessageRequest body, RequestOptions opts) {
    var idempotencyKey = opts.idempotencyKey().orElse(UUID.randomUUID().toString());
    var headers = new HashMap<String, String>(opts.headers());
    headers.putIfAbsent("Idempotency-Key", idempotencyKey);
    var optsWithKey =
        new RequestOptions(opts.timeout(), opts.maxRetries(), headers, Optional.of(idempotencyKey));
    return client.post(
        "/messages/" + pathParam("messageId", messageId) + "/reply",
        body,
        SendMessageResponse.class,
        optsWithKey);
  }

  /**
   * Retrieves a received or sent message by id, including its sender, recipients, subject, labels,
   * status, attachment count and raw headers.
   */
  public MessageResponse retrieve(String messageId) {
    return client.get(
        "/messages/" + pathParam("messageId", messageId) + "",
        MessageResponse.class,
        RequestOptions.none());
  }

  /**
   * Adds or removes labels on a message. Only messages in user-created inboxes accept labels, and a
   * message can hold at most 10 labels.
   */
  public IdResponse update(String messageId, UpdateMessageRequest body) {
    return client.patch(
        "/messages/" + pathParam("messageId", messageId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
