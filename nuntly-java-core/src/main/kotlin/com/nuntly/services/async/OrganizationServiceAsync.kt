// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.organizations.OrganizationListPageAsync
import com.nuntly.models.organizations.OrganizationListParams
import com.nuntly.models.organizations.OrganizationRetrieveParams
import com.nuntly.models.organizations.OrganizationRetrieveResponse
import com.nuntly.models.organizations.OrganizationUpdateParams
import com.nuntly.models.organizations.OrganizationUpdateResponse
import com.nuntly.services.async.organizations.InvitationServiceAsync
import com.nuntly.services.async.organizations.MembershipServiceAsync
import com.nuntly.services.async.organizations.SubscriptionServiceAsync
import com.nuntly.services.async.organizations.UsageServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface OrganizationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationServiceAsync

    fun memberships(): MembershipServiceAsync

    fun invitations(): InvitationServiceAsync

    fun subscriptions(): SubscriptionServiceAsync

    fun usage(): UsageServiceAsync

    /** Return the organization */
    fun retrieve(id: String): CompletableFuture<OrganizationRetrieveResponse> =
        retrieve(id, OrganizationRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: OrganizationRetrieveParams = OrganizationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: OrganizationRetrieveParams = OrganizationRetrieveParams.none(),
    ): CompletableFuture<OrganizationRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OrganizationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: OrganizationRetrieveParams
    ): CompletableFuture<OrganizationRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrganizationRetrieveResponse> =
        retrieve(id, OrganizationRetrieveParams.none(), requestOptions)

    /** Patch the organization */
    fun update(
        id: String,
        params: OrganizationUpdateParams,
    ): CompletableFuture<OrganizationUpdateResponse> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        params: OrganizationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(params: OrganizationUpdateParams): CompletableFuture<OrganizationUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: OrganizationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationUpdateResponse>

    /** Return the organizations that the current user is a member */
    fun list(): CompletableFuture<OrganizationListPageAsync> = list(OrganizationListParams.none())

    /** @see list */
    fun list(
        params: OrganizationListParams = OrganizationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationListPageAsync>

    /** @see list */
    fun list(
        params: OrganizationListParams = OrganizationListParams.none()
    ): CompletableFuture<OrganizationListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<OrganizationListPageAsync> =
        list(OrganizationListParams.none(), requestOptions)

    /**
     * A view of [OrganizationServiceAsync] that provides access to raw HTTP responses for each
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
        ): OrganizationServiceAsync.WithRawResponse

        fun memberships(): MembershipServiceAsync.WithRawResponse

        fun invitations(): InvitationServiceAsync.WithRawResponse

        fun subscriptions(): SubscriptionServiceAsync.WithRawResponse

        fun usage(): UsageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}`, but is otherwise the same as
         * [OrganizationServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<OrganizationRetrieveResponse>> =
            retrieve(id, OrganizationRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: OrganizationRetrieveParams = OrganizationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: OrganizationRetrieveParams = OrganizationRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: OrganizationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: OrganizationRetrieveParams
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveResponse>> =
            retrieve(id, OrganizationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /organizations/{id}`, but is otherwise the same as
         * [OrganizationServiceAsync.update].
         */
        fun update(
            id: String,
            params: OrganizationUpdateParams,
        ): CompletableFuture<HttpResponseFor<OrganizationUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            params: OrganizationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            params: OrganizationUpdateParams
        ): CompletableFuture<HttpResponseFor<OrganizationUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: OrganizationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationUpdateResponse>>

        /**
         * Returns a raw HTTP response for `get /organizations`, but is otherwise the same as
         * [OrganizationServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<OrganizationListPageAsync>> =
            list(OrganizationListParams.none())

        /** @see list */
        fun list(
            params: OrganizationListParams = OrganizationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationListPageAsync>>

        /** @see list */
        fun list(
            params: OrganizationListParams = OrganizationListParams.none()
        ): CompletableFuture<HttpResponseFor<OrganizationListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<OrganizationListPageAsync>> =
            list(OrganizationListParams.none(), requestOptions)
    }
}
