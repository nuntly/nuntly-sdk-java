// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.core.ClientOptions
import com.nuntly.services.blocking.agents.MemoryService
import com.nuntly.services.blocking.agents.MemoryServiceImpl
import java.util.function.Consumer

class AgentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AgentService {

    private val withRawResponse: AgentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val memory: MemoryService by lazy { MemoryServiceImpl(clientOptions) }

    override fun withRawResponse(): AgentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AgentService =
        AgentServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Read and write persistent state for an AI agent, optionally scoped to a specific inbox or
     * thread.
     */
    override fun memory(): MemoryService = memory

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AgentService.WithRawResponse {

        private val memory: MemoryService.WithRawResponse by lazy {
            MemoryServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AgentService.WithRawResponse =
            AgentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Read and write persistent state for an AI agent, optionally scoped to a specific inbox or
         * thread.
         */
        override fun memory(): MemoryService.WithRawResponse = memory
    }
}
