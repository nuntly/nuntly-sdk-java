// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadUpdateParamsTest {

    @Test
    fun create() {
        ThreadUpdateParams.builder()
            .threadId("thr_01kabn43yqyxn2bx4ve84mczd3")
            .agentId("agentId")
            .isRead(true)
            .isSpam(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ThreadUpdateParams.builder().threadId("thr_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("thr_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ThreadUpdateParams.builder()
                .threadId("thr_01kabn43yqyxn2bx4ve84mczd3")
                .agentId("agentId")
                .isRead(true)
                .isSpam(true)
                .build()

        val body = params._body()

        assertThat(body.agentId()).contains("agentId")
        assertThat(body.isRead()).contains(true)
        assertThat(body.isSpam()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ThreadUpdateParams.builder().threadId("thr_01kabn43yqyxn2bx4ve84mczd3").build()

        val body = params._body()
    }
}
