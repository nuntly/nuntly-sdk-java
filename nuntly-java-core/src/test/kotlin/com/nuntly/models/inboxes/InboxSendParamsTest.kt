// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxSendParamsTest {

    @Test
    fun create() {
        InboxSendParams.builder()
            .inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3")
            .subject("x")
            .addTo("dev@stainless.com")
            .addBcc("dev@stainless.com")
            .addCc("dev@stainless.com")
            .html("html")
            .text("text")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            InboxSendParams.builder()
                .inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3")
                .subject("x")
                .addTo("dev@stainless.com")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("ibx_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            InboxSendParams.builder()
                .inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3")
                .subject("x")
                .addTo("dev@stainless.com")
                .addBcc("dev@stainless.com")
                .addCc("dev@stainless.com")
                .html("html")
                .text("text")
                .build()

        val body = params._body()

        assertThat(body.subject()).isEqualTo("x")
        assertThat(body.to()).containsExactly("dev@stainless.com")
        assertThat(body.bcc().getOrNull()).containsExactly("dev@stainless.com")
        assertThat(body.cc().getOrNull()).containsExactly("dev@stainless.com")
        assertThat(body.html()).contains("html")
        assertThat(body.text()).contains("text")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            InboxSendParams.builder()
                .inboxId("ibx_01kabn43yqyxn2bx4ve84mczd3")
                .subject("x")
                .addTo("dev@stainless.com")
                .build()

        val body = params._body()

        assertThat(body.subject()).isEqualTo("x")
        assertThat(body.to()).containsExactly("dev@stainless.com")
    }
}
