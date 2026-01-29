// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateResponseTest {

    @Test
    fun create() {
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .apiKey("apiKey")
                .shortToken("shortToken")
                .status(ApiKeyCreateResponse.Status.ENABLED)
                .name("name")
                .build()

        assertThat(apiKeyCreateResponse.id()).isEqualTo("apk_01ka8k8s80gvx9604cn9am5st4")
        assertThat(apiKeyCreateResponse.apiKey()).isEqualTo("apiKey")
        assertThat(apiKeyCreateResponse.shortToken()).isEqualTo("shortToken")
        assertThat(apiKeyCreateResponse.status()).isEqualTo(ApiKeyCreateResponse.Status.ENABLED)
        assertThat(apiKeyCreateResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .apiKey("apiKey")
                .shortToken("shortToken")
                .status(ApiKeyCreateResponse.Status.ENABLED)
                .name("name")
                .build()

        val roundtrippedApiKeyCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyCreateResponse),
                jacksonTypeRef<ApiKeyCreateResponse>(),
            )

        assertThat(roundtrippedApiKeyCreateResponse).isEqualTo(apiKeyCreateResponse)
    }
}
