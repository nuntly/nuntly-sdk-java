// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainCreateResponseTest {

    @Test
    fun create() {
        val domainCreateResponse =
            DomainCreateResponse.builder()
                .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                .clickTracking(true)
                .createdAt("createdAt")
                .name("name")
                .openTracking(true)
                .region(DomainCreateResponse.Region.EU_WEST_1)
                .addSendingRecord(
                    DomainCreateResponse.SendingRecord.builder()
                        .fullname("fullname")
                        .group(DomainCreateResponse.SendingRecord.Group.DKIM)
                        .name("name")
                        .recordType(DomainCreateResponse.SendingRecord.RecordType.TXT)
                        .status(DomainCreateResponse.SendingRecord.Status.BOOTSTRAPPING)
                        .statusAt("statusAt")
                        .ttl("ttl")
                        .value("value")
                        .priority("priority")
                        .selector("selector")
                        .build()
                )
                .sendingStatus(DomainCreateResponse.SendingStatus.ENABLED)
                .status(DomainCreateResponse.Status.BOOTSTRAPPING)
                .statusAt("statusAt")
                .build()

        assertThat(domainCreateResponse.id()).isEqualTo("dns_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(domainCreateResponse.clickTracking()).isEqualTo(true)
        assertThat(domainCreateResponse.createdAt()).isEqualTo("createdAt")
        assertThat(domainCreateResponse.name()).isEqualTo("name")
        assertThat(domainCreateResponse.openTracking()).isEqualTo(true)
        assertThat(domainCreateResponse.region()).isEqualTo(DomainCreateResponse.Region.EU_WEST_1)
        assertThat(domainCreateResponse.sendingRecords())
            .containsExactly(
                DomainCreateResponse.SendingRecord.builder()
                    .fullname("fullname")
                    .group(DomainCreateResponse.SendingRecord.Group.DKIM)
                    .name("name")
                    .recordType(DomainCreateResponse.SendingRecord.RecordType.TXT)
                    .status(DomainCreateResponse.SendingRecord.Status.BOOTSTRAPPING)
                    .statusAt("statusAt")
                    .ttl("ttl")
                    .value("value")
                    .priority("priority")
                    .selector("selector")
                    .build()
            )
        assertThat(domainCreateResponse.sendingStatus())
            .isEqualTo(DomainCreateResponse.SendingStatus.ENABLED)
        assertThat(domainCreateResponse.status())
            .isEqualTo(DomainCreateResponse.Status.BOOTSTRAPPING)
        assertThat(domainCreateResponse.statusAt()).isEqualTo("statusAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainCreateResponse =
            DomainCreateResponse.builder()
                .id("dns_01kabn43yqyxn2bx4ve84mczd3")
                .clickTracking(true)
                .createdAt("createdAt")
                .name("name")
                .openTracking(true)
                .region(DomainCreateResponse.Region.EU_WEST_1)
                .addSendingRecord(
                    DomainCreateResponse.SendingRecord.builder()
                        .fullname("fullname")
                        .group(DomainCreateResponse.SendingRecord.Group.DKIM)
                        .name("name")
                        .recordType(DomainCreateResponse.SendingRecord.RecordType.TXT)
                        .status(DomainCreateResponse.SendingRecord.Status.BOOTSTRAPPING)
                        .statusAt("statusAt")
                        .ttl("ttl")
                        .value("value")
                        .priority("priority")
                        .selector("selector")
                        .build()
                )
                .sendingStatus(DomainCreateResponse.SendingStatus.ENABLED)
                .status(DomainCreateResponse.Status.BOOTSTRAPPING)
                .statusAt("statusAt")
                .build()

        val roundtrippedDomainCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainCreateResponse),
                jacksonTypeRef<DomainCreateResponse>(),
            )

        assertThat(roundtrippedDomainCreateResponse).isEqualTo(domainCreateResponse)
    }
}
