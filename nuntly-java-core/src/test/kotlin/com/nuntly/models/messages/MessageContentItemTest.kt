// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageContentItemTest {

    @Test
    fun create() {
        val messageContentItem =
            MessageContentItem.builder()
                .downloadUrl("https://example.com")
                .expiresAt("expiresAt")
                .size(0.0)
                .build()

        assertThat(messageContentItem.downloadUrl()).isEqualTo("https://example.com")
        assertThat(messageContentItem.expiresAt()).isEqualTo("expiresAt")
        assertThat(messageContentItem.size()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageContentItem =
            MessageContentItem.builder()
                .downloadUrl("https://example.com")
                .expiresAt("expiresAt")
                .size(0.0)
                .build()

        val roundtrippedMessageContentItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContentItem),
                jacksonTypeRef<MessageContentItem>(),
            )

        assertThat(roundtrippedMessageContentItem).isEqualTo(messageContentItem)
    }
}
