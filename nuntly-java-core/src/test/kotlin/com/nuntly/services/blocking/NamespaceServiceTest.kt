// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.namespaces.NamespaceCreateParams
import com.nuntly.models.namespaces.NamespaceUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class NamespaceServiceTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val namespace =
            namespaceService.create(
                NamespaceCreateParams.builder().name("x").externalId("externalId").build()
            )

        namespace.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val namespaceDetail = namespaceService.retrieve("ns_01kabn43yqyxn2bx4ve84mczd3")

        namespaceDetail.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val namespace =
            namespaceService.update(
                NamespaceUpdateParams.builder()
                    .namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3")
                    .externalId("externalId")
                    .name("x")
                    .build()
            )

        namespace.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val page = namespaceService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val namespace = namespaceService.delete("ns_01kabn43yqyxn2bx4ve84mczd3")

        namespace.validate()
    }
}
