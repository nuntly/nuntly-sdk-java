// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainListResponseTest {

    @Test
    fun create() {
        val domainListResponse =
            DomainListResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .kind(DomainListResponse.Kind.DOMAIN)
                .name("name")
                .orgId("org_id")
                .region(DomainListResponse.Region.EU_WEST_1)
                .sendingStatus(DomainListResponse.SendingStatus.ENABLED)
                .status(DomainListResponse.Status.BOOTSTRAPPING)
                .statusAt("status_at")
                .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(domainListResponse.id()).isEqualTo("id")
        assertThat(domainListResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(domainListResponse.kind()).isEqualTo(DomainListResponse.Kind.DOMAIN)
        assertThat(domainListResponse.name()).isEqualTo("name")
        assertThat(domainListResponse.orgId()).isEqualTo("org_id")
        assertThat(domainListResponse.region()).isEqualTo(DomainListResponse.Region.EU_WEST_1)
        assertThat(domainListResponse.sendingStatus())
            .isEqualTo(DomainListResponse.SendingStatus.ENABLED)
        assertThat(domainListResponse.status()).isEqualTo(DomainListResponse.Status.BOOTSTRAPPING)
        assertThat(domainListResponse.statusAt()).isEqualTo("status_at")
        assertThat(domainListResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainListResponse =
            DomainListResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .kind(DomainListResponse.Kind.DOMAIN)
                .name("name")
                .orgId("org_id")
                .region(DomainListResponse.Region.EU_WEST_1)
                .sendingStatus(DomainListResponse.SendingStatus.ENABLED)
                .status(DomainListResponse.Status.BOOTSTRAPPING)
                .statusAt("status_at")
                .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedDomainListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainListResponse),
                jacksonTypeRef<DomainListResponse>(),
            )

        assertThat(roundtrippedDomainListResponse).isEqualTo(domainListResponse)
    }
}
