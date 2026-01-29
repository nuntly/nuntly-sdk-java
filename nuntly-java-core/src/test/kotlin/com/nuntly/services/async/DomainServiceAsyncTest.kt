// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.domains.DomainCreateParams
import com.nuntly.models.domains.DomainUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DomainServiceAsyncTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val domainServiceAsync = client.domains()

        val domainFuture =
            domainServiceAsync.create(DomainCreateParams.builder().name("name").build())

        val domain = domainFuture.get()
        domain.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val domainServiceAsync = client.domains()

        val domainFuture = domainServiceAsync.retrieve("dns_01kabn43yqyxn2bx4ve84mczd3")

        val domain = domainFuture.get()
        domain.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val domainServiceAsync = client.domains()

        val domainFuture =
            domainServiceAsync.update(
                DomainUpdateParams.builder()
                    .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                    .clickTracking(true)
                    .openTracking(true)
                    .build()
            )

        val domain = domainFuture.get()
        domain.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val domainServiceAsync = client.domains()

        val pageFuture = domainServiceAsync.list()

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
        val domainServiceAsync = client.domains()

        val domainFuture = domainServiceAsync.delete("dns_01kabn43yqyxn2bx4ve84mczd3")

        val domain = domainFuture.get()
        domain.validate()
    }
}
