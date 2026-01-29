// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.organizations

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.organizations.usage.UsageRetrieveParams
import com.nuntly.models.organizations.usage.UsageRetrieveResponse
import java.util.function.Consumer

interface UsageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageService

    /** Retrieve organization usage */
    fun retrieve(id: String): UsageRetrieveResponse = retrieve(id, UsageRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: UsageRetrieveParams = UsageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: UsageRetrieveParams = UsageRetrieveParams.none(),
    ): UsageRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UsageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: UsageRetrieveParams): UsageRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): UsageRetrieveResponse =
        retrieve(id, UsageRetrieveParams.none(), requestOptions)

    /** A view of [UsageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}/usage`, but is otherwise the
         * same as [UsageService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<UsageRetrieveResponse> =
            retrieve(id, UsageRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: UsageRetrieveParams = UsageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: UsageRetrieveParams = UsageRetrieveParams.none(),
        ): HttpResponseFor<UsageRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: UsageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: UsageRetrieveParams): HttpResponseFor<UsageRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageRetrieveResponse> =
            retrieve(id, UsageRetrieveParams.none(), requestOptions)
    }
}
