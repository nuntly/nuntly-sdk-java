// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.namespaces

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.namespaces.inboxes.InboxListPageAsync
import com.nuntly.models.namespaces.inboxes.InboxListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
 * namespaces to your own data model.
 */
interface InboxServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboxServiceAsync

    /** List inboxes in a namespace. */
    fun list(namespaceId: String): CompletableFuture<InboxListPageAsync> =
        list(namespaceId, InboxListParams.none())

    /** @see list */
    fun list(
        namespaceId: String,
        params: InboxListParams = InboxListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxListPageAsync> =
        list(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

    /** @see list */
    fun list(
        namespaceId: String,
        params: InboxListParams = InboxListParams.none(),
    ): CompletableFuture<InboxListPageAsync> = list(namespaceId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: InboxListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxListPageAsync>

    /** @see list */
    fun list(params: InboxListParams): CompletableFuture<InboxListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        namespaceId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InboxListPageAsync> =
        list(namespaceId, InboxListParams.none(), requestOptions)

    /** A view of [InboxServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InboxServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /namespaces/{namespaceId}/inboxes`, but is otherwise
         * the same as [InboxServiceAsync.list].
         */
        fun list(namespaceId: String): CompletableFuture<HttpResponseFor<InboxListPageAsync>> =
            list(namespaceId, InboxListParams.none())

        /** @see list */
        fun list(
            namespaceId: String,
            params: InboxListParams = InboxListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxListPageAsync>> =
            list(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

        /** @see list */
        fun list(
            namespaceId: String,
            params: InboxListParams = InboxListParams.none(),
        ): CompletableFuture<HttpResponseFor<InboxListPageAsync>> =
            list(namespaceId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: InboxListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxListPageAsync>>

        /** @see list */
        fun list(params: InboxListParams): CompletableFuture<HttpResponseFor<InboxListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            namespaceId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InboxListPageAsync>> =
            list(namespaceId, InboxListParams.none(), requestOptions)
    }
}
