// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyDeleteResponseTest {

    @Test
    fun create() {
        val apiKeyDeleteResponse =
            ApiKeyDeleteResponse.builder()
                .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                .kind(ApiKeyDeleteResponse.Kind.API_KEY)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        assertThat(apiKeyDeleteResponse.id()).isEqualTo("apk_01jnx372zj49s3zqnn7ew8hzpk")
        assertThat(apiKeyDeleteResponse.kind()).isEqualTo(ApiKeyDeleteResponse.Kind.API_KEY)
        assertThat(apiKeyDeleteResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyDeleteResponse =
            ApiKeyDeleteResponse.builder()
                .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                .kind(ApiKeyDeleteResponse.Kind.API_KEY)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        val roundtrippedApiKeyDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyDeleteResponse),
                jacksonTypeRef<ApiKeyDeleteResponse>(),
            )

        assertThat(roundtrippedApiKeyDeleteResponse).isEqualTo(apiKeyDeleteResponse)
    }
}
