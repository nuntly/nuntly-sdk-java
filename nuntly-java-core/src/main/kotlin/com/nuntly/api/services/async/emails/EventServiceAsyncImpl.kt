// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async.emails

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
import com.nuntly.api.core.prepareAsync
import com.nuntly.api.models.DataEnvelope
import com.nuntly.api.models.emails.events.EventListParams
import com.nuntly.api.models.emails.events.EventListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class EventServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    EventServiceAsync {

    private val withRawResponse: EventServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): EventServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventServiceAsync =
        EventServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: EventListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<EventListResponse>> =
        // get /emails/{id}/events
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EventServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventServiceAsync.WithRawResponse =
            EventServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<DataEnvelope<List<EventListResponse>>> =
            jsonHandler<DataEnvelope<List<EventListResponse>>>(clientOptions.jsonMapper)

        override fun list(
            params: EventListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<EventListResponse>>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("emails", params._pathParam(0), "events")
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
                            .data()
                    }
                }
        }
    }
}
