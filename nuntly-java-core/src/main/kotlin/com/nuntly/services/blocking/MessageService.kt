// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.messages.MessageDetail
import com.nuntly.models.messages.MessageForwardParams
import com.nuntly.models.messages.MessageForwardResponse
import com.nuntly.models.messages.MessageListPage
import com.nuntly.models.messages.MessageListParams
import com.nuntly.models.messages.MessageReplyParams
import com.nuntly.models.messages.MessageReplyResponse
import com.nuntly.models.messages.MessageRetrieveParams
import com.nuntly.services.blocking.messages.AttachmentService
import com.nuntly.services.blocking.messages.ContentService
import java.util.function.Consumer

/** Access received messages, download attachments, and send replies or forwards from an inbox. */
interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    fun content(): ContentService

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    fun attachments(): AttachmentService

    /** Retrieve a single message with inbox enrichment. */
    fun retrieve(messageId: String): MessageDetail =
        retrieve(messageId, MessageRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        params: MessageRetrieveParams = MessageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageDetail = retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        params: MessageRetrieveParams = MessageRetrieveParams.none(),
    ): MessageDetail = retrieve(messageId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageDetail

    /** @see retrieve */
    fun retrieve(params: MessageRetrieveParams): MessageDetail =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(messageId: String, requestOptions: RequestOptions): MessageDetail =
        retrieve(messageId, MessageRetrieveParams.none(), requestOptions)

    /** List all received messages across inboxes. */
    fun list(): MessageListPage = list(MessageListParams.none())

    /** @see list */
    fun list(
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage

    /** @see list */
    fun list(params: MessageListParams = MessageListParams.none()): MessageListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): MessageListPage =
        list(MessageListParams.none(), requestOptions)

    /** Forward a message to new recipients. */
    fun forward(messageId: String, params: MessageForwardParams): MessageForwardResponse =
        forward(messageId, params, RequestOptions.none())

    /** @see forward */
    fun forward(
        messageId: String,
        params: MessageForwardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageForwardResponse =
        forward(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see forward */
    fun forward(params: MessageForwardParams): MessageForwardResponse =
        forward(params, RequestOptions.none())

    /** @see forward */
    fun forward(
        params: MessageForwardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageForwardResponse

    /** Reply to a message. Set replyAll to true to reply to all recipients. */
    fun reply(messageId: String): MessageReplyResponse = reply(messageId, MessageReplyParams.none())

    /** @see reply */
    fun reply(
        messageId: String,
        params: MessageReplyParams = MessageReplyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageReplyResponse = reply(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see reply */
    fun reply(
        messageId: String,
        params: MessageReplyParams = MessageReplyParams.none(),
    ): MessageReplyResponse = reply(messageId, params, RequestOptions.none())

    /** @see reply */
    fun reply(
        params: MessageReplyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageReplyResponse

    /** @see reply */
    fun reply(params: MessageReplyParams): MessageReplyResponse =
        reply(params, RequestOptions.none())

    /** @see reply */
    fun reply(messageId: String, requestOptions: RequestOptions): MessageReplyResponse =
        reply(messageId, MessageReplyParams.none(), requestOptions)

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService.WithRawResponse

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        fun content(): ContentService.WithRawResponse

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        fun attachments(): AttachmentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /messages/{messageId}`, but is otherwise the same as
         * [MessageService.retrieve].
         */
        @MustBeClosed
        fun retrieve(messageId: String): HttpResponseFor<MessageDetail> =
            retrieve(messageId, MessageRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams = MessageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageDetail> =
            retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams = MessageRetrieveParams.none(),
        ): HttpResponseFor<MessageDetail> = retrieve(messageId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageDetail>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: MessageRetrieveParams): HttpResponseFor<MessageDetail> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageDetail> =
            retrieve(messageId, MessageRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /messages`, but is otherwise the same as
         * [MessageService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<MessageListPage> = list(MessageListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: MessageListParams = MessageListParams.none()
        ): HttpResponseFor<MessageListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<MessageListPage> =
            list(MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /messages/{messageId}/forward`, but is otherwise
         * the same as [MessageService.forward].
         */
        @MustBeClosed
        fun forward(
            messageId: String,
            params: MessageForwardParams,
        ): HttpResponseFor<MessageForwardResponse> =
            forward(messageId, params, RequestOptions.none())

        /** @see forward */
        @MustBeClosed
        fun forward(
            messageId: String,
            params: MessageForwardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageForwardResponse> =
            forward(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see forward */
        @MustBeClosed
        fun forward(params: MessageForwardParams): HttpResponseFor<MessageForwardResponse> =
            forward(params, RequestOptions.none())

        /** @see forward */
        @MustBeClosed
        fun forward(
            params: MessageForwardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageForwardResponse>

        /**
         * Returns a raw HTTP response for `post /messages/{messageId}/reply`, but is otherwise the
         * same as [MessageService.reply].
         */
        @MustBeClosed
        fun reply(messageId: String): HttpResponseFor<MessageReplyResponse> =
            reply(messageId, MessageReplyParams.none())

        /** @see reply */
        @MustBeClosed
        fun reply(
            messageId: String,
            params: MessageReplyParams = MessageReplyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageReplyResponse> =
            reply(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see reply */
        @MustBeClosed
        fun reply(
            messageId: String,
            params: MessageReplyParams = MessageReplyParams.none(),
        ): HttpResponseFor<MessageReplyResponse> = reply(messageId, params, RequestOptions.none())

        /** @see reply */
        @MustBeClosed
        fun reply(
            params: MessageReplyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageReplyResponse>

        /** @see reply */
        @MustBeClosed
        fun reply(params: MessageReplyParams): HttpResponseFor<MessageReplyResponse> =
            reply(params, RequestOptions.none())

        /** @see reply */
        @MustBeClosed
        fun reply(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageReplyResponse> =
            reply(messageId, MessageReplyParams.none(), requestOptions)
    }
}
