// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadRetrieveParamsTest {

    @Test
    fun create() {
        ThreadRetrieveParams.builder().threadId("thr_01kabn43yqyxn2bx4ve84mczd3").build()
    }

    @Test
    fun pathParams() {
        val params =
            ThreadRetrieveParams.builder().threadId("thr_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("thr_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
