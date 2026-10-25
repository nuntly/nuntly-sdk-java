package com.nuntly.sdk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class CursorPage<T> implements Iterable<T> {
  private final List<T> data;
  private final Optional<String> nextCursor;
  private final Function<Optional<String>, CursorPage<T>> fetchPage;
  private final Optional<String> requestCursor;

  public CursorPage(
      List<T> data, String nextCursor, Function<Optional<String>, CursorPage<T>> fetchPage) {
    this(data, nextCursor, fetchPage, Optional.empty());
  }

  CursorPage(
      List<T> data,
      String nextCursor,
      Function<Optional<String>, CursorPage<T>> fetchPage,
      Optional<String> requestCursor) {
    this.data = data;
    this.nextCursor = Optional.ofNullable(nextCursor).filter(s -> !s.isBlank());
    this.fetchPage = fetchPage;
    this.requestCursor = requestCursor;
  }

  public List<T> data() {
    return data;
  }

  public Optional<String> nextCursor() {
    return nextCursor;
  }

  public boolean hasNextPage() {
    return nextCursor.isPresent();
  }

  /**
   * Fetches the page after this one.
   *
   * @throws NoSuchElementException when this is the last page ({@link #hasNextPage()} is false)
   * @throws NuntlyError when the next cursor is the cursor this page was requested with, which
   *     would fetch this page again, or when a caller-supplied {@code fetchPage} returns null. A
   *     longer cycle is not detected here; iterating the page detects any repeated cursor.
   */
  public CursorPage<T> nextPage() {
    if (!hasNextPage()) throw new NoSuchElementException("No more pages");
    if (nextCursor.equals(requestCursor)) throw repeatedCursor(nextCursor.get());
    var fetched = fetchPage.apply(nextCursor);
    if (fetched == null) {
      throw new NuntlyError(
          "fetchPage returned no page for the cursor '" + nextCursor.get() + "'.");
    }
    // A caller fetchPage builds pages without their request cursor: record it here.
    return new CursorPage<>(
        fetched.data, fetched.nextCursor.orElse(null), fetched.fetchPage, nextCursor);
  }

  private static NuntlyError repeatedCursor(String cursor) {
    return new NuntlyError(
        "The API returned the cursor '" + cursor + "' again: pagination stopped to avoid a loop.");
  }

  @Override
  public Iterator<T> iterator() {
    return new AutoPaginatingIterator<>(this);
  }

  public Stream<T> stream() {
    return StreamSupport.stream(spliterator(), false);
  }

  // Each iteration keeps its own set of the cursors requested, seeded with the starting page's
  // own, so any repeat throws before it is fetched while the pages stay immutable.
  private static final class AutoPaginatingIterator<T> implements Iterator<T> {
    private final Set<String> requestedCursors = new HashSet<>();
    private CursorPage<T> currentPage;
    private int index;

    AutoPaginatingIterator(CursorPage<T> firstPage) {
      this.currentPage = firstPage;
      firstPage.requestCursor.ifPresent(requestedCursors::add);
    }

    @Override
    public boolean hasNext() {
      // A page can be empty and still have a next cursor.
      while (index >= currentPage.data().size()) {
        if (!currentPage.hasNextPage()) return false;
        var cursor = currentPage.nextCursor().get();
        if (!requestedCursors.add(cursor)) throw repeatedCursor(cursor);
        currentPage = currentPage.nextPage();
        index = 0;
      }
      return true;
    }

    @Override
    public T next() {
      if (!hasNext()) throw new NoSuchElementException();
      return currentPage.data().get(index++);
    }
  }
}
