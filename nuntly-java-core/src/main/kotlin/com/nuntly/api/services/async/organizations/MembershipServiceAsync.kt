// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async.organizations

import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.models.organizations.memberships.MembershipListPageAsync
import com.nuntly.api.models.organizations.memberships.MembershipListParams
import com.nuntly.api.models.organizations.memberships.MembershipRevokeParams
import com.nuntly.api.models.organizations.memberships.MembershipRevokeResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface MembershipServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MembershipServiceAsync

    /** Return the organization memberships */
    fun list(id: String): CompletableFuture<MembershipListPageAsync> =
        list(id, MembershipListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: MembershipListParams = MembershipListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MembershipListPageAsync> =
        list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: MembershipListParams = MembershipListParams.none(),
    ): CompletableFuture<MembershipListPageAsync> = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: MembershipListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MembershipListPageAsync>

    /** @see list */
    fun list(params: MembershipListParams): CompletableFuture<MembershipListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MembershipListPageAsync> =
        list(id, MembershipListParams.none(), requestOptions)

    /** Revoke a user from an organization */
    fun revoke(
        userId: String,
        params: MembershipRevokeParams,
    ): CompletableFuture<MembershipRevokeResponse> = revoke(userId, params, RequestOptions.none())

    /** @see revoke */
    fun revoke(
        userId: String,
        params: MembershipRevokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MembershipRevokeResponse> =
        revoke(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see revoke */
    fun revoke(params: MembershipRevokeParams): CompletableFuture<MembershipRevokeResponse> =
        revoke(params, RequestOptions.none())

    /** @see revoke */
    fun revoke(
        params: MembershipRevokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MembershipRevokeResponse>

    /**
     * A view of [MembershipServiceAsync] that provides access to raw HTTP responses for each
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
        ): MembershipServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}/memberships`, but is otherwise
         * the same as [MembershipServiceAsync.list].
         */
        fun list(id: String): CompletableFuture<HttpResponseFor<MembershipListPageAsync>> =
            list(id, MembershipListParams.none())

        /** @see list */
        fun list(
            id: String,
            params: MembershipListParams = MembershipListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MembershipListPageAsync>> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        fun list(
            id: String,
            params: MembershipListParams = MembershipListParams.none(),
        ): CompletableFuture<HttpResponseFor<MembershipListPageAsync>> =
            list(id, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: MembershipListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MembershipListPageAsync>>

        /** @see list */
        fun list(
            params: MembershipListParams
        ): CompletableFuture<HttpResponseFor<MembershipListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MembershipListPageAsync>> =
            list(id, MembershipListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organizations/{id}/memberships/{user_id}`, but
         * is otherwise the same as [MembershipServiceAsync.revoke].
         */
        fun revoke(
            userId: String,
            params: MembershipRevokeParams,
        ): CompletableFuture<HttpResponseFor<MembershipRevokeResponse>> =
            revoke(userId, params, RequestOptions.none())

        /** @see revoke */
        fun revoke(
            userId: String,
            params: MembershipRevokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MembershipRevokeResponse>> =
            revoke(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see revoke */
        fun revoke(
            params: MembershipRevokeParams
        ): CompletableFuture<HttpResponseFor<MembershipRevokeResponse>> =
            revoke(params, RequestOptions.none())

        /** @see revoke */
        fun revoke(
            params: MembershipRevokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MembershipRevokeResponse>>
    }
}
