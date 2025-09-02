// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.apikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateParamsTest {

    @Test
    fun create() {
        ApiKeyCreateParams.builder().name("My API key").build()
    }

    @Test
    fun body() {
        val params = ApiKeyCreateParams.builder().name("My API key").build()

        val body = params._body()

        assertThat(body.name()).contains("My API key")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ApiKeyCreateParams.builder().build()

        val body = params._body()
    }
}
