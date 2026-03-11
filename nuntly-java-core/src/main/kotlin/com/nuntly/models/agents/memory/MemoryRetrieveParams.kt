// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.agents.memory

import com.nuntly.core.Params
import com.nuntly.core.http.Headers
import com.nuntly.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Retrieve the memory for an AI agent. */
class MemoryRetrieveParams
private constructor(
    private val agentId: String?,
    private val inboxId: String?,
    private val threadId: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun agentId(): Optional<String> = Optional.ofNullable(agentId)

    /** Scope memory to a specific inbox. */
    fun inboxId(): Optional<String> = Optional.ofNullable(inboxId)

    /** Scope memory to a specific thread. */
    fun threadId(): Optional<String> = Optional.ofNullable(threadId)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): MemoryRetrieveParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [MemoryRetrieveParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MemoryRetrieveParams]. */
    class Builder internal constructor() {

        private var agentId: String? = null
        private var inboxId: String? = null
        private var threadId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(memoryRetrieveParams: MemoryRetrieveParams) = apply {
            agentId = memoryRetrieveParams.agentId
            inboxId = memoryRetrieveParams.inboxId
            threadId = memoryRetrieveParams.threadId
            additionalHeaders = memoryRetrieveParams.additionalHeaders.toBuilder()
            additionalQueryParams = memoryRetrieveParams.additionalQueryParams.toBuilder()
        }

        fun agentId(agentId: String?) = apply { this.agentId = agentId }

        /** Alias for calling [Builder.agentId] with `agentId.orElse(null)`. */
        fun agentId(agentId: Optional<String>) = agentId(agentId.getOrNull())

        /** Scope memory to a specific inbox. */
        fun inboxId(inboxId: String?) = apply { this.inboxId = inboxId }

        /** Alias for calling [Builder.inboxId] with `inboxId.orElse(null)`. */
        fun inboxId(inboxId: Optional<String>) = inboxId(inboxId.getOrNull())

        /** Scope memory to a specific thread. */
        fun threadId(threadId: String?) = apply { this.threadId = threadId }

        /** Alias for calling [Builder.threadId] with `threadId.orElse(null)`. */
        fun threadId(threadId: Optional<String>) = threadId(threadId.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [MemoryRetrieveParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MemoryRetrieveParams =
            MemoryRetrieveParams(
                agentId,
                inboxId,
                threadId,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> agentId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                inboxId?.let { put("inboxId", it) }
                threadId?.let { put("threadId", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MemoryRetrieveParams &&
            agentId == other.agentId &&
            inboxId == other.inboxId &&
            threadId == other.threadId &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(agentId, inboxId, threadId, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "MemoryRetrieveParams{agentId=$agentId, inboxId=$inboxId, threadId=$threadId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
