// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.agents

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.core.JsonValue
import com.nuntly.models.agents.memory.MemoryRetrieveParams
import com.nuntly.models.agents.memory.MemoryUpsertParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MemoryServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val memoryServiceAsync = client.agents().memory()

        val agentMemoryFuture =
            memoryServiceAsync.retrieve(
                MemoryRetrieveParams.builder()
                    .agentId("x")
                    .inboxId("inboxId")
                    .threadId("threadId")
                    .build()
            )

        val agentMemory = agentMemoryFuture.get()
        agentMemory.validate()
    }

    @Test
    fun upsert() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val memoryServiceAsync = client.agents().memory()

        val agentMemoryFuture =
            memoryServiceAsync.upsert(
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

        val agentMemory = agentMemoryFuture.get()
        agentMemory.validate()
    }
}
