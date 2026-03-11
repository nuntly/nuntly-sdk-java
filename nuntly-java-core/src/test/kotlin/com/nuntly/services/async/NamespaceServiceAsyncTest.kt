// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.namespaces.NamespaceCreateParams
import com.nuntly.models.namespaces.NamespaceUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class NamespaceServiceAsyncTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val namespaceFuture =
            namespaceServiceAsync.create(
                NamespaceCreateParams.builder().name("x").externalId("externalId").build()
            )

        val namespace = namespaceFuture.get()
        namespace.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val namespaceDetailFuture = namespaceServiceAsync.retrieve("ns_01kabn43yqyxn2bx4ve84mczd3")

        val namespaceDetail = namespaceDetailFuture.get()
        namespaceDetail.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val namespaceFuture =
            namespaceServiceAsync.update(
                NamespaceUpdateParams.builder()
                    .namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3")
                    .externalId("externalId")
                    .name("x")
                    .build()
            )

        val namespace = namespaceFuture.get()
        namespace.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val pageFuture = namespaceServiceAsync.list()

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
        val namespaceServiceAsync = client.namespaces()

        val namespaceFuture = namespaceServiceAsync.delete("ns_01kabn43yqyxn2bx4ve84mczd3")

        val namespace = namespaceFuture.get()
        namespace.validate()
    }
}
