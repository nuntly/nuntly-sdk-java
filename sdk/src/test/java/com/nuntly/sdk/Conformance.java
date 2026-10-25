package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.ThrowingConsumer;

/**
 * Loads the conformance vectors for the runners of the sdk module and checks that none is skipped.
 */
public final class Conformance {

  private Conformance() {}

  // The vectors are in conformance/ at the repository root, the nearest ancestor that has one.
  private static JsonObject vectors(String file) throws IOException {
    for (var dir = Path.of("").toAbsolutePath(); dir != null; dir = dir.getParent()) {
      var path = dir.resolve("conformance").resolve(file);
      if (Files.exists(path))
        return JsonParser.parseString(Files.readString(path)).getAsJsonObject();
    }
    throw new IOException("conformance/" + file + " not found");
  }

  /**
   * One test per case the runtimes filter keeps and {@code here} selects, then one that fails
   * unless each of them ran and every case left out is one {@code elsewhere} names.
   */
  public static Stream<DynamicTest> each(
      String file,
      Predicate<JsonObject> here,
      Predicate<JsonObject> elsewhere,
      ThrowingConsumer<JsonObject> run)
      throws IOException {
    var kept =
        vectors(file).getAsJsonArray("cases").asList().stream()
            .map(JsonElement::getAsJsonObject)
            .filter(
                c ->
                    !c.has("runtimes")
                        || c.getAsJsonArray("runtimes").asList().stream()
                            .anyMatch(r -> r.getAsString().equals("java")))
            .toList();
    var selected = kept.stream().filter(here).toList();
    var ran = new AtomicInteger();
    var tests =
        selected.stream()
            .map(
                c ->
                    DynamicTest.dynamicTest(
                        c.get("name").getAsString(),
                        () -> {
                          ran.incrementAndGet();
                          run.accept(c);
                        }));
    var check =
        DynamicTest.dynamicTest(
            "every case of " + file + " ran",
            () -> {
              assertEquals(selected.size(), ran.get(), "cases run");
              assertEquals(
                  List.of(),
                  kept.stream()
                      .filter(here.negate().and(elsewhere.negate()))
                      .map(c -> c.get("name").getAsString())
                      .toList(),
                  "cases no runner takes");
            });
    return Stream.concat(tests, Stream.of(check));
  }

  public static Stream<DynamicTest> each(String file, ThrowingConsumer<JsonObject> run)
      throws IOException {
    return each(file, c -> true, c -> false, run);
  }

  // A vector field the runner does not assert would pass whatever the SDK does.
  public static void assertAsserted(JsonObject expected, String... asserted) {
    var unasserted = new TreeSet<>(expected.keySet());
    List.of(asserted).forEach(unasserted::remove);
    assertEquals(new TreeSet<String>(), unasserted, "expected fields this runner does not assert");
  }
}
