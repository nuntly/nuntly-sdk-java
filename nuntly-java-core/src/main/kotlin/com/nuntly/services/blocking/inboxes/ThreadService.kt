// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.inboxes

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.inboxes.threads.ThreadListPage
import com.nuntly.models.inboxes.threads.ThreadListParams
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

    /** List threads in an inbox. */
    fun list(inboxId: String): ThreadListPage = list(inboxId, ThreadListParams.none())

    /** @see list */
    fun list(
        inboxId: String,
        params: ThreadListParams = ThreadListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadListPage = list(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see list */
    fun list(inboxId: String, params: ThreadListParams = ThreadListParams.none()): ThreadListPage =
        list(inboxId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ThreadListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadListPage

    /** @see list */
    fun list(params: ThreadListParams): ThreadListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(inboxId: String, requestOptions: RequestOptions): ThreadListPage =
        list(inboxId, ThreadListParams.none(), requestOptions)

    /** A view of [ThreadService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /inboxes/{inboxId}/threads`, but is otherwise the
         * same as [ThreadService.list].
         */
        @MustBeClosed
        fun list(inboxId: String): HttpResponseFor<ThreadListPage> =
            list(inboxId, ThreadListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            inboxId: String,
            params: ThreadListParams = ThreadListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadListPage> =
            list(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            inboxId: String,
            params: ThreadListParams = ThreadListParams.none(),
        ): HttpResponseFor<ThreadListPage> = list(inboxId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ThreadListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: ThreadListParams): HttpResponseFor<ThreadListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(inboxId: String, requestOptions: RequestOptions): HttpResponseFor<ThreadListPage> =
            list(inboxId, ThreadListParams.none(), requestOptions)
    }
}
