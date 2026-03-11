// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.inboxes

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.inboxes.threads.ThreadListPageAsync
import com.nuntly.models.inboxes.threads.ThreadListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them to
 * an agent.
 */
interface ThreadServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadServiceAsync

    /** List threads in an inbox. */
    fun list(inboxId: String): CompletableFuture<ThreadListPageAsync> =
        list(inboxId, ThreadListParams.none())

    /** @see list */
    fun list(
        inboxId: String,
        params: ThreadListParams = ThreadListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadListPageAsync> =
        list(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see list */
    fun list(
        inboxId: String,
        params: ThreadListParams = ThreadListParams.none(),
    ): CompletableFuture<ThreadListPageAsync> = list(inboxId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ThreadListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadListPageAsync>

    /** @see list */
    fun list(params: ThreadListParams): CompletableFuture<ThreadListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        inboxId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ThreadListPageAsync> =
        list(inboxId, ThreadListParams.none(), requestOptions)

    /**
     * A view of [ThreadServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ThreadServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /inboxes/{inboxId}/threads`, but is otherwise the
         * same as [ThreadServiceAsync.list].
         */
        fun list(inboxId: String): CompletableFuture<HttpResponseFor<ThreadListPageAsync>> =
            list(inboxId, ThreadListParams.none())

        /** @see list */
        fun list(
            inboxId: String,
            params: ThreadListParams = ThreadListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadListPageAsync>> =
            list(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see list */
        fun list(
            inboxId: String,
            params: ThreadListParams = ThreadListParams.none(),
        ): CompletableFuture<HttpResponseFor<ThreadListPageAsync>> =
            list(inboxId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: ThreadListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadListPageAsync>>

        /** @see list */
        fun list(
            params: ThreadListParams
        ): CompletableFuture<HttpResponseFor<ThreadListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            inboxId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ThreadListPageAsync>> =
            list(inboxId, ThreadListParams.none(), requestOptions)
    }
}
