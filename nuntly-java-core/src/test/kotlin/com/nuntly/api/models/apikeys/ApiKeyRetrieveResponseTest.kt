// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyRetrieveResponseTest {

    @Test
    fun create() {
        val apiKeyRetrieveResponse =
            ApiKeyRetrieveResponse.builder()
                .id("id")
                .apikeyTruncated("apikey_truncated")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .kind(ApiKeyRetrieveResponse.Kind.API_KEY)
                .orgId("org_id")
                .region(ApiKeyRetrieveResponse.Region.EU_WEST_1)
                .status(ApiKeyRetrieveResponse.Status.ENABLED)
                .userId("user_id")
                .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .name("name")
                .build()

        assertThat(apiKeyRetrieveResponse.id()).isEqualTo("id")
        assertThat(apiKeyRetrieveResponse.apikeyTruncated()).isEqualTo("apikey_truncated")
        assertThat(apiKeyRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(apiKeyRetrieveResponse.kind()).isEqualTo(ApiKeyRetrieveResponse.Kind.API_KEY)
        assertThat(apiKeyRetrieveResponse.orgId()).isEqualTo("org_id")
        assertThat(apiKeyRetrieveResponse.region())
            .isEqualTo(ApiKeyRetrieveResponse.Region.EU_WEST_1)
        assertThat(apiKeyRetrieveResponse.status()).isEqualTo(ApiKeyRetrieveResponse.Status.ENABLED)
        assertThat(apiKeyRetrieveResponse.userId()).isEqualTo("user_id")
        assertThat(apiKeyRetrieveResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(apiKeyRetrieveResponse.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyRetrieveResponse =
            ApiKeyRetrieveResponse.builder()
                .id("id")
                .apikeyTruncated("apikey_truncated")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .kind(ApiKeyRetrieveResponse.Kind.API_KEY)
                .orgId("org_id")
                .region(ApiKeyRetrieveResponse.Region.EU_WEST_1)
                .status(ApiKeyRetrieveResponse.Status.ENABLED)
                .userId("user_id")
                .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
