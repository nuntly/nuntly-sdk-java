// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DeliveryDelayDetailTest {

    @Test
    fun create() {
        val deliveryDelayDetail =
            DeliveryDelayDetail.builder()
                .delayType("delay_type")
                .delayedAt("delayed_at")
                .addDelayedRecipient(
                    DeliveryDelayDetail.DelayedRecipient.builder()
                        .email("email")
                        .diagnosticCode("diagnostic_code")
                        .status("status")
                        .build()
                )
                .deliveryStoppedAt("delivery_stopped_at")
                .reportingMta("reporting_mta")
                .build()

        assertThat(deliveryDelayDetail.delayType()).isEqualTo("delay_type")
        assertThat(deliveryDelayDetail.delayedAt()).isEqualTo("delayed_at")
        assertThat(deliveryDelayDetail.delayedRecipients())
            .containsExactly(
                DeliveryDelayDetail.DelayedRecipient.builder()
                    .email("email")
                    .diagnosticCode("diagnostic_code")
                    .status("status")
                    .build()
            )
        assertThat(deliveryDelayDetail.deliveryStoppedAt()).isEqualTo("delivery_stopped_at")
        assertThat(deliveryDelayDetail.reportingMta()).isEqualTo("reporting_mta")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val deliveryDelayDetail =
            DeliveryDelayDetail.builder()
                .delayType("delay_type")
                .delayedAt("delayed_at")
                .addDelayedRecipient(
                    DeliveryDelayDetail.DelayedRecipient.builder()
                        .email("email")
                        .diagnosticCode("diagnostic_code")
                        .status("status")
                        .build()
                )
                .deliveryStoppedAt("delivery_stopped_at")
                .reportingMta("reporting_mta")
                .build()

        val roundtrippedDeliveryDelayDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(deliveryDelayDetail),
                jacksonTypeRef<DeliveryDelayDetail>(),
            )

        assertThat(roundtrippedDeliveryDelayDetail).isEqualTo(deliveryDelayDetail)
    }
}
