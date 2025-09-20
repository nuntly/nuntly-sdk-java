// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.webhooks

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
import com.nuntly.models.webhooks.events.EventDeliveriesParams
import com.nuntly.models.webhooks.events.EventDeliveriesResponse
import com.nuntly.models.webhooks.events.EventListPage
import com.nuntly.models.webhooks.events.EventListPageResponse
import com.nuntly.models.webhooks.events.EventListParams
import com.nuntly.models.webhooks.events.EventRetryParams
import com.nuntly.models.webhooks.events.EventRetryResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class EventServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    EventService {

    private val withRawResponse: EventService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): EventService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService =
        EventServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(params: EventListParams, requestOptions: RequestOptions): EventListPage =
        // get /webhooks/events
        withRawResponse().list(params, requestOptions).parse()

    override fun deliveries(
        params: EventDeliveriesParams,
        requestOptions: RequestOptions,
    ): List<EventDeliveriesResponse> =
        // get /webhooks/{id}/events/{event_id}/deliveries
        withRawResponse().deliveries(params, requestOptions).parse()

    override fun retry(
        params: EventRetryParams,
        requestOptions: RequestOptions,
    ): EventRetryResponse =
        // post /webhooks/{id}/events/{event_id}/retry
        withRawResponse().retry(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EventService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventService.WithRawResponse =
            EventServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<EventListPageResponse> =
            jsonHandler<EventListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: EventListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EventListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("webhooks", "events")
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
                        EventListPage.builder()
                            .service(EventServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deliveriesHandler: Handler<DataEnvelope<List<EventDeliveriesResponse>>> =
            jsonHandler<DataEnvelope<List<EventDeliveriesResponse>>>(clientOptions.jsonMapper)

        override fun deliveries(
            params: EventDeliveriesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<EventDeliveriesResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("eventId", params.eventId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "webhooks",
                        params._pathParam(0),
                        "events",
                        params._pathParam(1),
                        "deliveries",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deliveriesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .data()
            }
        }

        private val retryHandler: Handler<DataEnvelope<EventRetryResponse>> =
            jsonHandler<DataEnvelope<EventRetryResponse>>(clientOptions.jsonMapper)

        override fun retry(
            params: EventRetryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EventRetryResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("eventId", params.eventId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "webhooks",
                        params._pathParam(0),
                        "events",
                        params._pathParam(1),
                        "retry",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retryHandler.handle(it) }
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
