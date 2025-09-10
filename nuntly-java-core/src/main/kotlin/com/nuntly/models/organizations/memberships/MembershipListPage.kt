// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.memberships

import com.nuntly.core.AutoPager
import com.nuntly.core.Page
import com.nuntly.core.checkRequired
import com.nuntly.services.blocking.organizations.MembershipService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see MembershipService.list */
class MembershipListPage
private constructor(
    private val service: MembershipService,
    private val params: MembershipListParams,
    private val response: MembershipListPageResponse,
) : Page<MembershipListResponse> {

    /**
     * Delegates to [MembershipListPageResponse], but gracefully handles missing data.
     *
     * @see MembershipListPageResponse.data
     */
    fun data(): List<MembershipListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [MembershipListPageResponse], but gracefully handles missing data.
     *
     * @see MembershipListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<MembershipListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): MembershipListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): MembershipListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<MembershipListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): MembershipListParams = params

    /** The response that this page was parsed from. */
    fun response(): MembershipListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MembershipListPage].
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

    /** A builder for [MembershipListPage]. */
    class Builder internal constructor() {

        private var service: MembershipService? = null
        private var params: MembershipListParams? = null
        private var response: MembershipListPageResponse? = null

        @JvmSynthetic
        internal fun from(membershipListPage: MembershipListPage) = apply {
            service = membershipListPage.service
            params = membershipListPage.params
            response = membershipListPage.response
        }

        fun service(service: MembershipService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MembershipListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MembershipListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MembershipListPage].
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
        fun build(): MembershipListPage =
            MembershipListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MembershipListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "MembershipListPage{service=$service, params=$params, response=$response}"
}
