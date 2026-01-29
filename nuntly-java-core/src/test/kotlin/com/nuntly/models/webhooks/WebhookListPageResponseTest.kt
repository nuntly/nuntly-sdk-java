// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListPageResponseTest {

    @Test
    fun create() {
        val webhookListPageResponse =
            WebhookListPageResponse.builder()
                .addData(
                    WebhookListResponse.builder()
                        .id("wh_01ka8k8s80gvx9604cn9am5st4")
                        .createdAt("createdAt")
                        .endpointUrl("https://example.com")
                        .addEvent(EventType.EMAIL_QUEUED)
                        .status(WebhookListResponse.Status.ENABLED)
                        .name("name")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(webhookListPageResponse.data())
            .containsExactly(
                WebhookListResponse.builder()
                    .id("wh_01ka8k8s80gvx9604cn9am5st4")
                    .createdAt("createdAt")
                    .endpointUrl("https://example.com")
                    .addEvent(EventType.EMAIL_QUEUED)
                    .status(WebhookListResponse.Status.ENABLED)
                    .name("name")
                    .build()
            )
        assertThat(webhookListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListPageResponse =
            WebhookListPageResponse.builder()
                .addData(
                    WebhookListResponse.builder()
                        .id("wh_01ka8k8s80gvx9604cn9am5st4")
                        .createdAt("createdAt")
                        .endpointUrl("https://example.com")
                        .addEvent(EventType.EMAIL_QUEUED)
                        .status(WebhookListResponse.Status.ENABLED)
                        .name("name")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedWebhookListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListPageResponse),
                jacksonTypeRef<WebhookListPageResponse>(),
            )

        assertThat(roundtrippedWebhookListPageResponse).isEqualTo(webhookListPageResponse)
    }
}
