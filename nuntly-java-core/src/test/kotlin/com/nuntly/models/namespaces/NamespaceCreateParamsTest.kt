// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceCreateParamsTest {

    @Test
    fun create() {
        NamespaceCreateParams.builder().name("x").externalId("externalId").build()
    }

    @Test
    fun body() {
        val params = NamespaceCreateParams.builder().name("x").externalId("externalId").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("x")
        assertThat(body.externalId()).contains("externalId")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceCreateParams.builder().name("x").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("x")
    }
}
