// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.agents

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.core.JsonValue
import com.nuntly.models.agents.memory.MemoryRetrieveParams
import com.nuntly.models.agents.memory.MemoryUpsertParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MemoryServiceTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val memoryService = client.agents().memory()

        val agentMemory =
            memoryService.retrieve(
                MemoryRetrieveParams.builder()
                    .agentId("x")
                    .inboxId("inboxId")
                    .threadId("threadId")
                    .build()
            )

        agentMemory.validate()
    }

    @Test
    fun upsert() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val memoryService = client.agents().memory()

        val agentMemory =
            memoryService.upsert(
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
            )

        agentMemory.validate()
    }
}
