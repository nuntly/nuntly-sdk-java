package com.nuntly.sdk;

import java.util.Iterator;
import java.util.List;
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

  public CursorPage<T> nextPage() {
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
      if (index < currentPage.data().size()) return true;
      if (!currentPage.hasNextPage()) return false;
      currentPage = currentPage.nextPage();
      index = 0;
      return !currentPage.data().isEmpty();
    }

    @Override
    public T next() {
      return currentPage.data().get(index++);
    }
  }
}
