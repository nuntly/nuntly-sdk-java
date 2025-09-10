// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookUpdateResponseTest {

    @Test
    fun create() {
        val webhookUpdateResponse =
            WebhookUpdateResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .kind(WebhookUpdateResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        assertThat(webhookUpdateResponse.id()).isEqualTo("wh_01jne5c7gr2mhwrqg4zqwf48y2")
        assertThat(webhookUpdateResponse.kind()).isEqualTo(WebhookUpdateResponse.Kind.WEBHOOK)
        assertThat(webhookUpdateResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookUpdateResponse =
            WebhookUpdateResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .kind(WebhookUpdateResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        val roundtrippedWebhookUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookUpdateResponse),
                jacksonTypeRef<WebhookUpdateResponse>(),
            )

        assertThat(roundtrippedWebhookUpdateResponse).isEqualTo(webhookUpdateResponse)
    }
}
