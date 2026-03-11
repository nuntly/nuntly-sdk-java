// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.messages

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.messages.MessageAttachment
import com.nuntly.models.messages.attachments.AttachmentListParams
import com.nuntly.models.messages.attachments.AttachmentRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Access received messages, download attachments, and send replies or forwards from an inbox. */
interface AttachmentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AttachmentServiceAsync

    /** Retrieve an attachment with a presigned download URL. */
    fun retrieve(
        attachmentId: String,
        params: AttachmentRetrieveParams,
    ): CompletableFuture<MessageAttachment> = retrieve(attachmentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        attachmentId: String,
        params: AttachmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageAttachment> =
        retrieve(params.toBuilder().attachmentId(attachmentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: AttachmentRetrieveParams): CompletableFuture<MessageAttachment> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AttachmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageAttachment>

    /** List all attachments for a message. */
    fun list(messageId: String): CompletableFuture<List<MessageAttachment>> =
        list(messageId, AttachmentListParams.none())

    /** @see list */
    fun list(
        messageId: String,
        params: AttachmentListParams = AttachmentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<MessageAttachment>> =
        list(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see list */
    fun list(
        messageId: String,
        params: AttachmentListParams = AttachmentListParams.none(),
    ): CompletableFuture<List<MessageAttachment>> = list(messageId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: AttachmentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<MessageAttachment>>

    /** @see list */
    fun list(params: AttachmentListParams): CompletableFuture<List<MessageAttachment>> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<MessageAttachment>> =
        list(messageId, AttachmentListParams.none(), requestOptions)

    /**
     * A view of [AttachmentServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AttachmentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /messages/{messageId}/attachments/{attachmentId}`,
         * but is otherwise the same as [AttachmentServiceAsync.retrieve].
         */
        fun retrieve(
            attachmentId: String,
            params: AttachmentRetrieveParams,
        ): CompletableFuture<HttpResponseFor<MessageAttachment>> =
            retrieve(attachmentId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            attachmentId: String,
            params: AttachmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageAttachment>> =
            retrieve(params.toBuilder().attachmentId(attachmentId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: AttachmentRetrieveParams
        ): CompletableFuture<HttpResponseFor<MessageAttachment>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AttachmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageAttachment>>

        /**
         * Returns a raw HTTP response for `get /messages/{messageId}/attachments`, but is otherwise
         * the same as [AttachmentServiceAsync.list].
         */
        fun list(messageId: String): CompletableFuture<HttpResponseFor<List<MessageAttachment>>> =
            list(messageId, AttachmentListParams.none())

        /** @see list */
        fun list(
            messageId: String,
            params: AttachmentListParams = AttachmentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<MessageAttachment>>> =
            list(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see list */
        fun list(
            messageId: String,
            params: AttachmentListParams = AttachmentListParams.none(),
        ): CompletableFuture<HttpResponseFor<List<MessageAttachment>>> =
            list(messageId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: AttachmentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<MessageAttachment>>>

        /** @see list */
        fun list(
            params: AttachmentListParams
        ): CompletableFuture<HttpResponseFor<List<MessageAttachment>>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<MessageAttachment>>> =
            list(messageId, AttachmentListParams.none(), requestOptions)
    }
}
