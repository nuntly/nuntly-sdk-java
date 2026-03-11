// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.inboxes.Inbox
import com.nuntly.models.inboxes.InboxCreateParams
import com.nuntly.models.inboxes.InboxDeleteParams
import com.nuntly.models.inboxes.InboxDeleteResponse
import com.nuntly.models.inboxes.InboxListPageAsync
import com.nuntly.models.inboxes.InboxListParams
import com.nuntly.models.inboxes.InboxRetrieveParams
import com.nuntly.models.inboxes.InboxSendParams
import com.nuntly.models.inboxes.InboxSendResponse
import com.nuntly.models.inboxes.InboxUpdateParams
import com.nuntly.models.inboxes.InboxUpdateResponse
import com.nuntly.services.async.inboxes.ThreadServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes to
 * namespaces or AI agents.
 */
interface InboxServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboxServiceAsync

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    fun threads(): ThreadServiceAsync

    /** Create a new inbox on a verified domain. */
    fun create(params: InboxCreateParams): CompletableFuture<Inbox> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InboxCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Inbox>

    /** Retrieve an inbox with thread stats. */
    fun retrieve(inboxId: String): CompletableFuture<Inbox> =
        retrieve(inboxId, InboxRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        inboxId: String,
        params: InboxRetrieveParams = InboxRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Inbox> =
        retrieve(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        inboxId: String,
        params: InboxRetrieveParams = InboxRetrieveParams.none(),
    ): CompletableFuture<Inbox> = retrieve(inboxId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InboxRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Inbox>

    /** @see retrieve */
    fun retrieve(params: InboxRetrieveParams): CompletableFuture<Inbox> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(inboxId: String, requestOptions: RequestOptions): CompletableFuture<Inbox> =
        retrieve(inboxId, InboxRetrieveParams.none(), requestOptions)

    /** Update an inbox. */
    fun update(inboxId: String): CompletableFuture<InboxUpdateResponse> =
        update(inboxId, InboxUpdateParams.none())

    /** @see update */
    fun update(
        inboxId: String,
        params: InboxUpdateParams = InboxUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxUpdateResponse> =
        update(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see update */
    fun update(
        inboxId: String,
        params: InboxUpdateParams = InboxUpdateParams.none(),
    ): CompletableFuture<InboxUpdateResponse> = update(inboxId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: InboxUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxUpdateResponse>

    /** @see update */
    fun update(params: InboxUpdateParams): CompletableFuture<InboxUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        inboxId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InboxUpdateResponse> =
        update(inboxId, InboxUpdateParams.none(), requestOptions)

    /** List all inboxes. */
    fun list(): CompletableFuture<InboxListPageAsync> = list(InboxListParams.none())

    /** @see list */
    fun list(
        params: InboxListParams = InboxListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxListPageAsync>

    /** @see list */
    fun list(
        params: InboxListParams = InboxListParams.none()
    ): CompletableFuture<InboxListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<InboxListPageAsync> =
        list(InboxListParams.none(), requestOptions)

    /** Soft-delete an inbox. */
    fun delete(inboxId: String): CompletableFuture<InboxDeleteResponse> =
        delete(inboxId, InboxDeleteParams.none())

    /** @see delete */
    fun delete(
        inboxId: String,
        params: InboxDeleteParams = InboxDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxDeleteResponse> =
        delete(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see delete */
    fun delete(
        inboxId: String,
        params: InboxDeleteParams = InboxDeleteParams.none(),
    ): CompletableFuture<InboxDeleteResponse> = delete(inboxId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InboxDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxDeleteResponse>

    /** @see delete */
    fun delete(params: InboxDeleteParams): CompletableFuture<InboxDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        inboxId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InboxDeleteResponse> =
        delete(inboxId, InboxDeleteParams.none(), requestOptions)

    /** Send a new message from an inbox. */
    fun send(inboxId: String, params: InboxSendParams): CompletableFuture<InboxSendResponse> =
        send(inboxId, params, RequestOptions.none())

    /** @see send */
    fun send(
        inboxId: String,
        params: InboxSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxSendResponse> =
        send(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see send */
    fun send(params: InboxSendParams): CompletableFuture<InboxSendResponse> =
        send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: InboxSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxSendResponse>

    /** A view of [InboxServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InboxServiceAsync.WithRawResponse

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        fun threads(): ThreadServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /inboxes`, but is otherwise the same as
         * [InboxServiceAsync.create].
         */
        fun create(params: InboxCreateParams): CompletableFuture<HttpResponseFor<Inbox>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: InboxCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Inbox>>

        /**
         * Returns a raw HTTP response for `get /inboxes/{inboxId}`, but is otherwise the same as
         * [InboxServiceAsync.retrieve].
         */
        fun retrieve(inboxId: String): CompletableFuture<HttpResponseFor<Inbox>> =
            retrieve(inboxId, InboxRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            inboxId: String,
            params: InboxRetrieveParams = InboxRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Inbox>> =
            retrieve(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            inboxId: String,
            params: InboxRetrieveParams = InboxRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Inbox>> =
            retrieve(inboxId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: InboxRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Inbox>>

        /** @see retrieve */
        fun retrieve(params: InboxRetrieveParams): CompletableFuture<HttpResponseFor<Inbox>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            inboxId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Inbox>> =
            retrieve(inboxId, InboxRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /inboxes/{inboxId}`, but is otherwise the same as
         * [InboxServiceAsync.update].
         */
        fun update(inboxId: String): CompletableFuture<HttpResponseFor<InboxUpdateResponse>> =
            update(inboxId, InboxUpdateParams.none())

        /** @see update */
        fun update(
            inboxId: String,
            params: InboxUpdateParams = InboxUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxUpdateResponse>> =
            update(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see update */
        fun update(
            inboxId: String,
            params: InboxUpdateParams = InboxUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<InboxUpdateResponse>> =
            update(inboxId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: InboxUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxUpdateResponse>>

        /** @see update */
        fun update(
            params: InboxUpdateParams
        ): CompletableFuture<HttpResponseFor<InboxUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            inboxId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InboxUpdateResponse>> =
            update(inboxId, InboxUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /inboxes`, but is otherwise the same as
         * [InboxServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<InboxListPageAsync>> =
            list(InboxListParams.none())

        /** @see list */
        fun list(
            params: InboxListParams = InboxListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxListPageAsync>>

        /** @see list */
        fun list(
            params: InboxListParams = InboxListParams.none()
        ): CompletableFuture<HttpResponseFor<InboxListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<InboxListPageAsync>> =
            list(InboxListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /inboxes/{inboxId}`, but is otherwise the same as
         * [InboxServiceAsync.delete].
         */
        fun delete(inboxId: String): CompletableFuture<HttpResponseFor<InboxDeleteResponse>> =
            delete(inboxId, InboxDeleteParams.none())

        /** @see delete */
        fun delete(
            inboxId: String,
            params: InboxDeleteParams = InboxDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxDeleteResponse>> =
            delete(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see delete */
        fun delete(
            inboxId: String,
            params: InboxDeleteParams = InboxDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<InboxDeleteResponse>> =
            delete(inboxId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: InboxDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxDeleteResponse>>

        /** @see delete */
        fun delete(
            params: InboxDeleteParams
        ): CompletableFuture<HttpResponseFor<InboxDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            inboxId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InboxDeleteResponse>> =
            delete(inboxId, InboxDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /inboxes/{inboxId}/messages`, but is otherwise the
         * same as [InboxServiceAsync.send].
         */
        fun send(
            inboxId: String,
            params: InboxSendParams,
        ): CompletableFuture<HttpResponseFor<InboxSendResponse>> =
            send(inboxId, params, RequestOptions.none())

        /** @see send */
        fun send(
            inboxId: String,
            params: InboxSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxSendResponse>> =
            send(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see send */
        fun send(params: InboxSendParams): CompletableFuture<HttpResponseFor<InboxSendResponse>> =
            send(params, RequestOptions.none())

        /** @see send */
        fun send(
            params: InboxSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxSendResponse>>
    }
}
