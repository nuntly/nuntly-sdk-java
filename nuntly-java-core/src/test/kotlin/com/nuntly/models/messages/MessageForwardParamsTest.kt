// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageForwardParamsTest {

    @Test
    fun create() {
        MessageForwardParams.builder()
            .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
            .addTo("dev@stainless.com")
            .text("text")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MessageForwardParams.builder()
                .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .addTo("dev@stainless.com")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            MessageForwardParams.builder()
                .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .addTo("dev@stainless.com")
                .text("text")
                .build()

        val body = params._body()

        assertThat(body.to()).containsExactly("dev@stainless.com")
        assertThat(body.text()).contains("text")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageForwardParams.builder()
                .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .addTo("dev@stainless.com")
                .build()

        val body = params._body()

        assertThat(body.to()).containsExactly("dev@stainless.com")
    }
}
