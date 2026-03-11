// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.threads

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.threads.messages.MessageListPage
import com.nuntly.models.threads.messages.MessageListParams
import java.util.function.Consumer

/**
 * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them to
 * an agent.
 */
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

    /** List messages in a thread (chronological order). */
    fun list(threadId: String): MessageListPage = list(threadId, MessageListParams.none())

    /** @see list */
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage = list(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see list */
    fun list(
        threadId: String,
        params: MessageListParams = MessageListParams.none(),
    ): MessageListPage = list(threadId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: MessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage

    /** @see list */
    fun list(params: MessageListParams): MessageListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(threadId: String, requestOptions: RequestOptions): MessageListPage =
        list(threadId, MessageListParams.none(), requestOptions)

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /threads/{threadId}/messages`, but is otherwise the
         * same as [MessageService.list].
         */
        @MustBeClosed
        fun list(threadId: String): HttpResponseFor<MessageListPage> =
            list(threadId, MessageListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage> =
            list(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            threadId: String,
            params: MessageListParams = MessageListParams.none(),
        ): HttpResponseFor<MessageListPage> = list(threadId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: MessageListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: MessageListParams): HttpResponseFor<MessageListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            threadId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListPage> =
            list(threadId, MessageListParams.none(), requestOptions)
    }
}
