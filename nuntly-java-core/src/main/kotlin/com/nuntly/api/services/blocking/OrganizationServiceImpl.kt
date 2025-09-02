// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking

import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.checkRequired
import com.nuntly.api.core.handlers.errorBodyHandler
import com.nuntly.api.core.handlers.errorHandler
import com.nuntly.api.core.handlers.jsonHandler
import com.nuntly.api.core.http.HttpMethod
import com.nuntly.api.core.http.HttpRequest
import com.nuntly.api.core.http.HttpResponse
import com.nuntly.api.core.http.HttpResponse.Handler
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.core.http.json
import com.nuntly.api.core.http.parseable
import com.nuntly.api.core.prepare
import com.nuntly.api.models.DataEnvelope
import com.nuntly.api.models.organizations.OrganizationListPage
import com.nuntly.api.models.organizations.OrganizationListPageResponse
import com.nuntly.api.models.organizations.OrganizationListParams
import com.nuntly.api.models.organizations.OrganizationRetrieveParams
import com.nuntly.api.models.organizations.OrganizationRetrieveResponse
import com.nuntly.api.models.organizations.OrganizationUpdateParams
import com.nuntly.api.models.organizations.OrganizationUpdateResponse
import com.nuntly.api.services.blocking.organizations.InvitationService
import com.nuntly.api.services.blocking.organizations.InvitationServiceImpl
import com.nuntly.api.services.blocking.organizations.MembershipService
import com.nuntly.api.services.blocking.organizations.MembershipServiceImpl
import com.nuntly.api.services.blocking.organizations.SubscriptionService
import com.nuntly.api.services.blocking.organizations.SubscriptionServiceImpl
import com.nuntly.api.services.blocking.organizations.UsageService
import com.nuntly.api.services.blocking.organizations.UsageServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OrganizationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrganizationService {

    private val withRawResponse: OrganizationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val memberships: MembershipService by lazy { MembershipServiceImpl(clientOptions) }

    private val invitations: InvitationService by lazy { InvitationServiceImpl(clientOptions) }

    private val subscriptions: SubscriptionService by lazy {
        SubscriptionServiceImpl(clientOptions)
    }

    private val usage: UsageService by lazy { UsageServiceImpl(clientOptions) }

    override fun withRawResponse(): OrganizationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationService =
        OrganizationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun memberships(): MembershipService = memberships

    override fun invitations(): InvitationService = invitations

    override fun subscriptions(): SubscriptionService = subscriptions

    override fun usage(): UsageService = usage

    override fun retrieve(
        params: OrganizationRetrieveParams,
        requestOptions: RequestOptions,
    ): OrganizationRetrieveResponse =
        // get /organizations/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: OrganizationUpdateParams,
        requestOptions: RequestOptions,
    ): OrganizationUpdateResponse =
        // patch /organizations/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: OrganizationListParams,
        requestOptions: RequestOptions,
    ): OrganizationListPage =
        // get /organizations
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrganizationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val memberships: MembershipService.WithRawResponse by lazy {
            MembershipServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val invitations: InvitationService.WithRawResponse by lazy {
            InvitationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val subscriptions: SubscriptionService.WithRawResponse by lazy {
            SubscriptionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val usage: UsageService.WithRawResponse by lazy {
            UsageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationService.WithRawResponse =
            OrganizationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun memberships(): MembershipService.WithRawResponse = memberships

        override fun invitations(): InvitationService.WithRawResponse = invitations

        override fun subscriptions(): SubscriptionService.WithRawResponse = subscriptions

        override fun usage(): UsageService.WithRawResponse = usage

        private val retrieveHandler: Handler<DataEnvelope<OrganizationRetrieveResponse>> =
            jsonHandler<DataEnvelope<OrganizationRetrieveResponse>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: OrganizationRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organizations", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .data()
            }
        }

        private val updateHandler: Handler<DataEnvelope<OrganizationUpdateResponse>> =
            jsonHandler<DataEnvelope<OrganizationUpdateResponse>>(clientOptions.jsonMapper)

        override fun update(
            params: OrganizationUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organizations", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .data()
            }
        }

        private val listHandler: Handler<OrganizationListPageResponse> =
            jsonHandler<OrganizationListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: OrganizationListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organizations")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        OrganizationListPage.builder()
                            .service(OrganizationServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
