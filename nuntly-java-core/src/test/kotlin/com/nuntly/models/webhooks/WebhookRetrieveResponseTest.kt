// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.WebhookEventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookRetrieveResponseTest {

    @Test
    fun create() {
        val webhookRetrieveResponse =
            WebhookRetrieveResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .createdAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                .addEvent(WebhookEventType.EMAIL_DELIVERED)
                .addEvent(WebhookEventType.EMAIL_SENT)
                .kind(WebhookRetrieveResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(WebhookRetrieveResponse.Region.EU_WEST_1)
                .status(WebhookRetrieveResponse.Status.ENABLED)
                .modifiedAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .name("My webhook")
                .build()

        assertThat(webhookRetrieveResponse.id()).isEqualTo("wh_01jne5c7gr2mhwrqg4zqwf48y2")
        assertThat(webhookRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
        assertThat(webhookRetrieveResponse.endpointUrl())
            .isEqualTo("https://webhook.site/12345678-1234-5678-1234-123456789012")
        assertThat(webhookRetrieveResponse.events())
            .containsExactly(WebhookEventType.EMAIL_DELIVERED, WebhookEventType.EMAIL_SENT)
        assertThat(webhookRetrieveResponse.kind()).isEqualTo(WebhookRetrieveResponse.Kind.WEBHOOK)
        assertThat(webhookRetrieveResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(webhookRetrieveResponse.region())
            .isEqualTo(WebhookRetrieveResponse.Region.EU_WEST_1)
        assertThat(webhookRetrieveResponse.status())
            .isEqualTo(WebhookRetrieveResponse.Status.ENABLED)
        assertThat(webhookRetrieveResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
        assertThat(webhookRetrieveResponse.name()).contains("My webhook")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookRetrieveResponse =
            WebhookRetrieveResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .createdAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                .addEvent(WebhookEventType.EMAIL_DELIVERED)
                .addEvent(WebhookEventType.EMAIL_SENT)
                .kind(WebhookRetrieveResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(WebhookRetrieveResponse.Region.EU_WEST_1)
                .status(WebhookRetrieveResponse.Status.ENABLED)
                .modifiedAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .name("My webhook")
                .build()

        val roundtrippedWebhookRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookRetrieveResponse),
                jacksonTypeRef<WebhookRetrieveResponse>(),
            )

        assertThat(roundtrippedWebhookRetrieveResponse).isEqualTo(webhookRetrieveResponse)
    }
}
