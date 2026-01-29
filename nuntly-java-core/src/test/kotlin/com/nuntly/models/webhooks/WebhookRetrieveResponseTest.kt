// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookRetrieveResponseTest {

    @Test
    fun create() {
        val webhookRetrieveResponse =
            WebhookRetrieveResponse.builder()
                .id("wh_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .endpointUrl("https://example.com")
                .addEvent(EventType.EMAIL_QUEUED)
                .status(WebhookRetrieveResponse.Status.ENABLED)
                .name("name")
                .build()

        assertThat(webhookRetrieveResponse.id()).isEqualTo("wh_01ka8k8s80gvx9604cn9am5st4")
        assertThat(webhookRetrieveResponse.createdAt()).isEqualTo("createdAt")
        assertThat(webhookRetrieveResponse.endpointUrl()).isEqualTo("https://example.com")
        assertThat(webhookRetrieveResponse.events()).containsExactly(EventType.EMAIL_QUEUED)
        assertThat(webhookRetrieveResponse.status())
            .isEqualTo(WebhookRetrieveResponse.Status.ENABLED)
        assertThat(webhookRetrieveResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookRetrieveResponse =
            WebhookRetrieveResponse.builder()
                .id("wh_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .endpointUrl("https://example.com")
                .addEvent(EventType.EMAIL_QUEUED)
                .status(WebhookRetrieveResponse.Status.ENABLED)
                .name("name")
                .build()

        val roundtrippedWebhookRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookRetrieveResponse),
                jacksonTypeRef<WebhookRetrieveResponse>(),
            )

        assertThat(roundtrippedWebhookRetrieveResponse).isEqualTo(webhookRetrieveResponse)
    }
}
