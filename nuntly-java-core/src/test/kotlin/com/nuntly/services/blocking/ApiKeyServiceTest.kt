// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.apikeys.ApiKeyCreateParams
import com.nuntly.models.apikeys.ApiKeyUpdateParams
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

        val apiKey =
            apiKeyService.create(
                ApiKeyCreateParams.builder()
                    .name("name")
                    .status(ApiKeyCreateParams.Status.ENABLED)
                    .build()
            )

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

        val apiKey = apiKeyService.retrieve("apk_01ka8k8s80gvx9604cn9am5st4")

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
                    .id("apk_01ka8k8s80gvx9604cn9am5st4")
                    .name("name")
                    .status(ApiKeyUpdateParams.Status.ENABLED)
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

        val apiKey = apiKeyService.delete("apk_01ka8k8s80gvx9604cn9am5st4")

        apiKey.validate()
    }
}
