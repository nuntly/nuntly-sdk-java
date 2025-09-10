// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyUpdateResponseTest {

    @Test
    fun create() {
        val apiKeyUpdateResponse =
            ApiKeyUpdateResponse.builder()
                .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                .kind(ApiKeyUpdateResponse.Kind.API_KEY)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        assertThat(apiKeyUpdateResponse.id()).isEqualTo("apk_01jnx372zj49s3zqnn7ew8hzpk")
        assertThat(apiKeyUpdateResponse.kind()).isEqualTo(ApiKeyUpdateResponse.Kind.API_KEY)
        assertThat(apiKeyUpdateResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyUpdateResponse =
            ApiKeyUpdateResponse.builder()
                .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                .kind(ApiKeyUpdateResponse.Kind.API_KEY)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        val roundtrippedApiKeyUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyUpdateResponse),
                jacksonTypeRef<ApiKeyUpdateResponse>(),
            )

        assertThat(roundtrippedApiKeyUpdateResponse).isEqualTo(apiKeyUpdateResponse)
    }
}
