// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationListPageResponseTest {

    @Test
    fun create() {
        val organizationListPageResponse =
            OrganizationListPageResponse.builder()
                .addData(
                    OrganizationListResponse.builder()
                        .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                        .displayName("Ray Tomlinson org")
                        .kind(OrganizationListResponse.Kind.ORGANIZATION)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(OrganizationListResponse.Region.EU_WEST_1)
                        .status(OrganizationListResponse.Status.ACTIVE)
                        .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        assertThat(organizationListPageResponse.data().getOrNull())
            .containsExactly(
                OrganizationListResponse.builder()
                    .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                    .displayName("Ray Tomlinson org")
                    .kind(OrganizationListResponse.Kind.ORGANIZATION)
                    .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                    .region(OrganizationListResponse.Region.EU_WEST_1)
                    .status(OrganizationListResponse.Status.ACTIVE)
                    .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                    .build()
            )
        assertThat(organizationListPageResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationListPageResponse =
            OrganizationListPageResponse.builder()
                .addData(
                    OrganizationListResponse.builder()
                        .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                        .displayName("Ray Tomlinson org")
                        .kind(OrganizationListResponse.Kind.ORGANIZATION)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(OrganizationListResponse.Region.EU_WEST_1)
                        .status(OrganizationListResponse.Status.ACTIVE)
                        .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        val roundtrippedOrganizationListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationListPageResponse),
                jacksonTypeRef<OrganizationListPageResponse>(),
            )

        assertThat(roundtrippedOrganizationListPageResponse).isEqualTo(organizationListPageResponse)
    }
}
