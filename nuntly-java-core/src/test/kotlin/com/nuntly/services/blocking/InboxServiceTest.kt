// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.inboxes.InboxCreateParams
import com.nuntly.models.inboxes.InboxSendParams
import com.nuntly.models.inboxes.InboxUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InboxServiceTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxService = client.inboxes()

        val inbox =
            inboxService.create(
                InboxCreateParams.builder()
                    .address("x")
                    .agentId("agentId")
                    .domainId("domainId")
                    .name("name")
                    .namespaceId("namespaceId")
                    .build()
            )

        inbox.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxService = client.inboxes()

        val inbox = inboxService.retrieve("ibx_01kabn43yqyxn2bx4ve84mczd3")

        inbox.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxService = client.inboxes()

        val inbox =
            inboxService.update(
                InboxUpdateParams.builder()
                    .inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3")
                    .name("name")
                    .build()
            )

        inbox.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxService = client.inboxes()

        val page = inboxService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxService = client.inboxes()

        val inbox = inboxService.delete("ibx_01kabn43yqyxn2bx4ve84mczd3")

        inbox.validate()
    }

    @Test
    fun send() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxService = client.inboxes()

        val response =
            inboxService.send(
                InboxSendParams.builder()
                    .inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3")
                    .subject("x")
                    .addTo("dev@stainless.com")
                    .addBcc("dev@stainless.com")
                    .addCc("dev@stainless.com")
                    .html("html")
                    .text("text")
                    .build()
            )

        response.validate()
    }
}
