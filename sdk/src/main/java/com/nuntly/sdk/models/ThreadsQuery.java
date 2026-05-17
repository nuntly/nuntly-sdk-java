package com.nuntly.sdk.models;

import java.util.Optional;

public record ThreadsQuery(
    /** The cursor to retrieve the next page of results */
    Optional<String> cursor,
    /** The maximum number of results to return */
    Optional<Long> limit,
    /**
     * Comma-separated labels to filter by (AND logic). Threads with spam/trash are excluded by
     * default unless explicitly requested via ?labels=spam or ?labels=trash.
     */
    Optional<String> labels) {}
