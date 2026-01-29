// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.nuntly.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailSendParamsTest {

    @Test
    fun create() {
        EmailSendParams.builder()
            .from("from")
            .subject("subject")
            .toOfStrings(listOf("string"))
            .addAttachment(
                EmailSendParams.Attachment.builder()
                    .content("content")
                    .contentType("contentType")
                    .filename("filename")
                    .build()
            )
            .bccOfStrings(listOf("string"))
            .ccOfStrings(listOf("string"))
            .context(
                EmailSendParams.Context.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .headers(
                EmailSendParams.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .html("html")
            .replyToOfStrings(listOf("string"))
            .scheduledAt("scheduledAt")
            .addTag(Tag.builder().name("name").value("value").build())
            .text("text")
            .build()
    }

    @Test
    fun body() {
        val params =
            EmailSendParams.builder()
                .from("from")
                .subject("subject")
                .toOfStrings(listOf("string"))
                .addAttachment(
                    EmailSendParams.Attachment.builder()
                        .content("content")
                        .contentType("contentType")
                        .filename("filename")
                        .build()
                )
                .bccOfStrings(listOf("string"))
                .ccOfStrings(listOf("string"))
                .context(
                    EmailSendParams.Context.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .headers(
                    EmailSendParams.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .html("html")
                .replyToOfStrings(listOf("string"))
                .scheduledAt("scheduledAt")
                .addTag(Tag.builder().name("name").value("value").build())
                .text("text")
                .build()

        val body = params._body()

        assertThat(body.from()).isEqualTo("from")
        assertThat(body.subject()).isEqualTo("subject")
        assertThat(body.to()).isEqualTo(EmailSendParams.To.ofStrings(listOf("string")))
        assertThat(body.attachments().getOrNull())
            .containsExactly(
                EmailSendParams.Attachment.builder()
                    .content("content")
                    .contentType("contentType")
                    .filename("filename")
                    .build()
            )
        assertThat(body.bcc()).contains(EmailSendParams.Bcc.ofStrings(listOf("string")))
        assertThat(body.cc()).contains(EmailSendParams.Cc.ofStrings(listOf("string")))
        assertThat(body.context())
            .contains(
                EmailSendParams.Context.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.headers())
            .contains(
                EmailSendParams.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.html()).contains("html")
        assertThat(body.replyTo()).contains(EmailSendParams.ReplyTo.ofStrings(listOf("string")))
        assertThat(body.scheduledAt()).contains("scheduledAt")
        assertThat(body.tags().getOrNull())
            .containsExactly(Tag.builder().name("name").value("value").build())
        assertThat(body.text()).contains("text")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EmailSendParams.builder()
                .from("from")
                .subject("subject")
                .toOfStrings(listOf("string"))
                .build()

        val body = params._body()

        assertThat(body.from()).isEqualTo("from")
        assertThat(body.subject()).isEqualTo("subject")
        assertThat(body.to()).isEqualTo(EmailSendParams.To.ofStrings(listOf("string")))
    }
}
