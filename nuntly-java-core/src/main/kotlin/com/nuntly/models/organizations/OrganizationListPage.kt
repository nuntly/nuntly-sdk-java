// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations

import com.nuntly.core.AutoPager
import com.nuntly.core.Page
import com.nuntly.core.checkRequired
import com.nuntly.services.blocking.OrganizationService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see OrganizationService.list */
class OrganizationListPage
private constructor(
    private val service: OrganizationService,
    private val params: OrganizationListParams,
    private val response: OrganizationListPageResponse,
) : Page<OrganizationListResponse> {

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

    override fun nextPage(): OrganizationListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<OrganizationListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): OrganizationListParams = params

    /** The response that this page was parsed from. */
    fun response(): OrganizationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OrganizationListPage].
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

    /** A builder for [OrganizationListPage]. */
    class Builder internal constructor() {

        private var service: OrganizationService? = null
        private var params: OrganizationListParams? = null
        private var response: OrganizationListPageResponse? = null

        @JvmSynthetic
        internal fun from(organizationListPage: OrganizationListPage) = apply {
            service = organizationListPage.service
            params = organizationListPage.params
            response = organizationListPage.response
        }

        fun service(service: OrganizationService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: OrganizationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: OrganizationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [OrganizationListPage].
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
        fun build(): OrganizationListPage =
            OrganizationListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrganizationListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "OrganizationListPage{service=$service, params=$params, response=$response}"
}
