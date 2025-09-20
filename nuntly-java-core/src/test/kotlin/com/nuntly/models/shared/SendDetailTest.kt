// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SendDetailTest {

    @Test
    fun create() {
        val sendDetail = SendDetail.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sendDetail = SendDetail.builder().build()

        val roundtrippedSendDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sendDetail),
                jacksonTypeRef<SendDetail>(),
            )

        assertThat(roundtrippedSendDetail).isEqualTo(sendDetail)
    }
}
