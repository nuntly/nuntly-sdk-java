// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateResponseTest {

    @Test
    fun create() {
        val webhookCreateResponse =
            WebhookCreateResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .createdAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                .addEvent(EventType.EMAIL_DELIVERED)
                .addEvent(EventType.EMAIL_SENT)
                .kind(WebhookCreateResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(WebhookCreateResponse.Region.EU_WEST_1)
                .signingSecret("2VERerverv3V3RVeververv")
                .status(WebhookCreateResponse.Status.ENABLED)
                .modifiedAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .name("My webhook")
                .build()

        assertThat(webhookCreateResponse.id()).isEqualTo("wh_01jne5c7gr2mhwrqg4zqwf48y2")
        assertThat(webhookCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
        assertThat(webhookCreateResponse.endpointUrl())
            .isEqualTo("https://webhook.site/12345678-1234-5678-1234-123456789012")
        assertThat(webhookCreateResponse.events())
            .containsExactly(EventType.EMAIL_DELIVERED, EventType.EMAIL_SENT)
        assertThat(webhookCreateResponse.kind()).isEqualTo(WebhookCreateResponse.Kind.WEBHOOK)
        assertThat(webhookCreateResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(webhookCreateResponse.region()).isEqualTo(WebhookCreateResponse.Region.EU_WEST_1)
        assertThat(webhookCreateResponse.signingSecret()).isEqualTo("2VERerverv3V3RVeververv")
        assertThat(webhookCreateResponse.status()).isEqualTo(WebhookCreateResponse.Status.ENABLED)
        assertThat(webhookCreateResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
        assertThat(webhookCreateResponse.name()).contains("My webhook")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookCreateResponse =
            WebhookCreateResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .createdAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                .addEvent(EventType.EMAIL_DELIVERED)
                .addEvent(EventType.EMAIL_SENT)
                .kind(WebhookCreateResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(WebhookCreateResponse.Region.EU_WEST_1)
                .signingSecret("2VERerverv3V3RVeververv")
                .status(WebhookCreateResponse.Status.ENABLED)
                .modifiedAt(OffsetDateTime.parse("2025-03-03T14:08:22.552Z"))
                .name("My webhook")
                .build()

        val roundtrippedWebhookCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookCreateResponse),
                jacksonTypeRef<WebhookCreateResponse>(),
            )

        assertThat(roundtrippedWebhookCreateResponse).isEqualTo(webhookCreateResponse)
    }
}
