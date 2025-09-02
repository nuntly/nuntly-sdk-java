// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking.organizations

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.models.organizations.memberships.MembershipListPage
import com.nuntly.api.models.organizations.memberships.MembershipListParams
import com.nuntly.api.models.organizations.memberships.MembershipRevokeParams
import com.nuntly.api.models.organizations.memberships.MembershipRevokeResponse
import java.util.function.Consumer

interface MembershipService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MembershipService

    /** Return the organization memberships */
    fun list(id: String): MembershipListPage = list(id, MembershipListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: MembershipListParams = MembershipListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MembershipListPage = list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: MembershipListParams = MembershipListParams.none(),
    ): MembershipListPage = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: MembershipListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MembershipListPage

    /** @see list */
    fun list(params: MembershipListParams): MembershipListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(id: String, requestOptions: RequestOptions): MembershipListPage =
        list(id, MembershipListParams.none(), requestOptions)

    /** Revoke a user from an organization */
    fun revoke(userId: String, params: MembershipRevokeParams): MembershipRevokeResponse =
        revoke(userId, params, RequestOptions.none())

    /** @see revoke */
    fun revoke(
        userId: String,
        params: MembershipRevokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MembershipRevokeResponse = revoke(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see revoke */
    fun revoke(params: MembershipRevokeParams): MembershipRevokeResponse =
        revoke(params, RequestOptions.none())

    /** @see revoke */
    fun revoke(
        params: MembershipRevokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MembershipRevokeResponse

    /** A view of [MembershipService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MembershipService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}/memberships`, but is otherwise
         * the same as [MembershipService.list].
         */
        @MustBeClosed
        fun list(id: String): HttpResponseFor<MembershipListPage> =
            list(id, MembershipListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: MembershipListParams = MembershipListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MembershipListPage> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: MembershipListParams = MembershipListParams.none(),
        ): HttpResponseFor<MembershipListPage> = list(id, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: MembershipListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MembershipListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: MembershipListParams): HttpResponseFor<MembershipListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(id: String, requestOptions: RequestOptions): HttpResponseFor<MembershipListPage> =
            list(id, MembershipListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organizations/{id}/memberships/{user_id}`, but
         * is otherwise the same as [MembershipService.revoke].
         */
        @MustBeClosed
        fun revoke(
            userId: String,
            params: MembershipRevokeParams,
        ): HttpResponseFor<MembershipRevokeResponse> = revoke(userId, params, RequestOptions.none())

        /** @see revoke */
        @MustBeClosed
        fun revoke(
            userId: String,
            params: MembershipRevokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MembershipRevokeResponse> =
            revoke(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see revoke */
        @MustBeClosed
        fun revoke(params: MembershipRevokeParams): HttpResponseFor<MembershipRevokeResponse> =
            revoke(params, RequestOptions.none())

        /** @see revoke */
        @MustBeClosed
        fun revoke(
            params: MembershipRevokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MembershipRevokeResponse>
    }
}
