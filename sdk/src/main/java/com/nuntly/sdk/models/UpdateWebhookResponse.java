package com.nuntly.sdk.models;

import java.util.Optional;

public record UpdateWebhookResponse(
    /** The id of the webhook */
    String id,
    /** The signing secret of the webhook. */
    Optional<String> signingSecret) {}
