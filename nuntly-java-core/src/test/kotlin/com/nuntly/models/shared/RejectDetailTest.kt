// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RejectDetailTest {

    @Test
    fun create() {
        val rejectDetail = RejectDetail.builder().reason("reason").build()

        assertThat(rejectDetail.reason()).isEqualTo("reason")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rejectDetail = RejectDetail.builder().reason("reason").build()

        val roundtrippedRejectDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rejectDetail),
                jacksonTypeRef<RejectDetail>(),
            )

        assertThat(roundtrippedRejectDetail).isEqualTo(rejectDetail)
    }
}
