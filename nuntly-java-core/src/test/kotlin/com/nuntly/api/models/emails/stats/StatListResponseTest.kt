// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails.stats

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StatListResponseTest {

    @Test
    fun create() {
        val statListResponse =
            StatListResponse.builder()
                .end(LocalDate.parse("2025-01-23"))
                .start(LocalDate.parse("2025-01-20"))
                .stats(
                    listOf(
                        StatListResponse.Stat.builder()
                            .occurredOn(LocalDate.parse("2025-01-20"))
                            .bounced(0.0)
                            .clicked(0.0)
                            .complaintReceived(0.0)
                            .delivered(9625.0)
                            .deliveryDelayed(0.0)
                            .opened(5403.0)
                            .rejected(0.0)
                            .renderingFailed(0.0)
                            .sent(9625.0)
                            .subscribed(0.0)
                            .build(),
                        StatListResponse.Stat.builder()
                            .occurredOn(LocalDate.parse("2025-01-21"))
                            .bounced(0.0)
                            .clicked(0.0)
                            .complaintReceived(0.0)
                            .delivered(8404.0)
                            .deliveryDelayed(0.0)
                            .opened(3503.0)
                            .rejected(0.0)
                            .renderingFailed(0.0)
                            .sent(8404.0)
                            .subscribed(0.0)
                            .build(),
                        StatListResponse.Stat.builder()
                            .occurredOn(LocalDate.parse("2025-01-22"))
                            .bounced(0.0)
                            .clicked(0.0)
                            .complaintReceived(0.0)
                            .delivered(9254.0)
                            .deliveryDelayed(0.0)
                            .opened(4253.0)
                            .rejected(0.0)
                            .renderingFailed(0.0)
                            .sent(9254.0)
                            .subscribed(0.0)
                            .build(),
                        StatListResponse.Stat.builder()
                            .occurredOn(LocalDate.parse("2025-01-23"))
                            .bounced(0.0)
                            .clicked(4211.0)
                            .complaintReceived(0.0)
                            .delivered(9783.0)
                            .deliveryDelayed(0.0)
                            .opened(5919.0)
                            .rejected(0.0)
                            .renderingFailed(0.0)
                            .sent(9783.0)
                            .subscribed(0.0)
                            .build(),
                    )
                )
                .build()

        assertThat(statListResponse.end()).isEqualTo(LocalDate.parse("2025-01-23"))
        assertThat(statListResponse.start()).isEqualTo(LocalDate.parse("2025-01-20"))
        assertThat(statListResponse.stats())
            .containsExactly(
                StatListResponse.Stat.builder()
                    .occurredOn(LocalDate.parse("2025-01-20"))
                    .bounced(0.0)
                    .clicked(0.0)
                    .complaintReceived(0.0)
                    .delivered(9625.0)
                    .deliveryDelayed(0.0)
                    .opened(5403.0)
                    .rejected(0.0)
                    .renderingFailed(0.0)
                    .sent(9625.0)
                    .subscribed(0.0)
                    .build(),
                StatListResponse.Stat.builder()
                    .occurredOn(LocalDate.parse("2025-01-21"))
                    .bounced(0.0)
                    .clicked(0.0)
                    .complaintReceived(0.0)
                    .delivered(8404.0)
                    .deliveryDelayed(0.0)
                    .opened(3503.0)
                    .rejected(0.0)
                    .renderingFailed(0.0)
                    .sent(8404.0)
                    .subscribed(0.0)
                    .build(),
                StatListResponse.Stat.builder()
                    .occurredOn(LocalDate.parse("2025-01-22"))
                    .bounced(0.0)
                    .clicked(0.0)
                    .complaintReceived(0.0)
                    .delivered(9254.0)
                    .deliveryDelayed(0.0)
                    .opened(4253.0)
                    .rejected(0.0)
                    .renderingFailed(0.0)
                    .sent(9254.0)
                    .subscribed(0.0)
                    .build(),
                StatListResponse.Stat.builder()
                    .occurredOn(LocalDate.parse("2025-01-23"))
                    .bounced(0.0)
                    .clicked(4211.0)
                    .complaintReceived(0.0)
                    .delivered(9783.0)
                    .deliveryDelayed(0.0)
                    .opened(5919.0)
                    .rejected(0.0)
                    .renderingFailed(0.0)
                    .sent(9783.0)
                    .subscribed(0.0)
                    .build(),
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val statListResponse =
            StatListResponse.builder()
                .end(LocalDate.parse("2025-01-23"))
                .start(LocalDate.parse("2025-01-20"))
                .stats(
                    listOf(
                        StatListResponse.Stat.builder()
                            .occurredOn(LocalDate.parse("2025-01-20"))
                            .bounced(0.0)
                            .clicked(0.0)
                            .complaintReceived(0.0)
                            .delivered(9625.0)
                            .deliveryDelayed(0.0)
                            .opened(5403.0)
                            .rejected(0.0)
                            .renderingFailed(0.0)
                            .sent(9625.0)
                            .subscribed(0.0)
                            .build(),
                        StatListResponse.Stat.builder()
                            .occurredOn(LocalDate.parse("2025-01-21"))
                            .bounced(0.0)
                            .clicked(0.0)
                            .complaintReceived(0.0)
                            .delivered(8404.0)
                            .deliveryDelayed(0.0)
                            .opened(3503.0)
                            .rejected(0.0)
                            .renderingFailed(0.0)
                            .sent(8404.0)
                            .subscribed(0.0)
                            .build(),
                        StatListResponse.Stat.builder()
                            .occurredOn(LocalDate.parse("2025-01-22"))
                            .bounced(0.0)
                            .clicked(0.0)
                            .complaintReceived(0.0)
                            .delivered(9254.0)
                            .deliveryDelayed(0.0)
                            .opened(4253.0)
                            .rejected(0.0)
                            .renderingFailed(0.0)
                            .sent(9254.0)
                            .subscribed(0.0)
                            .build(),
                        StatListResponse.Stat.builder()
                            .occurredOn(LocalDate.parse("2025-01-23"))
                            .bounced(0.0)
                            .clicked(4211.0)
                            .complaintReceived(0.0)
                            .delivered(9783.0)
                            .deliveryDelayed(0.0)
                            .opened(5919.0)
                            .rejected(0.0)
                            .renderingFailed(0.0)
                            .sent(9783.0)
                            .subscribed(0.0)
                            .build(),
                    )
                )
                .build()

        val roundtrippedStatListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(statListResponse),
                jacksonTypeRef<StatListResponse>(),
            )

        assertThat(roundtrippedStatListResponse).isEqualTo(statListResponse)
    }
}
