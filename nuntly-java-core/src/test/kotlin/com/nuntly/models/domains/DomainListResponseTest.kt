// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainListResponseTest {

    @Test
    fun create() {
        val domainListResponse =
            DomainListResponse.builder()
                .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                .createdAt("createdAt")
                .name("name")
                .region(DomainListResponse.Region.EU_WEST_1)
                .sendingStatus(DomainListResponse.SendingStatus.ENABLED)
                .status(DomainListResponse.Status.BOOTSTRAPPING)
                .build()

        assertThat(domainListResponse.id()).isEqualTo("dns_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(domainListResponse.createdAt()).isEqualTo("createdAt")
        assertThat(domainListResponse.name()).isEqualTo("name")
        assertThat(domainListResponse.region()).isEqualTo(DomainListResponse.Region.EU_WEST_1)
        assertThat(domainListResponse.sendingStatus())
            .isEqualTo(DomainListResponse.SendingStatus.ENABLED)
        assertThat(domainListResponse.status()).isEqualTo(DomainListResponse.Status.BOOTSTRAPPING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainListResponse =
            DomainListResponse.builder()
                .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                .createdAt("createdAt")
                .name("name")
                .region(DomainListResponse.Region.EU_WEST_1)
                .sendingStatus(DomainListResponse.SendingStatus.ENABLED)
                .status(DomainListResponse.Status.BOOTSTRAPPING)
                .build()

        val roundtrippedDomainListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainListResponse),
                jacksonTypeRef<DomainListResponse>(),
            )

        assertThat(roundtrippedDomainListResponse).isEqualTo(domainListResponse)
    }
}
