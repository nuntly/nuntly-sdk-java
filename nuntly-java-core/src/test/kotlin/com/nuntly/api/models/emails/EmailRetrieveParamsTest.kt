// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailRetrieveParamsTest {

    @Test
    fun create() {
        EmailRetrieveParams.builder()
            .id("em_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            EmailRetrieveParams.builder()
                .id("em_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")
                .build()

        assertThat(params._pathParam(0))
            .isEqualTo("em_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
