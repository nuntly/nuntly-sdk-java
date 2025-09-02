// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookDeleteResponseTest {

    @Test
    fun create() {
        val webhookDeleteResponse =
            WebhookDeleteResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .kind(WebhookDeleteResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        assertThat(webhookDeleteResponse.id()).isEqualTo("wh_01jne5c7gr2mhwrqg4zqwf48y2")
        assertThat(webhookDeleteResponse.kind()).isEqualTo(WebhookDeleteResponse.Kind.WEBHOOK)
        assertThat(webhookDeleteResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookDeleteResponse =
            WebhookDeleteResponse.builder()
                .id("wh_01jne5c7gr2mhwrqg4zqwf48y2")
                .kind(WebhookDeleteResponse.Kind.WEBHOOK)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        val roundtrippedWebhookDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookDeleteResponse),
                jacksonTypeRef<WebhookDeleteResponse>(),
            )

        assertThat(roundtrippedWebhookDeleteResponse).isEqualTo(webhookDeleteResponse)
    }
}
