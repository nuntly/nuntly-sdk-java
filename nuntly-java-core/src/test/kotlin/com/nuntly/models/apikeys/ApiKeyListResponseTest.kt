// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyListResponseTest {

    @Test
    fun create() {
        val apiKeyListResponse =
            ApiKeyListResponse.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .shortToken("shortToken")
                .status(ApiKeyListResponse.Status.ENABLED)
                .name("name")
                .build()

        assertThat(apiKeyListResponse.id()).isEqualTo("apk_01ka8k8s80gvx9604cn9am5st4")
        assertThat(apiKeyListResponse.createdAt()).isEqualTo("createdAt")
        assertThat(apiKeyListResponse.shortToken()).isEqualTo("shortToken")
        assertThat(apiKeyListResponse.status()).isEqualTo(ApiKeyListResponse.Status.ENABLED)
        assertThat(apiKeyListResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyListResponse =
            ApiKeyListResponse.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .shortToken("shortToken")
                .status(ApiKeyListResponse.Status.ENABLED)
                .name("name")
                .build()

        val roundtrippedApiKeyListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyListResponse),
                jacksonTypeRef<ApiKeyListResponse>(),
            )

        assertThat(roundtrippedApiKeyListResponse).isEqualTo(apiKeyListResponse)
    }
}
