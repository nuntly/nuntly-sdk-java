// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.webhooks

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.webhooks.events.EventDeliveriesParams
import com.nuntly.models.webhooks.events.EventDeliveriesResponse
import com.nuntly.models.webhooks.events.EventListPageAsync
import com.nuntly.models.webhooks.events.EventListParams
import com.nuntly.models.webhooks.events.EventRetryParams
import com.nuntly.models.webhooks.events.EventRetryResponse
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

    /** Return the last events sent by webhooks */
    fun list(): CompletableFuture<EventListPageAsync> = list(EventListParams.none())

    /** @see list */
    fun list(
        params: EventListParams = EventListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EventListPageAsync>

    /** @see list */
    fun list(
        params: EventListParams = EventListParams.none()
    ): CompletableFuture<EventListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<EventListPageAsync> =
        list(EventListParams.none(), requestOptions)

    /** Return the delivery attempts for the given webhook event ID */
    fun deliveries(
        eventId: String,
        params: EventDeliveriesParams,
    ): CompletableFuture<List<EventDeliveriesResponse>> =
        deliveries(eventId, params, RequestOptions.none())

    /** @see deliveries */
    fun deliveries(
        eventId: String,
        params: EventDeliveriesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<EventDeliveriesResponse>> =
        deliveries(params.toBuilder().eventId(eventId).build(), requestOptions)

    /** @see deliveries */
    fun deliveries(
        params: EventDeliveriesParams
    ): CompletableFuture<List<EventDeliveriesResponse>> = deliveries(params, RequestOptions.none())

    /** @see deliveries */
    fun deliveries(
        params: EventDeliveriesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<EventDeliveriesResponse>>

    /** Retry sending the webhook event with the given event ID */
    fun retry(eventId: String, params: EventRetryParams): CompletableFuture<EventRetryResponse> =
        retry(eventId, params, RequestOptions.none())

    /** @see retry */
    fun retry(
        eventId: String,
        params: EventRetryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EventRetryResponse> =
        retry(params.toBuilder().eventId(eventId).build(), requestOptions)

    /** @see retry */
    fun retry(params: EventRetryParams): CompletableFuture<EventRetryResponse> =
        retry(params, RequestOptions.none())

    /** @see retry */
    fun retry(
        params: EventRetryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EventRetryResponse>

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
         * Returns a raw HTTP response for `get /webhooks/events`, but is otherwise the same as
         * [EventServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<EventListPageAsync>> =
            list(EventListParams.none())

        /** @see list */
        fun list(
            params: EventListParams = EventListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EventListPageAsync>>

        /** @see list */
        fun list(
            params: EventListParams = EventListParams.none()
        ): CompletableFuture<HttpResponseFor<EventListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<EventListPageAsync>> =
            list(EventListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /webhooks/{id}/events/{event_id}/deliveries`, but is
         * otherwise the same as [EventServiceAsync.deliveries].
         */
        fun deliveries(
            eventId: String,
            params: EventDeliveriesParams,
        ): CompletableFuture<HttpResponseFor<List<EventDeliveriesResponse>>> =
            deliveries(eventId, params, RequestOptions.none())

        /** @see deliveries */
        fun deliveries(
            eventId: String,
            params: EventDeliveriesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<EventDeliveriesResponse>>> =
            deliveries(params.toBuilder().eventId(eventId).build(), requestOptions)

        /** @see deliveries */
        fun deliveries(
            params: EventDeliveriesParams
        ): CompletableFuture<HttpResponseFor<List<EventDeliveriesResponse>>> =
            deliveries(params, RequestOptions.none())

        /** @see deliveries */
        fun deliveries(
            params: EventDeliveriesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<EventDeliveriesResponse>>>

        /**
         * Returns a raw HTTP response for `post /webhooks/{id}/events/{event_id}/retry`, but is
         * otherwise the same as [EventServiceAsync.retry].
         */
        fun retry(
            eventId: String,
            params: EventRetryParams,
        ): CompletableFuture<HttpResponseFor<EventRetryResponse>> =
            retry(eventId, params, RequestOptions.none())

        /** @see retry */
        fun retry(
            eventId: String,
            params: EventRetryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EventRetryResponse>> =
            retry(params.toBuilder().eventId(eventId).build(), requestOptions)

        /** @see retry */
        fun retry(
            params: EventRetryParams
        ): CompletableFuture<HttpResponseFor<EventRetryResponse>> =
            retry(params, RequestOptions.none())

        /** @see retry */
        fun retry(
            params: EventRetryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EventRetryResponse>>
    }
}
