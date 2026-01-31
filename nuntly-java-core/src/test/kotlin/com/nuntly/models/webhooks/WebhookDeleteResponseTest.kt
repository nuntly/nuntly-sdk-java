// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookDeleteResponseTest {

    @Test
    fun create() {
        val webhookDeleteResponse =
            WebhookDeleteResponse.builder().id("wh_01ka8k8s80gvx9604cn9am5st4").build()

        assertThat(webhookDeleteResponse.id()).isEqualTo("wh_01ka8k8s80gvx9604cn9am5st4")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookDeleteResponse =
            WebhookDeleteResponse.builder().id("wh_01ka8k8s80gvx9604cn9am5st4").build()

        val roundtrippedWebhookDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookDeleteResponse),
                jacksonTypeRef<WebhookDeleteResponse>(),
            )

        assertThat(roundtrippedWebhookDeleteResponse).isEqualTo(webhookDeleteResponse)
    }
}
