// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateParamsTest {

    @Test
    fun create() {
        WebhookCreateParams.builder()
            .endpointUrl("https://example.com")
            .addEvent(EventType.EMAIL_QUEUED)
            .name("name")
            .status(WebhookCreateParams.Status.ENABLED)
            .build()
    }

    @Test
    fun body() {
        val params =
            WebhookCreateParams.builder()
                .endpointUrl("https://example.com")
                .addEvent(EventType.EMAIL_QUEUED)
                .name("name")
                .status(WebhookCreateParams.Status.ENABLED)
                .build()

        val body = params._body()

        assertThat(body.endpointUrl()).isEqualTo("https://example.com")
        assertThat(body.events()).containsExactly(EventType.EMAIL_QUEUED)
        assertThat(body.name()).contains("name")
        assertThat(body.status()).contains(WebhookCreateParams.Status.ENABLED)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WebhookCreateParams.builder()
                .endpointUrl("https://example.com")
                .addEvent(EventType.EMAIL_QUEUED)
                .build()

        val body = params._body()

        assertThat(body.endpointUrl()).isEqualTo("https://example.com")
        assertThat(body.events()).containsExactly(EventType.EMAIL_QUEUED)
    }
}
