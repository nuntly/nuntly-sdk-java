// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainUpdateResponseTest {

    @Test
    fun create() {
        val domainUpdateResponse =
            DomainUpdateResponse.builder()
                .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                .clickTracking(true)
                .openTracking(true)
                .build()

        assertThat(domainUpdateResponse.id()).isEqualTo("dns_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(domainUpdateResponse.clickTracking()).isEqualTo(true)
        assertThat(domainUpdateResponse.openTracking()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainUpdateResponse =
            DomainUpdateResponse.builder()
                .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                .clickTracking(true)
                .openTracking(true)
                .build()

        val roundtrippedDomainUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainUpdateResponse),
                jacksonTypeRef<DomainUpdateResponse>(),
            )

        assertThat(roundtrippedDomainUpdateResponse).isEqualTo(domainUpdateResponse)
    }
}
