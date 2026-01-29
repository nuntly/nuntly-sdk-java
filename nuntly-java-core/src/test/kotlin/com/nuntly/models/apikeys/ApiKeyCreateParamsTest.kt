// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateParamsTest {

    @Test
    fun create() {
        ApiKeyCreateParams.builder().name("name").status(ApiKeyCreateParams.Status.ENABLED).build()
    }

    @Test
    fun body() {
        val params =
            ApiKeyCreateParams.builder()
                .name("name")
                .status(ApiKeyCreateParams.Status.ENABLED)
                .build()

        val body = params._body()

        assertThat(body.name()).contains("name")
        assertThat(body.status()).contains(ApiKeyCreateParams.Status.ENABLED)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ApiKeyCreateParams.builder().build()

        val body = params._body()
    }
}
