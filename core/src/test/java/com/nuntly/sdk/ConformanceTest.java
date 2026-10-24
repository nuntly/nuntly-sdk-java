package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URLDecoder;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/** Runs conformance/{retry,errors,pagination,transport}.json against the client. */
class ConformanceTest {

  // The vectors are in conformance/ at the repository root, the nearest ancestor that has one.
  static JsonObject vectors(String file) throws IOException {
    for (var dir = Path.of("").toAbsolutePath(); dir != null; dir = dir.getParent()) {
      var path = dir.resolve("conformance").resolve(file);
      if (Files.exists(path))
        return JsonParser.parseString(Files.readString(path)).getAsJsonObject();
    }
    throw new IOException("conformance/" + file + " not found");
  }

  static Stream<JsonObject> cases(String file) throws IOException {
    return vectors(file).getAsJsonArray("cases").asList().stream()
        .map(JsonElement::getAsJsonObject)
        .filter(
            c ->
                !c.has("runtimes")
                    || c.getAsJsonArray("runtimes").asList().stream()
                        .anyMatch(r -> r.getAsString().equals("java")));
  }

  private static final Map<String, Predicate<Throwable>> KINDS =
      Map.ofEntries(
          Map.entry("bad_request", e -> e instanceof ApiError.BadRequestError),
          Map.entry("authentication", e -> e instanceof ApiError.AuthenticationError),
          Map.entry("permission_denied", e -> e instanceof ApiError.PermissionDeniedError),
          Map.entry("not_found", e -> e instanceof ApiError.NotFoundError),
          Map.entry("conflict", e -> e instanceof ApiError.ConflictError),
          Map.entry("unprocessable_entity", e -> e instanceof ApiError.UnprocessableEntityError),
          Map.entry("rate_limit", e -> e instanceof ApiError.RateLimitError),
          Map.entry("internal_server", e -> e instanceof ApiError.InternalServerError),
          Map.entry("api", e -> e != null && e.getClass() == ApiError.class),
          Map.entry("connection", e -> e instanceof ConnectionError),
          Map.entry("timeout", e -> e instanceof ConnectionError.TimeoutError),
          Map.entry("hook", e -> e instanceof HookFailure),
          Map.entry("no_more_pages", e -> e instanceof NoSuchElementException));

  static final class HookFailure extends RuntimeException {
    HookFailure() {
      super("hook failed");
    }
  }

  static void assertWithin(long actual, JsonElement expected) {
    long min =
        expected.isJsonArray()
            ? expected.getAsJsonArray().get(0).getAsLong()
            : expected.getAsLong();
    long max =
        expected.isJsonArray()
            ? expected.getAsJsonArray().get(1).getAsLong()
            : expected.getAsLong();
    assertTrue(actual >= min && actual <= max, actual + " not in [" + min + ", " + max + "]");
  }

  static void assertError(Throwable error, JsonObject expected) {
    var kind = expected.get("kind").getAsString();
    assertTrue(KINDS.get(kind).test(error), "expected " + kind + ", got " + error);
    if (expected.has("notKind")) {
      var notKind = expected.get("notKind").getAsString();
      assertTrue(!KINDS.get(notKind).test(error), "expected no " + notKind + ", got " + error);
    }
    if (!(error instanceof ApiError api)) return;
    if (expected.has("status")) assertEquals(expected.get("status").getAsInt(), api.status());
    if (expected.has("code")) {
      assertEquals(expected.get("code").getAsString(), api.code());
      assertEquals(Optional.ofNullable(expected.get("details")), api.details());
    }
    if (expected.has("title")) assertEquals(expected.get("title").getAsString(), api.title());
    if (expected.has("requestId") || expected.has("code")) {
      assertEquals(
          Optional.ofNullable(expected.get("requestId")).map(JsonElement::getAsString),
          api.requestId());
    }
    if (expected.has("retryAfterMs")) {
      var retryAfter = ((ApiError.RateLimitError) api).retryAfter();
      assertTrue(retryAfter.isPresent(), "retryAfter is empty");
      assertWithin(retryAfter.get(), expected.get("retryAfterMs"));
    }
  }

  /** Serves the scripted responses in order and records each request it gets. */
  static final class ScriptedHttpClient extends HttpClient {
    private final List<JsonObject> responses;
    final List<HttpRequest> requests = new ArrayList<>();

    ScriptedHttpClient(List<JsonObject> responses) {
      this.responses = responses;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> HttpResponse<T> send(HttpRequest request, HttpResponse.BodyHandler<T> handler)
        throws IOException {
      if (requests.size() == responses.size()) throw new IllegalStateException("no response left");
      var r = responses.get(requests.size());
      requests.add(request);
      if (r.has("network")) throw new IOException("Connection reset");
      if (r.has("timeout")) throw new HttpTimeoutException("request timed out");
      return (HttpResponse<T>) new Scripted(r, request);
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(
        HttpRequest request, HttpResponse.BodyHandler<T> handler) {
      throw new UnsupportedOperationException();
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(
        HttpRequest request,
        HttpResponse.BodyHandler<T> handler,
        HttpResponse.PushPromiseHandler<T> pushPromiseHandler) {
      throw new UnsupportedOperationException();
    }

    @Override
    public Optional<CookieHandler> cookieHandler() {
      return Optional.empty();
    }

    @Override
    public Optional<Duration> connectTimeout() {
      return Optional.empty();
    }

    @Override
    public Redirect followRedirects() {
      return Redirect.NEVER;
    }

    @Override
    public Optional<ProxySelector> proxy() {
      return Optional.empty();
    }

    @Override
    public SSLContext sslContext() {
      return null;
    }

    @Override
    public SSLParameters sslParameters() {
      return null;
    }

    @Override
    public Optional<Authenticator> authenticator() {
      return Optional.empty();
    }

    @Override
    public Version version() {
      return Version.HTTP_1_1;
    }

    @Override
    public Optional<Executor> executor() {
      return Optional.empty();
    }
  }

  private record Scripted(JsonObject r, HttpRequest request) implements HttpResponse<String> {
    @Override
    public int statusCode() {
      return r.get("status").getAsInt();
    }

    @Override
    public HttpHeaders headers() {
      var map = new HashMap<String, List<String>>();
      if (!r.has("rawBody")) map.put("content-type", List.of("application/json"));
      if (r.has("headers")) {
        r.getAsJsonObject("headers")
            .entrySet()
            .forEach(e -> map.put(e.getKey(), List.of(e.getValue().getAsString())));
      }
      return HttpHeaders.of(map, (k, v) -> true);
    }

    @Override
    public String body() {
      if (r.has("rawBody")) return r.get("rawBody").getAsString();
      return r.has("body") ? r.get("body").toString() : "{}";
    }

    @Override
    public Optional<HttpResponse<String>> previousResponse() {
      return Optional.empty();
    }

    @Override
    public Optional<SSLSession> sslSession() {
      return Optional.empty();
    }

    @Override
    public URI uri() {
      return request.uri();
    }

    @Override
    public HttpClient.Version version() {
      return HttpClient.Version.HTTP_1_1;
    }
  }

  private static List<JsonObject> objects(JsonElement array) {
    return array.getAsJsonArray().asList().stream().map(JsonElement::getAsJsonObject).toList();
  }

  @TestFactory
  Stream<DynamicTest> retry() throws IOException {
    return cases("retry.json")
        .map(c -> DynamicTest.dynamicTest(c.get("name").getAsString(), () -> runRetry(c)));
  }

  private static void runRetry(JsonObject c) {
    var http = new ScriptedHttpClient(objects(c.get("responses")));
    var delays = new ArrayList<Long>();
    var retries = new AtomicInteger();
    var hookCalls = new AtomicInteger();
    var request = c.getAsJsonObject("request");
    var client = c.has("client") ? c.getAsJsonObject("client") : new JsonObject();
    var builder =
        ClientOptions.builder()
            .apiKey("test_key")
            .baseUrl("https://api.test.com")
            .hooks(
                Hooks.builder()
                    .onRetry(ctx -> retries.incrementAndGet())
                    .onRequest(
                        req -> {
                          hookCalls.incrementAndGet();
                          if (request.has("onRequestThrows")) throw new HookFailure();
                        })
                    .onResponse(
                        (res, req) -> {
                          if (request.has("onResponseThrows")) throw new HookFailure();
                        })
                    .build());
    if (client.has("retry")) builder.disableRetry();
    if (client.has("maxRetries")) builder.maxRetries(client.get("maxRetries").getAsInt());
    var nuntly = new NuntlyClient(builder.build(), http, delays::add);

    var headers = new HashMap<String, String>();
    if (request.has("idempotencyKey")) {
      headers.put("Idempotency-Key", request.get("idempotencyKey").getAsString());
    }
    var opts = RequestOptions.builder().headers(headers);
    if (request.has("maxRetries")) opts.maxRetries(request.get("maxRetries").getAsInt());
    var body = request.has("body") ? (Object) request.get("body") : null;

    HttpResponse<String> response = null;
    Throwable error = null;
    try {
      response =
          nuntly.rawRequest(
              request.get("method").getAsString(),
              request.get("path").getAsString(),
              body,
              opts.build());
    } catch (RuntimeException e) {
      error = e;
    }

    var expected = c.getAsJsonObject("expected");
    assertEquals(expected.get("calls").getAsInt(), http.requests.size(), "calls");
    if (expected.has("retries")) assertEquals(expected.get("retries").getAsInt(), retries.get());
    if (expected.has("hookCalls")) {
      assertEquals(expected.get("hookCalls").getAsInt(), hookCalls.get());
    }
    if (expected.has("result")) {
      assertNotNull(response, () -> "unexpected error " + http.requests.size());
      assertEquals(
          expected.getAsJsonObject("result").get("status").getAsInt(), response.statusCode());
    }
    if (expected.has("error")) assertError(error, expected.getAsJsonObject("error"));
    if (expected.has("sameIdempotencyKey")) {
      var key = request.get("idempotencyKey").getAsString();
      http.requests.forEach(
          r -> assertEquals(List.of(key), r.headers().allValues("Idempotency-Key")));
    }
    if (expected.has("delaysMs")) {
      var ranges = expected.getAsJsonArray("delaysMs");
      assertEquals(ranges.size(), delays.size(), "delays " + delays);
      for (int i = 0; i < ranges.size(); i++) assertWithin(delays.get(i), ranges.get(i));
    }
  }

  @TestFactory
  Stream<DynamicTest> errors() throws IOException {
    return cases("errors.json")
        .map(c -> DynamicTest.dynamicTest(c.get("name").getAsString(), () -> runError(c)));
  }

  private static void runError(JsonObject c) {
    var http = new ScriptedHttpClient(List.of(c.getAsJsonObject("response")));
    var nuntly =
        new NuntlyClient(
            ClientOptions.builder()
                .apiKey("test_key")
                .baseUrl("https://api.test.com")
                .disableRetry()
                .build(),
            http,
            ms -> {});

    var error =
        assertThrows(
            RuntimeException.class,
            () -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));

    assertError(error, c.getAsJsonObject("expected"));
  }

  @TestFactory
  Stream<DynamicTest> pagination() throws IOException {
    return cases("pagination.json")
        .map(c -> DynamicTest.dynamicTest(c.get("name").getAsString(), () -> runPagination(c)));
  }

  private static void runPagination(JsonObject c) {
    var http = new ScriptedHttpClient(objects(c.get("responses")));
    var nuntly =
        new NuntlyClient(
            ClientOptions.builder()
                .apiKey("test_key")
                .baseUrl("https://api.test.com")
                .disableRetry()
                .build(),
            http,
            ms -> {});
    var request = c.getAsJsonObject("request");
    var query = stringMap(request.getAsJsonObject("query"));

    var ids = new ArrayList<String>();
    Throwable error = null;
    try {
      var page =
          nuntly.list(
              request.get("path").getAsString(), JsonObject.class, query, RequestOptions.none());
      if (c.get("action").getAsString().equals("nextPage")) {
        page.nextPage();
      } else {
        page.forEach(item -> ids.add(item.get("id").getAsString()));
      }
    } catch (RuntimeException e) {
      error = e;
    }

    var expected = c.getAsJsonObject("expected");
    assertEquals(expected.get("calls").getAsInt(), http.requests.size(), "calls");
    if (expected.has("queries")) {
      var queries = http.requests.stream().map(r -> queryOf(r.uri())).toList();
      assertEquals(
          objects(expected.get("queries")).stream().map(ConformanceTest::stringMap).toList(),
          queries);
    }
    if (expected.has("ids")) {
      assertEquals(
          expected.getAsJsonArray("ids").asList().stream().map(JsonElement::getAsString).toList(),
          ids);
    }
    if (expected.has("error")) assertError(error, expected.getAsJsonObject("error"));
    else assertEquals(null, error);
  }

  private static Map<String, String> stringMap(JsonObject object) {
    var map = new HashMap<String, String>();
    object.entrySet().forEach(e -> map.put(e.getKey(), e.getValue().getAsString()));
    return map;
  }

  private static String decode(String s) {
    return URLDecoder.decode(s, StandardCharsets.UTF_8);
  }

  private static Map<String, String> queryOf(URI uri) {
    var map = new HashMap<String, String>();
    if (uri.getQuery() == null) return map;
    for (var pair : uri.getRawQuery().split("&")) {
      var kv = pair.split("=", 2);
      map.put(decode(kv[0]), kv.length == 2 ? decode(kv[1]) : "");
    }
    return map;
  }

  @TestFactory
  Stream<DynamicTest> transport() throws IOException {
    // The path id cases call generated resources: ResourceConformanceTest in sdk runs them.
    return cases("transport.json")
        .filter(c -> c.has("request"))
        .map(c -> DynamicTest.dynamicTest(c.get("name").getAsString(), () -> runTransport(c)));
  }

  private static void runTransport(JsonObject c) {
    var http = new ScriptedHttpClient(objects(c.get("responses")));
    var client = c.has("client") ? c.getAsJsonObject("client") : new JsonObject();
    var builder =
        ClientOptions.builder()
            .apiKey("test_key")
            .baseUrl(
                client.has("baseUrl")
                    ? client.get("baseUrl").getAsString()
                    : "https://api.test.com");
    if (client.has("retry")) builder.disableRetry();
    var nuntly = new NuntlyClient(builder.build(), http, ms -> {});
    var request = c.getAsJsonObject("request");

    HttpResponse<String> response = null;
    Throwable error = null;
    try {
      response =
          nuntly.rawRequest(
              request.get("method").getAsString(),
              request.get("path").getAsString(),
              null,
              RequestOptions.none());
    } catch (RuntimeException e) {
      error = e;
    }

    var expected = c.getAsJsonObject("expected");
    assertEquals(expected.get("calls").getAsInt(), http.requests.size(), "calls");
    if (expected.has("url")) {
      var url = expected.get("url").getAsString();
      http.requests.forEach(r -> assertEquals(url, r.uri().toString()));
    }
    if (expected.has("result")) {
      assertNotNull(response, () -> "unexpected error");
      assertEquals(
          expected.getAsJsonObject("result").get("status").getAsInt(), response.statusCode());
    }
    if (expected.has("error")) assertError(error, expected.getAsJsonObject("error"));
  }
}
