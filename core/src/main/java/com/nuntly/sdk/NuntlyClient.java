package com.nuntly.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class NuntlyClient {
  // 409 is a deterministic business conflict: a retry only adds latency.
  private static final Set<Integer> RETRYABLE_CODES = Set.of(408, 429, 500, 502, 503, 504);
  // A longer Retry-After is not waited on: the caller gets that response's error at once.
  private static final long MAX_RETRY_AFTER_MS = 60_000;
  // Optional adapter is mandatory: without it, Gson falls back to reflection
  // on java.util.Optional, which the JDK 17+ module system refuses to allow.
  private static final Gson GSON =
      new GsonBuilder()
          .registerTypeAdapterFactory(new OptionalTypeAdapterFactory())
          .registerTypeAdapterFactory(new ExplicitNullTypeAdapterFactory())
          .create();

  private final ClientOptions options;
  private final HttpClient httpClient;
  private final Sleeper sleeper;
  private final String userAgent;

  interface Sleeper {
    void sleep(long millis) throws InterruptedException;
  }

  public NuntlyClient(ClientOptions options) {
    this(
        options,
        HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(options.timeout())
            .build(),
        Thread::sleep);
  }

  NuntlyClient(ClientOptions options, HttpClient httpClient, Sleeper sleeper) {
    this.options = options;
    this.httpClient = httpClient;
    this.sleeper = sleeper;
    var appInfoSuffix =
        options
            .appInfo()
            .map(app -> " (" + app.name() + app.version().map(v -> "/" + v).orElse("") + ")")
            .orElse("");
    this.userAgent =
        "@nuntly/sdk-java/" + Version.SDK_VERSION + appInfoSuffix + " " + detectPlatform();
  }

  public <T> T get(String path, Class<T> type, RequestOptions opts) {
    return unwrap(request("GET", path, null, opts), type);
  }

  public <T> T get(String path, Class<T> type, Map<String, ?> query, RequestOptions opts) {
    var queryPath = query.isEmpty() ? path : path + "?" + encodeQuery(query);
    return unwrap(request("GET", queryPath, null, opts), type);
  }

  public <T> T post(String path, Object body, Class<T> type, RequestOptions opts) {
    return unwrap(request("POST", path, body, opts), type);
  }

  public <T> T put(String path, Object body, Class<T> type, RequestOptions opts) {
    return unwrap(request("PUT", path, body, opts), type);
  }

  public <T> T patch(String path, Object body, Class<T> type, RequestOptions opts) {
    return unwrap(request("PATCH", path, body, opts), type);
  }

  public <T> T delete(String path, Class<T> type, RequestOptions opts) {
    return unwrap(request("DELETE", path, null, opts), type);
  }

  public void deleteVoid(String path, RequestOptions opts) {
    request("DELETE", path, null, opts);
  }

  public HttpResponse<String> rawRequest(
      String method, String path, Object body, RequestOptions opts) {
    return request(method, path, body, opts);
  }

  /**
   * Issue a paginated GET, decode the response into a {@link CursorPage} of items, and capture the
   * original query so {@link CursorPage#nextPage()} replays the same filters with only the cursor
   * updated.
   */
  public <T> CursorPage<T> list(
      String path, Class<T> itemType, Map<String, String> query, RequestOptions opts) {
    var queryPath = query.isEmpty() ? path : path + "?" + encodeQuery(query);
    var response = request("GET", queryPath, null, opts);
    var json = JsonParser.parseString(response.body()).getAsJsonObject();
    @SuppressWarnings("unchecked")
    T[] items = (T[]) GSON.fromJson(json.get("data"), Array.newInstance(itemType, 0).getClass());
    String next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(
        java.util.List.of(items),
        next,
        (cursor) -> {
          var nextQuery = new HashMap<>(query);
          cursor.ifPresent(c -> nextQuery.put("cursor", c));
          return list(path, itemType, nextQuery, opts);
        });
  }

  public Gson gson() {
    return GSON;
  }

  private HttpResponse<String> request(
      String method, String path, Object body, RequestOptions opts) {
    var timeout = opts.timeout().orElse(options.timeout());
    var maxRetries = options.retryEnabled() ? opts.maxRetries().orElse(options.maxRetries()) : 0;
    var backoff = options.backoff();
    var hooks = options.hooks();
    var uri = URI.create(options.baseUrl() + path);

    var reqBuilder =
        HttpRequest.newBuilder()
            .uri(uri)
            .timeout(timeout)
            .header("Authorization", "Bearer " + options.apiKey())
            .header("User-Agent", userAgent)
            .header("Content-Type", "application/json")
            .header("Accept", "application/json");

    for (var entry : opts.headers().entrySet()) {
      reqBuilder.header(entry.getKey(), entry.getValue());
    }

    var bodyPublisher =
        body != null
            ? HttpRequest.BodyPublishers.ofString(GSON.toJson(body))
            : HttpRequest.BodyPublishers.noBody();
    reqBuilder.method(method, bodyPublisher);

    var req = reqBuilder.build();
    // A POST without Idempotency-Key may already have been applied: only a 429 is safe to replay.
    var replaySafe =
        !method.equals("POST") || req.headers().firstValue("Idempotency-Key").isPresent();

    if (options.debug()) {
      System.err.printf("-> %s %s%n", method, uri);
    }
    if (hooks.onRequest() != null) hooks.onRequest().accept(req);

    for (int attempt = 0; attempt <= maxRetries; attempt++) {
      try {
        var response = httpClient.send(req, HttpResponse.BodyHandlers.ofString());

        if (options.debug()) {
          var requestId = response.headers().firstValue("x-request-id").orElse("");
          System.err.printf(
              "<- %d %s %s%s%n",
              response.statusCode(),
              method,
              uri,
              requestId.isEmpty() ? "" : " [" + requestId + "]");
        }
        if (hooks.onResponse() != null) hooks.onResponse().accept(response, req);

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
          if (hooks.onSuccess() != null) hooks.onSuccess().accept(response.body(), req);
          return response;
        }

        var status = response.statusCode();
        // The server can force or forbid a retry; otherwise the status rules apply.
        var retryable =
            switch (response.headers().firstValue("x-should-retry").orElse("")) {
              case "true" -> true;
              case "false" -> false;
              default -> RETRYABLE_CODES.contains(status) && (replaySafe || status == 429);
            };
        var retryAfter = response.headers().firstValue("retry-after");
        if (attempt < maxRetries
            && retryable
            && retryAfter.flatMap(RetryAfter::parseMillis).orElse(0L) <= MAX_RETRY_AFTER_MS) {
          var delay = computeRetryDelay(attempt, retryAfter, backoff);
          if (options.debug()) {
            System.err.printf("~> Retry #%d in %dms%n", attempt + 1, delay);
          }
          if (hooks.onRetry() != null) {
            hooks.onRetry().accept(new Hooks.RetryContext(attempt + 1, response, null, req));
          }
          sleeper.sleep(delay);
          continue;
        }

        var error = ApiError.from(response);
        if (hooks.onError() != null) hooks.onError().accept(error, req);
        throw error;

      } catch (IOException e) {
        if (attempt < maxRetries && replaySafe) {
          if (hooks.onRetry() != null) {
            hooks.onRetry().accept(new Hooks.RetryContext(attempt + 1, null, e, req));
          }
          try {
            sleeper.sleep(computeRetryDelay(attempt, Optional.empty(), backoff));
          } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            var err = new ConnectionError("Request interrupted", ie);
            if (hooks.onError() != null) hooks.onError().accept(err, req);
            throw err;
          }
          continue;
        }
        var err =
            e instanceof HttpTimeoutException
                ? new ConnectionError.TimeoutError(e)
                : new ConnectionError(e.getMessage(), e);
        if (hooks.onError() != null) hooks.onError().accept(err, req);
        throw err;
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        var err = new ConnectionError("Request interrupted", e);
        if (hooks.onError() != null) hooks.onError().accept(err, req);
        throw err;
      }
    }

    throw new ConnectionError("Max retries exceeded", null);
  }

  static long computeRetryDelay(int attempt, Optional<String> retryAfter, BackoffStrategy backoff) {
    var retryAfterMs = retryAfter.flatMap(RetryAfter::parseMillis);
    if (retryAfterMs.isPresent()) return retryAfterMs.get();
    var base =
        Math.min(
            (long) (backoff.initialIntervalMs() * Math.pow(backoff.exponent(), attempt)),
            backoff.maxIntervalMs());
    return (long) (base * (0.75 + 0.25 * ThreadLocalRandom.current().nextDouble()));
  }

  private <T> T unwrap(HttpResponse<String> response, Class<T> type) {
    if (type == Void.class) return null;
    var json = JsonParser.parseString(response.body()).getAsJsonObject();
    if (json.has("data")) {
      return GSON.fromJson(json.get("data"), type);
    }
    return GSON.fromJson(json, type);
  }

  // A collection value is sent as repeated keys (format=html&format=text).
  private String encodeQuery(Map<String, ?> query) {
    return query.entrySet().stream()
        .flatMap(
            e -> {
              var key = URLEncoder.encode(e.getKey(), StandardCharsets.UTF_8);
              var values =
                  e.getValue() instanceof Collection<?> c ? c.stream() : Stream.of(e.getValue());
              return values.map(
                  v -> key + "=" + URLEncoder.encode(queryValue(v), StandardCharsets.UTF_8));
            })
        .collect(Collectors.joining("&"));
  }

  // An enum goes out as its @SerializedName wire value (html), not its constant name (HTML).
  private static String queryValue(Object value) {
    return value instanceof Enum<?> ? GSON.toJsonTree(value).getAsString() : String.valueOf(value);
  }

  private static String detectPlatform() {
    var vendor = System.getProperty("java.vendor", "");
    var version = System.getProperty("java.version", "");
    if (vendor.contains("GraalVM")) return "GraalVM/" + version;
    return "Java/" + version;
  }
}
