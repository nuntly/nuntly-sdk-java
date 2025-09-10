// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.organizations

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.organizations.invitations.InvitationDeleteParams
import com.nuntly.models.organizations.invitations.InvitationDeleteResponse
import com.nuntly.models.organizations.invitations.InvitationListPage
import com.nuntly.models.organizations.invitations.InvitationListParams
import com.nuntly.models.organizations.invitations.InvitationSendParams
import com.nuntly.models.organizations.invitations.InvitationSendResponse
import java.util.function.Consumer

interface InvitationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvitationService

    /** Return the organization invitations */
    fun list(id: String): InvitationListPage = list(id, InvitationListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: InvitationListParams = InvitationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationListPage = list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: InvitationListParams = InvitationListParams.none(),
    ): InvitationListPage = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: InvitationListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationListPage

    /** @see list */
    fun list(params: InvitationListParams): InvitationListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(id: String, requestOptions: RequestOptions): InvitationListPage =
        list(id, InvitationListParams.none(), requestOptions)

    /** Delete an invitation */
    fun delete(invitationId: String, params: InvitationDeleteParams): InvitationDeleteResponse =
        delete(invitationId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        invitationId: String,
        params: InvitationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationDeleteResponse =
        delete(params.toBuilder().invitationId(invitationId).build(), requestOptions)

    /** @see delete */
    fun delete(params: InvitationDeleteParams): InvitationDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InvitationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationDeleteResponse

    /** Send an invitation to someone you wish to invite to join your organization */
    fun send(id: String, params: InvitationSendParams): InvitationSendResponse =
        send(id, params, RequestOptions.none())

    /** @see send */
    fun send(
        id: String,
        params: InvitationSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationSendResponse = send(params.toBuilder().id(id).build(), requestOptions)

    /** @see send */
    fun send(params: InvitationSendParams): InvitationSendResponse =
        send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: InvitationSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationSendResponse

    /** A view of [InvitationService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvitationService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}/invitations`, but is otherwise
         * the same as [InvitationService.list].
         */
        @MustBeClosed
        fun list(id: String): HttpResponseFor<InvitationListPage> =
            list(id, InvitationListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: InvitationListParams = InvitationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationListPage> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: InvitationListParams = InvitationListParams.none(),
        ): HttpResponseFor<InvitationListPage> = list(id, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: InvitationListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: InvitationListParams): HttpResponseFor<InvitationListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(id: String, requestOptions: RequestOptions): HttpResponseFor<InvitationListPage> =
            list(id, InvitationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organizations/{id}/invitations/{invitation_id}`,
         * but is otherwise the same as [InvitationService.delete].
         */
        @MustBeClosed
        fun delete(
            invitationId: String,
            params: InvitationDeleteParams,
        ): HttpResponseFor<InvitationDeleteResponse> =
            delete(invitationId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            invitationId: String,
            params: InvitationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationDeleteResponse> =
            delete(params.toBuilder().invitationId(invitationId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: InvitationDeleteParams): HttpResponseFor<InvitationDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: InvitationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationDeleteResponse>

        /**
         * Returns a raw HTTP response for `post /organizations/{id}/invitations`, but is otherwise
         * the same as [InvitationService.send].
         */
        @MustBeClosed
        fun send(
            id: String,
            params: InvitationSendParams,
        ): HttpResponseFor<InvitationSendResponse> = send(id, params, RequestOptions.none())

        /** @see send */
        @MustBeClosed
        fun send(
            id: String,
            params: InvitationSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationSendResponse> =
            send(params.toBuilder().id(id).build(), requestOptions)

        /** @see send */
        @MustBeClosed
        fun send(params: InvitationSendParams): HttpResponseFor<InvitationSendResponse> =
            send(params, RequestOptions.none())

        /** @see send */
        @MustBeClosed
        fun send(
            params: InvitationSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationSendResponse>
    }
}
