// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.messages

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.messages.MessageContent
import com.nuntly.models.messages.content.ContentRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Access received messages, download attachments, and send replies or forwards from an inbox. */
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

    /**
     * Returns presigned URLs to download the HTML, plain-text, and raw MIME source of a received
     * message.
     */
    fun retrieve(messageId: String): CompletableFuture<MessageContent> =
        retrieve(messageId, ContentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageContent> =
        retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
    ): CompletableFuture<MessageContent> = retrieve(messageId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageContent>

    /** @see retrieve */
    fun retrieve(params: ContentRetrieveParams): CompletableFuture<MessageContent> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageContent> =
        retrieve(messageId, ContentRetrieveParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `get /messages/{messageId}/content`, but is otherwise the
         * same as [ContentServiceAsync.retrieve].
         */
        fun retrieve(messageId: String): CompletableFuture<HttpResponseFor<MessageContent>> =
            retrieve(messageId, ContentRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            messageId: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageContent>> =
            retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            messageId: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageContent>> =
            retrieve(messageId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageContent>>

        /** @see retrieve */
        fun retrieve(
            params: ContentRetrieveParams
        ): CompletableFuture<HttpResponseFor<MessageContent>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageContent>> =
            retrieve(messageId, ContentRetrieveParams.none(), requestOptions)
    }
}
