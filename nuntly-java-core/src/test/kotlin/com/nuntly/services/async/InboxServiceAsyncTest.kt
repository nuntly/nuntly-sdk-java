// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.inboxes.InboxCreateParams
import com.nuntly.models.inboxes.InboxSendParams
import com.nuntly.models.inboxes.InboxUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InboxServiceAsyncTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.inboxes()

        val inboxFuture =
            inboxServiceAsync.create(
                InboxCreateParams.builder()
                    .address("x")
                    .agentId("agentId")
                    .domainId("domainId")
                    .name("name")
                    .namespaceId("namespaceId")
                    .build()
            )

        val inbox = inboxFuture.get()
        inbox.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.inboxes()

        val inboxFuture = inboxServiceAsync.retrieve("ibx_01kabn43yqyxn2bx4ve84mczd3")

        val inbox = inboxFuture.get()
        inbox.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.inboxes()

        val inboxFuture =
            inboxServiceAsync.update(
                InboxUpdateParams.builder()
                    .inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3")
                    .name("name")
                    .build()
            )

        val inbox = inboxFuture.get()
        inbox.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.inboxes()

        val pageFuture = inboxServiceAsync.list()

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
        val inboxServiceAsync = client.inboxes()

        val inboxFuture = inboxServiceAsync.delete("ibx_01kabn43yqyxn2bx4ve84mczd3")

        val inbox = inboxFuture.get()
        inbox.validate()
    }

    @Test
    fun send() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.inboxes()

        val responseFuture =
            inboxServiceAsync.send(
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

        val response = responseFuture.get()
        response.validate()
    }
}
