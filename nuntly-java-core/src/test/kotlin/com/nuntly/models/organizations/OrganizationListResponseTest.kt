// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationListResponseTest {

    @Test
    fun create() {
        val organizationListResponse =
            OrganizationListResponse.builder()
                .id("org_01ka8k8s80gvx9604cn9am5st4")
                .name("name")
                .status(OrganizationListResponse.Status.ENABLED)
                .build()

        assertThat(organizationListResponse.id()).isEqualTo("org_01ka8k8s80gvx9604cn9am5st4")
        assertThat(organizationListResponse.name()).isEqualTo("name")
        assertThat(organizationListResponse.status())
            .isEqualTo(OrganizationListResponse.Status.ENABLED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationListResponse =
            OrganizationListResponse.builder()
                .id("org_01ka8k8s80gvx9604cn9am5st4")
                .name("name")
                .status(OrganizationListResponse.Status.ENABLED)
                .build()

        val roundtrippedOrganizationListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationListResponse),
                jacksonTypeRef<OrganizationListResponse>(),
            )

        assertThat(roundtrippedOrganizationListResponse).isEqualTo(organizationListResponse)
    }
}
