// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadUpdateResponseTest {

    @Test
    fun create() {
        val threadUpdateResponse = ThreadUpdateResponse.builder().id("id").build()

        assertThat(threadUpdateResponse.id()).isEqualTo("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val threadUpdateResponse = ThreadUpdateResponse.builder().id("id").build()

        val roundtrippedThreadUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(threadUpdateResponse),
                jacksonTypeRef<ThreadUpdateResponse>(),
            )

        assertThat(roundtrippedThreadUpdateResponse).isEqualTo(threadUpdateResponse)
    }
}
