package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * Runs the conformance cases that call the generated resources: the path id cases of transport.json
 * and forward-compat.json.
 */
class ResourceConformanceTest {

  static HttpServer server;
  static Nuntly nuntly;
  static final List<String> sent = new CopyOnWriteArrayList<>();
  static volatile String responseBody = "{\"data\":{}}";

  @BeforeAll
  static void startServer() throws IOException {
    server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext(
        "/",
        exchange -> {
          sent.add(exchange.getRequestMethod() + " " + exchange.getRequestURI().getRawPath());
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

  // The vectors are in conformance/ at the repository root, the nearest ancestor that has one.
  private static JsonObject vectors(String file) throws IOException {
    for (var dir = Path.of("").toAbsolutePath(); dir != null; dir = dir.getParent()) {
      var path = dir.resolve("conformance").resolve(file);
      if (Files.exists(path))
        return JsonParser.parseString(Files.readString(path)).getAsJsonObject();
    }
    throw new IOException("conformance/" + file + " not found");
  }

  private static Stream<JsonObject> javaCases(String file) throws IOException {
    return vectors(file).getAsJsonArray("cases").asList().stream()
        .map(JsonElement::getAsJsonObject)
        .filter(
            c ->
                !c.has("runtimes")
                    || c.getAsJsonArray("runtimes").asList().stream()
                        .anyMatch(r -> r.getAsString().equals("java")));
  }

  @TestFactory
  Stream<DynamicTest> transport() throws IOException {
    return javaCases("transport.json")
        .filter(c -> c.has("call"))
        .map(c -> DynamicTest.dynamicTest(c.get("name").getAsString(), () -> run(c)));
  }

  @TestFactory
  Stream<DynamicTest> forwardCompat() throws IOException {
    return javaCases("forward-compat.json")
        .map(c -> DynamicTest.dynamicTest(c.get("name").getAsString(), () -> readField(c)));
  }

  private static void readField(JsonObject c) throws ReflectiveOperationException {
    responseBody = c.getAsJsonObject("response").get("body").toString();
    var result = invoke(c.getAsJsonObject("call"));
    var expected = c.getAsJsonObject("expected");
    var field =
        (Enum<?>) result.getClass().getMethod(expected.get("field").getAsString()).invoke(result);
    if (expected.get("known").getAsBoolean()) {
      assertEquals(
          expected.get("value").getAsString(), field.getClass().getMethod("value").invoke(field));
    } else {
      assertEquals("UNKNOWN", field.name());
    }
  }

  private static Object invoke(JsonObject call) throws ReflectiveOperationException {
    var args =
        call.getAsJsonArray("args").asList().stream()
            .map(a -> a.isJsonNull() ? null : a.getAsString())
            .toArray();
    var segments = call.get("operation").getAsString().split("\\.");
    Object target = nuntly;
    for (var accessor : Arrays.copyOf(segments, segments.length - 1)) {
      target = target.getClass().getMethod(accessor).invoke(target);
    }
    return operation(target, segments[segments.length - 1], args.length).invoke(target, args);
  }

  private static void run(JsonObject c) throws ReflectiveOperationException {
    sent.clear();
    responseBody = "{\"data\":{}}";
    Throwable error = null;
    try {
      invoke(c.getAsJsonObject("call"));
    } catch (InvocationTargetException e) {
      error = e.getCause();
    }

    var expected = c.getAsJsonObject("expected");
    assertEquals(expected.get("calls").getAsInt(), sent.size(), "calls " + sent);
    if (expected.has("path")) {
      assertEquals(
          expected.get("method").getAsString() + " " + expected.get("path").getAsString(),
          sent.get(0));
    }
    if (expected.has("error")) {
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
