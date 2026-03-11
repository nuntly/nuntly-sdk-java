// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageAttachmentTest {

    @Test
    fun create() {
        val messageAttachment =
            MessageAttachment.builder()
                .id("iatt_01kabn43yqyxn2bx4ve84mczd3")
                .contentDisposition("contentDisposition")
                .contentId("contentId")
                .contentType("contentType")
                .filename("filename")
                .size(0.0)
                .downloadUrl("https://example.com")
                .build()

        assertThat(messageAttachment.id()).isEqualTo("iatt_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(messageAttachment.contentDisposition()).contains("contentDisposition")
        assertThat(messageAttachment.contentId()).contains("contentId")
        assertThat(messageAttachment.contentType()).isEqualTo("contentType")
        assertThat(messageAttachment.filename()).contains("filename")
        assertThat(messageAttachment.size()).isEqualTo(0.0)
        assertThat(messageAttachment.downloadUrl()).contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageAttachment =
            MessageAttachment.builder()
                .id("iatt_01kabn43yqyxn2bx4ve84mczd3")
                .contentDisposition("contentDisposition")
                .contentId("contentId")
                .contentType("contentType")
                .filename("filename")
                .size(0.0)
                .downloadUrl("https://example.com")
                .build()

        val roundtrippedMessageAttachment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageAttachment),
                jacksonTypeRef<MessageAttachment>(),
            )

        assertThat(roundtrippedMessageAttachment).isEqualTo(messageAttachment)
    }
}
