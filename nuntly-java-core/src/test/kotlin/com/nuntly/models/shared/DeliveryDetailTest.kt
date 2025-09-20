// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DeliveryDetailTest {

    @Test
    fun create() {
        val deliveryDetail =
            DeliveryDetail.builder()
                .deliveredAt("delivered_at")
                .addRecipient("string")
                .remoteMtaIp("remote_mta_ip")
                .reportingMta("reporting_mta")
                .smtpResponse("smtp_response")
                .processingTime(0.0)
                .build()

        assertThat(deliveryDetail.deliveredAt()).isEqualTo("delivered_at")
        assertThat(deliveryDetail.recipients()).containsExactly("string")
        assertThat(deliveryDetail.remoteMtaIp()).isEqualTo("remote_mta_ip")
        assertThat(deliveryDetail.reportingMta()).isEqualTo("reporting_mta")
        assertThat(deliveryDetail.smtpResponse()).isEqualTo("smtp_response")
        assertThat(deliveryDetail.processingTime()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val deliveryDetail =
            DeliveryDetail.builder()
                .deliveredAt("delivered_at")
                .addRecipient("string")
                .remoteMtaIp("remote_mta_ip")
                .reportingMta("reporting_mta")
                .smtpResponse("smtp_response")
                .processingTime(0.0)
                .build()

        val roundtrippedDeliveryDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(deliveryDetail),
                jacksonTypeRef<DeliveryDetail>(),
            )

        assertThat(roundtrippedDeliveryDetail).isEqualTo(deliveryDetail)
    }
}
