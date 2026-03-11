// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.core.ClientOptions
import com.nuntly.services.async.agents.MemoryServiceAsync
import com.nuntly.services.async.agents.MemoryServiceAsyncImpl
import java.util.function.Consumer

class AgentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AgentServiceAsync {

    private val withRawResponse: AgentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val memory: MemoryServiceAsync by lazy { MemoryServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): AgentServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AgentServiceAsync =
        AgentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Read and write persistent state for an AI agent, optionally scoped to a specific inbox or
     * thread.
     */
    override fun memory(): MemoryServiceAsync = memory

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AgentServiceAsync.WithRawResponse {

        private val memory: MemoryServiceAsync.WithRawResponse by lazy {
            MemoryServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AgentServiceAsync.WithRawResponse =
            AgentServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Read and write persistent state for an AI agent, optionally scoped to a specific inbox or
         * thread.
         */
        override fun memory(): MemoryServiceAsync.WithRawResponse = memory
    }
}
