package com.nuntly.sdk.models;

public record InboxesQuery(
    /** The cursor to retrieve the next page of results */
    java.util.Optional<String> cursor,
    /** The maximum number of results to return */
    java.util.Optional<Long> limit,
    /** Filter by namespace. */
    java.util.Optional<String> namespaceId) {}
