// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationRetrieveResponseTest {

    @Test
    fun create() {
        val organizationRetrieveResponse =
            OrganizationRetrieveResponse.builder()
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .displayName("Ray Tomlinson org")
                .kind(OrganizationRetrieveResponse.Kind.ORGANIZATION)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(OrganizationRetrieveResponse.Region.EU_WEST_1)
                .status(OrganizationRetrieveResponse.Status.ACTIVE)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        assertThat(organizationRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
        assertThat(organizationRetrieveResponse.displayName()).isEqualTo("Ray Tomlinson org")
        assertThat(organizationRetrieveResponse.kind())
            .isEqualTo(OrganizationRetrieveResponse.Kind.ORGANIZATION)
        assertThat(organizationRetrieveResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(organizationRetrieveResponse.region())
            .isEqualTo(OrganizationRetrieveResponse.Region.EU_WEST_1)
        assertThat(organizationRetrieveResponse.status())
            .isEqualTo(OrganizationRetrieveResponse.Status.ACTIVE)
        assertThat(organizationRetrieveResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationRetrieveResponse =
            OrganizationRetrieveResponse.builder()
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .displayName("Ray Tomlinson org")
                .kind(OrganizationRetrieveResponse.Kind.ORGANIZATION)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(OrganizationRetrieveResponse.Region.EU_WEST_1)
                .status(OrganizationRetrieveResponse.Status.ACTIVE)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        val roundtrippedOrganizationRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationRetrieveResponse),
                jacksonTypeRef<OrganizationRetrieveResponse>(),
            )

        assertThat(roundtrippedOrganizationRetrieveResponse).isEqualTo(organizationRetrieveResponse)
    }
}
