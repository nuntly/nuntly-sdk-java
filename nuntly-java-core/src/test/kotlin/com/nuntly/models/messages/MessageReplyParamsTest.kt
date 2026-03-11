// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageReplyParamsTest {

    @Test
    fun create() {
        MessageReplyParams.builder()
            .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
            .html("html")
            .replyAll(true)
            .text("text")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MessageReplyParams.builder().messageId("imsg_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            MessageReplyParams.builder()
                .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .html("html")
                .replyAll(true)
                .text("text")
                .build()

        val body = params._body()

        assertThat(body.html()).contains("html")
        assertThat(body.replyAll()).contains(true)
        assertThat(body.text()).contains("text")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageReplyParams.builder().messageId("imsg_01kabn43yqyxn2bx4ve84mczd3").build()

        val body = params._body()
    }
}
