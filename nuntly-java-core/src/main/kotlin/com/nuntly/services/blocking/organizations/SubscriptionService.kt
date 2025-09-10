// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.organizations

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.organizations.subscriptions.SubscriptionListParams
import com.nuntly.models.organizations.subscriptions.SubscriptionListResponse
import java.util.function.Consumer

interface SubscriptionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubscriptionService

    /** Return the organization subscriptions */
    fun list(id: String): List<SubscriptionListResponse> = list(id, SubscriptionListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: SubscriptionListParams = SubscriptionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<SubscriptionListResponse> = list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: SubscriptionListParams = SubscriptionListParams.none(),
    ): List<SubscriptionListResponse> = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: SubscriptionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<SubscriptionListResponse>

    /** @see list */
    fun list(params: SubscriptionListParams): List<SubscriptionListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(id: String, requestOptions: RequestOptions): List<SubscriptionListResponse> =
        list(id, SubscriptionListParams.none(), requestOptions)

    /**
     * A view of [SubscriptionService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SubscriptionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}/subscriptions`, but is otherwise
         * the same as [SubscriptionService.list].
         */
        @MustBeClosed
        fun list(id: String): HttpResponseFor<List<SubscriptionListResponse>> =
            list(id, SubscriptionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: SubscriptionListParams = SubscriptionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<SubscriptionListResponse>> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: SubscriptionListParams = SubscriptionListParams.none(),
        ): HttpResponseFor<List<SubscriptionListResponse>> = list(id, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: SubscriptionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<SubscriptionListResponse>>

        /** @see list */
        @MustBeClosed
        fun list(params: SubscriptionListParams): HttpResponseFor<List<SubscriptionListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<SubscriptionListResponse>> =
            list(id, SubscriptionListParams.none(), requestOptions)
    }
}
