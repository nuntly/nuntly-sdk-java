// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.emails

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.emails.bulk.BulkRetrieveParams
import com.nuntly.models.emails.bulk.BulkRetrieveResponse
import com.nuntly.models.emails.bulk.BulkSendParams
import com.nuntly.models.emails.bulk.BulkSendResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkServiceAsync

    /** Return a list of emails */
    fun retrieve(id: String): CompletableFuture<BulkRetrieveResponse> =
        retrieve(id, BulkRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: BulkRetrieveParams = BulkRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: BulkRetrieveParams = BulkRetrieveParams.none(),
    ): CompletableFuture<BulkRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: BulkRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: BulkRetrieveParams): CompletableFuture<BulkRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<BulkRetrieveResponse> =
        retrieve(id, BulkRetrieveParams.none(), requestOptions)

    /** Send bulk emails */
    fun send(params: BulkSendParams): CompletableFuture<BulkSendResponse> =
        send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: BulkSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkSendResponse>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/bulk/{id}`, but is otherwise the same as
         * [BulkServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<BulkRetrieveResponse>> =
            retrieve(id, BulkRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: BulkRetrieveParams = BulkRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: BulkRetrieveParams = BulkRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<BulkRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: BulkRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: BulkRetrieveParams
        ): CompletableFuture<HttpResponseFor<BulkRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkRetrieveResponse>> =
            retrieve(id, BulkRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /emails/bulk`, but is otherwise the same as
         * [BulkServiceAsync.send].
         */
        fun send(params: BulkSendParams): CompletableFuture<HttpResponseFor<BulkSendResponse>> =
            send(params, RequestOptions.none())

        /** @see send */
        fun send(
            params: BulkSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkSendResponse>>
    }
}
