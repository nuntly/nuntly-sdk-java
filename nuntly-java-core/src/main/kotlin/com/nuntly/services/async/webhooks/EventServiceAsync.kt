// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.webhooks

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.webhooks.events.EventDeliveriesParams
import com.nuntly.models.webhooks.events.EventDeliveriesResponse
import com.nuntly.models.webhooks.events.EventListPageAsync
import com.nuntly.models.webhooks.events.EventListParams
import com.nuntly.models.webhooks.events.EventReplayParams
import com.nuntly.models.webhooks.events.EventReplayResponse
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

    /** List webhook events */
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

    /** List webhook event deliveries */
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

    /** Replay a webhook event */
    fun replay(eventId: String, params: EventReplayParams): CompletableFuture<EventReplayResponse> =
        replay(eventId, params, RequestOptions.none())

    /** @see replay */
    fun replay(
        eventId: String,
        params: EventReplayParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EventReplayResponse> =
        replay(params.toBuilder().eventId(eventId).build(), requestOptions)

    /** @see replay */
    fun replay(params: EventReplayParams): CompletableFuture<EventReplayResponse> =
        replay(params, RequestOptions.none())

    /** @see replay */
    fun replay(
        params: EventReplayParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EventReplayResponse>

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
         * Returns a raw HTTP response for `get /webhooks/{id}/events/{eventId}/deliveries`, but is
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
         * Returns a raw HTTP response for `post /webhooks/{id}/events/{eventId}/replay`, but is
         * otherwise the same as [EventServiceAsync.replay].
         */
        fun replay(
            eventId: String,
            params: EventReplayParams,
        ): CompletableFuture<HttpResponseFor<EventReplayResponse>> =
            replay(eventId, params, RequestOptions.none())

        /** @see replay */
        fun replay(
            eventId: String,
            params: EventReplayParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EventReplayResponse>> =
            replay(params.toBuilder().eventId(eventId).build(), requestOptions)

        /** @see replay */
        fun replay(
            params: EventReplayParams
        ): CompletableFuture<HttpResponseFor<EventReplayResponse>> =
            replay(params, RequestOptions.none())

        /** @see replay */
        fun replay(
            params: EventReplayParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EventReplayResponse>>
    }
}
