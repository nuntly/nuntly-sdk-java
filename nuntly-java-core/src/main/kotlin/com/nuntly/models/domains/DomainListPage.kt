// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import com.nuntly.core.AutoPager
import com.nuntly.core.Page
import com.nuntly.core.checkRequired
import com.nuntly.services.blocking.DomainService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see DomainService.list */
class DomainListPage
private constructor(
    private val service: DomainService,
    private val params: DomainListParams,
    private val response: DomainListPageResponse,
) : Page<DomainListResponse> {

    /**
     * Delegates to [DomainListPageResponse], but gracefully handles missing data.
     *
     * @see DomainListPageResponse.data
     */
    fun data(): List<DomainListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [DomainListPageResponse], but gracefully handles missing data.
     *
     * @see DomainListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("nextCursor")

    override fun items(): List<DomainListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): DomainListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): DomainListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<DomainListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): DomainListParams = params

    /** The response that this page was parsed from. */
    fun response(): DomainListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DomainListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DomainListPage]. */
    class Builder internal constructor() {

        private var service: DomainService? = null
        private var params: DomainListParams? = null
        private var response: DomainListPageResponse? = null

        @JvmSynthetic
        internal fun from(domainListPage: DomainListPage) = apply {
            service = domainListPage.service
            params = domainListPage.params
            response = domainListPage.response
        }

        fun service(service: DomainService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: DomainListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: DomainListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [DomainListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DomainListPage =
            DomainListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DomainListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "DomainListPage{service=$service, params=$params, response=$response}"
}
