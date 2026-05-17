package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.emails.*;
import java.util.*;

public final class Emails extends Resource {
  private EmailsBulk bulk;
  private EmailsContent content;
  private EmailsEvents events;
  private EmailsStats stats;

  public Emails(NuntlyClient client) {
    super(client);
  }

  public EmailsBulk bulk() {
    if (bulk == null) bulk = new EmailsBulk(client);
    return bulk;
  }

  public EmailsContent content() {
    if (content == null) content = new EmailsContent(client);
    return content;
  }

  public EmailsEvents events() {
    if (events == null) events = new EmailsEvents(client);
    return events;
  }

  public EmailsStats stats() {
    if (stats == null) stats = new EmailsStats(client);
    return stats;
  }

  /**
   * Cancel a scheduled email before delivery. Only emails with `scheduled` status can be cancelled.
   */
  public DeleteEmailResponse cancel(String id) {
    return client.delete("/emails/" + id + "", DeleteEmailResponse.class, RequestOptions.none());
  }

  /** Returns sent emails ordered by submission date, newest first. */
  public CursorPage<EmailsResponseItem> list(Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    return client.list("/emails", EmailsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<EmailsResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }

  /** Returns an email with its current delivery status and metadata. */
  public EmailResponse retrieve(String id) {
    return client.get("/emails/" + id + "", EmailResponse.class, RequestOptions.none());
  }

  /**
   * Send transactional emails through Nuntly platform. It supports HTML and plain-text emails,
   * attachments, labels, custom headers and scheduling.
   */
  public CreateEmailResponse send(CreateEmailRequest body) {
    return send(body, RequestOptions.none());
  }

  public CreateEmailResponse send(CreateEmailRequest body, RequestOptions opts) {
    var idempotencyKey = opts.idempotencyKey().orElse(UUID.randomUUID().toString());
    var headers = new HashMap<String, String>(opts.headers());
    headers.putIfAbsent("Idempotency-Key", idempotencyKey);
    var optsWithKey =
        new RequestOptions(opts.timeout(), opts.maxRetries(), headers, Optional.of(idempotencyKey));
    return client.post("/emails", body, CreateEmailResponse.class, optsWithKey);
  }
}
