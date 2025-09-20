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
import com.nuntly.models.webhooks.events.EventRetryParams
import com.nuntly.models.webhooks.events.EventRetryResponse
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

    /** Return the last events sent by webhooks */
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

    /** Return the delivery attempts for the given webhook event ID */
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

    /** Retry sending the webhook event with the given event ID */
    fun retry(eventId: String, params: EventRetryParams): EventRetryResponse =
        retry(eventId, params, RequestOptions.none())

    /** @see retry */
    fun retry(
        eventId: String,
        params: EventRetryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventRetryResponse = retry(params.toBuilder().eventId(eventId).build(), requestOptions)

    /** @see retry */
    fun retry(params: EventRetryParams): EventRetryResponse = retry(params, RequestOptions.none())

    /** @see retry */
    fun retry(
        params: EventRetryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventRetryResponse

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
         * Returns a raw HTTP response for `get /webhooks/{id}/events/{event_id}/deliveries`, but is
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
         * Returns a raw HTTP response for `post /webhooks/{id}/events/{event_id}/retry`, but is
         * otherwise the same as [EventService.retry].
         */
        @MustBeClosed
        fun retry(eventId: String, params: EventRetryParams): HttpResponseFor<EventRetryResponse> =
            retry(eventId, params, RequestOptions.none())

        /** @see retry */
        @MustBeClosed
        fun retry(
            eventId: String,
            params: EventRetryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventRetryResponse> =
            retry(params.toBuilder().eventId(eventId).build(), requestOptions)

        /** @see retry */
        @MustBeClosed
        fun retry(params: EventRetryParams): HttpResponseFor<EventRetryResponse> =
            retry(params, RequestOptions.none())

        /** @see retry */
        @MustBeClosed
        fun retry(
            params: EventRetryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventRetryResponse>
    }
}
