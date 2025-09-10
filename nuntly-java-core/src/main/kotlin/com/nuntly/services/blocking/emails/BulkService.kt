// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.emails

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.emails.bulk.BulkRetrieveParams
import com.nuntly.models.emails.bulk.BulkRetrieveResponse
import com.nuntly.models.emails.bulk.BulkSendParams
import com.nuntly.models.emails.bulk.BulkSendResponse
import java.util.function.Consumer

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkService

    /** Return a list of emails */
    fun retrieve(id: String): BulkRetrieveResponse = retrieve(id, BulkRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: BulkRetrieveParams = BulkRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: BulkRetrieveParams = BulkRetrieveParams.none(),
    ): BulkRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: BulkRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: BulkRetrieveParams): BulkRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): BulkRetrieveResponse =
        retrieve(id, BulkRetrieveParams.none(), requestOptions)

    /** Send bulk emails */
    fun send(params: BulkSendParams): BulkSendResponse = send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: BulkSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkSendResponse

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/bulk/{id}`, but is otherwise the same as
         * [BulkService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<BulkRetrieveResponse> =
            retrieve(id, BulkRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: BulkRetrieveParams = BulkRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: BulkRetrieveParams = BulkRetrieveParams.none(),
        ): HttpResponseFor<BulkRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: BulkRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: BulkRetrieveParams): HttpResponseFor<BulkRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkRetrieveResponse> =
            retrieve(id, BulkRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /emails/bulk`, but is otherwise the same as
         * [BulkService.send].
         */
        @MustBeClosed
        fun send(params: BulkSendParams): HttpResponseFor<BulkSendResponse> =
            send(params, RequestOptions.none())

        /** @see send */
        @MustBeClosed
        fun send(
            params: BulkSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkSendResponse>
    }
}
