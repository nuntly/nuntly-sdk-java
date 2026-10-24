package com.nuntly.sdk;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class CursorPage<T> implements Iterable<T> {
  private final List<T> data;
  private final Optional<String> nextCursor;
  private final Function<Optional<String>, CursorPage<T>> fetchPage;

  public CursorPage(
      List<T> data, String nextCursor, Function<Optional<String>, CursorPage<T>> fetchPage) {
    this.data = data;
    this.nextCursor = Optional.ofNullable(nextCursor).filter(s -> !s.isBlank());
    this.fetchPage = fetchPage;
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
   */
  public CursorPage<T> nextPage() {
    if (!hasNextPage()) throw new NoSuchElementException("No more pages");
    return fetchPage.apply(nextCursor);
  }

  @Override
  public Iterator<T> iterator() {
    return new AutoPaginatingIterator<>(this);
  }

  public Stream<T> stream() {
    return StreamSupport.stream(spliterator(), false);
  }

  private static final class AutoPaginatingIterator<T> implements Iterator<T> {
    private CursorPage<T> currentPage;
    private int index;

    AutoPaginatingIterator(CursorPage<T> firstPage) {
      this.currentPage = firstPage;
      this.index = 0;
    }

    @Override
    public boolean hasNext() {
      // A page can be empty and still have a next cursor.
      while (index >= currentPage.data().size()) {
        if (!currentPage.hasNextPage()) return false;
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
