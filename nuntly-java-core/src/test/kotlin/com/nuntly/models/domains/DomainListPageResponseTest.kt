// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainListPageResponseTest {

    @Test
    fun create() {
        val domainListPageResponse =
            DomainListPageResponse.builder()
                .addData(
                    DomainListResponse.builder()
                        .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                        .createdAt("createdAt")
                        .name("name")
                        .region(DomainListResponse.Region.EU_WEST_1)
                        .sendingStatus(DomainListResponse.SendingStatus.ENABLED)
                        .status(DomainListResponse.Status.BOOTSTRAPPING)
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(domainListPageResponse.data())
            .containsExactly(
                DomainListResponse.builder()
                    .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                    .createdAt("createdAt")
                    .name("name")
                    .region(DomainListResponse.Region.EU_WEST_1)
                    .sendingStatus(DomainListResponse.SendingStatus.ENABLED)
                    .status(DomainListResponse.Status.BOOTSTRAPPING)
                    .build()
            )
        assertThat(domainListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainListPageResponse =
            DomainListPageResponse.builder()
                .addData(
                    DomainListResponse.builder()
                        .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                        .createdAt("createdAt")
                        .name("name")
                        .region(DomainListResponse.Region.EU_WEST_1)
                        .sendingStatus(DomainListResponse.SendingStatus.ENABLED)
                        .status(DomainListResponse.Status.BOOTSTRAPPING)
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedDomainListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainListPageResponse),
                jacksonTypeRef<DomainListPageResponse>(),
            )

        assertThat(roundtrippedDomainListPageResponse).isEqualTo(domainListPageResponse)
    }
}
