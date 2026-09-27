package com.nuntly.sdk.models;

import java.util.Optional;

public record OpenDetail(
    String openedAt, String userAgent, Optional<ClickDetailIsBotEvent> isBotEvent) {}
