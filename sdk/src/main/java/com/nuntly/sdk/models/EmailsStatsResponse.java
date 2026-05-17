package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;

public record EmailsStatsResponse(
    /** The start date of the stats range */
    String start,
    /** The end date of the stats range */
    String end,
    List<Map<String, Object>> stats) {}
