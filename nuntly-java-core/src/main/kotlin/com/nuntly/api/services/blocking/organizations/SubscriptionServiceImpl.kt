// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking.organizations

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
import com.nuntly.api.core.http.parseable
import com.nuntly.api.core.prepare
import com.nuntly.api.models.DataEnvelope
import com.nuntly.api.models.organizations.subscriptions.SubscriptionListParams
import com.nuntly.api.models.organizations.subscriptions.SubscriptionListResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SubscriptionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SubscriptionService {

    private val withRawResponse: SubscriptionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SubscriptionService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubscriptionService =
        SubscriptionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: SubscriptionListParams,
        requestOptions: RequestOptions,
    ): List<SubscriptionListResponse> =
        // get /organizations/{id}/subscriptions
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SubscriptionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SubscriptionService.WithRawResponse =
            SubscriptionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<DataEnvelope<List<SubscriptionListResponse>>> =
            jsonHandler<DataEnvelope<List<SubscriptionListResponse>>>(clientOptions.jsonMapper)

        override fun list(
            params: SubscriptionListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<SubscriptionListResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organizations", params._pathParam(0), "subscriptions")
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
                    .data()
            }
        }
    }
}
