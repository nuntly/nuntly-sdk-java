// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageUpdateParamsTest {

    @Test
    fun create() {
        MessageUpdateParams.builder()
            .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
            .addAddLabel("x")
            .addRemoveLabel("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MessageUpdateParams.builder().messageId("imsg_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            MessageUpdateParams.builder()
                .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .addAddLabel("x")
                .addRemoveLabel("x")
                .build()

        val body = params._body()

        assertThat(body.addLabels().getOrNull()).containsExactly("x")
        assertThat(body.removeLabels().getOrNull()).containsExactly("x")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageUpdateParams.builder().messageId("imsg_01kabn43yqyxn2bx4ve84mczd3").build()

        val body = params._body()
    }
}
