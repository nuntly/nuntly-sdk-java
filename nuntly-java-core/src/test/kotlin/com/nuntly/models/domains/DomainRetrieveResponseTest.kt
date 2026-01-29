// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainRetrieveResponseTest {

    @Test
    fun create() {
        val domainRetrieveResponse =
            DomainRetrieveResponse.builder()
                .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                .clickTracking(true)
                .createdAt("createdAt")
                .name("name")
                .openTracking(true)
                .region(DomainRetrieveResponse.Region.EU_WEST_1)
                .addSendingRecord(
                    DomainRetrieveResponse.SendingRecord.builder()
                        .fullname("fullname")
                        .group(DomainRetrieveResponse.SendingRecord.Group.DKIM)
                        .name("name")
                        .recordType(DomainRetrieveResponse.SendingRecord.RecordType.TXT)
                        .status(DomainRetrieveResponse.SendingRecord.Status.BOOTSTRAPPING)
                        .statusAt("statusAt")
                        .ttl("ttl")
                        .value("value")
                        .priority("priority")
                        .selector("selector")
                        .build()
                )
                .sendingStatus(DomainRetrieveResponse.SendingStatus.ENABLED)
                .status(DomainRetrieveResponse.Status.BOOTSTRAPPING)
                .statusAt("statusAt")
                .build()

        assertThat(domainRetrieveResponse.id()).isEqualTo("dns_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(domainRetrieveResponse.clickTracking()).isEqualTo(true)
        assertThat(domainRetrieveResponse.createdAt()).isEqualTo("createdAt")
        assertThat(domainRetrieveResponse.name()).isEqualTo("name")
        assertThat(domainRetrieveResponse.openTracking()).isEqualTo(true)
        assertThat(domainRetrieveResponse.region())
            .isEqualTo(DomainRetrieveResponse.Region.EU_WEST_1)
        assertThat(domainRetrieveResponse.sendingRecords())
            .containsExactly(
                DomainRetrieveResponse.SendingRecord.builder()
                    .fullname("fullname")
                    .group(DomainRetrieveResponse.SendingRecord.Group.DKIM)
                    .name("name")
                    .recordType(DomainRetrieveResponse.SendingRecord.RecordType.TXT)
                    .status(DomainRetrieveResponse.SendingRecord.Status.BOOTSTRAPPING)
                    .statusAt("statusAt")
                    .ttl("ttl")
                    .value("value")
                    .priority("priority")
                    .selector("selector")
                    .build()
            )
        assertThat(domainRetrieveResponse.sendingStatus())
            .isEqualTo(DomainRetrieveResponse.SendingStatus.ENABLED)
        assertThat(domainRetrieveResponse.status())
            .isEqualTo(DomainRetrieveResponse.Status.BOOTSTRAPPING)
        assertThat(domainRetrieveResponse.statusAt()).isEqualTo("statusAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainRetrieveResponse =
            DomainRetrieveResponse.builder()
                .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                .clickTracking(true)
                .createdAt("createdAt")
                .name("name")
                .openTracking(true)
                .region(DomainRetrieveResponse.Region.EU_WEST_1)
                .addSendingRecord(
                    DomainRetrieveResponse.SendingRecord.builder()
                        .fullname("fullname")
                        .group(DomainRetrieveResponse.SendingRecord.Group.DKIM)
                        .name("name")
                        .recordType(DomainRetrieveResponse.SendingRecord.RecordType.TXT)
                        .status(DomainRetrieveResponse.SendingRecord.Status.BOOTSTRAPPING)
                        .statusAt("statusAt")
                        .ttl("ttl")
                        .value("value")
                        .priority("priority")
                        .selector("selector")
                        .build()
                )
                .sendingStatus(DomainRetrieveResponse.SendingStatus.ENABLED)
                .status(DomainRetrieveResponse.Status.BOOTSTRAPPING)
                .statusAt("statusAt")
                .build()

        val roundtrippedDomainRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainRetrieveResponse),
                jacksonTypeRef<DomainRetrieveResponse>(),
            )

        assertThat(roundtrippedDomainRetrieveResponse).isEqualTo(domainRetrieveResponse)
    }
}
