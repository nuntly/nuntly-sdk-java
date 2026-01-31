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
            apiKeyServiceAsync.create(
                ApiKeyCreateParams.builder()
                    .name("name")
                    .status(ApiKeyCreateParams.Status.ENABLED)
                    .build()
            )

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

        val apiKeyFuture = apiKeyServiceAsync.retrieve("apk_01ka8k8s80gvx9604cn9am5st4")

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
                    .id("apk_01ka8k8s80gvx9604cn9am5st4")
                    .name("name")
                    .status(ApiKeyUpdateParams.Status.ENABLED)
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

        val apiKeyFuture = apiKeyServiceAsync.delete("apk_01ka8k8s80gvx9604cn9am5st4")

        val apiKey = apiKeyFuture.get()
        apiKey.validate()
    }
}
