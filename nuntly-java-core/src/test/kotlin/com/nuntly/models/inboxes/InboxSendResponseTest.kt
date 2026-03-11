// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxSendResponseTest {

    @Test
    fun create() {
        val inboxSendResponse =
            InboxSendResponse.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .messageId("messageId")
                .threadId("threadId")
                .build()

        assertThat(inboxSendResponse.id()).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(inboxSendResponse.messageId()).isEqualTo("messageId")
        assertThat(inboxSendResponse.threadId()).isEqualTo("threadId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboxSendResponse =
            InboxSendResponse.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .messageId("messageId")
                .threadId("threadId")
                .build()

        val roundtrippedInboxSendResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboxSendResponse),
                jacksonTypeRef<InboxSendResponse>(),
            )

        assertThat(roundtrippedInboxSendResponse).isEqualTo(inboxSendResponse)
    }
}
