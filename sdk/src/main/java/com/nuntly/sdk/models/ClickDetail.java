package com.nuntly.sdk.models;

import java.util.Map;
import java.util.Optional;

public record ClickDetail(
    String clickedAt,
    String userAgent,
    String link,
    Map<String, Object> linkTags,
    Optional<ClickDetailIsBotEvent> isBotEvent) {}
