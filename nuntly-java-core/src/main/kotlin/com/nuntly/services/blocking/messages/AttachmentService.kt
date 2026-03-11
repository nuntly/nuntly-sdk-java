// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.messages

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.messages.MessageAttachment
import com.nuntly.models.messages.attachments.AttachmentListParams
import com.nuntly.models.messages.attachments.AttachmentRetrieveParams
import java.util.function.Consumer

/** Access received messages, download attachments, and send replies or forwards from an inbox. */
interface AttachmentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AttachmentService

    /** Retrieve an attachment with a presigned download URL. */
    fun retrieve(attachmentId: String, params: AttachmentRetrieveParams): MessageAttachment =
        retrieve(attachmentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        attachmentId: String,
        params: AttachmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageAttachment =
        retrieve(params.toBuilder().attachmentId(attachmentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: AttachmentRetrieveParams): MessageAttachment =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AttachmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageAttachment

    /** List all attachments for a message. */
    fun list(messageId: String): List<MessageAttachment> =
        list(messageId, AttachmentListParams.none())

    /** @see list */
    fun list(
        messageId: String,
        params: AttachmentListParams = AttachmentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<MessageAttachment> =
        list(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see list */
    fun list(
        messageId: String,
        params: AttachmentListParams = AttachmentListParams.none(),
    ): List<MessageAttachment> = list(messageId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: AttachmentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<MessageAttachment>

    /** @see list */
    fun list(params: AttachmentListParams): List<MessageAttachment> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(messageId: String, requestOptions: RequestOptions): List<MessageAttachment> =
        list(messageId, AttachmentListParams.none(), requestOptions)

    /** A view of [AttachmentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AttachmentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /messages/{messageId}/attachments/{attachmentId}`,
         * but is otherwise the same as [AttachmentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            attachmentId: String,
            params: AttachmentRetrieveParams,
        ): HttpResponseFor<MessageAttachment> =
            retrieve(attachmentId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            attachmentId: String,
            params: AttachmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageAttachment> =
            retrieve(params.toBuilder().attachmentId(attachmentId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: AttachmentRetrieveParams): HttpResponseFor<MessageAttachment> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AttachmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageAttachment>

        /**
         * Returns a raw HTTP response for `get /messages/{messageId}/attachments`, but is otherwise
         * the same as [AttachmentService.list].
         */
        @MustBeClosed
        fun list(messageId: String): HttpResponseFor<List<MessageAttachment>> =
            list(messageId, AttachmentListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            messageId: String,
            params: AttachmentListParams = AttachmentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<MessageAttachment>> =
            list(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            messageId: String,
            params: AttachmentListParams = AttachmentListParams.none(),
        ): HttpResponseFor<List<MessageAttachment>> = list(messageId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: AttachmentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<MessageAttachment>>

        /** @see list */
        @MustBeClosed
        fun list(params: AttachmentListParams): HttpResponseFor<List<MessageAttachment>> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<MessageAttachment>> =
            list(messageId, AttachmentListParams.none(), requestOptions)
    }
}
