package com.nuntly.sdk.models;

public record ErrorResponse(
    /**
     * This object provide you additional information about errors encountered while performing the
     * operation
     */
    Error error) {}
