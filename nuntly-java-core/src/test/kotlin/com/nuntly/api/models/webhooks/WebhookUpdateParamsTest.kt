// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.webhooks

import com.nuntly.api.models.shared.WebhookEventType
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookUpdateParamsTest {

    @Test
    fun create() {
        WebhookUpdateParams.builder()
            .id("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
            .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
            .addEvent(WebhookEventType.EMAIL_DELIVERED)
            .addEvent(WebhookEventType.EMAIL_SENT)
            .name("My webhook")
            .status(WebhookUpdateParams.Status.ENABLED)
            .build()
    }

    @Test
    fun pathParams() {
        val params = WebhookUpdateParams.builder().id("wh_YNtYn86oYZmP1ZHbnUBvXXFt").build()

        assertThat(params._pathParam(0)).isEqualTo("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            WebhookUpdateParams.builder()
                .id("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
                .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                .addEvent(WebhookEventType.EMAIL_DELIVERED)
                .addEvent(WebhookEventType.EMAIL_SENT)
                .name("My webhook")
                .status(WebhookUpdateParams.Status.ENABLED)
                .build()

        val body = params._body()

        assertThat(body.endpointUrl())
            .contains("https://webhook.site/12345678-1234-5678-1234-123456789012")
        assertThat(body.events().getOrNull())
            .containsExactly(WebhookEventType.EMAIL_DELIVERED, WebhookEventType.EMAIL_SENT)
        assertThat(body.name()).contains("My webhook")
        assertThat(body.status()).contains(WebhookUpdateParams.Status.ENABLED)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WebhookUpdateParams.builder().id("wh_YNtYn86oYZmP1ZHbnUBvXXFt").build()

        val body = params._body()
    }
}
