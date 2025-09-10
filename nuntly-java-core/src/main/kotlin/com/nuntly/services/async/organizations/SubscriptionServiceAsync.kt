// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.organizations

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.organizations.subscriptions.SubscriptionListParams
import com.nuntly.models.organizations.subscriptions.SubscriptionListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SubscriptionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubscriptionServiceAsync

    /** Return the organization subscriptions */
    fun list(id: String): CompletableFuture<List<SubscriptionListResponse>> =
        list(id, SubscriptionListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: SubscriptionListParams = SubscriptionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<SubscriptionListResponse>> =
        list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: SubscriptionListParams = SubscriptionListParams.none(),
    ): CompletableFuture<List<SubscriptionListResponse>> = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: SubscriptionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<SubscriptionListResponse>>

    /** @see list */
    fun list(params: SubscriptionListParams): CompletableFuture<List<SubscriptionListResponse>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<SubscriptionListResponse>> =
        list(id, SubscriptionListParams.none(), requestOptions)

    /**
     * A view of [SubscriptionServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SubscriptionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}/subscriptions`, but is otherwise
         * the same as [SubscriptionServiceAsync.list].
         */
        fun list(id: String): CompletableFuture<HttpResponseFor<List<SubscriptionListResponse>>> =
            list(id, SubscriptionListParams.none())

        /** @see list */
        fun list(
            id: String,
            params: SubscriptionListParams = SubscriptionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<SubscriptionListResponse>>> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        fun list(
            id: String,
            params: SubscriptionListParams = SubscriptionListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<SubscriptionListResponse>>> =
            list(id, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: SubscriptionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<SubscriptionListResponse>>>

        /** @see list */
        fun list(
            params: SubscriptionListParams
        ): CompletableFuture<HttpResponseFor<List<SubscriptionListResponse>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<SubscriptionListResponse>>> =
            list(id, SubscriptionListParams.none(), requestOptions)
    }
}
