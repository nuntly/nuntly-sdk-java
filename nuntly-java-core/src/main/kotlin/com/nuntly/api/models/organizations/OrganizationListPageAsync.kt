// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations

import com.nuntly.api.core.AutoPagerAsync
import com.nuntly.api.core.PageAsync
import com.nuntly.api.core.checkRequired
import com.nuntly.api.services.async.OrganizationServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see OrganizationServiceAsync.list */
class OrganizationListPageAsync
private constructor(
    private val service: OrganizationServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: OrganizationListParams,
    private val response: OrganizationListPageResponse,
) : PageAsync<OrganizationListResponse> {

    /**
     * Delegates to [OrganizationListPageResponse], but gracefully handles missing data.
     *
     * @see OrganizationListPageResponse.data
     */
    fun data(): List<OrganizationListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [OrganizationListPageResponse], but gracefully handles missing data.
     *
     * @see OrganizationListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<OrganizationListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): OrganizationListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<OrganizationListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<OrganizationListResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): OrganizationListParams = params

    /** The response that this page was parsed from. */
    fun response(): OrganizationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OrganizationListPageAsync].
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

    /** A builder for [OrganizationListPageAsync]. */
    class Builder internal constructor() {

        private var service: OrganizationServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: OrganizationListParams? = null
        private var response: OrganizationListPageResponse? = null

        @JvmSynthetic
        internal fun from(organizationListPageAsync: OrganizationListPageAsync) = apply {
            service = organizationListPageAsync.service
            streamHandlerExecutor = organizationListPageAsync.streamHandlerExecutor
            params = organizationListPageAsync.params
            response = organizationListPageAsync.response
        }

        fun service(service: OrganizationServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: OrganizationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: OrganizationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [OrganizationListPageAsync].
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
        fun build(): OrganizationListPageAsync =
            OrganizationListPageAsync(
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

        return other is OrganizationListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "OrganizationListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
