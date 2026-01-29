// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyListPageResponseTest {

    @Test
    fun create() {
        val apiKeyListPageResponse =
            ApiKeyListPageResponse.builder()
                .addData(
                    ApiKeyListResponse.builder()
                        .id("apk_01ka8k8s80gvx9604cn9am5st4")
                        .createdAt("createdAt")
                        .shortToken("shortToken")
                        .status(ApiKeyListResponse.Status.ENABLED)
                        .name("name")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(apiKeyListPageResponse.data())
            .containsExactly(
                ApiKeyListResponse.builder()
                    .id("apk_01ka8k8s80gvx9604cn9am5st4")
                    .createdAt("createdAt")
                    .shortToken("shortToken")
                    .status(ApiKeyListResponse.Status.ENABLED)
                    .name("name")
                    .build()
            )
        assertThat(apiKeyListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyListPageResponse =
            ApiKeyListPageResponse.builder()
                .addData(
                    ApiKeyListResponse.builder()
                        .id("apk_01ka8k8s80gvx9604cn9am5st4")
                        .createdAt("createdAt")
                        .shortToken("shortToken")
                        .status(ApiKeyListResponse.Status.ENABLED)
                        .name("name")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedApiKeyListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyListPageResponse),
                jacksonTypeRef<ApiKeyListPageResponse>(),
            )

        assertThat(roundtrippedApiKeyListPageResponse).isEqualTo(apiKeyListPageResponse)
    }
}
