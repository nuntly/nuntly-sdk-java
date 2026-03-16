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
            .from("Tomlinson AI <ray@info.tomlinson.ai>")
            .subject("Verify your email address")
            .to("brian67@gmail.com")
            .addAttachment(
                EmailSendParams.Attachment.builder()
                    .content("SGVsbG8gV29ybGQ=")
                    .contentType("application/pdf")
                    .filename("invoice.pdf")
                    .build()
            )
            .bccOfStrings(listOf("string"))
            .ccOfStrings(listOf("string"))
            .headers(
                EmailSendParams.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .html(
                "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
            )
            .replyToOfStrings(listOf("string"))
            .scheduledAt("scheduledAt")
            .addTag(Tag.builder().name("category").value("transactional").build())
            .text("Thank you for signing up! Please verify your email address.")
            .variables(
                EmailSendParams.Variables.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            EmailSendParams.builder()
                .from("Tomlinson AI <ray@info.tomlinson.ai>")
                .subject("Verify your email address")
                .to("brian67@gmail.com")
                .addAttachment(
                    EmailSendParams.Attachment.builder()
                        .content("SGVsbG8gV29ybGQ=")
                        .contentType("application/pdf")
                        .filename("invoice.pdf")
                        .build()
                )
                .bccOfStrings(listOf("string"))
                .ccOfStrings(listOf("string"))
                .headers(
                    EmailSendParams.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .html(
                    "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                )
                .replyToOfStrings(listOf("string"))
                .scheduledAt("scheduledAt")
                .addTag(Tag.builder().name("category").value("transactional").build())
                .text("Thank you for signing up! Please verify your email address.")
                .variables(
                    EmailSendParams.Variables.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.from()).isEqualTo("Tomlinson AI <ray@info.tomlinson.ai>")
        assertThat(body.subject()).isEqualTo("Verify your email address")
        assertThat(body.to()).isEqualTo(EmailSendParams.To.ofString("brian67@gmail.com"))
        assertThat(body.attachments().getOrNull())
            .containsExactly(
                EmailSendParams.Attachment.builder()
                    .content("SGVsbG8gV29ybGQ=")
                    .contentType("application/pdf")
                    .filename("invoice.pdf")
                    .build()
            )
        assertThat(body.bcc()).contains(EmailSendParams.Bcc.ofStrings(listOf("string")))
        assertThat(body.cc()).contains(EmailSendParams.Cc.ofStrings(listOf("string")))
        assertThat(body.headers())
            .contains(
                EmailSendParams.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.html())
            .contains(
                "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
            )
        assertThat(body.replyTo()).contains(EmailSendParams.ReplyTo.ofStrings(listOf("string")))
        assertThat(body.scheduledAt()).contains("scheduledAt")
        assertThat(body.tags().getOrNull())
            .containsExactly(Tag.builder().name("category").value("transactional").build())
        assertThat(body.text())
            .contains("Thank you for signing up! Please verify your email address.")
        assertThat(body.variables())
            .contains(
                EmailSendParams.Variables.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EmailSendParams.builder()
                .from("Tomlinson AI <ray@info.tomlinson.ai>")
                .subject("Verify your email address")
                .to("brian67@gmail.com")
                .build()

        val body = params._body()

        assertThat(body.from()).isEqualTo("Tomlinson AI <ray@info.tomlinson.ai>")
        assertThat(body.subject()).isEqualTo("Verify your email address")
        assertThat(body.to()).isEqualTo(EmailSendParams.To.ofString("brian67@gmail.com"))
    }
}
