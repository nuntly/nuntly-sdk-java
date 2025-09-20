// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailEventTest {

    @Test
    fun create() {
        val emailEvent =
            EmailEvent.builder()
                .id("id")
                .domain("domain")
                .domainId("domain_id")
                .enqueueAt("enqueue_at")
                .from("from")
                .messageId("message_id")
                .orgId("org_id")
                .sentAt("sent_at")
                .subject("subject")
                .to("string")
                .bcc("string")
                .bulkId("bulk_id")
                .cc("string")
                .addHeader(EmailEvent.Header.builder().name("name").value("value").build())
                .replyTo("string")
                .tags(
                    EmailEvent.Tags.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .build()

        assertThat(emailEvent.id()).isEqualTo("id")
        assertThat(emailEvent.domain()).isEqualTo("domain")
        assertThat(emailEvent.domainId()).isEqualTo("domain_id")
        assertThat(emailEvent.enqueueAt()).isEqualTo("enqueue_at")
        assertThat(emailEvent.from()).isEqualTo("from")
        assertThat(emailEvent.messageId()).isEqualTo("message_id")
        assertThat(emailEvent.orgId()).isEqualTo("org_id")
        assertThat(emailEvent.sentAt()).isEqualTo("sent_at")
        assertThat(emailEvent.subject()).isEqualTo("subject")
        assertThat(emailEvent.to()).isEqualTo(EmailEvent.To.ofString("string"))
        assertThat(emailEvent.bcc()).contains(EmailEvent.Bcc.ofString("string"))
        assertThat(emailEvent.bulkId()).contains("bulk_id")
        assertThat(emailEvent.cc()).contains(EmailEvent.Cc.ofString("string"))
        assertThat(emailEvent.headers().getOrNull())
            .containsExactly(EmailEvent.Header.builder().name("name").value("value").build())
        assertThat(emailEvent.replyTo()).contains(EmailEvent.ReplyTo.ofString("string"))
        assertThat(emailEvent.tags())
            .contains(
                EmailEvent.Tags.builder()
                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailEvent =
            EmailEvent.builder()
                .id("id")
                .domain("domain")
                .domainId("domain_id")
                .enqueueAt("enqueue_at")
                .from("from")
                .messageId("message_id")
                .orgId("org_id")
                .sentAt("sent_at")
                .subject("subject")
                .to("string")
                .bcc("string")
                .bulkId("bulk_id")
                .cc("string")
                .addHeader(EmailEvent.Header.builder().name("name").value("value").build())
                .replyTo("string")
                .tags(
                    EmailEvent.Tags.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .build()

        val roundtrippedEmailEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailEvent),
                jacksonTypeRef<EmailEvent>(),
            )

        assertThat(roundtrippedEmailEvent).isEqualTo(emailEvent)
    }
}
