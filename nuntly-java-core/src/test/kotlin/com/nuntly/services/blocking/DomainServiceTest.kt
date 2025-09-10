// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.domains.DomainCreateParams
import com.nuntly.models.domains.DomainUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DomainServiceTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val domainService = client.domains()

        val domain =
            domainService.create(
                DomainCreateParams.builder()
                    .name("acme.com")
                    .region(DomainCreateParams.Region.EU_WEST_1)
                    .build()
            )

        domain.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val domainService = client.domains()

        val domain = domainService.retrieve("dns_FdfQe2eZAzRrHCXKSr7VsxUz")

        domain.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val domainService = client.domains()

        val domain =
            domainService.update(
                DomainUpdateParams.builder()
                    .id("dns_FdfQe2eZAzRrHCXKSr7VsxUz")
                    .clickTracking(true)
                    .openTracking(true)
                    .build()
            )

        domain.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val domainService = client.domains()

        val page = domainService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val domainService = client.domains()

        val domain = domainService.delete("dns_FdfQe2eZAzRrHCXKSr7VsxUz")

        domain.validate()
    }
}
