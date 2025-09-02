// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.invitations

import com.nuntly.api.core.AutoPager
import com.nuntly.api.core.Page
import com.nuntly.api.core.checkRequired
import com.nuntly.api.services.blocking.organizations.InvitationService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see InvitationService.list */
class InvitationListPage
private constructor(
    private val service: InvitationService,
    private val params: InvitationListParams,
    private val response: InvitationListPageResponse,
) : Page<InvitationListResponse> {

    /**
     * Delegates to [InvitationListPageResponse], but gracefully handles missing data.
     *
     * @see InvitationListPageResponse.data
     */
    fun data(): List<InvitationListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [InvitationListPageResponse], but gracefully handles missing data.
     *
     * @see InvitationListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<InvitationListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): InvitationListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): InvitationListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<InvitationListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): InvitationListParams = params

    /** The response that this page was parsed from. */
    fun response(): InvitationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InvitationListPage].
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

    /** A builder for [InvitationListPage]. */
    class Builder internal constructor() {

        private var service: InvitationService? = null
        private var params: InvitationListParams? = null
        private var response: InvitationListPageResponse? = null

        @JvmSynthetic
        internal fun from(invitationListPage: InvitationListPage) = apply {
            service = invitationListPage.service
            params = invitationListPage.params
            response = invitationListPage.response
        }

        fun service(service: InvitationService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: InvitationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InvitationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InvitationListPage].
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
        fun build(): InvitationListPage =
            InvitationListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvitationListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "InvitationListPage{service=$service, params=$params, response=$response}"
}
