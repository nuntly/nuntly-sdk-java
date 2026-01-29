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
                    .from("from")
                    .headers(
                        BulkSendParams.Email.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html("html")
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .subject("subject")
                    .addTag(Tag.builder().name("name").value("value").build())
                    .text("text")
                    .toOfStrings(listOf("string"))
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
                    .from("from")
                    .headers(
                        BulkSendParams.Fallback.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html("html")
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .subject("subject")
                    .addTag(Tag.builder().name("name").value("value").build())
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
                        .bccOfStrings(listOf("string"))
                        .ccOfStrings(listOf("string"))
                        .context(
                            BulkSendParams.Email.Context.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .from("from")
                        .headers(
                            BulkSendParams.Email.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .html("html")
                        .replyToOfStrings(listOf("string"))
                        .scheduledAt("scheduledAt")
                        .subject("subject")
                        .addTag(Tag.builder().name("name").value("value").build())
                        .text("text")
                        .toOfStrings(listOf("string"))
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
                        .from("from")
                        .headers(
                            BulkSendParams.Fallback.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .html("html")
                        .replyToOfStrings(listOf("string"))
                        .scheduledAt("scheduledAt")
                        .subject("subject")
                        .addTag(Tag.builder().name("name").value("value").build())
                        .text("text")
                        .toOfStrings(listOf("string"))
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
                    .from("from")
                    .headers(
                        BulkSendParams.Email.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html("html")
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .subject("subject")
                    .addTag(Tag.builder().name("name").value("value").build())
                    .text("text")
                    .toOfStrings(listOf("string"))
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
                    .from("from")
                    .headers(
                        BulkSendParams.Fallback.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html("html")
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .subject("subject")
                    .addTag(Tag.builder().name("name").value("value").build())
                    .text("text")
                    .toOfStrings(listOf("string"))
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
