// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationListResponseTest {

    @Test
    fun create() {
        val organizationListResponse =
            OrganizationListResponse.builder()
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .displayName("Ray Tomlinson org")
                .kind(OrganizationListResponse.Kind.ORGANIZATION)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(OrganizationListResponse.Region.EU_WEST_1)
                .status(OrganizationListResponse.Status.ACTIVE)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        assertThat(organizationListResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
        assertThat(organizationListResponse.displayName()).isEqualTo("Ray Tomlinson org")
        assertThat(organizationListResponse.kind())
            .isEqualTo(OrganizationListResponse.Kind.ORGANIZATION)
        assertThat(organizationListResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(organizationListResponse.region())
            .isEqualTo(OrganizationListResponse.Region.EU_WEST_1)
        assertThat(organizationListResponse.status())
            .isEqualTo(OrganizationListResponse.Status.ACTIVE)
        assertThat(organizationListResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationListResponse =
            OrganizationListResponse.builder()
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .displayName("Ray Tomlinson org")
                .kind(OrganizationListResponse.Kind.ORGANIZATION)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(OrganizationListResponse.Region.EU_WEST_1)
                .status(OrganizationListResponse.Status.ACTIVE)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        val roundtrippedOrganizationListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationListResponse),
                jacksonTypeRef<OrganizationListResponse>(),
            )

        assertThat(roundtrippedOrganizationListResponse).isEqualTo(organizationListResponse)
    }
}
