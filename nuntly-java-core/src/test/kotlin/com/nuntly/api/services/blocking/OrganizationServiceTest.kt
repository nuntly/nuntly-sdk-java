// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClient
import com.nuntly.api.models.organizations.OrganizationUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrganizationServiceTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationService = client.organizations()

        val organization = organizationService.retrieve("org_9UTZz2PisZ68YwE3NJu9urQ9")

        organization.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationService = client.organizations()

        val organization =
            organizationService.update(
                OrganizationUpdateParams.builder()
                    .id("org_9UTZz2PisZ68YwE3NJu9urQ9")
                    .displayName("Ray Tomlinson org.")
                    .build()
            )

        organization.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val organizationService = client.organizations()

        val page = organizationService.list()

        page.response().validate()
    }
}
