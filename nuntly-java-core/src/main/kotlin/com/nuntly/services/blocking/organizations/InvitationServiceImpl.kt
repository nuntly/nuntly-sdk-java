// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.organizations

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.checkRequired
import com.nuntly.core.handlers.errorBodyHandler
import com.nuntly.core.handlers.errorHandler
import com.nuntly.core.handlers.jsonHandler
import com.nuntly.core.http.HttpMethod
import com.nuntly.core.http.HttpRequest
import com.nuntly.core.http.HttpResponse
import com.nuntly.core.http.HttpResponse.Handler
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.core.http.json
import com.nuntly.core.http.parseable
import com.nuntly.core.prepare
import com.nuntly.models.DataEnvelope
import com.nuntly.models.organizations.invitations.InvitationDeleteParams
import com.nuntly.models.organizations.invitations.InvitationDeleteResponse
import com.nuntly.models.organizations.invitations.InvitationListPage
import com.nuntly.models.organizations.invitations.InvitationListPageResponse
import com.nuntly.models.organizations.invitations.InvitationListParams
import com.nuntly.models.organizations.invitations.InvitationSendParams
import com.nuntly.models.organizations.invitations.InvitationSendResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class InvitationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    InvitationService {

    private val withRawResponse: InvitationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InvitationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvitationService =
        InvitationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: InvitationListParams,
        requestOptions: RequestOptions,
    ): InvitationListPage =
        // get /organizations/{id}/invitations
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: InvitationDeleteParams,
        requestOptions: RequestOptions,
    ): InvitationDeleteResponse =
        // delete /organizations/{id}/invitations/{invitation_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun send(
        params: InvitationSendParams,
        requestOptions: RequestOptions,
    ): InvitationSendResponse =
        // post /organizations/{id}/invitations
        withRawResponse().send(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InvitationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvitationService.WithRawResponse =
            InvitationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<InvitationListPageResponse> =
            jsonHandler<InvitationListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: InvitationListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvitationListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organizations", params._pathParam(0), "invitations")
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
                        InvitationListPage.builder()
                            .service(InvitationServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<DataEnvelope<InvitationDeleteResponse>> =
            jsonHandler<DataEnvelope<InvitationDeleteResponse>>(clientOptions.jsonMapper)

        override fun delete(
            params: InvitationDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvitationDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("invitationId", params.invitationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organizations",
                        params._pathParam(0),
                        "invitations",
                        params._pathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .data()
            }
        }

        private val sendHandler: Handler<DataEnvelope<InvitationSendResponse>> =
            jsonHandler<DataEnvelope<InvitationSendResponse>>(clientOptions.jsonMapper)

        override fun send(
            params: InvitationSendParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvitationSendResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organizations", params._pathParam(0), "invitations")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { sendHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .data()
            }
        }
    }
}
