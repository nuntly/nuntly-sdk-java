// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClient
import com.nuntly.api.models.apikeys.ApiKeyCreateParams
import com.nuntly.api.models.apikeys.ApiKeyUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ApiKeyServiceTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiKeyService = client.apiKeys()

        val apiKey = apiKeyService.create(ApiKeyCreateParams.builder().name("My API key").build())

        apiKey.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiKeyService = client.apiKeys()

        val apiKey = apiKeyService.retrieve("apk_pdGukGd4BTmHj8dscBDE5Mc9")

        apiKey.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiKeyService = client.apiKeys()

        val apiKey =
            apiKeyService.update(
                ApiKeyUpdateParams.builder()
                    .id("ak_pdGukGd4BTmHj8dscBDE5Mc9")
                    .name("name")
                    .status(ApiKeyUpdateParams.Status.DISABLED)
                    .build()
            )

        apiKey.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiKeyService = client.apiKeys()

        val page = apiKeyService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiKeyService = client.apiKeys()

        val apiKey = apiKeyService.delete("ak_pdGukGd4BTmHj8dscBDE5Mc9")

        apiKey.validate()
    }
}
