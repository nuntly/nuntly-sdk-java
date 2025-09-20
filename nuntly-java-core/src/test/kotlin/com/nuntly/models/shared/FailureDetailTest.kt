// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FailureDetailTest {

    @Test
    fun create() {
        val failureDetail =
            FailureDetail.builder().error(JsonValue.from(mapOf<String, Any>())).build()

        assertThat(failureDetail._error()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val failureDetail =
            FailureDetail.builder().error(JsonValue.from(mapOf<String, Any>())).build()

        val roundtrippedFailureDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(failureDetail),
                jacksonTypeRef<FailureDetail>(),
            )

        assertThat(roundtrippedFailureDetail).isEqualTo(failureDetail)
    }
}
