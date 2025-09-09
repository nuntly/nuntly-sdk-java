// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails

import com.nuntly.api.core.JsonValue
import com.nuntly.api.models.shared.EmailHeaders
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailSendParamsTest {

    @Test
    fun create() {
        EmailSendParams.builder()
            .from("ray@info.tomlinson.ai")
            .subject("Welcome to Tomlinson AI!")
            .to("carlo43@gmail.com")
            .addAttachment(
                EmailSendParams.Attachment.builder()
                    .content("content")
                    .contentType("content_type")
                    .filename("filename")
                    .build()
            )
            .bccOfStrings(listOf("string"))
            .ccOfStrings(listOf("string"))
            .context(JsonValue.from(mapOf<String, Any>()))
            .headers(
                EmailHeaders.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .html(
                "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
            )
            .replyToOfStrings(listOf("string"))
            .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .addTag(EmailSendParams.Tag.builder().name("name").value("value").build())
            .text("text")
            .build()
    }

    @Test
    fun body() {
        val params =
            EmailSendParams.builder()
                .from("ray@info.tomlinson.ai")
                .subject("Welcome to Tomlinson AI!")
                .to("carlo43@gmail.com")
                .addAttachment(
                    EmailSendParams.Attachment.builder()
                        .content("content")
                        .contentType("content_type")
                        .filename("filename")
                        .build()
                )
                .bccOfStrings(listOf("string"))
                .ccOfStrings(listOf("string"))
                .context(JsonValue.from(mapOf<String, Any>()))
                .headers(
                    EmailHeaders.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .html(
                    "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
                )
                .replyToOfStrings(listOf("string"))
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addTag(EmailSendParams.Tag.builder().name("name").value("value").build())
                .text("text")
                .build()

        val body = params._body()

        assertThat(body.from()).isEqualTo("ray@info.tomlinson.ai")
        assertThat(body.subject()).isEqualTo("Welcome to Tomlinson AI!")
        assertThat(body.to()).isEqualTo(EmailSendParams.To.ofString("carlo43@gmail.com"))
        assertThat(body.attachments().getOrNull())
            .containsExactly(
                EmailSendParams.Attachment.builder()
                    .content("content")
                    .contentType("content_type")
                    .filename("filename")
                    .build()
            )
        assertThat(body.bcc()).contains(EmailSendParams.Bcc.ofStrings(listOf("string")))
        assertThat(body.cc()).contains(EmailSendParams.Cc.ofStrings(listOf("string")))
        assertThat(body._context()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.headers())
            .contains(
                EmailHeaders.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.html())
            .contains(
                "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
            )
        assertThat(body.replyTo()).contains(EmailSendParams.ReplyTo.ofStrings(listOf("string")))
        assertThat(body.scheduledAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(body.tags().getOrNull())
            .containsExactly(EmailSendParams.Tag.builder().name("name").value("value").build())
        assertThat(body.text()).contains("text")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EmailSendParams.builder()
                .from("ray@info.tomlinson.ai")
                .subject("Welcome to Tomlinson AI!")
                .to("carlo43@gmail.com")
                .build()

        val body = params._body()

        assertThat(body.from()).isEqualTo("ray@info.tomlinson.ai")
        assertThat(body.subject()).isEqualTo("Welcome to Tomlinson AI!")
        assertThat(body.to()).isEqualTo(EmailSendParams.To.ofString("carlo43@gmail.com"))
    }
}
