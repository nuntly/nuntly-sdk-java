// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationUpdateResponseTest {

    @Test
    fun create() {
        val organizationUpdateResponse =
            OrganizationUpdateResponse.builder()
                .id("org_01jh6jk82zjq9deye73h0mzcaq")
                .kind(OrganizationUpdateResponse.Kind.ORGANIZATION)
                .build()

        assertThat(organizationUpdateResponse.id()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(organizationUpdateResponse.kind())
            .isEqualTo(OrganizationUpdateResponse.Kind.ORGANIZATION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationUpdateResponse =
            OrganizationUpdateResponse.builder()
                .id("org_01jh6jk82zjq9deye73h0mzcaq")
                .kind(OrganizationUpdateResponse.Kind.ORGANIZATION)
                .build()

        val roundtrippedOrganizationUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationUpdateResponse),
                jacksonTypeRef<OrganizationUpdateResponse>(),
            )

        assertThat(roundtrippedOrganizationUpdateResponse).isEqualTo(organizationUpdateResponse)
    }
}
