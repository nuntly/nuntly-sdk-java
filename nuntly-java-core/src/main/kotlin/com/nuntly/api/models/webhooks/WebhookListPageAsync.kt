// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.webhooks

import com.nuntly.api.core.AutoPagerAsync
import com.nuntly.api.core.PageAsync
import com.nuntly.api.core.checkRequired
import com.nuntly.api.services.async.WebhookServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see WebhookServiceAsync.list */
class WebhookListPageAsync
private constructor(
    private val service: WebhookServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: WebhookListParams,
    private val response: WebhookListPageResponse,
) : PageAsync<WebhookListResponse> {

    /**
     * Delegates to [WebhookListPageResponse], but gracefully handles missing data.
     *
     * @see WebhookListPageResponse.data
     */
    fun data(): List<WebhookListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [WebhookListPageResponse], but gracefully handles missing data.
     *
     * @see WebhookListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<WebhookListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): WebhookListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<WebhookListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<WebhookListResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): WebhookListParams = params

    /** The response that this page was parsed from. */
    fun response(): WebhookListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WebhookListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookListPageAsync]. */
    class Builder internal constructor() {

        private var service: WebhookServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: WebhookListParams? = null
        private var response: WebhookListPageResponse? = null

        @JvmSynthetic
        internal fun from(webhookListPageAsync: WebhookListPageAsync) = apply {
            service = webhookListPageAsync.service
            streamHandlerExecutor = webhookListPageAsync.streamHandlerExecutor
            params = webhookListPageAsync.params
            response = webhookListPageAsync.response
        }

        fun service(service: WebhookServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: WebhookListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: WebhookListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [WebhookListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WebhookListPageAsync =
            WebhookListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "WebhookListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
