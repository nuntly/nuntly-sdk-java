package com.nuntly.sdk.models;

public record ThreadsQuery(
    /** The cursor to retrieve the next page of results */
    java.util.Optional<String> cursor,
    /** The maximum number of results to return */
    java.util.Optional<Long> limit,
    /**
     * Comma-separated labels to filter by (AND logic). Threads with spam/trash are excluded by
     * default unless explicitly requested via ?labels=spam or ?labels=trash.
     */
    java.util.Optional<String> labels) {}
