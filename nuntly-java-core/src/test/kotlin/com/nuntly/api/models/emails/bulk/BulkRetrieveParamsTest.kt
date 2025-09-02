// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails.bulk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkRetrieveParamsTest {

    @Test
    fun create() {
        BulkRetrieveParams.builder()
            .id("blk_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            BulkRetrieveParams.builder()
                .id("blk_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")
                .build()

        assertThat(params._pathParam(0))
            .isEqualTo("blk_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
