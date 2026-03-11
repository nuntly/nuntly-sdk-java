// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.threads.Thread
import com.nuntly.models.threads.ThreadRetrieveParams
import com.nuntly.models.threads.ThreadUpdateParams
import com.nuntly.models.threads.ThreadUpdateResponse
import com.nuntly.services.async.threads.MessageServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them to
 * an agent.
 */
interface ThreadServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadServiceAsync

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    fun messages(): MessageServiceAsync

    /** Retrieve a thread. Auto-marks as read. */
    fun retrieve(threadId: String): CompletableFuture<Thread> =
        retrieve(threadId, ThreadRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread> =
        retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
    ): CompletableFuture<Thread> = retrieve(threadId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** @see retrieve */
    fun retrieve(params: ThreadRetrieveParams): CompletableFuture<Thread> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(threadId: String, requestOptions: RequestOptions): CompletableFuture<Thread> =
        retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

    /** Update thread properties (read status, spam, agent). */
    fun update(threadId: String): CompletableFuture<ThreadUpdateResponse> =
        update(threadId, ThreadUpdateParams.none())

    /** @see update */
    fun update(
        threadId: String,
        params: ThreadUpdateParams = ThreadUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadUpdateResponse> =
        update(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see update */
    fun update(
        threadId: String,
        params: ThreadUpdateParams = ThreadUpdateParams.none(),
    ): CompletableFuture<ThreadUpdateResponse> = update(threadId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadUpdateResponse>

    /** @see update */
    fun update(params: ThreadUpdateParams): CompletableFuture<ThreadUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        threadId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ThreadUpdateResponse> =
        update(threadId, ThreadUpdateParams.none(), requestOptions)

    /**
     * A view of [ThreadServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ThreadServiceAsync.WithRawResponse

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        fun messages(): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /threads/{threadId}`, but is otherwise the same as
         * [ThreadServiceAsync.retrieve].
         */
        fun retrieve(threadId: String): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(threadId, ThreadRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(threadId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /** @see retrieve */
        fun retrieve(params: ThreadRetrieveParams): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /threads/{threadId}`, but is otherwise the same as
         * [ThreadServiceAsync.update].
         */
        fun update(threadId: String): CompletableFuture<HttpResponseFor<ThreadUpdateResponse>> =
            update(threadId, ThreadUpdateParams.none())

        /** @see update */
        fun update(
            threadId: String,
            params: ThreadUpdateParams = ThreadUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadUpdateResponse>> =
            update(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see update */
        fun update(
            threadId: String,
            params: ThreadUpdateParams = ThreadUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ThreadUpdateResponse>> =
            update(threadId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ThreadUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadUpdateResponse>>

        /** @see update */
        fun update(
            params: ThreadUpdateParams
        ): CompletableFuture<HttpResponseFor<ThreadUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ThreadUpdateResponse>> =
            update(threadId, ThreadUpdateParams.none(), requestOptions)
    }
}
