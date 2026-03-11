// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.inboxes.Inbox
import com.nuntly.models.inboxes.InboxCreateParams
import com.nuntly.models.inboxes.InboxDeleteParams
import com.nuntly.models.inboxes.InboxDeleteResponse
import com.nuntly.models.inboxes.InboxListPage
import com.nuntly.models.inboxes.InboxListParams
import com.nuntly.models.inboxes.InboxRetrieveParams
import com.nuntly.models.inboxes.InboxSendParams
import com.nuntly.models.inboxes.InboxSendResponse
import com.nuntly.models.inboxes.InboxUpdateParams
import com.nuntly.models.inboxes.InboxUpdateResponse
import com.nuntly.services.blocking.inboxes.ThreadService
import java.util.function.Consumer

/**
 * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes to
 * namespaces or AI agents.
 */
interface InboxService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboxService

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    fun threads(): ThreadService

    /** Create a new inbox on a verified domain. */
    fun create(params: InboxCreateParams): Inbox = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InboxCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Inbox

    /** Retrieve an inbox with thread stats. */
    fun retrieve(inboxId: String): Inbox = retrieve(inboxId, InboxRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        inboxId: String,
        params: InboxRetrieveParams = InboxRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Inbox = retrieve(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(inboxId: String, params: InboxRetrieveParams = InboxRetrieveParams.none()): Inbox =
        retrieve(inboxId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InboxRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Inbox

    /** @see retrieve */
    fun retrieve(params: InboxRetrieveParams): Inbox = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(inboxId: String, requestOptions: RequestOptions): Inbox =
        retrieve(inboxId, InboxRetrieveParams.none(), requestOptions)

    /** Update an inbox. */
    fun update(inboxId: String): InboxUpdateResponse = update(inboxId, InboxUpdateParams.none())

    /** @see update */
    fun update(
        inboxId: String,
        params: InboxUpdateParams = InboxUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboxUpdateResponse = update(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see update */
    fun update(
        inboxId: String,
        params: InboxUpdateParams = InboxUpdateParams.none(),
    ): InboxUpdateResponse = update(inboxId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: InboxUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboxUpdateResponse

    /** @see update */
    fun update(params: InboxUpdateParams): InboxUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(inboxId: String, requestOptions: RequestOptions): InboxUpdateResponse =
        update(inboxId, InboxUpdateParams.none(), requestOptions)

    /** List all inboxes. */
    fun list(): InboxListPage = list(InboxListParams.none())

    /** @see list */
    fun list(
        params: InboxListParams = InboxListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboxListPage

    /** @see list */
    fun list(params: InboxListParams = InboxListParams.none()): InboxListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): InboxListPage =
        list(InboxListParams.none(), requestOptions)

    /** Soft-delete an inbox. */
    fun delete(inboxId: String): InboxDeleteResponse = delete(inboxId, InboxDeleteParams.none())

    /** @see delete */
    fun delete(
        inboxId: String,
        params: InboxDeleteParams = InboxDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboxDeleteResponse = delete(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see delete */
    fun delete(
        inboxId: String,
        params: InboxDeleteParams = InboxDeleteParams.none(),
    ): InboxDeleteResponse = delete(inboxId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InboxDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboxDeleteResponse

    /** @see delete */
    fun delete(params: InboxDeleteParams): InboxDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(inboxId: String, requestOptions: RequestOptions): InboxDeleteResponse =
        delete(inboxId, InboxDeleteParams.none(), requestOptions)

    /** Send a new message from an inbox. */
    fun send(inboxId: String, params: InboxSendParams): InboxSendResponse =
        send(inboxId, params, RequestOptions.none())

    /** @see send */
    fun send(
        inboxId: String,
        params: InboxSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboxSendResponse = send(params.toBuilder().inboxId(inboxId).build(), requestOptions)

    /** @see send */
    fun send(params: InboxSendParams): InboxSendResponse = send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: InboxSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboxSendResponse

    /** A view of [InboxService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboxService.WithRawResponse

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        fun threads(): ThreadService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /inboxes`, but is otherwise the same as
         * [InboxService.create].
         */
        @MustBeClosed
        fun create(params: InboxCreateParams): HttpResponseFor<Inbox> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: InboxCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Inbox>

        /**
         * Returns a raw HTTP response for `get /inboxes/{inboxId}`, but is otherwise the same as
         * [InboxService.retrieve].
         */
        @MustBeClosed
        fun retrieve(inboxId: String): HttpResponseFor<Inbox> =
            retrieve(inboxId, InboxRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            inboxId: String,
            params: InboxRetrieveParams = InboxRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Inbox> =
            retrieve(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            inboxId: String,
            params: InboxRetrieveParams = InboxRetrieveParams.none(),
        ): HttpResponseFor<Inbox> = retrieve(inboxId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: InboxRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Inbox>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: InboxRetrieveParams): HttpResponseFor<Inbox> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(inboxId: String, requestOptions: RequestOptions): HttpResponseFor<Inbox> =
            retrieve(inboxId, InboxRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /inboxes/{inboxId}`, but is otherwise the same as
         * [InboxService.update].
         */
        @MustBeClosed
        fun update(inboxId: String): HttpResponseFor<InboxUpdateResponse> =
            update(inboxId, InboxUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            inboxId: String,
            params: InboxUpdateParams = InboxUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboxUpdateResponse> =
            update(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            inboxId: String,
            params: InboxUpdateParams = InboxUpdateParams.none(),
        ): HttpResponseFor<InboxUpdateResponse> = update(inboxId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: InboxUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboxUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: InboxUpdateParams): HttpResponseFor<InboxUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            inboxId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxUpdateResponse> =
            update(inboxId, InboxUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /inboxes`, but is otherwise the same as
         * [InboxService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<InboxListPage> = list(InboxListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: InboxListParams = InboxListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboxListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: InboxListParams = InboxListParams.none()): HttpResponseFor<InboxListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<InboxListPage> =
            list(InboxListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /inboxes/{inboxId}`, but is otherwise the same as
         * [InboxService.delete].
         */
        @MustBeClosed
        fun delete(inboxId: String): HttpResponseFor<InboxDeleteResponse> =
            delete(inboxId, InboxDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            inboxId: String,
            params: InboxDeleteParams = InboxDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboxDeleteResponse> =
            delete(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            inboxId: String,
            params: InboxDeleteParams = InboxDeleteParams.none(),
        ): HttpResponseFor<InboxDeleteResponse> = delete(inboxId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: InboxDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboxDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: InboxDeleteParams): HttpResponseFor<InboxDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            inboxId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxDeleteResponse> =
            delete(inboxId, InboxDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /inboxes/{inboxId}/messages`, but is otherwise the
         * same as [InboxService.send].
         */
        @MustBeClosed
        fun send(inboxId: String, params: InboxSendParams): HttpResponseFor<InboxSendResponse> =
            send(inboxId, params, RequestOptions.none())

        /** @see send */
        @MustBeClosed
        fun send(
            inboxId: String,
            params: InboxSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboxSendResponse> =
            send(params.toBuilder().inboxId(inboxId).build(), requestOptions)

        /** @see send */
        @MustBeClosed
        fun send(params: InboxSendParams): HttpResponseFor<InboxSendResponse> =
            send(params, RequestOptions.none())

        /** @see send */
        @MustBeClosed
        fun send(
            params: InboxSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboxSendResponse>
    }
}
