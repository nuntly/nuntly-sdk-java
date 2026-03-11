// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.agents.memory

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.Params
import com.nuntly.core.checkRequired
import com.nuntly.core.http.Headers
import com.nuntly.core.http.QueryParams
import com.nuntly.core.toImmutable
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create or update the memory for an AI agent. */
class MemoryUpsertParams
private constructor(
    private val agentId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun agentId(): Optional<String> = Optional.ofNullable(agentId)

    /**
     * The agent memory key-value data.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun memory(): Memory = body.memory()

    /**
     * The inbox id to scope the memory to.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inboxId(): Optional<String> = body.inboxId()

    /**
     * A human-readable conversation summary.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun summary(): Optional<String> = body.summary()

    /**
     * The thread id to scope the memory to.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun threadId(): Optional<String> = body.threadId()

    /**
     * Returns the raw JSON value of [memory].
     *
     * Unlike [memory], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _memory(): JsonField<Memory> = body._memory()

    /**
     * Returns the raw JSON value of [inboxId].
     *
     * Unlike [inboxId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _inboxId(): JsonField<String> = body._inboxId()

    /**
     * Returns the raw JSON value of [summary].
     *
     * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _summary(): JsonField<String> = body._summary()

    /**
     * Returns the raw JSON value of [threadId].
     *
     * Unlike [threadId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _threadId(): JsonField<String> = body._threadId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MemoryUpsertParams].
         *
         * The following fields are required:
         * ```java
         * .memory()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MemoryUpsertParams]. */
    class Builder internal constructor() {

        private var agentId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(memoryUpsertParams: MemoryUpsertParams) = apply {
            agentId = memoryUpsertParams.agentId
            body = memoryUpsertParams.body.toBuilder()
            additionalHeaders = memoryUpsertParams.additionalHeaders.toBuilder()
            additionalQueryParams = memoryUpsertParams.additionalQueryParams.toBuilder()
        }

        fun agentId(agentId: String?) = apply { this.agentId = agentId }

        /** Alias for calling [Builder.agentId] with `agentId.orElse(null)`. */
        fun agentId(agentId: Optional<String>) = agentId(agentId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [memory]
         * - [inboxId]
         * - [summary]
         * - [threadId]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The agent memory key-value data. */
        fun memory(memory: Memory) = apply { body.memory(memory) }

        /**
         * Sets [Builder.memory] to an arbitrary JSON value.
         *
         * You should usually call [Builder.memory] with a well-typed [Memory] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun memory(memory: JsonField<Memory>) = apply { body.memory(memory) }

        /** The inbox id to scope the memory to. */
        fun inboxId(inboxId: String) = apply { body.inboxId(inboxId) }

        /**
         * Sets [Builder.inboxId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inboxId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun inboxId(inboxId: JsonField<String>) = apply { body.inboxId(inboxId) }

        /** A human-readable conversation summary. */
        fun summary(summary: String?) = apply { body.summary(summary) }

        /** Alias for calling [Builder.summary] with `summary.orElse(null)`. */
        fun summary(summary: Optional<String>) = summary(summary.getOrNull())

        /**
         * Sets [Builder.summary] to an arbitrary JSON value.
         *
         * You should usually call [Builder.summary] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun summary(summary: JsonField<String>) = apply { body.summary(summary) }

        /** The thread id to scope the memory to. */
        fun threadId(threadId: String) = apply { body.threadId(threadId) }

        /**
         * Sets [Builder.threadId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.threadId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun threadId(threadId: JsonField<String>) = apply { body.threadId(threadId) }

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
         * Returns an immutable instance of [MemoryUpsertParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .memory()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MemoryUpsertParams =
            MemoryUpsertParams(
                agentId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> agentId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val memory: JsonField<Memory>,
        private val inboxId: JsonField<String>,
        private val summary: JsonField<String>,
        private val threadId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("memory") @ExcludeMissing memory: JsonField<Memory> = JsonMissing.of(),
            @JsonProperty("inboxId") @ExcludeMissing inboxId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("summary") @ExcludeMissing summary: JsonField<String> = JsonMissing.of(),
            @JsonProperty("threadId") @ExcludeMissing threadId: JsonField<String> = JsonMissing.of(),
        ) : this(memory, inboxId, summary, threadId, mutableMapOf())

        /**
         * The agent memory key-value data.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun memory(): Memory = memory.getRequired("memory")

        /**
         * The inbox id to scope the memory to.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inboxId(): Optional<String> = inboxId.getOptional("inboxId")

        /**
         * A human-readable conversation summary.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun summary(): Optional<String> = summary.getOptional("summary")

        /**
         * The thread id to scope the memory to.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun threadId(): Optional<String> = threadId.getOptional("threadId")

        /**
         * Returns the raw JSON value of [memory].
         *
         * Unlike [memory], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("memory") @ExcludeMissing fun _memory(): JsonField<Memory> = memory

        /**
         * Returns the raw JSON value of [inboxId].
         *
         * Unlike [inboxId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inboxId") @ExcludeMissing fun _inboxId(): JsonField<String> = inboxId

        /**
         * Returns the raw JSON value of [summary].
         *
         * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<String> = summary

        /**
         * Returns the raw JSON value of [threadId].
         *
         * Unlike [threadId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("threadId") @ExcludeMissing fun _threadId(): JsonField<String> = threadId

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

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .memory()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var memory: JsonField<Memory>? = null
            private var inboxId: JsonField<String> = JsonMissing.of()
            private var summary: JsonField<String> = JsonMissing.of()
            private var threadId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                memory = body.memory
                inboxId = body.inboxId
                summary = body.summary
                threadId = body.threadId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The agent memory key-value data. */
            fun memory(memory: Memory) = memory(JsonField.of(memory))

            /**
             * Sets [Builder.memory] to an arbitrary JSON value.
             *
             * You should usually call [Builder.memory] with a well-typed [Memory] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun memory(memory: JsonField<Memory>) = apply { this.memory = memory }

            /** The inbox id to scope the memory to. */
            fun inboxId(inboxId: String) = inboxId(JsonField.of(inboxId))

            /**
             * Sets [Builder.inboxId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inboxId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inboxId(inboxId: JsonField<String>) = apply { this.inboxId = inboxId }

            /** A human-readable conversation summary. */
            fun summary(summary: String?) = summary(JsonField.ofNullable(summary))

            /** Alias for calling [Builder.summary] with `summary.orElse(null)`. */
            fun summary(summary: Optional<String>) = summary(summary.getOrNull())

            /**
             * Sets [Builder.summary] to an arbitrary JSON value.
             *
             * You should usually call [Builder.summary] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun summary(summary: JsonField<String>) = apply { this.summary = summary }

            /** The thread id to scope the memory to. */
            fun threadId(threadId: String) = threadId(JsonField.of(threadId))

            /**
             * Sets [Builder.threadId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.threadId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

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
             *
             * The following fields are required:
             * ```java
             * .memory()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("memory", memory),
                    inboxId,
                    summary,
                    threadId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            memory().validate()
            inboxId()
            summary()
            threadId()
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
            (memory.asKnown().getOrNull()?.validity() ?: 0) +
                (if (inboxId.asKnown().isPresent) 1 else 0) +
                (if (summary.asKnown().isPresent) 1 else 0) +
                (if (threadId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                memory == other.memory &&
                inboxId == other.inboxId &&
                summary == other.summary &&
                threadId == other.threadId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(memory, inboxId, summary, threadId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{memory=$memory, inboxId=$inboxId, summary=$summary, threadId=$threadId, additionalProperties=$additionalProperties}"
    }

    /** The agent memory key-value data. */
    class Memory
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Memory]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Memory]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(memory: Memory) = apply {
                additionalProperties = memory.additionalProperties.toMutableMap()
            }

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
             * Returns an immutable instance of [Memory].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Memory = Memory(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Memory = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Memory && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Memory{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MemoryUpsertParams &&
            agentId == other.agentId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(agentId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "MemoryUpsertParams{agentId=$agentId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
