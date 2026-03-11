// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceUpdateParamsTest {

    @Test
    fun create() {
        NamespaceUpdateParams.builder()
            .namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3")
            .externalId("externalId")
            .name("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            NamespaceUpdateParams.builder().namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("ns_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceUpdateParams.builder()
                .namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3")
                .externalId("externalId")
                .name("x")
                .build()

        val body = params._body()

        assertThat(body.externalId()).contains("externalId")
        assertThat(body.name()).contains("x")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            NamespaceUpdateParams.builder().namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3").build()

        val body = params._body()
    }
}
