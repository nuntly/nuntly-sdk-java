// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxCreateParamsTest {

    @Test
    fun create() {
        InboxCreateParams.builder()
            .address("x")
            .agentId("agentId")
            .domainId("domainId")
            .name("name")
            .namespaceId("namespaceId")
            .build()
    }

    @Test
    fun body() {
        val params =
            InboxCreateParams.builder()
                .address("x")
                .agentId("agentId")
                .domainId("domainId")
                .name("name")
                .namespaceId("namespaceId")
                .build()

        val body = params._body()

        assertThat(body.address()).isEqualTo("x")
        assertThat(body.agentId()).contains("agentId")
        assertThat(body.domainId()).contains("domainId")
        assertThat(body.name()).contains("name")
        assertThat(body.namespaceId()).contains("namespaceId")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = InboxCreateParams.builder().address("x").build()

        val body = params._body()

        assertThat(body.address()).isEqualTo("x")
    }
}
