package com.nuntly.sdk;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Base class for SDK resources (Emails, Domains, Webhooks, ...). Holds the shared {@link
 * NuntlyClient} used to issue HTTP calls. Use {@link ApiError#rawResponse()} to inspect the HTTP
 * response of a failed call.
 */
public abstract class Resource {
  protected final NuntlyClient client;

  protected Resource(NuntlyClient client) {
    this.client = client;
  }

  // The server resolves these into another route: /contacts/../segments/s is /segments/s.
  protected static String pathParam(String name, String value) {
    if (value == null) throw new NuntlyError("Missing path param '" + name + "'.");
    if (value.isEmpty() || value.equals(".") || value.equals("..")) {
      throw new NuntlyError("Path param '" + name + "' must not be '" + value + "'.");
    }
    // Percent-encoded, so a '/', '?' or '#' in the value cannot change the route.
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }

  /**
   * A POST to an endpoint that deduplicates requests by {@code Idempotency-Key}: it sends the key
   * of {@code opts}, or a generated one, and the same key on every retry.
   */
  protected <T> T postIdempotent(
      String path, Object body, Class<T> type, IdempotentRequestOptions opts) {
    return client.postIdempotent(path, body, type, opts);
  }

  // A retry replays the same key, so the server applies the request once.
  // A key header the caller set, in any case, wins over the option and is never sent twice;
  // one set to null counts as not set.
  static IdempotentRequestOptions withIdempotencyKey(IdempotentRequestOptions opts) {
    var header =
        opts.headers().entrySet().stream()
            .filter(e -> isKeyHeader(e.getKey()) && e.getValue() != null)
            // The exact spelling wins over another case variant of the header.
            .min(Comparator.comparing(e -> !e.getKey().equals("Idempotency-Key")))
            .map(e -> Map.entry(e.getKey(), e.getValue()))
            .orElseGet(
                () ->
                    Map.entry(
                        "Idempotency-Key",
                        opts.idempotencyKey().orElseGet(() -> UUID.randomUUID().toString())));
    var headers = new HashMap<>(opts.headers());
    headers.keySet().removeIf(Resource::isKeyHeader);
    headers.put(header.getKey(), header.getValue());
    return new IdempotentRequestOptions(
        opts.timeout(), opts.maxRetries(), headers, Optional.of(header.getValue()));
  }

  private static boolean isKeyHeader(String name) {
    return name.equalsIgnoreCase("Idempotency-Key");
  }
}
