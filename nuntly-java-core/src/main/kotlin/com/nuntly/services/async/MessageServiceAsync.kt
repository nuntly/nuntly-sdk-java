// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.messages.MessageDetail
import com.nuntly.models.messages.MessageForwardParams
import com.nuntly.models.messages.MessageForwardResponse
import com.nuntly.models.messages.MessageListPageAsync
import com.nuntly.models.messages.MessageListParams
import com.nuntly.models.messages.MessageReplyParams
import com.nuntly.models.messages.MessageReplyResponse
import com.nuntly.models.messages.MessageRetrieveParams
import com.nuntly.services.async.messages.AttachmentServiceAsync
import com.nuntly.services.async.messages.ContentServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Access received messages, download attachments, and send replies or forwards from an inbox. */
interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageServiceAsync

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    fun content(): ContentServiceAsync

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    fun attachments(): AttachmentServiceAsync

    /** Retrieve a single message with inbox enrichment. */
    fun retrieve(messageId: String): CompletableFuture<MessageDetail> =
        retrieve(messageId, MessageRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        params: MessageRetrieveParams = MessageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageDetail> =
        retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        params: MessageRetrieveParams = MessageRetrieveParams.none(),
    ): CompletableFuture<MessageDetail> = retrieve(messageId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageDetail>

    /** @see retrieve */
    fun retrieve(params: MessageRetrieveParams): CompletableFuture<MessageDetail> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageDetail> =
        retrieve(messageId, MessageRetrieveParams.none(), requestOptions)

    /** List all received messages across inboxes. */
    fun list(): CompletableFuture<MessageListPageAsync> = list(MessageListParams.none())

    /** @see list */
    fun list(
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync>

    /** @see list */
    fun list(
        params: MessageListParams = MessageListParams.none()
    ): CompletableFuture<MessageListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<MessageListPageAsync> =
        list(MessageListParams.none(), requestOptions)

    /** Forward a message to new recipients. */
    fun forward(
        messageId: String,
        params: MessageForwardParams,
    ): CompletableFuture<MessageForwardResponse> = forward(messageId, params, RequestOptions.none())

    /** @see forward */
    fun forward(
        messageId: String,
        params: MessageForwardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageForwardResponse> =
        forward(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see forward */
    fun forward(params: MessageForwardParams): CompletableFuture<MessageForwardResponse> =
        forward(params, RequestOptions.none())

    /** @see forward */
    fun forward(
        params: MessageForwardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageForwardResponse>

    /** Reply to a message. Set replyAll to true to reply to all recipients. */
    fun reply(messageId: String): CompletableFuture<MessageReplyResponse> =
        reply(messageId, MessageReplyParams.none())

    /** @see reply */
    fun reply(
        messageId: String,
        params: MessageReplyParams = MessageReplyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageReplyResponse> =
        reply(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see reply */
    fun reply(
        messageId: String,
        params: MessageReplyParams = MessageReplyParams.none(),
    ): CompletableFuture<MessageReplyResponse> = reply(messageId, params, RequestOptions.none())

    /** @see reply */
    fun reply(
        params: MessageReplyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageReplyResponse>

    /** @see reply */
    fun reply(params: MessageReplyParams): CompletableFuture<MessageReplyResponse> =
        reply(params, RequestOptions.none())

    /** @see reply */
    fun reply(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageReplyResponse> =
        reply(messageId, MessageReplyParams.none(), requestOptions)

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageServiceAsync.WithRawResponse

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        fun content(): ContentServiceAsync.WithRawResponse

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        fun attachments(): AttachmentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /messages/{messageId}`, but is otherwise the same as
         * [MessageServiceAsync.retrieve].
         */
        fun retrieve(messageId: String): CompletableFuture<HttpResponseFor<MessageDetail>> =
            retrieve(messageId, MessageRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams = MessageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageDetail>> =
            retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            messageId: String,
            params: MessageRetrieveParams = MessageRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageDetail>> =
            retrieve(messageId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageDetail>>

        /** @see retrieve */
        fun retrieve(
            params: MessageRetrieveParams
        ): CompletableFuture<HttpResponseFor<MessageDetail>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageDetail>> =
            retrieve(messageId, MessageRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /messages`, but is otherwise the same as
         * [MessageServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(MessageListParams.none())

        /** @see list */
        fun list(
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>>

        /** @see list */
        fun list(
            params: MessageListParams = MessageListParams.none()
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /messages/{messageId}/forward`, but is otherwise
         * the same as [MessageServiceAsync.forward].
         */
        fun forward(
            messageId: String,
            params: MessageForwardParams,
        ): CompletableFuture<HttpResponseFor<MessageForwardResponse>> =
            forward(messageId, params, RequestOptions.none())

        /** @see forward */
        fun forward(
            messageId: String,
            params: MessageForwardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageForwardResponse>> =
            forward(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see forward */
        fun forward(
            params: MessageForwardParams
        ): CompletableFuture<HttpResponseFor<MessageForwardResponse>> =
            forward(params, RequestOptions.none())

        /** @see forward */
        fun forward(
            params: MessageForwardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageForwardResponse>>

        /**
         * Returns a raw HTTP response for `post /messages/{messageId}/reply`, but is otherwise the
         * same as [MessageServiceAsync.reply].
         */
        fun reply(messageId: String): CompletableFuture<HttpResponseFor<MessageReplyResponse>> =
            reply(messageId, MessageReplyParams.none())

        /** @see reply */
        fun reply(
            messageId: String,
            params: MessageReplyParams = MessageReplyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageReplyResponse>> =
            reply(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see reply */
        fun reply(
            messageId: String,
            params: MessageReplyParams = MessageReplyParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageReplyResponse>> =
            reply(messageId, params, RequestOptions.none())

        /** @see reply */
        fun reply(
            params: MessageReplyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageReplyResponse>>

        /** @see reply */
        fun reply(
            params: MessageReplyParams
        ): CompletableFuture<HttpResponseFor<MessageReplyResponse>> =
            reply(params, RequestOptions.none())

        /** @see reply */
        fun reply(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageReplyResponse>> =
            reply(messageId, MessageReplyParams.none(), requestOptions)
    }
}
