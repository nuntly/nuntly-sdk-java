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
import com.nuntly.api.models.organizations.memberships.MembershipListPageAsync
import com.nuntly.api.models.organizations.memberships.MembershipListPageResponse
import com.nuntly.api.models.organizations.memberships.MembershipListParams
import com.nuntly.api.models.organizations.memberships.MembershipRevokeParams
import com.nuntly.api.models.organizations.memberships.MembershipRevokeResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class MembershipServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MembershipServiceAsync {

    private val withRawResponse: MembershipServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MembershipServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MembershipServiceAsync =
        MembershipServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: MembershipListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MembershipListPageAsync> =
        // get /organizations/{id}/memberships
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun revoke(
        params: MembershipRevokeParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MembershipRevokeResponse> =
        // delete /organizations/{id}/memberships/{user_id}
        withRawResponse().revoke(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MembershipServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MembershipServiceAsync.WithRawResponse =
            MembershipServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<MembershipListPageResponse> =
            jsonHandler<MembershipListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: MembershipListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MembershipListPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organizations", params._pathParam(0), "memberships")
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
                                MembershipListPageAsync.builder()
                                    .service(MembershipServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val revokeHandler: Handler<DataEnvelope<MembershipRevokeResponse>> =
            jsonHandler<DataEnvelope<MembershipRevokeResponse>>(clientOptions.jsonMapper)

        override fun revoke(
            params: MembershipRevokeParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MembershipRevokeResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organizations",
                        params._pathParam(0),
                        "memberships",
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
                            .use { revokeHandler.handle(it) }
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
