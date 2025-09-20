// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BounceDetailTest {

    @Test
    fun create() {
        val bounceDetail =
            BounceDetail.builder()
                .bounceSubtype("bounce_subtype")
                .bounceType("bounce_type")
                .bouncedAt("bounced_at")
                .addBouncedRecipient(
                    BounceDetail.BouncedRecipient.builder()
                        .email("email")
                        .action("action")
                        .diagnosticCode("diagnostic_code")
                        .status("status")
                        .build()
                )
                .feedbackId("feedback_id")
                .reportingMta("reporting_mta")
                .build()

        assertThat(bounceDetail.bounceSubtype()).isEqualTo("bounce_subtype")
        assertThat(bounceDetail.bounceType()).isEqualTo("bounce_type")
        assertThat(bounceDetail.bouncedAt()).isEqualTo("bounced_at")
        assertThat(bounceDetail.bouncedRecipients())
            .containsExactly(
                BounceDetail.BouncedRecipient.builder()
                    .email("email")
                    .action("action")
                    .diagnosticCode("diagnostic_code")
                    .status("status")
                    .build()
            )
        assertThat(bounceDetail.feedbackId()).isEqualTo("feedback_id")
        assertThat(bounceDetail.reportingMta()).contains("reporting_mta")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bounceDetail =
            BounceDetail.builder()
                .bounceSubtype("bounce_subtype")
                .bounceType("bounce_type")
                .bouncedAt("bounced_at")
                .addBouncedRecipient(
                    BounceDetail.BouncedRecipient.builder()
                        .email("email")
                        .action("action")
                        .diagnosticCode("diagnostic_code")
                        .status("status")
                        .build()
                )
                .feedbackId("feedback_id")
                .reportingMta("reporting_mta")
                .build()

        val roundtrippedBounceDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bounceDetail),
                jacksonTypeRef<BounceDetail>(),
            )

        assertThat(roundtrippedBounceDetail).isEqualTo(bounceDetail)
    }
}
