// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailFailedEventTest {

    @Test
    fun create() {
        val emailFailedEvent =
            EmailFailedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailFailedEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .failure(
                            EmailFailedEvent.Data.Failure.builder()
                                .error(JsonValue.from(mapOf<String, Any>()))
                                .build()
                        )
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailFailedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailFailedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(emailFailedEvent.id()).isEqualTo("id")
        assertThat(emailFailedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailFailedEvent.data())
            .isEqualTo(
                EmailFailedEvent.Data.builder()
                    .id("id")
                    .domainId("domainId")
                    .domainName("domainName")
                    .enqueuedAt("enqueuedAt")
                    .failure(
                        EmailFailedEvent.Data.Failure.builder()
                            .error(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                    .from("from")
                    .messageId("messageId")
                    .orgId("orgId")
                    .sentAt("sentAt")
                    .subject("subject")
                    .to("string")
                    .bcc("string")
                    .bulkId("bulkId")
                    .cc("string")
                    .addHeader(
                        EmailFailedEvent.Data.Header.builder().name("name").value("value").build()
                    )
                    .replyTo("string")
                    .tags(
                        EmailFailedEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailFailedEvent =
            EmailFailedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailFailedEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .failure(
                            EmailFailedEvent.Data.Failure.builder()
                                .error(JsonValue.from(mapOf<String, Any>()))
                                .build()
                        )
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailFailedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailFailedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedEmailFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailFailedEvent),
                jacksonTypeRef<EmailFailedEvent>(),
            )

        assertThat(roundtrippedEmailFailedEvent).isEqualTo(emailFailedEvent)
    }
}
