// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.nuntly.models.shared.EventType
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookUpdateParamsTest {

    @Test
    fun create() {
        WebhookUpdateParams.builder()
            .id("wh_01ka8k8s80gvx9604cn9am5st4")
            .endpointUrl("https://example.com")
            .addEvent(EventType.EMAIL_QUEUED)
            .name("name")
            .rotateSecret(true)
            .status(WebhookUpdateParams.Status.ENABLED)
            .build()
    }

    @Test
    fun pathParams() {
        val params = WebhookUpdateParams.builder().id("wh_01ka8k8s80gvx9604cn9am5st4").build()

        assertThat(params._pathParam(0)).isEqualTo("wh_01ka8k8s80gvx9604cn9am5st4")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            WebhookUpdateParams.builder()
                .id("wh_01ka8k8s80gvx9604cn9am5st4")
                .endpointUrl("https://example.com")
                .addEvent(EventType.EMAIL_QUEUED)
                .name("name")
                .rotateSecret(true)
                .status(WebhookUpdateParams.Status.ENABLED)
                .build()

        val body = params._body()

        assertThat(body.endpointUrl()).contains("https://example.com")
        assertThat(body.events().getOrNull()).containsExactly(EventType.EMAIL_QUEUED)
        assertThat(body.name()).contains("name")
        assertThat(body.rotateSecret()).contains(true)
        assertThat(body.status()).contains(WebhookUpdateParams.Status.ENABLED)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WebhookUpdateParams.builder().id("wh_01ka8k8s80gvx9604cn9am5st4").build()

        val body = params._body()
    }
}
