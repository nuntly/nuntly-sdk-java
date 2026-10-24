package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * @param id The id of the webhook
 * @param signingSecret The signing secret of the webhook.
 */
public record UpdateWebhookResponse(String id, Optional<String> signingSecret) {}
