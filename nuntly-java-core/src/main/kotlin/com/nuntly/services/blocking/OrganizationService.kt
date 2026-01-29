// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.organizations.OrganizationListPage
import com.nuntly.models.organizations.OrganizationListParams
import com.nuntly.models.organizations.OrganizationRetrieveParams
import com.nuntly.models.organizations.OrganizationRetrieveResponse
import com.nuntly.services.blocking.organizations.UsageService
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

    fun usage(): UsageService

    /** Retrieve organization */
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

    /** Retrieve organizations */
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
