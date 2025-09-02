// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import com.nuntly.api.models.shared.WebhookEventType
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListPageResponseTest {

    @Test
    fun create() {
        val webhookListPageResponse =
            WebhookListPageResponse.builder()
                .addData(
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
                        .name("My fist webhook")
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        assertThat(webhookListPageResponse.data().getOrNull())
            .containsExactly(
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
                    .name("My fist webhook")
                    .build()
            )
        assertThat(webhookListPageResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListPageResponse =
            WebhookListPageResponse.builder()
                .addData(
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
                        .name("My fist webhook")
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        val roundtrippedWebhookListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListPageResponse),
                jacksonTypeRef<WebhookListPageResponse>(),
            )

        assertThat(roundtrippedWebhookListPageResponse).isEqualTo(webhookListPageResponse)
    }
}
