// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async.emails

import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.models.emails.stats.StatListParams
import com.nuntly.api.models.emails.stats.StatListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface StatServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StatServiceAsync

    /** Return the emails stats */
    fun list(): CompletableFuture<StatListResponse> = list(StatListParams.none())

    /** @see list */
    fun list(
        params: StatListParams = StatListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StatListResponse>

    /** @see list */
    fun list(params: StatListParams = StatListParams.none()): CompletableFuture<StatListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<StatListResponse> =
        list(StatListParams.none(), requestOptions)

    /** A view of [StatServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): StatServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/stats`, but is otherwise the same as
         * [StatServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<StatListResponse>> =
            list(StatListParams.none())

        /** @see list */
        fun list(
            params: StatListParams = StatListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StatListResponse>>

        /** @see list */
        fun list(
            params: StatListParams = StatListParams.none()
        ): CompletableFuture<HttpResponseFor<StatListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<StatListResponse>> =
            list(StatListParams.none(), requestOptions)
    }
}
