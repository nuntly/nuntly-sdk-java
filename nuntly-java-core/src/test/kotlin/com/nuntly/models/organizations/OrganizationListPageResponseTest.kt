// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationListPageResponseTest {

    @Test
    fun create() {
        val organizationListPageResponse =
            OrganizationListPageResponse.builder()
                .addData(
                    OrganizationListResponse.builder()
                        .id("org_01ka8k8s80gvx9604cn9am5st4")
                        .name("name")
                        .status(OrganizationListResponse.Status.ENABLED)
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(organizationListPageResponse.data())
            .containsExactly(
                OrganizationListResponse.builder()
                    .id("org_01ka8k8s80gvx9604cn9am5st4")
                    .name("name")
                    .status(OrganizationListResponse.Status.ENABLED)
                    .build()
            )
        assertThat(organizationListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationListPageResponse =
            OrganizationListPageResponse.builder()
                .addData(
                    OrganizationListResponse.builder()
                        .id("org_01ka8k8s80gvx9604cn9am5st4")
                        .name("name")
                        .status(OrganizationListResponse.Status.ENABLED)
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedOrganizationListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationListPageResponse),
                jacksonTypeRef<OrganizationListPageResponse>(),
            )

        assertThat(roundtrippedOrganizationListPageResponse).isEqualTo(organizationListPageResponse)
    }
}
