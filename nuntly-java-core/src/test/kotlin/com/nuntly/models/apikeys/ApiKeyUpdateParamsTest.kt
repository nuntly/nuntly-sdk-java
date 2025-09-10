// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyUpdateParamsTest {

    @Test
    fun create() {
        ApiKeyUpdateParams.builder()
            .id("ak_pdGukGd4BTmHj8dscBDE5Mc9")
            .name("name")
            .status(ApiKeyUpdateParams.Status.DISABLED)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ApiKeyUpdateParams.builder().id("ak_pdGukGd4BTmHj8dscBDE5Mc9").build()

        assertThat(params._pathParam(0)).isEqualTo("ak_pdGukGd4BTmHj8dscBDE5Mc9")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ApiKeyUpdateParams.builder()
                .id("ak_pdGukGd4BTmHj8dscBDE5Mc9")
                .name("name")
                .status(ApiKeyUpdateParams.Status.DISABLED)
                .build()

        val body = params._body()

        assertThat(body.name()).contains("name")
        assertThat(body.status()).contains(ApiKeyUpdateParams.Status.DISABLED)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ApiKeyUpdateParams.builder().id("ak_pdGukGd4BTmHj8dscBDE5Mc9").build()

        val body = params._body()
    }
}
