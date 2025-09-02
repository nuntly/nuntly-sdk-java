// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async.organizations

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
import com.nuntly.api.core.prepareAsync
import com.nuntly.api.models.DataEnvelope
import com.nuntly.api.models.organizations.invitations.InvitationDeleteParams
import com.nuntly.api.models.organizations.invitations.InvitationDeleteResponse
import com.nuntly.api.models.organizations.invitations.InvitationListPageAsync
import com.nuntly.api.models.organizations.invitations.InvitationListPageResponse
import com.nuntly.api.models.organizations.invitations.InvitationListParams
import com.nuntly.api.models.organizations.invitations.InvitationSendParams
import com.nuntly.api.models.organizations.invitations.InvitationSendResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class InvitationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    InvitationServiceAsync {

    private val withRawResponse: InvitationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InvitationServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvitationServiceAsync =
        InvitationServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: InvitationListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvitationListPageAsync> =
        // get /organizations/{id}/invitations
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: InvitationDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvitationDeleteResponse> =
        // delete /organizations/{id}/invitations/{invitation_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun send(
        params: InvitationSendParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvitationSendResponse> =
        // post /organizations/{id}/invitations
        withRawResponse().send(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InvitationServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvitationServiceAsync.WithRawResponse =
            InvitationServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<InvitationListPageResponse> =
            jsonHandler<InvitationListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: InvitationListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvitationListPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organizations", params._pathParam(0), "invitations")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                InvitationListPageAsync.builder()
                                    .service(InvitationServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<DataEnvelope<InvitationDeleteResponse>> =
            jsonHandler<DataEnvelope<InvitationDeleteResponse>>(clientOptions.jsonMapper)

        override fun delete(
            params: InvitationDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvitationDeleteResponse>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
        }

        private val sendHandler: Handler<DataEnvelope<InvitationSendResponse>> =
            jsonHandler<DataEnvelope<InvitationSendResponse>>(clientOptions.jsonMapper)

        override fun send(
            params: InvitationSendParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvitationSendResponse>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
