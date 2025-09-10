// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyRetrieveParamsTest {

    @Test
    fun create() {
        ApiKeyRetrieveParams.builder().id("apk_pdGukGd4BTmHj8dscBDE5Mc9").build()
    }

    @Test
    fun pathParams() {
        val params = ApiKeyRetrieveParams.builder().id("apk_pdGukGd4BTmHj8dscBDE5Mc9").build()

        assertThat(params._pathParam(0)).isEqualTo("apk_pdGukGd4BTmHj8dscBDE5Mc9")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
