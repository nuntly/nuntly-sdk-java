// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxUpdateParamsTest {

    @Test
    fun create() {
        InboxUpdateParams.builder().inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3").name("name").build()
    }

    @Test
    fun pathParams() {
        val params = InboxUpdateParams.builder().inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("ibx_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            InboxUpdateParams.builder()
                .inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3")
                .name("name")
                .build()

        val body = params._body()

        assertThat(body.name()).contains("name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = InboxUpdateParams.builder().inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3").build()

        val body = params._body()
    }
}
