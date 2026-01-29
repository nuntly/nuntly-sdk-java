// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.shared.EventType
import com.nuntly.models.webhooks.WebhookCreateParams
import com.nuntly.models.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WebhookServiceAsyncTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookFuture =
            webhookServiceAsync.create(
                WebhookCreateParams.builder()
                    .endpointUrl("https://example.com")
                    .addEvent(EventType.EMAIL_QUEUED)
                    .name("name")
                    .status(WebhookCreateParams.Status.ENABLED)
                    .build()
            )

        val webhook = webhookFuture.get()
        webhook.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookFuture = webhookServiceAsync.retrieve("wh_01ka8k8s80gvx9604cn9am5st4")

        val webhook = webhookFuture.get()
        webhook.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookFuture =
            webhookServiceAsync.update(
                WebhookUpdateParams.builder()
                    .id("wh_01ka8k8s80gvx9604cn9am5st4")
                    .endpointUrl("https://example.com")
                    .addEvent(EventType.EMAIL_QUEUED)
                    .name("name")
                    .rotateSecret(true)
                    .status(WebhookUpdateParams.Status.ENABLED)
                    .build()
            )

        val webhook = webhookFuture.get()
        webhook.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val pageFuture = webhookServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookFuture = webhookServiceAsync.delete("wh_01ka8k8s80gvx9604cn9am5st4")

        val webhook = webhookFuture.get()
        webhook.validate()
    }
}
