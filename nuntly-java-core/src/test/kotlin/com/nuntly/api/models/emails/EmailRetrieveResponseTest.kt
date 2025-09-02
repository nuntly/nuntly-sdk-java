// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.JsonValue
import com.nuntly.api.core.jsonMapper
import com.nuntly.api.models.shared.EmailStatus
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailRetrieveResponseTest {

    @Test
    fun create() {
        val emailRetrieveResponse =
            EmailRetrieveResponse.builder()
                .id("em_01jnvnn9avq52k5mrhn1gab0ch")
                .createdAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                .from("ray@info.tomlinson.ai")
                .kind(EmailRetrieveResponse.Kind.EMAIL)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(EmailRetrieveResponse.Region.EU_WEST_1)
                .status(EmailStatus.QUEUED)
                .statusAt("2025-03-08T20:03:04.155Z")
                .subject("Welcome to Tomlinson AI!")
                .to("carlo43@gmail.com")
                .addAttachment(
                    EmailRetrieveResponse.Attachment.builder()
                        .contentType("content_type")
                        .filename("filename")
                        .build()
                )
                .bccOfStrings(listOf("string"))
                .bulkId("bulk_id")
                .ccOfStrings(listOf("string"))
                .context(JsonValue.from(mapOf<String, Any>()))
                .headers(
                    EmailRetrieveResponse.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .messageId("message_id")
                .modifiedAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                .replyToOfStrings(listOf("string"))
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .statusReason(
                    EmailRetrieveResponse.StatusReason.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addTag(EmailRetrieveResponse.Tag.builder().name("name").value("value").build())
                .build()

        assertThat(emailRetrieveResponse.id()).isEqualTo("em_01jnvnn9avq52k5mrhn1gab0ch")
        assertThat(emailRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
        assertThat(emailRetrieveResponse.from()).isEqualTo("ray@info.tomlinson.ai")
        assertThat(emailRetrieveResponse.kind()).isEqualTo(EmailRetrieveResponse.Kind.EMAIL)
        assertThat(emailRetrieveResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(emailRetrieveResponse.region()).isEqualTo(EmailRetrieveResponse.Region.EU_WEST_1)
        assertThat(emailRetrieveResponse.status()).isEqualTo(EmailStatus.QUEUED)
        assertThat(emailRetrieveResponse.statusAt()).isEqualTo("2025-03-08T20:03:04.155Z")
        assertThat(emailRetrieveResponse.subject()).isEqualTo("Welcome to Tomlinson AI!")
        assertThat(emailRetrieveResponse.to())
            .isEqualTo(EmailRetrieveResponse.To.ofString("carlo43@gmail.com"))
        assertThat(emailRetrieveResponse.attachments().getOrNull())
            .containsExactly(
                EmailRetrieveResponse.Attachment.builder()
                    .contentType("content_type")
                    .filename("filename")
                    .build()
            )
        assertThat(emailRetrieveResponse.bcc())
            .contains(EmailRetrieveResponse.Bcc.ofStrings(listOf("string")))
        assertThat(emailRetrieveResponse.bulkId()).contains("bulk_id")
        assertThat(emailRetrieveResponse.cc())
            .contains(EmailRetrieveResponse.Cc.ofStrings(listOf("string")))
        assertThat(emailRetrieveResponse._context()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(emailRetrieveResponse.headers())
            .contains(
                EmailRetrieveResponse.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(emailRetrieveResponse.messageId()).contains("message_id")
        assertThat(emailRetrieveResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
        assertThat(emailRetrieveResponse.replyTo())
            .contains(EmailRetrieveResponse.ReplyTo.ofStrings(listOf("string")))
        assertThat(emailRetrieveResponse.scheduledAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(emailRetrieveResponse.statusReason())
            .contains(
                EmailRetrieveResponse.StatusReason.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(emailRetrieveResponse.tags().getOrNull())
            .containsExactly(
                EmailRetrieveResponse.Tag.builder().name("name").value("value").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailRetrieveResponse =
            EmailRetrieveResponse.builder()
                .id("em_01jnvnn9avq52k5mrhn1gab0ch")
                .createdAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                .from("ray@info.tomlinson.ai")
                .kind(EmailRetrieveResponse.Kind.EMAIL)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(EmailRetrieveResponse.Region.EU_WEST_1)
                .status(EmailStatus.QUEUED)
                .statusAt("2025-03-08T20:03:04.155Z")
                .subject("Welcome to Tomlinson AI!")
                .to("carlo43@gmail.com")
                .addAttachment(
                    EmailRetrieveResponse.Attachment.builder()
                        .contentType("content_type")
                        .filename("filename")
                        .build()
                )
                .bccOfStrings(listOf("string"))
                .bulkId("bulk_id")
                .ccOfStrings(listOf("string"))
                .context(JsonValue.from(mapOf<String, Any>()))
                .headers(
                    EmailRetrieveResponse.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .messageId("message_id")
                .modifiedAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                .replyToOfStrings(listOf("string"))
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .statusReason(
                    EmailRetrieveResponse.StatusReason.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addTag(EmailRetrieveResponse.Tag.builder().name("name").value("value").build())
                .build()

        val roundtrippedEmailRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailRetrieveResponse),
                jacksonTypeRef<EmailRetrieveResponse>(),
            )

        assertThat(roundtrippedEmailRetrieveResponse).isEqualTo(emailRetrieveResponse)
    }
}
