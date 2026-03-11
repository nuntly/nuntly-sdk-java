// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.Params
import com.nuntly.core.http.Headers
import com.nuntly.core.http.QueryParams
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Update thread properties (read status, spam, agent). */
class ThreadUpdateParams
private constructor(
    private val threadId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun threadId(): Optional<String> = Optional.ofNullable(threadId)

    /**
     * The AI agent identifier.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun agentId(): Optional<String> = body.agentId()

    /**
     * Mark the thread as read or unread.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isRead(): Optional<Boolean> = body.isRead()

    /**
     * Mark the thread as spam or not spam.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isSpam(): Optional<Boolean> = body.isSpam()

    /**
     * Returns the raw JSON value of [agentId].
     *
     * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _agentId(): JsonField<String> = body._agentId()

    /**
     * Returns the raw JSON value of [isRead].
     *
     * Unlike [isRead], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _isRead(): JsonField<Boolean> = body._isRead()

    /**
     * Returns the raw JSON value of [isSpam].
     *
     * Unlike [isSpam], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _isSpam(): JsonField<Boolean> = body._isSpam()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ThreadUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ThreadUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ThreadUpdateParams]. */
    class Builder internal constructor() {

        private var threadId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(threadUpdateParams: ThreadUpdateParams) = apply {
            threadId = threadUpdateParams.threadId
            body = threadUpdateParams.body.toBuilder()
            additionalHeaders = threadUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = threadUpdateParams.additionalQueryParams.toBuilder()
        }

        fun threadId(threadId: String?) = apply { this.threadId = threadId }

        /** Alias for calling [Builder.threadId] with `threadId.orElse(null)`. */
        fun threadId(threadId: Optional<String>) = threadId(threadId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [agentId]
         * - [isRead]
         * - [isSpam]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The AI agent identifier. */
        fun agentId(agentId: String?) = apply { body.agentId(agentId) }

        /** Alias for calling [Builder.agentId] with `agentId.orElse(null)`. */
        fun agentId(agentId: Optional<String>) = agentId(agentId.getOrNull())

        /**
         * Sets [Builder.agentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agentId(agentId: JsonField<String>) = apply { body.agentId(agentId) }

        /** Mark the thread as read or unread. */
        fun isRead(isRead: Boolean) = apply { body.isRead(isRead) }

        /**
         * Sets [Builder.isRead] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isRead] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isRead(isRead: JsonField<Boolean>) = apply { body.isRead(isRead) }

        /** Mark the thread as spam or not spam. */
        fun isSpam(isSpam: Boolean) = apply { body.isSpam(isSpam) }

        /**
         * Sets [Builder.isSpam] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isSpam] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isSpam(isSpam: JsonField<Boolean>) = apply { body.isSpam(isSpam) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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
         * Returns an immutable instance of [ThreadUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ThreadUpdateParams =
            ThreadUpdateParams(
                threadId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> threadId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val agentId: JsonField<String>,
        private val isRead: JsonField<Boolean>,
        private val isSpam: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("agentId") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("isRead") @ExcludeMissing isRead: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isSpam") @ExcludeMissing isSpam: JsonField<Boolean> = JsonMissing.of(),
        ) : this(agentId, isRead, isSpam, mutableMapOf())

        /**
         * The AI agent identifier.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agentId(): Optional<String> = agentId.getOptional("agentId")

        /**
         * Mark the thread as read or unread.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun isRead(): Optional<Boolean> = isRead.getOptional("isRead")

        /**
         * Mark the thread as spam or not spam.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun isSpam(): Optional<Boolean> = isSpam.getOptional("isSpam")

        /**
         * Returns the raw JSON value of [agentId].
         *
         * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agentId") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

        /**
         * Returns the raw JSON value of [isRead].
         *
         * Unlike [isRead], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isRead") @ExcludeMissing fun _isRead(): JsonField<Boolean> = isRead

        /**
         * Returns the raw JSON value of [isSpam].
         *
         * Unlike [isSpam], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isSpam") @ExcludeMissing fun _isSpam(): JsonField<Boolean> = isSpam

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var agentId: JsonField<String> = JsonMissing.of()
            private var isRead: JsonField<Boolean> = JsonMissing.of()
            private var isSpam: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                agentId = body.agentId
                isRead = body.isRead
                isSpam = body.isSpam
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The AI agent identifier. */
            fun agentId(agentId: String?) = agentId(JsonField.ofNullable(agentId))

            /** Alias for calling [Builder.agentId] with `agentId.orElse(null)`. */
            fun agentId(agentId: Optional<String>) = agentId(agentId.getOrNull())

            /**
             * Sets [Builder.agentId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agentId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

            /** Mark the thread as read or unread. */
            fun isRead(isRead: Boolean) = isRead(JsonField.of(isRead))

            /**
             * Sets [Builder.isRead] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isRead] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isRead(isRead: JsonField<Boolean>) = apply { this.isRead = isRead }

            /** Mark the thread as spam or not spam. */
            fun isSpam(isSpam: Boolean) = isSpam(JsonField.of(isSpam))

            /**
             * Sets [Builder.isSpam] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isSpam] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isSpam(isSpam: JsonField<Boolean>) = apply { this.isSpam = isSpam }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body = Body(agentId, isRead, isSpam, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            agentId()
            isRead()
            isSpam()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: NuntlyInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (agentId.asKnown().isPresent) 1 else 0) +
                (if (isRead.asKnown().isPresent) 1 else 0) +
                (if (isSpam.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                agentId == other.agentId &&
                isRead == other.isRead &&
                isSpam == other.isSpam &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(agentId, isRead, isSpam, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{agentId=$agentId, isRead=$isRead, isSpam=$isSpam, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ThreadUpdateParams &&
            threadId == other.threadId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(threadId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ThreadUpdateParams{threadId=$threadId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
