// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainDeleteResponseTest {

    @Test
    fun create() {
        val domainDeleteResponse =
            DomainDeleteResponse.builder().id("dns_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(domainDeleteResponse.id()).isEqualTo("dns_01kabn43yqyxn2bx4ve84mczd3")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val domainDeleteResponse =
            DomainDeleteResponse.builder().id("dns_01kabn43yqyxn2bx4ve84mczd3").build()

        val roundtrippedDomainDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(domainDeleteResponse),
                jacksonTypeRef<DomainDeleteResponse>(),
            )

        assertThat(roundtrippedDomainDeleteResponse).isEqualTo(domainDeleteResponse)
    }
}
