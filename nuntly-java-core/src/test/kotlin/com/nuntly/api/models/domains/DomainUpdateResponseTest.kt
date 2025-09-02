// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainUpdateResponseTest {

    @Test
    fun create() {
        val domainUpdateResponse =
            DomainUpdateResponse.builder()
                .id("dns_01jh8xggryggczvjv4xfff4rwn")
                .kind(DomainUpdateResponse.Kind.DOMAIN)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .clickTracking(true)
                .openTracking(true)
                .build()

        assertThat(domainUpdateResponse.id()).isEqualTo("dns_01jh8xggryggczvjv4xfff4rwn")
        assertThat(domainUpdateResponse.kind()).isEqualTo(DomainUpdateResponse.Kind.DOMAIN)
        assertThat(domainUpdateResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(domainUpdateResponse.clickTracking()).contains(true)
        assertThat(domainUpdateResponse.openTracking()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainUpdateResponse =
            DomainUpdateResponse.builder()
                .id("dns_01jh8xggryggczvjv4xfff4rwn")
                .kind(DomainUpdateResponse.Kind.DOMAIN)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
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
