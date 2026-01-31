// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationRetrieveResponseTest {

    @Test
    fun create() {
        val organizationRetrieveResponse =
            OrganizationRetrieveResponse.builder()
                .id("org_01ka8k8s80gvx9604cn9am5st4")
                .name("name")
                .status(OrganizationRetrieveResponse.Status.ENABLED)
                .build()

        assertThat(organizationRetrieveResponse.id()).isEqualTo("org_01ka8k8s80gvx9604cn9am5st4")
        assertThat(organizationRetrieveResponse.name()).isEqualTo("name")
        assertThat(organizationRetrieveResponse.status())
            .isEqualTo(OrganizationRetrieveResponse.Status.ENABLED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationRetrieveResponse =
            OrganizationRetrieveResponse.builder()
                .id("org_01ka8k8s80gvx9604cn9am5st4")
                .name("name")
                .status(OrganizationRetrieveResponse.Status.ENABLED)
                .build()

        val roundtrippedOrganizationRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationRetrieveResponse),
                jacksonTypeRef<OrganizationRetrieveResponse>(),
            )

        assertThat(roundtrippedOrganizationRetrieveResponse).isEqualTo(organizationRetrieveResponse)
    }
}
