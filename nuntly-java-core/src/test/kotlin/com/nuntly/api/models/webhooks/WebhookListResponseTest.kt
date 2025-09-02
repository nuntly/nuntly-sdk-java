// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import com.nuntly.api.models.shared.WebhookEventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListResponseTest {

    @Test
    fun create() {
        val webhookListResponse =
            WebhookListResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .createdAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                .addEvent(WebhookEventType.EMAIL_DELIVERED)
                .addEvent(WebhookEventType.EMAIL_SENT)
                .kind(WebhookListResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(WebhookListResponse.Region.EU_WEST_1)
                .status(WebhookListResponse.Status.ENABLED)
                .modifiedAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .name("My webhook")
                .build()

        assertThat(webhookListResponse.id()).isEqualTo("wh_01jne5c7gr2mhwrqg4zqwf48y2")
        assertThat(webhookListResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
        assertThat(webhookListResponse.endpointUrl())
            .isEqualTo("https://webhook.site/12345678-1234-5678-1234-123456789012")
        assertThat(webhookListResponse.events())
            .containsExactly(WebhookEventType.EMAIL_DELIVERED, WebhookEventType.EMAIL_SENT)
        assertThat(webhookListResponse.kind()).isEqualTo(WebhookListResponse.Kind.WEBHOOK)
        assertThat(webhookListResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(webhookListResponse.region()).isEqualTo(WebhookListResponse.Region.EU_WEST_1)
        assertThat(webhookListResponse.status()).isEqualTo(WebhookListResponse.Status.ENABLED)
        assertThat(webhookListResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
        assertThat(webhookListResponse.name()).contains("My webhook")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListResponse =
            WebhookListResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .createdAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                .addEvent(WebhookEventType.EMAIL_DELIVERED)
                .addEvent(WebhookEventType.EMAIL_SENT)
                .kind(WebhookListResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(WebhookListResponse.Region.EU_WEST_1)
                .status(WebhookListResponse.Status.ENABLED)
                .modifiedAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .name("My webhook")
                .build()

        val roundtrippedWebhookListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListResponse),
                jacksonTypeRef<WebhookListResponse>(),
            )

        assertThat(roundtrippedWebhookListResponse).isEqualTo(webhookListResponse)
    }
}
