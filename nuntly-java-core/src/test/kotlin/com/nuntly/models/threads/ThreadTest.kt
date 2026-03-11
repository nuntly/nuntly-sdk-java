// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadTest {

    @Test
    fun create() {
        val thread =
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

        assertThat(thread.id()).isEqualTo("thr_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(thread.agentId()).contains("agentId")
        assertThat(thread.createdAt()).isEqualTo("createdAt")
        assertThat(thread.domainId()).contains("domainId")
        assertThat(thread.domainName()).isEqualTo("domainName")
        assertThat(thread.inboxId()).isEqualTo("inboxId")
        assertThat(thread.isRead()).isEqualTo(true)
        assertThat(thread.isSpam()).isEqualTo(true)
        assertThat(thread.lastMessageAt()).isEqualTo("lastMessageAt")
        assertThat(thread.messageCount()).isEqualTo(0.0)
        assertThat(thread.subject()).isEqualTo("subject")
        assertThat(thread.updatedAt()).contains("updatedAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val thread =
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

        val roundtrippedThread =
            jsonMapper.readValue(jsonMapper.writeValueAsString(thread), jacksonTypeRef<Thread>())

        assertThat(roundtrippedThread).isEqualTo(thread)
    }
}
