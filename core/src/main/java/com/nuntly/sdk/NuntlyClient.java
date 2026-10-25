package com.nuntly.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.ToNumberPolicy;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class NuntlyClient {
  // 409 is a deterministic business conflict: a retry only adds latency.
  private static final Set<Integer> RETRYABLE_CODES = Set.of(408, 429, 500, 502, 503, 504);
  private static final Set<String> IDEMPOTENT_METHODS =
      Set.of("GET", "HEAD", "OPTIONS", "PUT", "DELETE");
  // A longer Retry-After is not waited on: the caller gets that response's error at once.
  private static final long MAX_RETRY_AFTER_MS = 60_000;
  // Optional adapter is mandatory: without it, Gson falls back to reflection
  // on java.util.Optional, which the JDK 17+ module system refuses to allow.
  // LONG_OR_DOUBLE: an integer in a map or Object value reads as an exact Long, not a Double
  // that loses precision above 2^53.
  private static final Gson GSON =
      new GsonBuilder()
          .registerTypeAdapterFactory(new OptionalTypeAdapterFactory())
          .registerTypeAdapterFactory(new ExplicitNullTypeAdapterFactory())
          .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
          .setNumberToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
          .create();

  private final ClientOptions options;
  private final HttpClient httpClient;
  private final Sleeper sleeper;
  private final String userAgent;

  interface Sleeper {
    void sleep(long millis) throws InterruptedException;
  }

  public NuntlyClient(ClientOptions options) {
    this(options, httpClient(options.timeout()), Thread::sleep);
  }

  // A zero timeout sets none, as for a request.
  private static HttpClient httpClient(Duration timeout) {
    var builder = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2);
    if (timeout.isPositive()) builder.connectTimeout(timeout);
    return builder.build();
  }

  static Duration checkTimeout(Duration timeout) {
    if (timeout.isNegative()) {
      throw new NuntlyError("timeout must be zero, for none, or positive, not " + timeout + ".");
    }
    return timeout;
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
    return unwrap(request("GET", path, null, opts, false, type != Void.class), type);
  }

  public <T> T get(String path, Class<T> type, Map<String, ?> query, RequestOptions opts) {
    var queryPath = withQuery(path, query);
    return unwrap(request("GET", queryPath, null, opts, false, type != Void.class), type);
  }

  public <T> T post(String path, Object body, Class<T> type, RequestOptions opts) {
    return unwrap(request("POST", path, body, opts, false, type != Void.class), type);
  }

  // Only for an endpoint the API deduplicates by Idempotency-Key: a retry replays it on a 5xx.
  <T> T postIdempotent(String path, Object body, Class<T> type, IdempotentRequestOptions opts) {
    var keyed = Resource.withIdempotencyKey(opts);
    var plain = new RequestOptions(keyed.timeout(), keyed.maxRetries(), keyed.headers());
    return unwrap(request("POST", path, body, plain, true, type != Void.class), type);
  }

  public <T> T put(String path, Object body, Class<T> type, RequestOptions opts) {
    return unwrap(request("PUT", path, body, opts, false, type != Void.class), type);
  }

  public <T> T patch(String path, Object body, Class<T> type, RequestOptions opts) {
    return unwrap(request("PATCH", path, body, opts, false, type != Void.class), type);
  }

  public <T> T delete(String path, Class<T> type, RequestOptions opts) {
    return unwrap(request("DELETE", path, null, opts, false, type != Void.class), type);
  }

  public void deleteVoid(String path, RequestOptions opts) {
    request("DELETE", path, null, opts, false, false);
  }

  /** Sends a request and returns its 2xx response as is: the body is not read as JSON. */
  public HttpResponse<String> rawRequest(
      String method, String path, Object body, RequestOptions opts) {
    return request(method, path, body, opts, false, false).response();
  }

  /**
   * Issue a paginated GET, decode the response into a {@link CursorPage} of items, and capture the
   * original query so {@link CursorPage#nextPage()} replays the same filters with only the cursor
   * updated. Query values are encoded as in {@link #get(String, Class, Map, RequestOptions)}.
   */
  public <T> CursorPage<T> list(
      String path, Class<T> itemType, Map<String, ?> query, RequestOptions opts) {
    var queryPath = withQuery(path, query);
    var json = request("GET", queryPath, null, opts, false, true).json();
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
          var nextQuery = new HashMap<String, Object>(query);
          cursor.ifPresent(c -> nextQuery.put("cursor", c));
          return list(path, itemType, nextQuery, opts);
        },
        Optional.ofNullable(query.get("cursor")).map(String::valueOf));
  }

  public Gson gson() {
    return GSON;
  }

  /** The Gson configuration of every request and response, the instance {@link #gson()} returns. */
  public static Gson defaultGson() {
    return GSON;
  }

  // The final 2xx response, with its body parsed when the caller reads it as JSON.
  private record Reply(HttpResponse<String> response, JsonObject json) {}

  private Reply request(
      String method,
      String path,
      Object body,
      RequestOptions opts,
      boolean idempotent,
      boolean readsJson) {
    var timeout = checkTimeout(opts.timeout().orElse(options.timeout()));
    var maxRetries = options.retryEnabled() ? opts.maxRetries().orElse(options.maxRetries()) : 0;
    var backoff = options.backoff();
    var hooks = options.hooks();
    var uri = URI.create(options.baseUrl() + path);

    var reqBuilder =
        HttpRequest.newBuilder()
            .uri(uri)
            .header("Authorization", "Bearer " + options.apiKey())
            .header("User-Agent", userAgent)
            .header("Content-Type", "application/json")
            .header("Accept", "application/json");

    if (timeout.isPositive()) reqBuilder.timeout(timeout);
    for (var entry : opts.headers().entrySet()) {
      reqBuilder.header(entry.getKey(), entry.getValue());
    }

    var bodyPublisher =
        body != null
            ? HttpRequest.BodyPublishers.ofString(GSON.toJson(body))
            : HttpRequest.BodyPublishers.noBody();
    reqBuilder.method(method, bodyPublisher);

    var req = reqBuilder.build();
    // A POST or PATCH may already have been applied: only a 429 is safe to replay, unless the
    // operation is one the API deduplicates by Idempotency-Key and the request carries a key.
    var replaySafe =
        IDEMPOTENT_METHODS.contains(method)
            || (idempotent && req.headers().firstValue("Idempotency-Key").isPresent());

    // Hooks and errors see the request without the API key.
    var hookRequest = RedactedResponse.redact(req);

    if (options.debug()) {
      System.err.printf("-> %s %s%n", method, uri);
    }

    // Hooks follow the TypeScript order: onRequest before every attempt, onRetry before each retry,
    // onResponse once on the final response, then onSuccess or onError.
    for (int attempt = 0; attempt <= maxRetries; attempt++) {
      if (hooks.onRequest() != null) hooks.onRequest().accept(hookRequest);
      HttpResponse<String> response;
      try {
        response =
            new RedactedResponse(
                httpClient.send(req, HttpResponse.BodyHandlers.ofString()), hookRequest);
      } catch (IOException e) {
        if (attempt < maxRetries && replaySafe) {
          if (hooks.onRetry() != null) {
            hooks.onRetry().accept(new Hooks.RetryContext(attempt + 1, null, e, hookRequest));
          }
          sleep(computeRetryDelay(attempt, Optional.empty(), backoff), hooks, hookRequest);
          continue;
        }
        var err =
            e instanceof HttpTimeoutException
                ? new ConnectionError.TimeoutError(e)
                : new ConnectionError(e.getMessage(), e);
        throw reportError(hooks, err, hookRequest);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw reportError(hooks, new ConnectionError("Request interrupted", e), hookRequest);
      }

      var status = response.statusCode();
      if (options.debug()) {
        var requestId = response.headers().firstValue("x-request-id").orElse("");
        System.err.printf(
            "<- %d %s %s%s%n",
            status, method, uri, requestId.isEmpty() ? "" : " [" + requestId + "]");
      }
      var success = status >= 200 && status < 300;

      if (!success && attempt < maxRetries && retryable(response, replaySafe)) {
        var delay =
            computeRetryDelay(attempt, response.headers().firstValue("retry-after"), backoff);
        if (options.debug()) {
          System.err.printf("~> Retry #%d in %dms%n", attempt + 1, delay);
        }
        if (hooks.onRetry() != null) {
          hooks.onRetry().accept(new Hooks.RetryContext(attempt + 1, response, null, hookRequest));
        }
        sleep(delay, hooks, hookRequest);
        continue;
      }

      if (hooks.onResponse() != null) hooks.onResponse().accept(response, hookRequest);
      if (!success) throw reportError(hooks, ApiError.from(response), hookRequest);
      JsonObject json = null;
      if (readsJson) {
        try {
          json = parseSuccess(response);
        } catch (NuntlyError e) {
          throw reportError(hooks, e, hookRequest);
        }
      }
      if (hooks.onSuccess() != null) hooks.onSuccess().accept(response.body(), hookRequest);
      return new Reply(response, json);
    }

    throw new ConnectionError("Max retries exceeded", null);
  }

  // The server can force or forbid a retry; otherwise the status rules apply. A Retry-After above
  // the cap is not waited on, whatever x-should-retry says.
  private static boolean retryable(HttpResponse<String> response, boolean replaySafe) {
    var status = response.statusCode();
    var retryAfter = response.headers().firstValue("retry-after");
    if (retryAfter.flatMap(RetryAfter::parseMillis).orElse(0L) > MAX_RETRY_AFTER_MS) return false;
    return switch (response
        .headers()
        .firstValue("x-should-retry")
        .orElse("")
        .toLowerCase(Locale.ROOT)) {
      case "true" -> true;
      case "false" -> false;
      default -> RETRYABLE_CODES.contains(status) && (replaySafe || status == 429);
    };
  }

  private void sleep(long millis, Hooks hooks, HttpRequest hookRequest) {
    try {
      sleeper.sleep(millis);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw reportError(hooks, new ConnectionError("Request interrupted", e), hookRequest);
    }
  }

  // The caller gets the original error: a failing hook must not hide why the request failed.
  private static NuntlyError reportError(Hooks hooks, NuntlyError error, HttpRequest req) {
    if (hooks.onError() != null) {
      try {
        hooks.onError().accept(error, req);
      } catch (VirtualMachineError fatal) {
        // Out of memory or stack: the JVM cannot be trusted to go on, so nothing hides it.
        throw fatal;
      } catch (Throwable hookError) {
        // A hook that logs and rethrows the same error must not make addSuppressed throw.
        if (hookError != error) error.addSuppressed(hookError);
      }
    }
    return error;
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

  // Every 2xx of the API carries a JSON object; anything else is no answer the caller can use.
  // A 2xx means the API may have applied the request, so the error says so before a retry.
  private static JsonObject parseSuccess(HttpResponse<String> response) {
    var body = response.body();
    if (body == null || body.isEmpty()) {
      throw notJson(response, "an empty body where JSON was expected", null);
    }
    JsonElement json;
    try {
      json = JsonParser.parseString(body);
    } catch (JsonParseException e) {
      throw notJson(response, "a body that is not JSON", e);
    }
    if (!json.isJsonObject()) throw notJson(response, "a JSON body that is not an object", null);
    return json.getAsJsonObject();
  }

  private static NuntlyError notJson(HttpResponse<String> response, String what, Throwable cause) {
    return new NuntlyError(
        "The API answered "
            + response.statusCode()
            + " with "
            + what
            + ": the request may have been applied.",
        cause);
  }

  private <T> T unwrap(Reply reply, Class<T> type) {
    if (type == Void.class) return null;
    var json = reply.json();
    if (json.has("data")) {
      return GSON.fromJson(json.get("data"), type);
    }
    return GSON.fromJson(json, type);
  }

  private static String withQuery(String path, Map<String, ?> query) {
    var encoded = encodeQuery(query);
    return encoded.isEmpty() ? path : path + "?" + encoded;
  }

  // A collection value is sent as repeated keys (format=html&format=text); a null one is left out.
  private static String encodeQuery(Map<String, ?> query) {
    return query.entrySet().stream()
        .filter(e -> e.getValue() != null)
        .flatMap(
            e -> {
              var key = URLEncoder.encode(e.getKey(), StandardCharsets.UTF_8);
              var values =
                  e.getValue() instanceof Collection<?> c ? c.stream() : Stream.of(e.getValue());
              return values.map(
                  v ->
                      key
                          + "="
                          + URLEncoder.encode(queryValue(e.getKey(), v), StandardCharsets.UTF_8));
            })
        .collect(Collectors.joining("&"));
  }

  // An enum goes out as its @SerializedName wire value (html), not its constant name (HTML).
  private static String queryValue(String name, Object value) {
    // Only a list can hold a null here: a null param itself is left out before.
    if (value == null) throw new NuntlyError("Query param '" + name + "' must not contain null.");
    if (!(value instanceof Enum<?> member)) return String.valueOf(value);
    var wire = GSON.toJsonTree(value);
    // An open enum's UNKNOWN has no wire value.
    if (wire.isJsonNull()) {
      throw new NuntlyError(
          "Query param '"
              + name
              + "' cannot send "
              + member.getDeclaringClass().getSimpleName()
              + "."
              + member.name()
              + ", a value read from the API.");
    }
    return wire.getAsString();
  }

  private static String detectPlatform() {
    var vendor = System.getProperty("java.vendor", "");
    var version = System.getProperty("java.version", "");
    if (vendor.contains("GraalVM")) return "GraalVM/" + version;
    return "Java/" + version;
  }
}
