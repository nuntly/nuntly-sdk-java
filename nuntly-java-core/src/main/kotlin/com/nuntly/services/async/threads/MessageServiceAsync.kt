// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.threads

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.threads.messages.MessageListPageAsync
import com.nuntly.models.threads.messages.MessageListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them to
 * an agent.
 */
interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageServiceAsync

    /** List messages in a thread (chronological order). */
    fun list(threadId: String): CompletableFuture<MessageListPageAsync> =
        list(threadId, MessageListParams.none())

    /** @see list */
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync> =
        list(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see list */
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
    ): CompletableFuture<MessageListPageAsync> = list(threadId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync>

    /** @see list */
    fun list(params: MessageListParams): CompletableFuture<MessageListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        threadId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageListPageAsync> =
        list(threadId, MessageListParams.none(), requestOptions)

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /threads/{threadId}/messages`, but is otherwise the
         * same as [MessageServiceAsync.list].
         */
        fun list(threadId: String): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(threadId, MessageListParams.none())

        /** @see list */
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see list */
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(threadId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: MessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>>

        /** @see list */
        fun list(
            params: MessageListParams
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(threadId, MessageListParams.none(), requestOptions)
    }
}
