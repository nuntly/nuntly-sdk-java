// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxTest {

    @Test
    fun create() {
        val inbox =
            Inbox.builder()
                .id("ibx_01kabn43yqyxn2bx4ve84mczd3")
                .address("address")
                .agentId("agentId")
                .createdAt("createdAt")
                .domainId("domainId")
                .domainName("domainName")
                .name("name")
                .namespaceId("namespaceId")
                .namespaceName("namespaceName")
                .updatedAt("updatedAt")
                .build()

        assertThat(inbox.id()).isEqualTo("ibx_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(inbox.address()).isEqualTo("address")
        assertThat(inbox.agentId()).contains("agentId")
        assertThat(inbox.createdAt()).isEqualTo("createdAt")
        assertThat(inbox.domainId()).isEqualTo("domainId")
        assertThat(inbox.domainName()).isEqualTo("domainName")
        assertThat(inbox.name()).contains("name")
        assertThat(inbox.namespaceId()).contains("namespaceId")
        assertThat(inbox.namespaceName()).contains("namespaceName")
        assertThat(inbox.updatedAt()).contains("updatedAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inbox =
            Inbox.builder()
                .id("ibx_01kabn43yqyxn2bx4ve84mczd3")
                .address("address")
                .agentId("agentId")
                .createdAt("createdAt")
                .domainId("domainId")
                .domainName("domainName")
                .name("name")
                .namespaceId("namespaceId")
                .namespaceName("namespaceName")
                .updatedAt("updatedAt")
                .build()

        val roundtrippedInbox =
            jsonMapper.readValue(jsonMapper.writeValueAsString(inbox), jacksonTypeRef<Inbox>())

        assertThat(roundtrippedInbox).isEqualTo(inbox)
    }
}
