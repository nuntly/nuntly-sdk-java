// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.api.models.organizations.OrganizationUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrganizationServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationServiceAsync = client.organizations()

        val organizationFuture = organizationServiceAsync.retrieve("org_9UTZz2PisZ68YwE3NJu9urQ9")

        val organization = organizationFuture.get()
        organization.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationServiceAsync = client.organizations()

        val organizationFuture =
            organizationServiceAsync.update(
                OrganizationUpdateParams.builder()
                    .id("org_9UTZz2PisZ68YwE3NJu9urQ9")
                    .displayName("Ray Tomlinson org.")
                    .build()
            )

        val organization = organizationFuture.get()
        organization.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationServiceAsync = client.organizations()

        val pageFuture = organizationServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }
}
