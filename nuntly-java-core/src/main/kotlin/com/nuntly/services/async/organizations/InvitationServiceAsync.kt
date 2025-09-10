// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.organizations

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.organizations.invitations.InvitationDeleteParams
import com.nuntly.models.organizations.invitations.InvitationDeleteResponse
import com.nuntly.models.organizations.invitations.InvitationListPageAsync
import com.nuntly.models.organizations.invitations.InvitationListParams
import com.nuntly.models.organizations.invitations.InvitationSendParams
import com.nuntly.models.organizations.invitations.InvitationSendResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface InvitationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvitationServiceAsync

    /** Return the organization invitations */
    fun list(id: String): CompletableFuture<InvitationListPageAsync> =
        list(id, InvitationListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: InvitationListParams = InvitationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvitationListPageAsync> =
        list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: InvitationListParams = InvitationListParams.none(),
    ): CompletableFuture<InvitationListPageAsync> = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: InvitationListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvitationListPageAsync>

    /** @see list */
    fun list(params: InvitationListParams): CompletableFuture<InvitationListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvitationListPageAsync> =
        list(id, InvitationListParams.none(), requestOptions)

    /** Delete an invitation */
    fun delete(
        invitationId: String,
        params: InvitationDeleteParams,
    ): CompletableFuture<InvitationDeleteResponse> =
        delete(invitationId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        invitationId: String,
        params: InvitationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvitationDeleteResponse> =
        delete(params.toBuilder().invitationId(invitationId).build(), requestOptions)

    /** @see delete */
    fun delete(params: InvitationDeleteParams): CompletableFuture<InvitationDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InvitationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvitationDeleteResponse>

    /** Send an invitation to someone you wish to invite to join your organization */
    fun send(id: String, params: InvitationSendParams): CompletableFuture<InvitationSendResponse> =
        send(id, params, RequestOptions.none())

    /** @see send */
    fun send(
        id: String,
        params: InvitationSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvitationSendResponse> =
        send(params.toBuilder().id(id).build(), requestOptions)

    /** @see send */
    fun send(params: InvitationSendParams): CompletableFuture<InvitationSendResponse> =
        send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: InvitationSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvitationSendResponse>

    /**
     * A view of [InvitationServiceAsync] that provides access to raw HTTP responses for each
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
        ): InvitationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}/invitations`, but is otherwise
         * the same as [InvitationServiceAsync.list].
         */
        fun list(id: String): CompletableFuture<HttpResponseFor<InvitationListPageAsync>> =
            list(id, InvitationListParams.none())

        /** @see list */
        fun list(
            id: String,
            params: InvitationListParams = InvitationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvitationListPageAsync>> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        fun list(
            id: String,
            params: InvitationListParams = InvitationListParams.none(),
        ): CompletableFuture<HttpResponseFor<InvitationListPageAsync>> =
            list(id, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: InvitationListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvitationListPageAsync>>

        /** @see list */
        fun list(
            params: InvitationListParams
        ): CompletableFuture<HttpResponseFor<InvitationListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvitationListPageAsync>> =
            list(id, InvitationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organizations/{id}/invitations/{invitation_id}`,
         * but is otherwise the same as [InvitationServiceAsync.delete].
         */
        fun delete(
            invitationId: String,
            params: InvitationDeleteParams,
        ): CompletableFuture<HttpResponseFor<InvitationDeleteResponse>> =
            delete(invitationId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            invitationId: String,
            params: InvitationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvitationDeleteResponse>> =
            delete(params.toBuilder().invitationId(invitationId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: InvitationDeleteParams
        ): CompletableFuture<HttpResponseFor<InvitationDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: InvitationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvitationDeleteResponse>>

        /**
         * Returns a raw HTTP response for `post /organizations/{id}/invitations`, but is otherwise
         * the same as [InvitationServiceAsync.send].
         */
        fun send(
            id: String,
            params: InvitationSendParams,
        ): CompletableFuture<HttpResponseFor<InvitationSendResponse>> =
            send(id, params, RequestOptions.none())

        /** @see send */
        fun send(
            id: String,
            params: InvitationSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvitationSendResponse>> =
            send(params.toBuilder().id(id).build(), requestOptions)

        /** @see send */
        fun send(
            params: InvitationSendParams
        ): CompletableFuture<HttpResponseFor<InvitationSendResponse>> =
            send(params, RequestOptions.none())

        /** @see send */
        fun send(
            params: InvitationSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvitationSendResponse>>
    }
}
