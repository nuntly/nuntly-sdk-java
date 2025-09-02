// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainRetrieveResponseTest {

    @Test
    fun create() {
        val domainRetrieveResponse =
            DomainRetrieveResponse.builder()
                .id("id")
                .clickTracking(true)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .kind(DomainRetrieveResponse.Kind.DOMAIN)
                .name("name")
                .openTracking(true)
                .orgId("org_id")
                .region(DomainRetrieveResponse.Region.EU_WEST_1)
                .addSendingRecord(
                    DomainRetrieveResponse.SendingRecord.builder()
                        .fullname("fullname")
                        .group(DomainRetrieveResponse.SendingRecord.Group.DKIM)
                        .kind(DomainRetrieveResponse.SendingRecord.Kind.RECORD)
                        .name("name")
                        .region(DomainRetrieveResponse.SendingRecord.Region.EU_WEST_1)
                        .status(DomainRetrieveResponse.SendingRecord.Status.BOOTSTRAPPING)
                        .statusAt("status_at")
                        .ttl("ttl")
                        .type(DomainRetrieveResponse.SendingRecord.Type.TXT)
                        .value("value")
                        .priority("priority")
                        .selector("selector")
                        .build()
                )
                .sendingStatus(DomainRetrieveResponse.SendingStatus.ENABLED)
                .status(DomainRetrieveResponse.Status.BOOTSTRAPPING)
                .statusAt("status_at")
                .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(domainRetrieveResponse.id()).isEqualTo("id")
        assertThat(domainRetrieveResponse.clickTracking()).isEqualTo(true)
        assertThat(domainRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(domainRetrieveResponse.kind()).isEqualTo(DomainRetrieveResponse.Kind.DOMAIN)
        assertThat(domainRetrieveResponse.name()).isEqualTo("name")
        assertThat(domainRetrieveResponse.openTracking()).isEqualTo(true)
        assertThat(domainRetrieveResponse.orgId()).isEqualTo("org_id")
        assertThat(domainRetrieveResponse.region())
            .isEqualTo(DomainRetrieveResponse.Region.EU_WEST_1)
        assertThat(domainRetrieveResponse.sendingRecords())
            .containsExactly(
                DomainRetrieveResponse.SendingRecord.builder()
                    .fullname("fullname")
                    .group(DomainRetrieveResponse.SendingRecord.Group.DKIM)
                    .kind(DomainRetrieveResponse.SendingRecord.Kind.RECORD)
                    .name("name")
                    .region(DomainRetrieveResponse.SendingRecord.Region.EU_WEST_1)
                    .status(DomainRetrieveResponse.SendingRecord.Status.BOOTSTRAPPING)
                    .statusAt("status_at")
                    .ttl("ttl")
                    .type(DomainRetrieveResponse.SendingRecord.Type.TXT)
                    .value("value")
                    .priority("priority")
                    .selector("selector")
                    .build()
            )
        assertThat(domainRetrieveResponse.sendingStatus())
            .isEqualTo(DomainRetrieveResponse.SendingStatus.ENABLED)
        assertThat(domainRetrieveResponse.status())
            .isEqualTo(DomainRetrieveResponse.Status.BOOTSTRAPPING)
        assertThat(domainRetrieveResponse.statusAt()).isEqualTo("status_at")
        assertThat(domainRetrieveResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainRetrieveResponse =
            DomainRetrieveResponse.builder()
                .id("id")
                .clickTracking(true)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .kind(DomainRetrieveResponse.Kind.DOMAIN)
                .name("name")
                .openTracking(true)
                .orgId("org_id")
                .region(DomainRetrieveResponse.Region.EU_WEST_1)
                .addSendingRecord(
                    DomainRetrieveResponse.SendingRecord.builder()
                        .fullname("fullname")
                        .group(DomainRetrieveResponse.SendingRecord.Group.DKIM)
                        .kind(DomainRetrieveResponse.SendingRecord.Kind.RECORD)
                        .name("name")
                        .region(DomainRetrieveResponse.SendingRecord.Region.EU_WEST_1)
                        .status(DomainRetrieveResponse.SendingRecord.Status.BOOTSTRAPPING)
                        .statusAt("status_at")
                        .ttl("ttl")
                        .type(DomainRetrieveResponse.SendingRecord.Type.TXT)
                        .value("value")
                        .priority("priority")
                        .selector("selector")
                        .build()
                )
                .sendingStatus(DomainRetrieveResponse.SendingStatus.ENABLED)
                .status(DomainRetrieveResponse.Status.BOOTSTRAPPING)
                .statusAt("status_at")
                .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedDomainRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainRetrieveResponse),
                jacksonTypeRef<DomainRetrieveResponse>(),
            )

        assertThat(roundtrippedDomainRetrieveResponse).isEqualTo(domainRetrieveResponse)
    }
}
