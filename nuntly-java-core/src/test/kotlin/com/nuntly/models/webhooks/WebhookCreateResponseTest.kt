// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateResponseTest {

    @Test
    fun create() {
        val webhookCreateResponse =
            WebhookCreateResponse.builder()
                .id("wh_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .endpointUrl("https://example.com")
                .addEvent(EventType.EMAIL_QUEUED)
                .signingSecret("signingSecret")
                .status(WebhookCreateResponse.Status.ENABLED)
                .name("name")
                .build()

        assertThat(webhookCreateResponse.id()).isEqualTo("wh_01ka8k8s80gvx9604cn9am5st4")
        assertThat(webhookCreateResponse.createdAt()).isEqualTo("createdAt")
        assertThat(webhookCreateResponse.endpointUrl()).isEqualTo("https://example.com")
        assertThat(webhookCreateResponse.events()).containsExactly(EventType.EMAIL_QUEUED)
        assertThat(webhookCreateResponse.signingSecret()).isEqualTo("signingSecret")
        assertThat(webhookCreateResponse.status()).isEqualTo(WebhookCreateResponse.Status.ENABLED)
        assertThat(webhookCreateResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookCreateResponse =
            WebhookCreateResponse.builder()
                .id("wh_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .endpointUrl("https://example.com")
                .addEvent(EventType.EMAIL_QUEUED)
                .signingSecret("signingSecret")
                .status(WebhookCreateResponse.Status.ENABLED)
                .name("name")
                .build()

        val roundtrippedWebhookCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookCreateResponse),
                jacksonTypeRef<WebhookCreateResponse>(),
            )

        assertThat(roundtrippedWebhookCreateResponse).isEqualTo(webhookCreateResponse)
    }
}
