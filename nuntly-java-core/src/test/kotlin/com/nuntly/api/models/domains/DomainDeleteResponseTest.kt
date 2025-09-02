// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainDeleteResponseTest {

    @Test
    fun create() {
        val domainDeleteResponse =
            DomainDeleteResponse.builder()
                .id("dns_01jh8xggryggczvjv4xfff4rwn")
                .kind(DomainDeleteResponse.Kind.DOMAIN)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        assertThat(domainDeleteResponse.id()).isEqualTo("dns_01jh8xggryggczvjv4xfff4rwn")
        assertThat(domainDeleteResponse.kind()).isEqualTo(DomainDeleteResponse.Kind.DOMAIN)
        assertThat(domainDeleteResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainDeleteResponse =
            DomainDeleteResponse.builder()
                .id("dns_01jh8xggryggczvjv4xfff4rwn")
                .kind(DomainDeleteResponse.Kind.DOMAIN)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        val roundtrippedDomainDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainDeleteResponse),
                jacksonTypeRef<DomainDeleteResponse>(),
            )

        assertThat(roundtrippedDomainDeleteResponse).isEqualTo(domainDeleteResponse)
    }
}
