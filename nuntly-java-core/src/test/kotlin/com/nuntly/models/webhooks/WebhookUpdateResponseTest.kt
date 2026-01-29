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
                .id("wh_01ka8k8s80gvx9604cn9am5st4")
                .signingSecret("signingSecret")
                .build()

        assertThat(webhookUpdateResponse.id()).isEqualTo("wh_01ka8k8s80gvx9604cn9am5st4")
        assertThat(webhookUpdateResponse.signingSecret()).contains("signingSecret")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookUpdateResponse =
            WebhookUpdateResponse.builder()
                .id("wh_01ka8k8s80gvx9604cn9am5st4")
                .signingSecret("signingSecret")
                .build()

        val roundtrippedWebhookUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookUpdateResponse),
                jacksonTypeRef<WebhookUpdateResponse>(),
            )

        assertThat(roundtrippedWebhookUpdateResponse).isEqualTo(webhookUpdateResponse)
    }
}
