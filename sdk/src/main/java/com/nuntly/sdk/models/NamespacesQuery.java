package com.nuntly.sdk.models;

import java.util.Optional;

public record NamespacesQuery(
    /** The cursor to retrieve the next page of results */
    Optional<String> cursor,
    /** The maximum number of results to return */
    Optional<Long> limit) {}
