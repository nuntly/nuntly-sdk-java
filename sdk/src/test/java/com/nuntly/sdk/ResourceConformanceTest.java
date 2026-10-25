package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

/**
 * Runs the conformance cases that call the generated resources: the path id cases of
 * transport.json, forward-compat.json and serialization.json.
 */
class ResourceConformanceTest {

  static HttpServer server;
  static Nuntly nuntly;
  static final List<String> sent = new CopyOnWriteArrayList<>();
  static final List<String> queries = new CopyOnWriteArrayList<>();
  static final List<String> traces = new CopyOnWriteArrayList<>();
  static volatile String responseBody = "{\"data\":{}}";

  @BeforeAll
  static void startServer() throws IOException {
    server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext(
        "/",
        exchange -> {
          sent.add(exchange.getRequestMethod() + " " + exchange.getRequestURI().getRawPath());
          queries.add(Objects.toString(exchange.getRequestURI().getRawQuery(), ""));
          traces.add(Objects.toString(exchange.getRequestHeaders().getFirst("X-Trace-Id"), ""));
          var body = responseBody.getBytes(StandardCharsets.UTF_8);
          exchange.getResponseHeaders().add("Content-Type", "application/json");
          exchange.sendResponseHeaders(200, body.length);
          exchange.getResponseBody().write(body);
          exchange.close();
        });
    server.start();
    nuntly =
        Nuntly.create(
            Nuntly.builder()
                .apiKey("test_key")
                .baseUrl("http://localhost:" + server.getAddress().getPort())
                .disableRetry()
                .build());
  }

  @AfterAll
  static void stopServer() {
    server.stop(0);
  }

  @TestFactory
  Stream<DynamicTest> transport() throws IOException {
    // The cases with a `request` run against the client: ConformanceTest in core runs them.
    return Conformance.each(
        "transport.json", c -> c.has("call"), c -> c.has("request"), ResourceConformanceTest::run);
  }

  // Per-request options reach the wire through a public resource method, not only the core client.
  @Test
  void requestOptionsThroughAResourceMethod() {
    sent.clear();
    traces.clear();
    responseBody = "{\"data\":{}}";

    nuntly
        .emails()
        .retrieve(
            "em_123",
            RequestOptions.builder()
                .headers(Map.of("X-Trace-Id", "trace_42"))
                .timeout(Duration.ofSeconds(5))
                .maxRetries(0)
                .build());

    assertEquals(List.of("GET /emails/em_123"), sent);
    assertEquals(List.of("trace_42"), traces);
  }

  @TestFactory
  Stream<DynamicTest> forwardCompat() throws IOException {
    return Conformance.each("forward-compat.json", ResourceConformanceTest::readField);
  }

  private static void readField(JsonObject c) throws ReflectiveOperationException {
    responseBody = c.getAsJsonObject("response").get("body").toString();
    var result = invoke(c.getAsJsonObject("call"));
    var expected = c.getAsJsonObject("expected");
    Conformance.assertAsserted(expected, "field", "value", "known");
    var field =
        (Enum<?>) result.getClass().getMethod(expected.get("field").getAsString()).invoke(result);
    if (expected.get("known").getAsBoolean()) {
      assertEquals(
          expected.get("value").getAsString(), field.getClass().getMethod("value").invoke(field));
    } else {
      assertEquals("UNKNOWN", field.name());
    }
  }

  @TestFactory
  Stream<DynamicTest> serialization() throws IOException {
    return Conformance.each("serialization.json", ResourceConformanceTest::readNumber);
  }

  private static void readNumber(JsonObject c) throws ReflectiveOperationException {
    responseBody = c.getAsJsonObject("response").get("body").toString();
    Object value = invoke(c.getAsJsonObject("call"));
    var expected = c.getAsJsonObject("expected");
    Conformance.assertAsserted(expected, "path", "number", "integer");
    var path = expected.getAsJsonArray("path").asList();
    value = value.getClass().getMethod(path.get(0).getAsString()).invoke(value);
    for (var key : path.subList(1, path.size())) value = ((Map<?, ?>) value).get(key.getAsString());
    var number = expected.get("number").getAsBigDecimal();
    // Boxed apart: a ternary over long and double would widen the Long to a Double.
    Object wanted =
        expected.get("integer").getAsBoolean()
            ? (Object) number.longValueExact()
            : (Object) number.doubleValue();
    assertEquals(wanted, value);
  }

  private static Object invoke(JsonObject call) throws ReflectiveOperationException {
    var ids =
        call.getAsJsonArray("args").asList().stream()
            .map(a -> a.isJsonNull() ? null : a.getAsString())
            .toList();
    var segments = call.get("operation").getAsString().split("\\.");
    Object target = nuntly;
    for (var accessor : Arrays.copyOf(segments, segments.length - 1)) {
      target = target.getClass().getMethod(accessor).invoke(target);
    }
    var name = segments[segments.length - 1];
    if (!call.has("query")) {
      return operation(target, name, ids.size()).invoke(target, ids.toArray());
    }
    var method = queryOperation(target, name, ids.size());
    var args = new ArrayList<Object>(ids);
    args.add(params(method.getParameterTypes()[ids.size()], call.getAsJsonObject("query")));
    return method.invoke(target, args.toArray());
  }

  private static Method queryOperation(Object target, String name, int ids) {
    return Arrays.stream(target.getClass().getMethods())
        .filter(m -> m.getName().equals(name) && m.getParameterCount() == ids + 1)
        .filter(
            m ->
                m.getParameterTypes()[ids].isRecord()
                    && m.getParameterTypes()[ids] != RequestOptions.class)
        .findFirst()
        .orElseThrow();
  }

  // Builds the params record through its canonical constructor, so its own checks run.
  private static Object params(Class<?> type, JsonObject query)
      throws ReflectiveOperationException {
    var components = type.getRecordComponents();
    var values = new Object[components.length];
    for (int i = 0; i < components.length; i++) {
      var value = query.get(components[i].getName());
      values[i] =
          value == null
              ? null
              : NuntlyClient.defaultGson().fromJson(value, components[i].getGenericType());
    }
    var constructor =
        type.getDeclaredConstructor(
            Arrays.stream(components).map(RecordComponent::getType).toArray(Class<?>[]::new));
    return constructor.newInstance(values);
  }

  private static void run(JsonObject c) throws ReflectiveOperationException {
    sent.clear();
    queries.clear();
    responseBody = "{\"data\":{}}";
    Throwable error = null;
    try {
      invoke(c.getAsJsonObject("call"));
    } catch (InvocationTargetException e) {
      error = e.getCause();
    }

    var expected = c.getAsJsonObject("expected");
    Conformance.assertAsserted(expected, "calls", "method", "path", "query", "error");
    assertEquals(expected.get("calls").getAsInt(), sent.size(), "calls " + sent);
    var request = sent.isEmpty() ? new String[] {"", ""} : sent.get(0).split(" ", 2);
    if (expected.has("method")) assertEquals(expected.get("method").getAsString(), request[0]);
    if (expected.has("path")) assertEquals(expected.get("path").getAsString(), request[1]);
    if (expected.has("query")) {
      assertEquals(expected.get("query").getAsString(), queries.isEmpty() ? null : queries.get(0));
    }
    if (expected.has("error")) {
      Conformance.assertAsserted(expected.getAsJsonObject("error"), "kind");
      assertEquals("sdk", expected.getAsJsonObject("error").get("kind").getAsString());
      assertSame(NuntlyError.class, error == null ? null : error.getClass(), "error " + error);
    } else {
      assertNull(error);
    }
  }

  private static Method operation(Object target, String name, int arity) {
    return Arrays.stream(target.getClass().getMethods())
        .filter(m -> m.getName().equals(name) && m.getParameterCount() == arity)
        .filter(m -> Arrays.stream(m.getParameterTypes()).allMatch(t -> t == String.class))
        .findFirst()
        .orElseThrow();
  }
}
