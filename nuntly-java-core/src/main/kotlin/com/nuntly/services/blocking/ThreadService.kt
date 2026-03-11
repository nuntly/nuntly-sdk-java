// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.threads.Thread
import com.nuntly.models.threads.ThreadRetrieveParams
import com.nuntly.models.threads.ThreadUpdateParams
import com.nuntly.models.threads.ThreadUpdateResponse
import com.nuntly.services.blocking.threads.MessageService
import java.util.function.Consumer

/**
 * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them to
 * an agent.
 */
interface ThreadService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadService

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    fun messages(): MessageService

    /** Retrieve a thread. Auto-marks as read. */
    fun retrieve(threadId: String): Thread = retrieve(threadId, ThreadRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread = retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
    ): Thread = retrieve(threadId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** @see retrieve */
    fun retrieve(params: ThreadRetrieveParams): Thread = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(threadId: String, requestOptions: RequestOptions): Thread =
        retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

    /** Update thread properties (read status, spam, agent). */
    fun update(threadId: String): ThreadUpdateResponse = update(threadId, ThreadUpdateParams.none())

    /** @see update */
    fun update(
        threadId: String,
        params: ThreadUpdateParams = ThreadUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadUpdateResponse = update(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see update */
    fun update(
        threadId: String,
        params: ThreadUpdateParams = ThreadUpdateParams.none(),
    ): ThreadUpdateResponse = update(threadId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadUpdateResponse

    /** @see update */
    fun update(params: ThreadUpdateParams): ThreadUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(threadId: String, requestOptions: RequestOptions): ThreadUpdateResponse =
        update(threadId, ThreadUpdateParams.none(), requestOptions)

    /** A view of [ThreadService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadService.WithRawResponse

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        fun messages(): MessageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /threads/{threadId}`, but is otherwise the same as
         * [ThreadService.retrieve].
         */
        @MustBeClosed
        fun retrieve(threadId: String): HttpResponseFor<Thread> =
            retrieve(threadId, ThreadRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread> =
            retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        ): HttpResponseFor<Thread> = retrieve(threadId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ThreadRetrieveParams): HttpResponseFor<Thread> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(threadId: String, requestOptions: RequestOptions): HttpResponseFor<Thread> =
            retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /threads/{threadId}`, but is otherwise the same as
         * [ThreadService.update].
         */
        @MustBeClosed
        fun update(threadId: String): HttpResponseFor<ThreadUpdateResponse> =
            update(threadId, ThreadUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            threadId: String,
            params: ThreadUpdateParams = ThreadUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadUpdateResponse> =
            update(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            threadId: String,
            params: ThreadUpdateParams = ThreadUpdateParams.none(),
        ): HttpResponseFor<ThreadUpdateResponse> = update(threadId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ThreadUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: ThreadUpdateParams): HttpResponseFor<ThreadUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            threadId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ThreadUpdateResponse> =
            update(threadId, ThreadUpdateParams.none(), requestOptions)
    }
}
