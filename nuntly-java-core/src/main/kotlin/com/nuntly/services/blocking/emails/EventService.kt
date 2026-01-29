// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.emails

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.emails.events.EventListParams
import com.nuntly.models.emails.events.EventListResponse
import java.util.function.Consumer

interface EventService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService

    /** Retrieve email events by email id */
    fun list(id: String): List<EventListResponse> = list(id, EventListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: EventListParams = EventListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<EventListResponse> = list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: EventListParams = EventListParams.none(),
    ): List<EventListResponse> = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: EventListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<EventListResponse>

    /** @see list */
    fun list(params: EventListParams): List<EventListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(id: String, requestOptions: RequestOptions): List<EventListResponse> =
        list(id, EventListParams.none(), requestOptions)

    /** A view of [EventService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/{id}/events`, but is otherwise the same as
         * [EventService.list].
         */
        @MustBeClosed
        fun list(id: String): HttpResponseFor<List<EventListResponse>> =
            list(id, EventListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: EventListParams = EventListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<EventListResponse>> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: EventListParams = EventListParams.none(),
        ): HttpResponseFor<List<EventListResponse>> = list(id, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: EventListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<EventListResponse>>

        /** @see list */
        @MustBeClosed
        fun list(params: EventListParams): HttpResponseFor<List<EventListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<EventListResponse>> =
            list(id, EventListParams.none(), requestOptions)
    }
}
