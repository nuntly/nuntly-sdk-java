// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.emails

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.emails.content.ContentRetrieveParams
import com.nuntly.models.emails.content.ContentRetrieveResponse
import java.util.function.Consumer

interface ContentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContentService

    /** Retrieve email content by email id */
    fun retrieve(id: String): ContentRetrieveResponse = retrieve(id, ContentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContentRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
    ): ContentRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContentRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: ContentRetrieveParams): ContentRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): ContentRetrieveResponse =
        retrieve(id, ContentRetrieveParams.none(), requestOptions)

    /** A view of [ContentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/{id}/content`, but is otherwise the same as
         * [ContentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<ContentRetrieveResponse> =
            retrieve(id, ContentRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContentRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
        ): HttpResponseFor<ContentRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContentRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ContentRetrieveParams): HttpResponseFor<ContentRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContentRetrieveResponse> =
            retrieve(id, ContentRetrieveParams.none(), requestOptions)
    }
}
