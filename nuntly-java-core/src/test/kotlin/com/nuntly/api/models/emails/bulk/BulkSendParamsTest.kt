// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails.bulk

import com.nuntly.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkSendParamsTest {

    @Test
    fun create() {
        BulkSendParams.builder()
            .addEmail(
                BulkSendParams.Email.builder()
                    .to("carlo43@gmail.com")
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(JsonValue.from(mapOf<String, Any>()))
                    .from("ray@info.tomlinson.ai")
                    .headers(
                        BulkSendParams.Email.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html(
                        "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
                    )
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .subject("Welcome to Tomlinson AI!")
                    .addTag(BulkSendParams.Email.Tag.builder().name("name").value("value").build())
                    .text("text")
                    .build()
            )
            .addEmail(
                BulkSendParams.Email.builder()
                    .to("pink42@yahoo.com")
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(JsonValue.from(mapOf<String, Any>()))
                    .from("ray@info.tomlinson.ai")
                    .headers(
                        BulkSendParams.Email.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html(
                        "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
                    )
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .subject("Welcome to Tomlinson AI!")
                    .addTag(BulkSendParams.Email.Tag.builder().name("name").value("value").build())
                    .text("text")
                    .build()
            )
            .fallback(
                BulkSendParams.Fallback.builder()
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(JsonValue.from(mapOf<String, Any>()))
                    .from("from")
                    .headers(
                        BulkSendParams.Fallback.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html("html")
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .subject("subject")
                    .addTag(
                        BulkSendParams.Fallback.Tag.builder().name("name").value("value").build()
                    )
                    .text("text")
                    .toOfStrings(listOf("string"))
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
                        .to("carlo43@gmail.com")
                        .bccOfStrings(listOf("string"))
                        .ccOfStrings(listOf("string"))
                        .context(JsonValue.from(mapOf<String, Any>()))
                        .from("ray@info.tomlinson.ai")
                        .headers(
                            BulkSendParams.Email.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .html(
                            "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
                        )
                        .replyToOfStrings(listOf("string"))
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .subject("Welcome to Tomlinson AI!")
                        .addTag(
                            BulkSendParams.Email.Tag.builder().name("name").value("value").build()
                        )
                        .text("text")
                        .build()
                )
                .addEmail(
                    BulkSendParams.Email.builder()
                        .to("pink42@yahoo.com")
                        .bccOfStrings(listOf("string"))
                        .ccOfStrings(listOf("string"))
                        .context(JsonValue.from(mapOf<String, Any>()))
                        .from("ray@info.tomlinson.ai")
                        .headers(
                            BulkSendParams.Email.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .html(
                            "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
                        )
                        .replyToOfStrings(listOf("string"))
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .subject("Welcome to Tomlinson AI!")
                        .addTag(
                            BulkSendParams.Email.Tag.builder().name("name").value("value").build()
                        )
                        .text("text")
                        .build()
                )
                .fallback(
                    BulkSendParams.Fallback.builder()
                        .bccOfStrings(listOf("string"))
                        .ccOfStrings(listOf("string"))
                        .context(JsonValue.from(mapOf<String, Any>()))
                        .from("from")
                        .headers(
                            BulkSendParams.Fallback.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .html("html")
                        .replyToOfStrings(listOf("string"))
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .subject("subject")
                        .addTag(
                            BulkSendParams.Fallback.Tag.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .text("text")
                        .toOfStrings(listOf("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.emails())
            .containsExactly(
                BulkSendParams.Email.builder()
                    .to("carlo43@gmail.com")
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(JsonValue.from(mapOf<String, Any>()))
                    .from("ray@info.tomlinson.ai")
                    .headers(
                        BulkSendParams.Email.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html(
                        "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
                    )
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .subject("Welcome to Tomlinson AI!")
                    .addTag(BulkSendParams.Email.Tag.builder().name("name").value("value").build())
                    .text("text")
                    .build(),
                BulkSendParams.Email.builder()
                    .to("pink42@yahoo.com")
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(JsonValue.from(mapOf<String, Any>()))
                    .from("ray@info.tomlinson.ai")
                    .headers(
                        BulkSendParams.Email.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html(
                        "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
                    )
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .subject("Welcome to Tomlinson AI!")
                    .addTag(BulkSendParams.Email.Tag.builder().name("name").value("value").build())
                    .text("text")
                    .build(),
            )
        assertThat(body.fallback())
            .contains(
                BulkSendParams.Fallback.builder()
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(JsonValue.from(mapOf<String, Any>()))
                    .from("from")
                    .headers(
                        BulkSendParams.Fallback.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html("html")
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .subject("subject")
                    .addTag(
                        BulkSendParams.Fallback.Tag.builder().name("name").value("value").build()
                    )
                    .text("text")
                    .toOfStrings(listOf("string"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BulkSendParams.builder()
                .addEmail(BulkSendParams.Email.builder().to("carlo43@gmail.com").build())
                .addEmail(BulkSendParams.Email.builder().to("pink42@yahoo.com").build())
                .build()

        val body = params._body()

        assertThat(body.emails())
            .containsExactly(
                BulkSendParams.Email.builder().to("carlo43@gmail.com").build(),
                BulkSendParams.Email.builder().to("pink42@yahoo.com").build(),
            )
    }
}
