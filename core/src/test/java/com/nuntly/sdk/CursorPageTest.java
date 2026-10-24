package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class CursorPageTest {

  @Test
  void iteratorNextPastTheLastItemThrowsNoSuchElementException() {
    var iterator = new CursorPage<>(List.of("em_1"), null, null).iterator();

    assertEquals("em_1", iterator.next());
    assertThrows(NoSuchElementException.class, iterator::next);
  }
}
