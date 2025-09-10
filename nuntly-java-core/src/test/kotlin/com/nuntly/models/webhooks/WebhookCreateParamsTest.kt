// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.nuntly.models.shared.WebhookEventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateParamsTest {

    @Test
    fun create() {
        WebhookCreateParams.builder()
            .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
            .addEvent(WebhookEventType.EMAIL_DELIVERED)
            .addEvent(WebhookEventType.EMAIL_SENT)
            .status(WebhookCreateParams.Status.ENABLED)
            .name("My webhook")
            .build()
    }

    @Test
    fun body() {
        val params =
            WebhookCreateParams.builder()
                .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                .addEvent(WebhookEventType.EMAIL_DELIVERED)
                .addEvent(WebhookEventType.EMAIL_SENT)
                .status(WebhookCreateParams.Status.ENABLED)
                .name("My webhook")
                .build()

        val body = params._body()

        assertThat(body.endpointUrl())
            .isEqualTo("https://webhook.site/12345678-1234-5678-1234-123456789012")
        assertThat(body.events())
            .containsExactly(WebhookEventType.EMAIL_DELIVERED, WebhookEventType.EMAIL_SENT)
        assertThat(body.status()).isEqualTo(WebhookCreateParams.Status.ENABLED)
        assertThat(body.name()).contains("My webhook")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WebhookCreateParams.builder()
                .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                .addEvent(WebhookEventType.EMAIL_DELIVERED)
                .addEvent(WebhookEventType.EMAIL_SENT)
                .status(WebhookCreateParams.Status.ENABLED)
                .build()

        val body = params._body()

        assertThat(body.endpointUrl())
            .isEqualTo("https://webhook.site/12345678-1234-5678-1234-123456789012")
        assertThat(body.events())
            .containsExactly(WebhookEventType.EMAIL_DELIVERED, WebhookEventType.EMAIL_SENT)
        assertThat(body.status()).isEqualTo(WebhookCreateParams.Status.ENABLED)
    }
}
