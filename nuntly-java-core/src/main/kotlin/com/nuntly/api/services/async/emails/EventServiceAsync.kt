// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async.emails

import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.models.emails.events.EventListParams
import com.nuntly.api.models.emails.events.EventListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface EventServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventServiceAsync

    /** Return the events related to this email id */
    fun list(id: String): CompletableFuture<List<EventListResponse>> =
        list(id, EventListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: EventListParams = EventListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<EventListResponse>> =
        list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: EventListParams = EventListParams.none(),
    ): CompletableFuture<List<EventListResponse>> = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: EventListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<EventListResponse>>

    /** @see list */
    fun list(params: EventListParams): CompletableFuture<List<EventListResponse>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<EventListResponse>> = list(id, EventListParams.none(), requestOptions)

    /** A view of [EventServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/{id}/events`, but is otherwise the same as
         * [EventServiceAsync.list].
         */
        fun list(id: String): CompletableFuture<HttpResponseFor<List<EventListResponse>>> =
            list(id, EventListParams.none())

        /** @see list */
        fun list(
            id: String,
            params: EventListParams = EventListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<EventListResponse>>> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        fun list(
            id: String,
            params: EventListParams = EventListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<EventListResponse>>> =
            list(id, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: EventListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<EventListResponse>>>

        /** @see list */
        fun list(
            params: EventListParams
        ): CompletableFuture<HttpResponseFor<List<EventListResponse>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<EventListResponse>>> =
            list(id, EventListParams.none(), requestOptions)
    }
}
