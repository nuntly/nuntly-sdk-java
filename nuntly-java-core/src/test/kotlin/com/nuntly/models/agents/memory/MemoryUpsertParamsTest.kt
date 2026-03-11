// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.agents.memory

import com.nuntly.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryUpsertParamsTest {

    @Test
    fun create() {
        MemoryUpsertParams.builder()
            .agentId("x")
            .memory(
                MemoryUpsertParams.Memory.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .inboxId("inboxId")
            .summary("summary")
            .threadId("threadId")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MemoryUpsertParams.builder()
                .agentId("x")
                .memory(
                    MemoryUpsertParams.Memory.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("x")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            MemoryUpsertParams.builder()
                .agentId("x")
                .memory(
                    MemoryUpsertParams.Memory.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .inboxId("inboxId")
                .summary("summary")
                .threadId("threadId")
                .build()

        val body = params._body()

        assertThat(body.memory())
            .isEqualTo(
                MemoryUpsertParams.Memory.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.inboxId()).contains("inboxId")
        assertThat(body.summary()).contains("summary")
        assertThat(body.threadId()).contains("threadId")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MemoryUpsertParams.builder()
                .agentId("x")
                .memory(
                    MemoryUpsertParams.Memory.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.memory())
            .isEqualTo(
                MemoryUpsertParams.Memory.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }
}
