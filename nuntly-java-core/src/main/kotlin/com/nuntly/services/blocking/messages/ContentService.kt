// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.messages

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.messages.MessageContent
import com.nuntly.models.messages.content.ContentRetrieveParams
import java.util.function.Consumer

/** Access received messages, download attachments, and send replies or forwards from an inbox. */
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

    /**
     * Returns presigned URLs to download the HTML, plain-text, and raw MIME source of a received
     * message.
     */
    fun retrieve(messageId: String): MessageContent =
        retrieve(messageId, ContentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageContent = retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
    ): MessageContent = retrieve(messageId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageContent

    /** @see retrieve */
    fun retrieve(params: ContentRetrieveParams): MessageContent =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(messageId: String, requestOptions: RequestOptions): MessageContent =
        retrieve(messageId, ContentRetrieveParams.none(), requestOptions)

    /** A view of [ContentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /messages/{messageId}/content`, but is otherwise the
         * same as [ContentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(messageId: String): HttpResponseFor<MessageContent> =
            retrieve(messageId, ContentRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            messageId: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageContent> =
            retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            messageId: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
        ): HttpResponseFor<MessageContent> = retrieve(messageId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageContent>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ContentRetrieveParams): HttpResponseFor<MessageContent> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageContent> =
            retrieve(messageId, ContentRetrieveParams.none(), requestOptions)
    }
}
