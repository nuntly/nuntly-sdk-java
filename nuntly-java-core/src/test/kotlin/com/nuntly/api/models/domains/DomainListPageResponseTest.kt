// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainListPageResponseTest {

    @Test
    fun create() {
        val domainListPageResponse =
            DomainListPageResponse.builder()
                .addData(
                    DomainListResponse.builder()
                        .id("dns_01jh8xggryggczvjv4xfff4rwn")
                        .createdAt(OffsetDateTime.parse("2025-01-10T20:11:55.038Z"))
                        .kind(DomainListResponse.Kind.DOMAIN)
                        .name("info.tomlinson.ai")
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(DomainListResponse.Region.EU_WEST_1)
                        .sendingStatus(DomainListResponse.SendingStatus.DISABLED)
                        .status(DomainListResponse.Status.BOOTSTRAPPING)
                        .statusAt("2025-01-10T20:11:55.038Z")
                        .modifiedAt(OffsetDateTime.parse("2025-01-10T20:11:55.038Z"))
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        assertThat(domainListPageResponse.data().getOrNull())
            .containsExactly(
                DomainListResponse.builder()
                    .id("dns_01jh8xggryggczvjv4xfff4rwn")
                    .createdAt(OffsetDateTime.parse("2025-01-10T20:11:55.038Z"))
                    .kind(DomainListResponse.Kind.DOMAIN)
                    .name("info.tomlinson.ai")
                    .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                    .region(DomainListResponse.Region.EU_WEST_1)
                    .sendingStatus(DomainListResponse.SendingStatus.DISABLED)
                    .status(DomainListResponse.Status.BOOTSTRAPPING)
                    .statusAt("2025-01-10T20:11:55.038Z")
                    .modifiedAt(OffsetDateTime.parse("2025-01-10T20:11:55.038Z"))
                    .build()
            )
        assertThat(domainListPageResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainListPageResponse =
            DomainListPageResponse.builder()
                .addData(
                    DomainListResponse.builder()
                        .id("dns_01jh8xggryggczvjv4xfff4rwn")
                        .createdAt(OffsetDateTime.parse("2025-01-10T20:11:55.038Z"))
                        .kind(DomainListResponse.Kind.DOMAIN)
                        .name("info.tomlinson.ai")
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(DomainListResponse.Region.EU_WEST_1)
                        .sendingStatus(DomainListResponse.SendingStatus.DISABLED)
                        .status(DomainListResponse.Status.BOOTSTRAPPING)
                        .statusAt("2025-01-10T20:11:55.038Z")
                        .modifiedAt(OffsetDateTime.parse("2025-01-10T20:11:55.038Z"))
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        val roundtrippedDomainListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainListPageResponse),
                jacksonTypeRef<DomainListPageResponse>(),
            )

        assertThat(roundtrippedDomainListPageResponse).isEqualTo(domainListPageResponse)
    }
}
