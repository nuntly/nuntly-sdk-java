// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyListResponseTest {

    @Test
    fun create() {
        val apiKeyListResponse =
            ApiKeyListResponse.builder()
                .id("id")
                .apikeyTruncated("apikey_truncated")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .kind(ApiKeyListResponse.Kind.API_KEY)
                .orgId("org_id")
                .region(ApiKeyListResponse.Region.EU_WEST_1)
                .status(ApiKeyListResponse.Status.ENABLED)
                .userId("user_id")
                .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .name("name")
                .build()

        assertThat(apiKeyListResponse.id()).isEqualTo("id")
        assertThat(apiKeyListResponse.apikeyTruncated()).isEqualTo("apikey_truncated")
        assertThat(apiKeyListResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(apiKeyListResponse.kind()).isEqualTo(ApiKeyListResponse.Kind.API_KEY)
        assertThat(apiKeyListResponse.orgId()).isEqualTo("org_id")
        assertThat(apiKeyListResponse.region()).isEqualTo(ApiKeyListResponse.Region.EU_WEST_1)
        assertThat(apiKeyListResponse.status()).isEqualTo(ApiKeyListResponse.Status.ENABLED)
        assertThat(apiKeyListResponse.userId()).isEqualTo("user_id")
        assertThat(apiKeyListResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(apiKeyListResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyListResponse =
            ApiKeyListResponse.builder()
                .id("id")
                .apikeyTruncated("apikey_truncated")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .kind(ApiKeyListResponse.Kind.API_KEY)
                .orgId("org_id")
                .region(ApiKeyListResponse.Region.EU_WEST_1)
                .status(ApiKeyListResponse.Status.ENABLED)
                .userId("user_id")
                .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
