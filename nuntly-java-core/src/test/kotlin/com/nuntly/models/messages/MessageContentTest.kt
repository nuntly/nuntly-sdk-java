// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageContentTest {

    @Test
    fun create() {
        val messageContent =
            MessageContent.builder()
                .html(
                    MessageContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .mime(
                    MessageContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .text(
                    MessageContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .build()

        assertThat(messageContent.html())
            .contains(
                MessageContentItem.builder()
                    .downloadUrl("https://example.com")
                    .expiresAt("expiresAt")
                    .size(0.0)
                    .build()
            )
        assertThat(messageContent.mime())
            .contains(
                MessageContentItem.builder()
                    .downloadUrl("https://example.com")
                    .expiresAt("expiresAt")
                    .size(0.0)
                    .build()
            )
        assertThat(messageContent.text())
            .contains(
                MessageContentItem.builder()
                    .downloadUrl("https://example.com")
                    .expiresAt("expiresAt")
                    .size(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageContent =
            MessageContent.builder()
                .html(
                    MessageContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .mime(
                    MessageContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .text(
                    MessageContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .build()

        val roundtrippedMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContent),
                jacksonTypeRef<MessageContent>(),
            )

        assertThat(roundtrippedMessageContent).isEqualTo(messageContent)
    }
}
