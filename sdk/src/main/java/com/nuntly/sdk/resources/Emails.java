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
   * Cancels a scheduled email before it is sent and returns its id with status canceled. Only
   * scheduled emails sent outside a bulk request qualify.
   */
  public DeleteEmailResponse cancel(String id) {
    return client.delete(
        "/emails/" + pathParam("id", id) + "", DeleteEmailResponse.class, RequestOptions.none());
  }

  /**
   * Lists your emails newest first with cursor pagination, up to 30 per page. Each item has its
   * sender, recipients, subject, status and submission date.
   */
  public CursorPage<EmailsResponseItem> list(EmailsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list("/emails", EmailsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<EmailsResponseItem> list() {
    return list(EmailsListParams.builder().build());
  }

  /**
   * Returns a single email by id with its delivery status, status reason, recipients, subject,
   * headers, tags, attachment metadata and schedule.
   */
  public EmailResponse retrieve(String id) {
    return client.get(
        "/emails/" + pathParam("id", id) + "", EmailResponse.class, RequestOptions.none());
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
