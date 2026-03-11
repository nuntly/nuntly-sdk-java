// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces.inboxes

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.inboxes.Inbox
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxListPageResponseTest {

    @Test
    fun create() {
        val inboxListPageResponse =
            InboxListPageResponse.builder()
                .addData(
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
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(inboxListPageResponse.data())
            .containsExactly(
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
            )
        assertThat(inboxListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboxListPageResponse =
            InboxListPageResponse.builder()
                .addData(
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
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedInboxListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboxListPageResponse),
                jacksonTypeRef<InboxListPageResponse>(),
            )

        assertThat(roundtrippedInboxListPageResponse).isEqualTo(inboxListPageResponse)
    }
}
