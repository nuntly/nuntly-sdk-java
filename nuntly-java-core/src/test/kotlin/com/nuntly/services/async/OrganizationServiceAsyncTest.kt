// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
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

        val organizationFuture = organizationServiceAsync.retrieve("org_01ka8k8s80gvx9604cn9am5st4")

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
