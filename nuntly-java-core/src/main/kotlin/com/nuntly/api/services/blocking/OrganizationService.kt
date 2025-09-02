// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.models.organizations.OrganizationListPage
import com.nuntly.api.models.organizations.OrganizationListParams
import com.nuntly.api.models.organizations.OrganizationRetrieveParams
import com.nuntly.api.models.organizations.OrganizationRetrieveResponse
import com.nuntly.api.models.organizations.OrganizationUpdateParams
import com.nuntly.api.models.organizations.OrganizationUpdateResponse
import com.nuntly.api.services.blocking.organizations.InvitationService
import com.nuntly.api.services.blocking.organizations.MembershipService
import com.nuntly.api.services.blocking.organizations.SubscriptionService
import com.nuntly.api.services.blocking.organizations.UsageService
import java.util.function.Consumer

interface OrganizationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationService

    fun memberships(): MembershipService

    fun invitations(): InvitationService

    fun subscriptions(): SubscriptionService

    fun usage(): UsageService

    /** Return the organization */
    fun retrieve(id: String): OrganizationRetrieveResponse =
        retrieve(id, OrganizationRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: OrganizationRetrieveParams = OrganizationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: OrganizationRetrieveParams = OrganizationRetrieveParams.none(),
    ): OrganizationRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OrganizationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: OrganizationRetrieveParams): OrganizationRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): OrganizationRetrieveResponse =
        retrieve(id, OrganizationRetrieveParams.none(), requestOptions)

    /** Patch the organization */
    fun update(id: String, params: OrganizationUpdateParams): OrganizationUpdateResponse =
        update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        params: OrganizationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationUpdateResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(params: OrganizationUpdateParams): OrganizationUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: OrganizationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationUpdateResponse

    /** Return the organizations that the current user is a member */
    fun list(): OrganizationListPage = list(OrganizationListParams.none())

    /** @see list */
    fun list(
        params: OrganizationListParams = OrganizationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationListPage

    /** @see list */
    fun list(params: OrganizationListParams = OrganizationListParams.none()): OrganizationListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): OrganizationListPage =
        list(OrganizationListParams.none(), requestOptions)

    /**
     * A view of [OrganizationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationService.WithRawResponse

        fun memberships(): MembershipService.WithRawResponse

        fun invitations(): InvitationService.WithRawResponse

        fun subscriptions(): SubscriptionService.WithRawResponse

        fun usage(): UsageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organizations/{id}`, but is otherwise the same as
         * [OrganizationService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<OrganizationRetrieveResponse> =
            retrieve(id, OrganizationRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: OrganizationRetrieveParams = OrganizationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: OrganizationRetrieveParams = OrganizationRetrieveParams.none(),
        ): HttpResponseFor<OrganizationRetrieveResponse> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: OrganizationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: OrganizationRetrieveParams
        ): HttpResponseFor<OrganizationRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationRetrieveResponse> =
            retrieve(id, OrganizationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /organizations/{id}`, but is otherwise the same as
         * [OrganizationService.update].
         */
        @MustBeClosed
        fun update(
            id: String,
            params: OrganizationUpdateParams,
        ): HttpResponseFor<OrganizationUpdateResponse> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: OrganizationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationUpdateResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: OrganizationUpdateParams): HttpResponseFor<OrganizationUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: OrganizationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationUpdateResponse>

        /**
         * Returns a raw HTTP response for `get /organizations`, but is otherwise the same as
         * [OrganizationService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<OrganizationListPage> = list(OrganizationListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: OrganizationListParams = OrganizationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: OrganizationListParams = OrganizationListParams.none()
        ): HttpResponseFor<OrganizationListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<OrganizationListPage> =
            list(OrganizationListParams.none(), requestOptions)
    }
}
