// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.apikeys.ApiKeyCreateParams
import com.nuntly.models.apikeys.ApiKeyUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ApiKeyServiceAsyncTest {

    @Test
    fun create() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiKeyServiceAsync = client.apiKeys()

        val apiKeyFuture =
            apiKeyServiceAsync.create(ApiKeyCreateParams.builder().name("My API key").build())

        val apiKey = apiKeyFuture.get()
        apiKey.validate()
    }

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiKeyServiceAsync = client.apiKeys()

        val apiKeyFuture = apiKeyServiceAsync.retrieve("apk_pdGukGd4BTmHj8dscBDE5Mc9")

        val apiKey = apiKeyFuture.get()
        apiKey.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiKeyServiceAsync = client.apiKeys()

        val apiKeyFuture =
            apiKeyServiceAsync.update(
                ApiKeyUpdateParams.builder()
                    .id("ak_pdGukGd4BTmHj8dscBDE5Mc9")
                    .name("name")
                    .status(ApiKeyUpdateParams.Status.DISABLED)
                    .build()
            )

        val apiKey = apiKeyFuture.get()
        apiKey.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiKeyServiceAsync = client.apiKeys()

        val pageFuture = apiKeyServiceAsync.list()

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
        val apiKeyServiceAsync = client.apiKeys()

        val apiKeyFuture = apiKeyServiceAsync.delete("ak_pdGukGd4BTmHj8dscBDE5Mc9")

        val apiKey = apiKeyFuture.get()
        apiKey.validate()
    }
}
