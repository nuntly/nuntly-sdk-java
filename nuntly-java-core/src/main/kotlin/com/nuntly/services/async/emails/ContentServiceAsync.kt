// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.emails

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.emails.content.ContentRetrieveParams
import com.nuntly.models.emails.content.ContentRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ContentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContentServiceAsync

    /** Retrieve email content by email id */
    fun retrieve(id: String): CompletableFuture<ContentRetrieveResponse> =
        retrieve(id, ContentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContentRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
    ): CompletableFuture<ContentRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContentRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: ContentRetrieveParams): CompletableFuture<ContentRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContentRetrieveResponse> =
        retrieve(id, ContentRetrieveParams.none(), requestOptions)

    /**
     * A view of [ContentServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/{id}/content`, but is otherwise the same as
         * [ContentServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ContentRetrieveResponse>> =
            retrieve(id, ContentRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContentRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ContentRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContentRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: ContentRetrieveParams
        ): CompletableFuture<HttpResponseFor<ContentRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContentRetrieveResponse>> =
            retrieve(id, ContentRetrieveParams.none(), requestOptions)
    }
}
