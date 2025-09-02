// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.api.models.domains.DomainCreateParams
import com.nuntly.api.models.domains.DomainUpdateParams
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
            domainServiceAsync.create(
                DomainCreateParams.builder()
                    .name("acme.com")
                    .region(DomainCreateParams.Region.EU_WEST_1)
                    .build()
            )

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

        val domainFuture = domainServiceAsync.retrieve("dns_FdfQe2eZAzRrHCXKSr7VsxUz")

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
                    .id("dns_FdfQe2eZAzRrHCXKSr7VsxUz")
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

        val domainFuture = domainServiceAsync.delete("dns_FdfQe2eZAzRrHCXKSr7VsxUz")

        val domain = domainFuture.get()
        domain.validate()
    }
}
