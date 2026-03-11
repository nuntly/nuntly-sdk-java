// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.threads.Thread
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadListPageResponseTest {

    @Test
    fun create() {
        val threadListPageResponse =
            ThreadListPageResponse.builder()
                .addData(
                    Thread.builder()
                        .id("thr_01kabn43yqyxn2bx4ve84mczd3")
                        .agentId("agentId")
                        .createdAt("createdAt")
                        .domainId("domainId")
                        .domainName("domainName")
                        .inboxId("inboxId")
                        .isRead(true)
                        .isSpam(true)
                        .lastMessageAt("lastMessageAt")
                        .messageCount(0.0)
                        .subject("subject")
                        .updatedAt("updatedAt")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(threadListPageResponse.data())
            .containsExactly(
                Thread.builder()
                    .id("thr_01kabn43yqyxn2bx4ve84mczd3")
                    .agentId("agentId")
                    .createdAt("createdAt")
                    .domainId("domainId")
                    .domainName("domainName")
                    .inboxId("inboxId")
                    .isRead(true)
                    .isSpam(true)
                    .lastMessageAt("lastMessageAt")
                    .messageCount(0.0)
                    .subject("subject")
                    .updatedAt("updatedAt")
                    .build()
            )
        assertThat(threadListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val threadListPageResponse =
            ThreadListPageResponse.builder()
                .addData(
                    Thread.builder()
                        .id("thr_01kabn43yqyxn2bx4ve84mczd3")
                        .agentId("agentId")
                        .createdAt("createdAt")
                        .domainId("domainId")
                        .domainName("domainName")
                        .inboxId("inboxId")
                        .isRead(true)
                        .isSpam(true)
                        .lastMessageAt("lastMessageAt")
                        .messageCount(0.0)
                        .subject("subject")
                        .updatedAt("updatedAt")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedThreadListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(threadListPageResponse),
                jacksonTypeRef<ThreadListPageResponse>(),
            )

        assertThat(roundtrippedThreadListPageResponse).isEqualTo(threadListPageResponse)
    }
}
