// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentMemoryTest {

    @Test
    fun create() {
        val agentMemory =
            AgentMemory.builder()
                .id("id")
                .agentId("agentId")
                .createdAt("createdAt")
                .inboxId("inboxId")
                .memory(
                    AgentMemory.Memory.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .summary("summary")
                .threadId("threadId")
                .updatedAt("updatedAt")
                .build()

        assertThat(agentMemory.id()).isEqualTo("id")
        assertThat(agentMemory.agentId()).isEqualTo("agentId")
        assertThat(agentMemory.createdAt()).isEqualTo("createdAt")
        assertThat(agentMemory.inboxId()).contains("inboxId")
        assertThat(agentMemory.memory())
            .isEqualTo(
                AgentMemory.Memory.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(agentMemory.summary()).contains("summary")
        assertThat(agentMemory.threadId()).contains("threadId")
        assertThat(agentMemory.updatedAt()).contains("updatedAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentMemory =
            AgentMemory.builder()
                .id("id")
                .agentId("agentId")
                .createdAt("createdAt")
                .inboxId("inboxId")
                .memory(
                    AgentMemory.Memory.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .summary("summary")
                .threadId("threadId")
                .updatedAt("updatedAt")
                .build()

        val roundtrippedAgentMemory =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentMemory),
                jacksonTypeRef<AgentMemory>(),
            )

        assertThat(roundtrippedAgentMemory).isEqualTo(agentMemory)
    }
}
