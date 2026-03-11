// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.agents

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.agents.AgentMemory
import com.nuntly.models.agents.memory.MemoryRetrieveParams
import com.nuntly.models.agents.memory.MemoryUpsertParams
import java.util.function.Consumer

/**
 * Read and write persistent state for an AI agent, optionally scoped to a specific inbox or thread.
 */
interface MemoryService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MemoryService

    /** Retrieve the memory for an AI agent. */
    fun retrieve(agentId: String): AgentMemory = retrieve(agentId, MemoryRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        agentId: String,
        params: MemoryRetrieveParams = MemoryRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentMemory = retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        agentId: String,
        params: MemoryRetrieveParams = MemoryRetrieveParams.none(),
    ): AgentMemory = retrieve(agentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MemoryRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentMemory

    /** @see retrieve */
    fun retrieve(params: MemoryRetrieveParams): AgentMemory =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(agentId: String, requestOptions: RequestOptions): AgentMemory =
        retrieve(agentId, MemoryRetrieveParams.none(), requestOptions)

    /** Create or update the memory for an AI agent. */
    fun upsert(agentId: String, params: MemoryUpsertParams): AgentMemory =
        upsert(agentId, params, RequestOptions.none())

    /** @see upsert */
    fun upsert(
        agentId: String,
        params: MemoryUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentMemory = upsert(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see upsert */
    fun upsert(params: MemoryUpsertParams): AgentMemory = upsert(params, RequestOptions.none())

    /** @see upsert */
    fun upsert(
        params: MemoryUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentMemory

    /** A view of [MemoryService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MemoryService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /agents/{agentId}/memory`, but is otherwise the same
         * as [MemoryService.retrieve].
         */
        @MustBeClosed
        fun retrieve(agentId: String): HttpResponseFor<AgentMemory> =
            retrieve(agentId, MemoryRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            agentId: String,
            params: MemoryRetrieveParams = MemoryRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentMemory> =
            retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            agentId: String,
            params: MemoryRetrieveParams = MemoryRetrieveParams.none(),
        ): HttpResponseFor<AgentMemory> = retrieve(agentId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: MemoryRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentMemory>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: MemoryRetrieveParams): HttpResponseFor<AgentMemory> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            agentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentMemory> =
            retrieve(agentId, MemoryRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /agents/{agentId}/memory`, but is otherwise the same
         * as [MemoryService.upsert].
         */
        @MustBeClosed
        fun upsert(agentId: String, params: MemoryUpsertParams): HttpResponseFor<AgentMemory> =
            upsert(agentId, params, RequestOptions.none())

        /** @see upsert */
        @MustBeClosed
        fun upsert(
            agentId: String,
            params: MemoryUpsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentMemory> =
            upsert(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see upsert */
        @MustBeClosed
        fun upsert(params: MemoryUpsertParams): HttpResponseFor<AgentMemory> =
            upsert(params, RequestOptions.none())

        /** @see upsert */
        @MustBeClosed
        fun upsert(
            params: MemoryUpsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentMemory>
    }
}
