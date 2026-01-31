// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailScheduledEventTest {

    @Test
    fun create() {
        val emailScheduledEvent =
            EmailScheduledEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailScheduledEvent.Data.builder()
                        .schedule(
                            EmailScheduledEvent.Data.Schedule.builder()
                                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .build()
                )
                .type(EmailScheduledEvent.Type.EMAIL_SCHEDULED)
                .build()

        assertThat(emailScheduledEvent.id()).isEqualTo("id")
        assertThat(emailScheduledEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailScheduledEvent.data())
            .isEqualTo(
                EmailScheduledEvent.Data.builder()
                    .schedule(
                        EmailScheduledEvent.Data.Schedule.builder()
                            .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .build()
            )
        assertThat(emailScheduledEvent.type()).isEqualTo(EmailScheduledEvent.Type.EMAIL_SCHEDULED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailScheduledEvent =
            EmailScheduledEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailScheduledEvent.Data.builder()
                        .schedule(
                            EmailScheduledEvent.Data.Schedule.builder()
                                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .build()
                )
                .type(EmailScheduledEvent.Type.EMAIL_SCHEDULED)
                .build()

        val roundtrippedEmailScheduledEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailScheduledEvent),
                jacksonTypeRef<EmailScheduledEvent>(),
            )

        assertThat(roundtrippedEmailScheduledEvent).isEqualTo(emailScheduledEvent)
    }
}
