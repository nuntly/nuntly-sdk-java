// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateResponseTest {

    @Test
    fun create() {
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                .apikey("ntly_****_***************")
                .apikeyTruncated("GGvLoL")
                .createdAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                .kind(ApiKeyCreateResponse.Kind.API_KEY)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(ApiKeyCreateResponse.Region.EU_WEST_1)
                .status(ApiKeyCreateResponse.Status.ENABLED)
                .userId("user_01jh6jk831bzen14edngw38we9")
                .modifiedAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                .name("My API key")
                .build()

        assertThat(apiKeyCreateResponse.id()).isEqualTo("apk_01jnx372zj49s3zqnn7ew8hzpk")
        assertThat(apiKeyCreateResponse.apikey()).isEqualTo("ntly_****_***************")
        assertThat(apiKeyCreateResponse.apikeyTruncated()).isEqualTo("GGvLoL")
        assertThat(apiKeyCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
        assertThat(apiKeyCreateResponse.kind()).isEqualTo(ApiKeyCreateResponse.Kind.API_KEY)
        assertThat(apiKeyCreateResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(apiKeyCreateResponse.region()).isEqualTo(ApiKeyCreateResponse.Region.EU_WEST_1)
        assertThat(apiKeyCreateResponse.status()).isEqualTo(ApiKeyCreateResponse.Status.ENABLED)
        assertThat(apiKeyCreateResponse.userId()).isEqualTo("user_01jh6jk831bzen14edngw38we9")
        assertThat(apiKeyCreateResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
        assertThat(apiKeyCreateResponse.name()).contains("My API key")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                .apikey("ntly_****_***************")
                .apikeyTruncated("GGvLoL")
                .createdAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                .kind(ApiKeyCreateResponse.Kind.API_KEY)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(ApiKeyCreateResponse.Region.EU_WEST_1)
                .status(ApiKeyCreateResponse.Status.ENABLED)
                .userId("user_01jh6jk831bzen14edngw38we9")
                .modifiedAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                .name("My API key")
                .build()

        val roundtrippedApiKeyCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyCreateResponse),
                jacksonTypeRef<ApiKeyCreateResponse>(),
            )

        assertThat(roundtrippedApiKeyCreateResponse).isEqualTo(apiKeyCreateResponse)
    }
}
