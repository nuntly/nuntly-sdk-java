package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.emails.*;
import java.util.*;

public final class Emails extends Resource {
  private EmailsStats stats;
  private EmailsEvents events;
  private EmailsContent content;
  private EmailsBulk bulk;

  public Emails(NuntlyClient client) {
    super(client);
  }

  public EmailsStats stats() {
    if (stats == null) stats = new EmailsStats(client);
    return stats;
  }

  public EmailsEvents events() {
    if (events == null) events = new EmailsEvents(client);
    return events;
  }

  public EmailsContent content() {
    if (content == null) content = new EmailsContent(client);
    return content;
  }

  public EmailsBulk bulk() {
    if (bulk == null) bulk = new EmailsBulk(client);
    return bulk;
  }

  /** Returns an email with its current delivery status and metadata. */
  public EmailResponse retrieve(String id) {
    return client.get("/emails/" + id + "", EmailResponse.class, RequestOptions.none());
  }

  /** Returns sent emails ordered by submission date, newest first. */
  public CursorPage<EmailsResponseItem> list(Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    var response = client.rawRequest("GET", "/emails", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), EmailsResponseItem[].class);
    var next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(java.util.List.of(items), next, (c) -> list(c, limit));
  }

  public CursorPage<EmailsResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }

  /**
   * Send transactional emails through Nuntly platform. It supports HTML and plain-text emails,
   * attachments, labels, custom headers and scheduling.
   */
  public CreateEmailResponse send(CreateEmailRequest body) {
    return send(body, RequestOptions.none());
  }

  public CreateEmailResponse send(CreateEmailRequest body, RequestOptions opts) {
    var idempotencyKey = opts.idempotencyKey().orElse(java.util.UUID.randomUUID().toString());
    var headers = new java.util.HashMap<String, String>(opts.headers());
    headers.putIfAbsent("Idempotency-Key", idempotencyKey);
    var optsWithKey =
        new RequestOptions(
            opts.timeout(), opts.maxRetries(), headers, java.util.Optional.of(idempotencyKey));
    return client.post("/emails", body, CreateEmailResponse.class, optsWithKey);
  }

  /**
   * Cancel a scheduled email before delivery. Only emails with `scheduled` status can be cancelled.
   */
  public DeleteEmailResponse cancel(String id) {
    return client.delete("/emails/" + id + "", DeleteEmailResponse.class, RequestOptions.none());
  }
}
