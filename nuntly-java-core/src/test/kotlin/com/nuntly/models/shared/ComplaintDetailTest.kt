// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComplaintDetailTest {

    @Test
    fun create() {
        val complaintDetail =
            ComplaintDetail.builder()
                .complainedAt("complained_at")
                .feedbackId("feedback_id")
                .addComplainedRecipient(
                    ComplaintDetail.ComplainedRecipient.builder().email("email").build()
                )
                .complaintFeedbackType("complaint_feedback_type")
                .complaintSubtype("complaint_subtype")
                .receivedAt("received_at")
                .userAgent("user_agent")
                .build()

        assertThat(complaintDetail.complainedAt()).isEqualTo("complained_at")
        assertThat(complaintDetail.feedbackId()).isEqualTo("feedback_id")
        assertThat(complaintDetail.complainedRecipients().getOrNull())
            .containsExactly(ComplaintDetail.ComplainedRecipient.builder().email("email").build())
        assertThat(complaintDetail.complaintFeedbackType()).contains("complaint_feedback_type")
        assertThat(complaintDetail.complaintSubtype()).contains("complaint_subtype")
        assertThat(complaintDetail.receivedAt()).contains("received_at")
        assertThat(complaintDetail.userAgent()).contains("user_agent")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val complaintDetail =
            ComplaintDetail.builder()
                .complainedAt("complained_at")
                .feedbackId("feedback_id")
                .addComplainedRecipient(
                    ComplaintDetail.ComplainedRecipient.builder().email("email").build()
                )
                .complaintFeedbackType("complaint_feedback_type")
                .complaintSubtype("complaint_subtype")
                .receivedAt("received_at")
                .userAgent("user_agent")
                .build()

        val roundtrippedComplaintDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(complaintDetail),
                jacksonTypeRef<ComplaintDetail>(),
            )

        assertThat(roundtrippedComplaintDetail).isEqualTo(complaintDetail)
    }
}
