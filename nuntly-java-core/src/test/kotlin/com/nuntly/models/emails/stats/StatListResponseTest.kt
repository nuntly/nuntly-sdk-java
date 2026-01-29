// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.stats

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StatListResponseTest {

    @Test
    fun create() {
        val statListResponse =
            StatListResponse.builder()
                .end(LocalDate.parse("2019-12-27"))
                .start(LocalDate.parse("2019-12-27"))
                .addStat(
                    StatListResponse.Stat.builder()
                        .bounced(0.0)
                        .canceled(0.0)
                        .clicked(0.0)
                        .complaintReceived(0.0)
                        .delivered(0.0)
                        .deliveredDelayed(0.0)
                        .failed(0.0)
                        .occurredOn(LocalDate.parse("2019-12-27"))
                        .opened(0.0)
                        .processed(0.0)
                        .queued(0.0)
                        .rejected(0.0)
                        .renderingFailed(0.0)
                        .scheduled(0.0)
                        .sending(0.0)
                        .sent(0.0)
                        .build()
                )
                .build()

        assertThat(statListResponse.end()).isEqualTo(LocalDate.parse("2019-12-27"))
        assertThat(statListResponse.start()).isEqualTo(LocalDate.parse("2019-12-27"))
        assertThat(statListResponse.stats())
            .containsExactly(
                StatListResponse.Stat.builder()
                    .bounced(0.0)
                    .canceled(0.0)
                    .clicked(0.0)
                    .complaintReceived(0.0)
                    .delivered(0.0)
                    .deliveredDelayed(0.0)
                    .failed(0.0)
                    .occurredOn(LocalDate.parse("2019-12-27"))
                    .opened(0.0)
                    .processed(0.0)
                    .queued(0.0)
                    .rejected(0.0)
                    .renderingFailed(0.0)
                    .scheduled(0.0)
                    .sending(0.0)
                    .sent(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val statListResponse =
            StatListResponse.builder()
                .end(LocalDate.parse("2019-12-27"))
                .start(LocalDate.parse("2019-12-27"))
                .addStat(
                    StatListResponse.Stat.builder()
                        .bounced(0.0)
                        .canceled(0.0)
                        .clicked(0.0)
                        .complaintReceived(0.0)
                        .delivered(0.0)
                        .deliveredDelayed(0.0)
                        .failed(0.0)
                        .occurredOn(LocalDate.parse("2019-12-27"))
                        .opened(0.0)
                        .processed(0.0)
                        .queued(0.0)
                        .rejected(0.0)
                        .renderingFailed(0.0)
                        .scheduled(0.0)
                        .sending(0.0)
                        .sent(0.0)
                        .build()
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
