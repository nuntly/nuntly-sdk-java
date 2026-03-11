// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.core.ClientOptions
import com.nuntly.services.blocking.agents.MemoryService
import java.util.function.Consumer

interface AgentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AgentService

    /**
     * Read and write persistent state for an AI agent, optionally scoped to a specific inbox or
     * thread.
     */
    fun memory(): MemoryService

    /** A view of [AgentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AgentService.WithRawResponse

        /**
         * Read and write persistent state for an AI agent, optionally scoped to a specific inbox or
         * thread.
         */
        fun memory(): MemoryService.WithRawResponse
    }
}
