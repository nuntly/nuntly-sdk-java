// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.webhooks

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.webhooks.events.EventDeliveriesParams
import com.nuntly.models.webhooks.events.EventDeliveriesResponse
import com.nuntly.models.webhooks.events.EventListPage
import com.nuntly.models.webhooks.events.EventListParams
import com.nuntly.models.webhooks.events.EventReplayParams
import com.nuntly.models.webhooks.events.EventReplayResponse
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

    /** List webhook events */
    fun list(): EventListPage = list(EventListParams.none())

    /** @see list */
    fun list(
        params: EventListParams = EventListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventListPage

    /** @see list */
    fun list(params: EventListParams = EventListParams.none()): EventListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): EventListPage =
        list(EventListParams.none(), requestOptions)

    /** List webhook event deliveries */
    fun deliveries(eventId: String, params: EventDeliveriesParams): List<EventDeliveriesResponse> =
        deliveries(eventId, params, RequestOptions.none())

    /** @see deliveries */
    fun deliveries(
        eventId: String,
        params: EventDeliveriesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<EventDeliveriesResponse> =
        deliveries(params.toBuilder().eventId(eventId).build(), requestOptions)

    /** @see deliveries */
    fun deliveries(params: EventDeliveriesParams): List<EventDeliveriesResponse> =
        deliveries(params, RequestOptions.none())

    /** @see deliveries */
    fun deliveries(
        params: EventDeliveriesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<EventDeliveriesResponse>

    /** Replay a webhook event */
    fun replay(eventId: String, params: EventReplayParams): EventReplayResponse =
        replay(eventId, params, RequestOptions.none())

    /** @see replay */
    fun replay(
        eventId: String,
        params: EventReplayParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventReplayResponse = replay(params.toBuilder().eventId(eventId).build(), requestOptions)

    /** @see replay */
    fun replay(params: EventReplayParams): EventReplayResponse =
        replay(params, RequestOptions.none())

    /** @see replay */
    fun replay(
        params: EventReplayParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventReplayResponse

    /** A view of [EventService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /webhooks/events`, but is otherwise the same as
         * [EventService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<EventListPage> = list(EventListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: EventListParams = EventListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: EventListParams = EventListParams.none()): HttpResponseFor<EventListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<EventListPage> =
            list(EventListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /webhooks/{id}/events/{eventId}/deliveries`, but is
         * otherwise the same as [EventService.deliveries].
         */
        @MustBeClosed
        fun deliveries(
            eventId: String,
            params: EventDeliveriesParams,
        ): HttpResponseFor<List<EventDeliveriesResponse>> =
            deliveries(eventId, params, RequestOptions.none())

        /** @see deliveries */
        @MustBeClosed
        fun deliveries(
            eventId: String,
            params: EventDeliveriesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<EventDeliveriesResponse>> =
            deliveries(params.toBuilder().eventId(eventId).build(), requestOptions)

        /** @see deliveries */
        @MustBeClosed
        fun deliveries(
            params: EventDeliveriesParams
        ): HttpResponseFor<List<EventDeliveriesResponse>> =
            deliveries(params, RequestOptions.none())

        /** @see deliveries */
        @MustBeClosed
        fun deliveries(
            params: EventDeliveriesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<EventDeliveriesResponse>>

        /**
         * Returns a raw HTTP response for `post /webhooks/{id}/events/{eventId}/replay`, but is
         * otherwise the same as [EventService.replay].
         */
        @MustBeClosed
        fun replay(
            eventId: String,
            params: EventReplayParams,
        ): HttpResponseFor<EventReplayResponse> = replay(eventId, params, RequestOptions.none())

        /** @see replay */
        @MustBeClosed
        fun replay(
            eventId: String,
            params: EventReplayParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventReplayResponse> =
            replay(params.toBuilder().eventId(eventId).build(), requestOptions)

        /** @see replay */
        @MustBeClosed
        fun replay(params: EventReplayParams): HttpResponseFor<EventReplayResponse> =
            replay(params, RequestOptions.none())

        /** @see replay */
        @MustBeClosed
        fun replay(
            params: EventReplayParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventReplayResponse>
    }
}
