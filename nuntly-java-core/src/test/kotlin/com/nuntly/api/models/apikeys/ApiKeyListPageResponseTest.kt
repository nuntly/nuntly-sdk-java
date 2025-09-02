// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyListPageResponseTest {

    @Test
    fun create() {
        val apiKeyListPageResponse =
            ApiKeyListPageResponse.builder()
                .addData(
                    ApiKeyListResponse.builder()
                        .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                        .apikeyTruncated("GGvLoL")
                        .createdAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                        .kind(ApiKeyListResponse.Kind.API_KEY)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(ApiKeyListResponse.Region.EU_WEST_1)
                        .status(ApiKeyListResponse.Status.ENABLED)
                        .userId("user_01jh6jk831bzen14edngw38we9")
                        .modifiedAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                        .name("My API key")
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        assertThat(apiKeyListPageResponse.data().getOrNull())
            .containsExactly(
                ApiKeyListResponse.builder()
                    .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                    .apikeyTruncated("GGvLoL")
                    .createdAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                    .kind(ApiKeyListResponse.Kind.API_KEY)
                    .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                    .region(ApiKeyListResponse.Region.EU_WEST_1)
                    .status(ApiKeyListResponse.Status.ENABLED)
                    .userId("user_01jh6jk831bzen14edngw38we9")
                    .modifiedAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                    .name("My API key")
                    .build()
            )
        assertThat(apiKeyListPageResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyListPageResponse =
            ApiKeyListPageResponse.builder()
                .addData(
                    ApiKeyListResponse.builder()
                        .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                        .apikeyTruncated("GGvLoL")
                        .createdAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                        .kind(ApiKeyListResponse.Kind.API_KEY)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(ApiKeyListResponse.Region.EU_WEST_1)
                        .status(ApiKeyListResponse.Status.ENABLED)
                        .userId("user_01jh6jk831bzen14edngw38we9")
                        .modifiedAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                        .name("My API key")
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        val roundtrippedApiKeyListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyListPageResponse),
                jacksonTypeRef<ApiKeyListPageResponse>(),
            )

        assertThat(roundtrippedApiKeyListPageResponse).isEqualTo(apiKeyListPageResponse)
    }
}
