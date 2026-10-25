package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class CursorPageTest {

  @Test
  void iteratorNextPastTheLastItemThrowsNoSuchElementException() {
    var iterator = new CursorPage<>(List.of("em_1"), null, null).iterator();

    assertEquals("em_1", iterator.next());
    assertThrows(NoSuchElementException.class, iterator::next);
  }

  // The second page answers the cursor it was fetched with: following it would loop.
  private static CursorPage<String> loopingPages(AtomicInteger fetches) {
    return new CursorPage<>(
        List.of("em_1"),
        "cur_2",
        cursor -> {
          fetches.incrementAndGet();
          return new CursorPage<>(List.of("em_2"), cursor.get(), c -> fetchMustNotHappen(), cursor);
        });
  }

  private static CursorPage<String> fetchMustNotHappen() {
    throw new AssertionError("a cursor already requested was fetched again");
  }

  @Test
  void autoPaginationFailsWhenTheApiReturnsACursorAlreadyRequested() {
    var fetches = new AtomicInteger();
    var seen = new ArrayList<String>();

    var error = assertThrows(NuntlyError.class, () -> loopingPages(fetches).forEach(seen::add));

    assertEquals(
        "The API returned the cursor 'cur_2' again: pagination stopped to avoid a loop.",
        error.getMessage());
    assertEquals(List.of("em_1", "em_2"), seen);
    assertEquals(1, fetches.get());
  }

  @Test
  void nextPageFailsWhenTheApiReturnsTheCursorThePageWasRequestedWith() {
    var second = loopingPages(new AtomicInteger()).nextPage();

    assertThrows(NuntlyError.class, second::nextPage);
  }

  // A caller fetchPage builds its pages with the public constructor, which knows no cursor.
  private static CursorPage<String> callerPages(String... nextCursors) {
    return new CursorPage<>(List.of("em_0"), "cur_1", callerFetch(nextCursors));
  }

  private static Function<Optional<String>, CursorPage<String>> callerFetch(String... next) {
    return cursor -> {
      var n = Integer.parseInt(cursor.get().substring(4));
      return new CursorPage<>(List.of("em_" + n), next[n - 1], callerFetch(next));
    };
  }

  @Test
  void aPageFromACallerFetchPageRejectsItsOwnCursorAsNext() {
    var first = callerPages("cur_1").nextPage();

    assertThrows(NuntlyError.class, first::nextPage);
  }

  @Test
  void iterationFromAHandAdvancedPageYieldsEachItemOnceThenThrows() {
    var advanced = callerPages("cur_2", "cur_1").nextPage();
    var seen = new ArrayList<String>();

    var error = assertThrows(NuntlyError.class, () -> advanced.forEach(seen::add));

    assertEquals(List.of("em_1", "em_2"), seen);
    assertEquals(
        "The API returned the cursor 'cur_1' again: pagination stopped to avoid a loop.",
        error.getMessage());
  }

  @Test
  void nextPageRejectsANullPageFromFetchPage() {
    var first = new CursorPage<String>(List.of("em_0"), "cur_1", cursor -> null);

    var error = assertThrows(NuntlyError.class, first::nextPage);
    assertEquals("fetchPage returned no page for the cursor 'cur_1'.", error.getMessage());
  }

  @Test
  void aPageIsImmutable() {
    for (var field : CursorPage.class.getDeclaredFields()) {
      assertTrue(Modifier.isFinal(field.getModifiers()), field.getName() + " is not final");
    }
  }

  // Pages cur_1 to cur_<last>; the last one points back to cur_<backTo>, or ends when backTo is 0.
  @SuppressWarnings("unchecked")
  private static CursorPage<String> chain(int last, int backTo, AtomicInteger fetches) {
    Function<Optional<String>, CursorPage<String>>[] fetch = new Function[1];
    fetch[0] =
        cursor -> {
          fetches.incrementAndGet();
          var n = Integer.parseInt(cursor.get().substring(4));
          var next = n < last ? "cur_" + (n + 1) : backTo > 0 ? "cur_" + backTo : null;
          return new CursorPage<>(List.of("em_" + n), next, fetch[0], cursor);
        };
    return new CursorPage<>(List.of("em_0"), "cur_1", fetch[0]);
  }

  @Test
  void autoPaginationDetectsARepeatAtTheEndOfALongChain() {
    var fetches = new AtomicInteger();

    var error = assertThrows(NuntlyError.class, () -> chain(500, 7, fetches).forEach(item -> {}));

    assertEquals(
        "The API returned the cursor 'cur_7' again: pagination stopped to avoid a loop.",
        error.getMessage());
    assertEquals(500, fetches.get());
  }

  @Test
  void twoIterationsFromTheSameFirstPageDoNotInterfere() {
    var first = chain(3, 0, new AtomicInteger());

    var once = first.stream().toList();
    var twice = first.stream().toList();

    assertEquals(List.of("em_0", "em_1", "em_2", "em_3"), once);
    assertEquals(once, twice);
  }

  @Test
  void nextPageFailsWhenTheApiReturnsTheCursorOfTheFirstRequest() {
    var http =
        new ConformanceTest.ScriptedHttpClient(
            List.of(
                JsonParser.parseString(
                        "{\"status\":200,\"body\":{\"data\":[{\"id\":\"em_1\"}],\"nextCursor\":\"cur_1\"}}")
                    .getAsJsonObject()));
    var nuntly =
        new NuntlyClient(
            ClientOptions.builder()
                .apiKey("test_key")
                .baseUrl("https://api.test.com")
                .disableRetry()
                .build(),
            http,
            ms -> {});

    var page =
        nuntly.list("/emails", JsonObject.class, Map.of("cursor", "cur_1"), RequestOptions.none());

    assertThrows(NuntlyError.class, page::nextPage);
    assertEquals(1, http.requests.size());
  }
}
