// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListResponseTest {

    @Test
    fun create() {
        val webhookListResponse =
            WebhookListResponse.builder()
                .id("wh_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .endpointUrl("https://example.com")
                .addEvent(EventType.EMAIL_QUEUED)
                .status(WebhookListResponse.Status.ENABLED)
                .name("name")
                .build()

        assertThat(webhookListResponse.id()).isEqualTo("wh_01ka8k8s80gvx9604cn9am5st4")
        assertThat(webhookListResponse.createdAt()).isEqualTo("createdAt")
        assertThat(webhookListResponse.endpointUrl()).isEqualTo("https://example.com")
        assertThat(webhookListResponse.events()).containsExactly(EventType.EMAIL_QUEUED)
        assertThat(webhookListResponse.status()).isEqualTo(WebhookListResponse.Status.ENABLED)
        assertThat(webhookListResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListResponse =
            WebhookListResponse.builder()
                .id("wh_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .endpointUrl("https://example.com")
                .addEvent(EventType.EMAIL_QUEUED)
                .status(WebhookListResponse.Status.ENABLED)
                .name("name")
                .build()

        val roundtrippedWebhookListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListResponse),
                jacksonTypeRef<WebhookListResponse>(),
            )

        assertThat(roundtrippedWebhookListResponse).isEqualTo(webhookListResponse)
    }
}
