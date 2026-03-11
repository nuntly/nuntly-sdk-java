// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.bulk

import com.nuntly.core.JsonValue
import com.nuntly.models.emails.Tag
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkSendParamsTest {

    @Test
    fun create() {
        BulkSendParams.builder()
            .addEmail(
                BulkSendParams.Email.builder()
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(
                        BulkSendParams.Email.Context.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .from("Tomlinson AI <ray@info.tomlinson.ai>")
                    .headers(
                        BulkSendParams.Email.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html(
                        "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                    )
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .subject("Verify your email address")
                    .addTag(Tag.builder().name("category").value("transactional").build())
                    .text("Thank you for signing up! Please verify your email address.")
                    .to("brian67@gmail.com")
                    .build()
            )
            .fallback(
                BulkSendParams.Fallback.builder()
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(
                        BulkSendParams.Fallback.Context.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .from("Tomlinson AI <ray@info.tomlinson.ai>")
                    .headers(
                        BulkSendParams.Fallback.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html(
                        "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                    )
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .subject("Verify your email address")
                    .addTag(Tag.builder().name("category").value("transactional").build())
                    .text("Thank you for signing up! Please verify your email address.")
                    .to("brian67@gmail.com")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            BulkSendParams.builder()
                .addEmail(
                    BulkSendParams.Email.builder()
                        .bccOfStrings(listOf("string"))
                        .ccOfStrings(listOf("string"))
                        .context(
                            BulkSendParams.Email.Context.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .from("Tomlinson AI <ray@info.tomlinson.ai>")
                        .headers(
                            BulkSendParams.Email.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .html(
                            "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                        )
                        .replyToOfStrings(listOf("string"))
                        .scheduledAt("scheduledAt")
                        .subject("Verify your email address")
                        .addTag(Tag.builder().name("category").value("transactional").build())
                        .text("Thank you for signing up! Please verify your email address.")
                        .to("brian67@gmail.com")
                        .build()
                )
                .fallback(
                    BulkSendParams.Fallback.builder()
                        .bccOfStrings(listOf("string"))
                        .ccOfStrings(listOf("string"))
                        .context(
                            BulkSendParams.Fallback.Context.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .from("Tomlinson AI <ray@info.tomlinson.ai>")
                        .headers(
                            BulkSendParams.Fallback.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .html(
                            "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                        )
                        .replyToOfStrings(listOf("string"))
                        .scheduledAt("scheduledAt")
                        .subject("Verify your email address")
                        .addTag(Tag.builder().name("category").value("transactional").build())
                        .text("Thank you for signing up! Please verify your email address.")
                        .to("brian67@gmail.com")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.emails())
            .containsExactly(
                BulkSendParams.Email.builder()
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(
                        BulkSendParams.Email.Context.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .from("Tomlinson AI <ray@info.tomlinson.ai>")
                    .headers(
                        BulkSendParams.Email.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html(
                        "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                    )
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .subject("Verify your email address")
                    .addTag(Tag.builder().name("category").value("transactional").build())
                    .text("Thank you for signing up! Please verify your email address.")
                    .to("brian67@gmail.com")
                    .build()
            )
        assertThat(body.fallback())
            .contains(
                BulkSendParams.Fallback.builder()
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(
                        BulkSendParams.Fallback.Context.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .from("Tomlinson AI <ray@info.tomlinson.ai>")
                    .headers(
                        BulkSendParams.Fallback.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html(
                        "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                    )
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .subject("Verify your email address")
                    .addTag(Tag.builder().name("category").value("transactional").build())
                    .text("Thank you for signing up! Please verify your email address.")
                    .to("brian67@gmail.com")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BulkSendParams.builder().addEmail(BulkSendParams.Email.builder().build()).build()

        val body = params._body()

        assertThat(body.emails()).containsExactly(BulkSendParams.Email.builder().build())
    }
}
