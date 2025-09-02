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
import com.nuntly.api.models.domains.DomainCreateParams
import com.nuntly.api.models.domains.DomainCreateResponse
import com.nuntly.api.models.domains.DomainDeleteParams
import com.nuntly.api.models.domains.DomainDeleteResponse
import com.nuntly.api.models.domains.DomainListPage
import com.nuntly.api.models.domains.DomainListPageResponse
import com.nuntly.api.models.domains.DomainListParams
import com.nuntly.api.models.domains.DomainRetrieveParams
import com.nuntly.api.models.domains.DomainRetrieveResponse
import com.nuntly.api.models.domains.DomainUpdateParams
import com.nuntly.api.models.domains.DomainUpdateResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class DomainServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    DomainService {

    private val withRawResponse: DomainService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): DomainService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DomainService =
        DomainServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: DomainCreateParams,
        requestOptions: RequestOptions,
    ): DomainCreateResponse =
        // post /domains
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: DomainRetrieveParams,
        requestOptions: RequestOptions,
    ): DomainRetrieveResponse =
        // get /domains/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: DomainUpdateParams,
        requestOptions: RequestOptions,
    ): DomainUpdateResponse =
        // patch /domains/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: DomainListParams, requestOptions: RequestOptions): DomainListPage =
        // get /domains
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: DomainDeleteParams,
        requestOptions: RequestOptions,
    ): DomainDeleteResponse =
        // delete /domains/{id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DomainService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DomainService.WithRawResponse =
            DomainServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<DataEnvelope<DomainCreateResponse>> =
            jsonHandler<DataEnvelope<DomainCreateResponse>>(clientOptions.jsonMapper)

        override fun create(
            params: DomainCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DomainCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("domains")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .data()
            }
        }

        private val retrieveHandler: Handler<DataEnvelope<DomainRetrieveResponse>> =
            jsonHandler<DataEnvelope<DomainRetrieveResponse>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: DomainRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DomainRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("domains", params._pathParam(0))
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

        private val updateHandler: Handler<DataEnvelope<DomainUpdateResponse>> =
            jsonHandler<DataEnvelope<DomainUpdateResponse>>(clientOptions.jsonMapper)

        override fun update(
            params: DomainUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DomainUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("domains", params._pathParam(0))
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

        private val listHandler: Handler<DomainListPageResponse> =
            jsonHandler<DomainListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: DomainListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DomainListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("domains")
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
                        DomainListPage.builder()
                            .service(DomainServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<DataEnvelope<DomainDeleteResponse>> =
            jsonHandler<DataEnvelope<DomainDeleteResponse>>(clientOptions.jsonMapper)

        override fun delete(
            params: DomainDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DomainDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("domains", params._pathParam(0))
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
    }
}
