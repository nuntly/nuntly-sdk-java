// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.api.models.shared.WebhookEventType
import com.nuntly.api.models.webhooks.WebhookCreateParams
import com.nuntly.api.models.webhooks.WebhookUpdateParams
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
                    .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                    .addEvent(WebhookEventType.EMAIL_DELIVERED)
                    .addEvent(WebhookEventType.EMAIL_SENT)
                    .status(WebhookCreateParams.Status.ENABLED)
                    .name("My webhook")
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

        val webhookFuture = webhookServiceAsync.retrieve("wh_YNtYn86oYZmP1ZHbnUBvXXFt")

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
                    .id("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
                    .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                    .addEvent(WebhookEventType.EMAIL_DELIVERED)
                    .addEvent(WebhookEventType.EMAIL_SENT)
                    .name("My webhook")
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

        val webhookFuture = webhookServiceAsync.delete("wh_YNtYn86oYZmP1ZHbnUBvXXFt")

        val webhook = webhookFuture.get()
        webhook.validate()
    }
}
