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
import com.nuntly.api.models.apikeys.ApiKeyCreateParams
import com.nuntly.api.models.apikeys.ApiKeyCreateResponse
import com.nuntly.api.models.apikeys.ApiKeyDeleteParams
import com.nuntly.api.models.apikeys.ApiKeyDeleteResponse
import com.nuntly.api.models.apikeys.ApiKeyListPage
import com.nuntly.api.models.apikeys.ApiKeyListPageResponse
import com.nuntly.api.models.apikeys.ApiKeyListParams
import com.nuntly.api.models.apikeys.ApiKeyRetrieveParams
import com.nuntly.api.models.apikeys.ApiKeyRetrieveResponse
import com.nuntly.api.models.apikeys.ApiKeyUpdateParams
import com.nuntly.api.models.apikeys.ApiKeyUpdateResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ApiKeyServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ApiKeyService {

    private val withRawResponse: ApiKeyService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ApiKeyService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyService =
        ApiKeyServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions,
    ): ApiKeyCreateResponse =
        // post /api-keys
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions,
    ): ApiKeyRetrieveResponse =
        // get /api-keys/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: ApiKeyUpdateParams,
        requestOptions: RequestOptions,
    ): ApiKeyUpdateResponse =
        // put /api-keys/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: ApiKeyListParams, requestOptions: RequestOptions): ApiKeyListPage =
        // get /api-keys
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions,
    ): ApiKeyDeleteResponse =
        // delete /api-keys/{id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ApiKeyService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ApiKeyService.WithRawResponse =
            ApiKeyServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<DataEnvelope<ApiKeyCreateResponse>> =
            jsonHandler<DataEnvelope<ApiKeyCreateResponse>>(clientOptions.jsonMapper)

        override fun create(
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api-keys")
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

        private val retrieveHandler: Handler<DataEnvelope<ApiKeyRetrieveResponse>> =
            jsonHandler<DataEnvelope<ApiKeyRetrieveResponse>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ApiKeyRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api-keys", params._pathParam(0))
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

        private val updateHandler: Handler<DataEnvelope<ApiKeyUpdateResponse>> =
            jsonHandler<DataEnvelope<ApiKeyUpdateResponse>>(clientOptions.jsonMapper)

        override fun update(
            params: ApiKeyUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api-keys", params._pathParam(0))
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

        private val listHandler: Handler<ApiKeyListPageResponse> =
            jsonHandler<ApiKeyListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ApiKeyListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api-keys")
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
                        ApiKeyListPage.builder()
                            .service(ApiKeyServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<DataEnvelope<ApiKeyDeleteResponse>> =
            jsonHandler<DataEnvelope<ApiKeyDeleteResponse>>(clientOptions.jsonMapper)

        override fun delete(
            params: ApiKeyDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api-keys", params._pathParam(0))
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
