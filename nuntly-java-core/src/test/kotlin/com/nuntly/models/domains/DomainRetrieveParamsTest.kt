// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainRetrieveParamsTest {

    @Test
    fun create() {
        DomainRetrieveParams.builder().id("dns_01kabn43yqyxn2bx4ve84mczd3").build()
    }

    @Test
    fun pathParams() {
        val params = DomainRetrieveParams.builder().id("dns_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("dns_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
