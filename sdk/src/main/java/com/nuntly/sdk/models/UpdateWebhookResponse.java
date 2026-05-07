package com.nuntly.sdk.models;

public record UpdateWebhookResponse(
    /** The id of the webhook */
    String id,
    /** The signing secret of the webhook. */
    java.util.Optional<String> signingSecret) {}
