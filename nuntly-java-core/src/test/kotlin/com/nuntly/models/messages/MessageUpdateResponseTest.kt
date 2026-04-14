// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageUpdateResponseTest {

    @Test
    fun create() {
        val messageUpdateResponse = MessageUpdateResponse.builder().id("id").build()

        assertThat(messageUpdateResponse.id()).isEqualTo("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageUpdateResponse = MessageUpdateResponse.builder().id("id").build()

        val roundtrippedMessageUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageUpdateResponse),
                jacksonTypeRef<MessageUpdateResponse>(),
            )

        assertThat(roundtrippedMessageUpdateResponse).isEqualTo(messageUpdateResponse)
    }
}
