package com.nuntly.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class NuntlyClient {
  private static final Set<Integer> RETRYABLE_CODES = Set.of(408, 409, 429, 500, 502, 503, 504);
  private static final Gson GSON = new GsonBuilder().create();

  private final ClientOptions options;
  private final HttpClient httpClient;
  private final String userAgent;
  private volatile HttpResponse<String> lastResponse;

  public NuntlyClient(ClientOptions options) {
    this.options = options;
    this.httpClient =
        HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(options.timeout())
            .build();
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

  public <T> T get(String path, Class<T> type, Map<String, String> query, RequestOptions opts) {
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

  public HttpResponse<String> lastResponse() {
    return lastResponse;
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

    if (options.debug()) {
      System.err.printf("-> %s %s%n", method, uri);
    }
    if (hooks.onRequest() != null) hooks.onRequest().accept(req);

    for (int attempt = 0; attempt <= maxRetries; attempt++) {
      try {
        var response = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
        this.lastResponse = response;

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

        if (attempt < maxRetries && RETRYABLE_CODES.contains(response.statusCode())) {
          var delay = computeRetryDelay(attempt, response, backoff);
          if (options.debug()) {
            System.err.printf("~> Retry #%d in %dms%n", attempt + 1, delay);
          }
          if (hooks.onRetry() != null) {
            hooks.onRetry().accept(new Hooks.RetryContext(attempt + 1, response, null, req));
          }
          Thread.sleep(delay);
          continue;
        }

        var error = ApiError.from(response);
        if (hooks.onError() != null) hooks.onError().accept(error, req);
        throw error;

      } catch (IOException e) {
        if (attempt < maxRetries) {
          if (hooks.onRetry() != null) {
            hooks.onRetry().accept(new Hooks.RetryContext(attempt + 1, null, e, req));
          }
          try {
            Thread.sleep(computeRetryDelay(attempt, null, backoff));
          } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            var err = new ConnectionError(e.getMessage(), e);
            if (hooks.onError() != null) hooks.onError().accept(err, req);
            throw err;
          }
          continue;
        }
        var err = new ConnectionError(e.getMessage(), e);
        if (hooks.onError() != null) hooks.onError().accept(err, req);
        throw err;
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        var err = new ConnectionError.TimeoutError(e);
        if (hooks.onError() != null) hooks.onError().accept(err, req);
        throw err;
      }
    }

    throw new ConnectionError("Max retries exceeded", null);
  }

  private long computeRetryDelay(
      int attempt, HttpResponse<String> response, BackoffStrategy backoff) {
    if (response != null && response.statusCode() == 429) {
      var retryAfter = response.headers().firstValue("retry-after");
      if (retryAfter.isPresent()) {
        try {
          return Long.parseLong(retryAfter.get()) * 1000;
        } catch (NumberFormatException ignored) {
        }
      }
    }
    var base =
        Math.min(
            (long) (backoff.initialIntervalMs() * Math.pow(backoff.exponent(), attempt)),
            backoff.maxIntervalMs());
    var jitter = (long) (base * 0.25 * ThreadLocalRandom.current().nextDouble());
    return base + jitter;
  }

  private <T> T unwrap(HttpResponse<String> response, Class<T> type) {
    if (type == Void.class) return null;
    var json = JsonParser.parseString(response.body()).getAsJsonObject();
    if (json.has("data")) {
      return GSON.fromJson(json.get("data"), type);
    }
    return GSON.fromJson(json, type);
  }

  private String encodeQuery(Map<String, String> query) {
    return query.entrySet().stream()
        .map(e -> e.getKey() + "=" + e.getValue())
        .reduce((a, b) -> a + "&" + b)
        .orElse("");
  }

  private static String detectPlatform() {
    var vendor = System.getProperty("java.vendor", "");
    var version = System.getProperty("java.version", "");
    if (vendor.contains("GraalVM")) return "GraalVM/" + version;
    return "Java/" + version;
  }
}
