package com.nuntly.sdk.models;

import java.util.Optional;

public record MessagesQuery(
    /** The cursor to retrieve the next page of results */
    Optional<String> cursor,
    /** The maximum number of results to return */
    Optional<Long> limit,
    /** Filter by domain. */
    Optional<String> domainId,
    /** Filter by sender address. */
    Optional<String> from) {}
