// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking.emails

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.models.emails.stats.StatListParams
import com.nuntly.api.models.emails.stats.StatListResponse
import java.util.function.Consumer

interface StatService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StatService

    /** Return the emails stats */
    fun list(): StatListResponse = list(StatListParams.none())

    /** @see list */
    fun list(
        params: StatListParams = StatListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StatListResponse

    /** @see list */
    fun list(params: StatListParams = StatListParams.none()): StatListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): StatListResponse =
        list(StatListParams.none(), requestOptions)

    /** A view of [StatService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): StatService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/stats`, but is otherwise the same as
         * [StatService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<StatListResponse> = list(StatListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: StatListParams = StatListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StatListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: StatListParams = StatListParams.none()
        ): HttpResponseFor<StatListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<StatListResponse> =
            list(StatListParams.none(), requestOptions)
    }
}
