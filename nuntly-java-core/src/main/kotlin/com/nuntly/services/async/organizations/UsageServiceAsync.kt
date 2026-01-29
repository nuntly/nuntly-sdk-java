// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.organizations

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.organizations.usage.UsageRetrieveParams
import com.nuntly.models.organizations.usage.UsageRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface UsageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageServiceAsync

    /** Retrieve organization usage */
    fun retrieve(id: String): CompletableFuture<UsageRetrieveResponse> =
        retrieve(id, UsageRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: UsageRetrieveParams = UsageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: UsageRetrieveParams = UsageRetrieveParams.none(),
    ): CompletableFuture<UsageRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UsageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: UsageRetrieveParams): CompletableFuture<UsageRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageRetrieveResponse> =
        retrieve(id, UsageRetrieveParams.none(), requestOptions)

    /** A view of [UsageServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UsageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}/usage`, but is otherwise the
         * same as [UsageServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>> =
            retrieve(id, UsageRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: UsageRetrieveParams = UsageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: UsageRetrieveParams = UsageRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: UsageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: UsageRetrieveParams
        ): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>> =
            retrieve(id, UsageRetrieveParams.none(), requestOptions)
    }
}
