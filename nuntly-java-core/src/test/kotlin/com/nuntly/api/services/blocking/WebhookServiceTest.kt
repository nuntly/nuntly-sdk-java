// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClient
import com.nuntly.api.models.shared.WebhookEventType
import com.nuntly.api.models.webhooks.WebhookCreateParams
import com.nuntly.api.models.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WebhookServiceTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val webhook =
            webhookService.create(
                WebhookCreateParams.builder()
                    .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                    .addEvent(WebhookEventType.EMAIL_DELIVERED)
                    .addEvent(WebhookEventType.EMAIL_SENT)
                    .status(WebhookCreateParams.Status.ENABLED)
                    .name("My webhook")
                    .build()
            )

        webhook.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val webhook = webhookService.retrieve("wh_YNtYn86oYZmP1ZHbnUBvXXFt")

        webhook.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val webhook =
            webhookService.update(
                WebhookUpdateParams.builder()
                    .id("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
                    .endpointUrl("https://webhook.site/12345678-1234-5678-1234-123456789012")
                    .addEvent(WebhookEventType.EMAIL_DELIVERED)
                    .addEvent(WebhookEventType.EMAIL_SENT)
                    .name("My webhook")
                    .status(WebhookUpdateParams.Status.ENABLED)
                    .build()
            )

        webhook.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val page = webhookService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val webhook = webhookService.delete("wh_YNtYn86oYZmP1ZHbnUBvXXFt")

        webhook.validate()
    }
}
