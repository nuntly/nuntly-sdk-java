// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads

import com.nuntly.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadRetrieveParamsTest {

    @Test
    fun create() {
        ThreadRetrieveParams.builder()
            .threadId("thr_01kabn43yqyxn2bx4ve84mczd3")
            .markRead("markRead")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ThreadRetrieveParams.builder().threadId("thr_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("thr_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ThreadRetrieveParams.builder()
                .threadId("thr_01kabn43yqyxn2bx4ve84mczd3")
                .markRead("markRead")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("markRead", "markRead").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ThreadRetrieveParams.builder().threadId("thr_01kabn43yqyxn2bx4ve84mczd3").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
