// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailRetrieveResponseTest {

    @Test
    fun create() {
        val emailRetrieveResponse =
            EmailRetrieveResponse.builder()
                .id("em_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .from("Tomlinson AI <ray@info.tomlinson.ai>")
                .orgId("orgId")
                .status(Status.QUEUED)
                .subject("Verify your email address")
                .to("brian67@gmail.com")
                .addAttachment(
                    EmailRetrieveResponse.Attachment.builder()
                        .contentType("application/pdf")
                        .filename("invoice.pdf")
                        .size(12345.0)
                        .build()
                )
                .bccOfStrings(listOf("string"))
                .bulkId("bulkId")
                .ccOfStrings(listOf("string"))
                .context(
                    EmailRetrieveResponse.Context.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .headers(
                    EmailRetrieveResponse.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .messageId("messageId")
                .replyToOfStrings(listOf("string"))
                .scheduledAt("scheduledAt")
                .statusReason(
                    EmailRetrieveResponse.StatusReason.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addTag(Tag.builder().name("category").value("transactional").build())
                .build()

        assertThat(emailRetrieveResponse.id()).isEqualTo("em_01ka8k8s80gvx9604cn9am5st4")
        assertThat(emailRetrieveResponse.createdAt()).isEqualTo("createdAt")
        assertThat(emailRetrieveResponse.from()).isEqualTo("Tomlinson AI <ray@info.tomlinson.ai>")
        assertThat(emailRetrieveResponse.orgId()).isEqualTo("orgId")
        assertThat(emailRetrieveResponse.status()).isEqualTo(Status.QUEUED)
        assertThat(emailRetrieveResponse.subject()).isEqualTo("Verify your email address")
        assertThat(emailRetrieveResponse.to())
            .isEqualTo(EmailRetrieveResponse.To.ofString("brian67@gmail.com"))
        assertThat(emailRetrieveResponse.attachments().getOrNull())
            .containsExactly(
                EmailRetrieveResponse.Attachment.builder()
                    .contentType("application/pdf")
                    .filename("invoice.pdf")
                    .size(12345.0)
                    .build()
            )
        assertThat(emailRetrieveResponse.bcc())
            .contains(EmailRetrieveResponse.Bcc.ofStrings(listOf("string")))
        assertThat(emailRetrieveResponse.bulkId()).contains("bulkId")
        assertThat(emailRetrieveResponse.cc())
            .contains(EmailRetrieveResponse.Cc.ofStrings(listOf("string")))
        assertThat(emailRetrieveResponse.context())
            .contains(
                EmailRetrieveResponse.Context.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(emailRetrieveResponse.headers())
            .contains(
                EmailRetrieveResponse.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(emailRetrieveResponse.messageId()).contains("messageId")
        assertThat(emailRetrieveResponse.replyTo())
            .contains(EmailRetrieveResponse.ReplyTo.ofStrings(listOf("string")))
        assertThat(emailRetrieveResponse.scheduledAt()).contains("scheduledAt")
        assertThat(emailRetrieveResponse.statusReason())
            .contains(
                EmailRetrieveResponse.StatusReason.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(emailRetrieveResponse.tags().getOrNull())
            .containsExactly(Tag.builder().name("category").value("transactional").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailRetrieveResponse =
            EmailRetrieveResponse.builder()
                .id("em_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .from("Tomlinson AI <ray@info.tomlinson.ai>")
                .orgId("orgId")
                .status(Status.QUEUED)
                .subject("Verify your email address")
                .to("brian67@gmail.com")
                .addAttachment(
                    EmailRetrieveResponse.Attachment.builder()
                        .contentType("application/pdf")
                        .filename("invoice.pdf")
                        .size(12345.0)
                        .build()
                )
                .bccOfStrings(listOf("string"))
                .bulkId("bulkId")
                .ccOfStrings(listOf("string"))
                .context(
                    EmailRetrieveResponse.Context.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .headers(
                    EmailRetrieveResponse.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .messageId("messageId")
                .replyToOfStrings(listOf("string"))
                .scheduledAt("scheduledAt")
                .statusReason(
                    EmailRetrieveResponse.StatusReason.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addTag(Tag.builder().name("category").value("transactional").build())
                .build()

        val roundtrippedEmailRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailRetrieveResponse),
                jacksonTypeRef<EmailRetrieveResponse>(),
            )

        assertThat(roundtrippedEmailRetrieveResponse).isEqualTo(emailRetrieveResponse)
    }
}
