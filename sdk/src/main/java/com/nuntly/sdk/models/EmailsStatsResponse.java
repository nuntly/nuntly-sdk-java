package com.nuntly.sdk.models;

public record EmailsStatsResponse(
    /** The start date of the stats range */
    String start,
    /** The end date of the stats range */
    String end,
    java.util.List<java.util.Map<String, Object>> stats) {}
