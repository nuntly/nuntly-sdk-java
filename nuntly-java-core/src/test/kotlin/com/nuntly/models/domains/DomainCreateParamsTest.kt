// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainCreateParamsTest {

    @Test
    fun create() {
        DomainCreateParams.builder().name("name").receiving(true).sending(true).build()
    }

    @Test
    fun body() {
        val params = DomainCreateParams.builder().name("name").receiving(true).sending(true).build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.receiving()).contains(true)
        assertThat(body.sending()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = DomainCreateParams.builder().name("name").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
    }
}
