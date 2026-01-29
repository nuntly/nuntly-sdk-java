// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyRetrieveResponseTest {

    @Test
    fun create() {
        val apiKeyRetrieveResponse =
            ApiKeyRetrieveResponse.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .shortToken("shortToken")
                .status(ApiKeyRetrieveResponse.Status.ENABLED)
                .name("name")
                .build()

        assertThat(apiKeyRetrieveResponse.id()).isEqualTo("apk_01ka8k8s80gvx9604cn9am5st4")
        assertThat(apiKeyRetrieveResponse.createdAt()).isEqualTo("createdAt")
        assertThat(apiKeyRetrieveResponse.shortToken()).isEqualTo("shortToken")
        assertThat(apiKeyRetrieveResponse.status()).isEqualTo(ApiKeyRetrieveResponse.Status.ENABLED)
        assertThat(apiKeyRetrieveResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyRetrieveResponse =
            ApiKeyRetrieveResponse.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .shortToken("shortToken")
                .status(ApiKeyRetrieveResponse.Status.ENABLED)
                .name("name")
                .build()

        val roundtrippedApiKeyRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyRetrieveResponse),
                jacksonTypeRef<ApiKeyRetrieveResponse>(),
            )

        assertThat(roundtrippedApiKeyRetrieveResponse).isEqualTo(apiKeyRetrieveResponse)
    }
}
