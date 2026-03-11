// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces

import com.nuntly.core.AutoPagerAsync
import com.nuntly.core.PageAsync
import com.nuntly.core.checkRequired
import com.nuntly.services.async.NamespaceServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see NamespaceServiceAsync.list */
class NamespaceListPageAsync
private constructor(
    private val service: NamespaceServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: NamespaceListParams,
    private val response: NamespaceListPageResponse,
) : PageAsync<Namespace> {

    /**
     * Delegates to [NamespaceListPageResponse], but gracefully handles missing data.
     *
     * @see NamespaceListPageResponse.data
     */
    fun data(): List<Namespace> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [NamespaceListPageResponse], but gracefully handles missing data.
     *
     * @see NamespaceListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("nextCursor")

    override fun items(): List<Namespace> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): NamespaceListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<NamespaceListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Namespace> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): NamespaceListParams = params

    /** The response that this page was parsed from. */
    fun response(): NamespaceListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceListPageAsync].
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

    /** A builder for [NamespaceListPageAsync]. */
    class Builder internal constructor() {

        private var service: NamespaceServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: NamespaceListParams? = null
        private var response: NamespaceListPageResponse? = null

        @JvmSynthetic
        internal fun from(namespaceListPageAsync: NamespaceListPageAsync) = apply {
            service = namespaceListPageAsync.service
            streamHandlerExecutor = namespaceListPageAsync.streamHandlerExecutor
            params = namespaceListPageAsync.params
            response = namespaceListPageAsync.response
        }

        fun service(service: NamespaceServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: NamespaceListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: NamespaceListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [NamespaceListPageAsync].
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
        fun build(): NamespaceListPageAsync =
            NamespaceListPageAsync(
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

        return other is NamespaceListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "NamespaceListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
