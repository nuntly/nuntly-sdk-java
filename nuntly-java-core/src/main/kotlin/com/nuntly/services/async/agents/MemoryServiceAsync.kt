// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.agents

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.agents.AgentMemory
import com.nuntly.models.agents.memory.MemoryRetrieveParams
import com.nuntly.models.agents.memory.MemoryUpsertParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Read and write persistent state for an AI agent, optionally scoped to a specific inbox or thread.
 */
interface MemoryServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MemoryServiceAsync

    /** Retrieve the memory for an AI agent. */
    fun retrieve(agentId: String): CompletableFuture<AgentMemory> =
        retrieve(agentId, MemoryRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        agentId: String,
        params: MemoryRetrieveParams = MemoryRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentMemory> =
        retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        agentId: String,
        params: MemoryRetrieveParams = MemoryRetrieveParams.none(),
    ): CompletableFuture<AgentMemory> = retrieve(agentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MemoryRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentMemory>

    /** @see retrieve */
    fun retrieve(params: MemoryRetrieveParams): CompletableFuture<AgentMemory> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(agentId: String, requestOptions: RequestOptions): CompletableFuture<AgentMemory> =
        retrieve(agentId, MemoryRetrieveParams.none(), requestOptions)

    /** Create or update the memory for an AI agent. */
    fun upsert(agentId: String, params: MemoryUpsertParams): CompletableFuture<AgentMemory> =
        upsert(agentId, params, RequestOptions.none())

    /** @see upsert */
    fun upsert(
        agentId: String,
        params: MemoryUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentMemory> =
        upsert(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see upsert */
    fun upsert(params: MemoryUpsertParams): CompletableFuture<AgentMemory> =
        upsert(params, RequestOptions.none())

    /** @see upsert */
    fun upsert(
        params: MemoryUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentMemory>

    /**
     * A view of [MemoryServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MemoryServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /agents/{agentId}/memory`, but is otherwise the same
         * as [MemoryServiceAsync.retrieve].
         */
        fun retrieve(agentId: String): CompletableFuture<HttpResponseFor<AgentMemory>> =
            retrieve(agentId, MemoryRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            agentId: String,
            params: MemoryRetrieveParams = MemoryRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentMemory>> =
            retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            agentId: String,
            params: MemoryRetrieveParams = MemoryRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<AgentMemory>> =
            retrieve(agentId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: MemoryRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentMemory>>

        /** @see retrieve */
        fun retrieve(
            params: MemoryRetrieveParams
        ): CompletableFuture<HttpResponseFor<AgentMemory>> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            agentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AgentMemory>> =
            retrieve(agentId, MemoryRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /agents/{agentId}/memory`, but is otherwise the same
         * as [MemoryServiceAsync.upsert].
         */
        fun upsert(
            agentId: String,
            params: MemoryUpsertParams,
        ): CompletableFuture<HttpResponseFor<AgentMemory>> =
            upsert(agentId, params, RequestOptions.none())

        /** @see upsert */
        fun upsert(
            agentId: String,
            params: MemoryUpsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentMemory>> =
            upsert(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see upsert */
        fun upsert(params: MemoryUpsertParams): CompletableFuture<HttpResponseFor<AgentMemory>> =
            upsert(params, RequestOptions.none())

        /** @see upsert */
        fun upsert(
            params: MemoryUpsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentMemory>>
    }
}
