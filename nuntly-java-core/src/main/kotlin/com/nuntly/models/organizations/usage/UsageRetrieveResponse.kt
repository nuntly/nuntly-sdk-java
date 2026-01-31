// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.usage

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.checkRequired
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class UsageRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val transactional: JsonField<Transactional>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("transactional")
        @ExcludeMissing
        transactional: JsonField<Transactional> = JsonMissing.of()
    ) : this(transactional, mutableMapOf())

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transactional(): Transactional = transactional.getRequired("transactional")

    /**
     * Returns the raw JSON value of [transactional].
     *
     * Unlike [transactional], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transactional")
    @ExcludeMissing
    fun _transactional(): JsonField<Transactional> = transactional

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
         * Returns a mutable builder for constructing an instance of [UsageRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .transactional()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsageRetrieveResponse]. */
    class Builder internal constructor() {

        private var transactional: JsonField<Transactional>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(usageRetrieveResponse: UsageRetrieveResponse) = apply {
            transactional = usageRetrieveResponse.transactional
            additionalProperties = usageRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun transactional(transactional: Transactional) = transactional(JsonField.of(transactional))

        /**
         * Sets [Builder.transactional] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transactional] with a well-typed [Transactional] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun transactional(transactional: JsonField<Transactional>) = apply {
            this.transactional = transactional
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
         * Returns an immutable instance of [UsageRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .transactional()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UsageRetrieveResponse =
            UsageRetrieveResponse(
                checkRequired("transactional", transactional),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): UsageRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        transactional().validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int = (transactional.asKnown().getOrNull()?.validity() ?: 0)

    class Transactional
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val limits: JsonField<Limits>,
        private val usage: JsonField<Usage>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("limits") @ExcludeMissing limits: JsonField<Limits> = JsonMissing.of(),
            @JsonProperty("usage") @ExcludeMissing usage: JsonField<Usage> = JsonMissing.of(),
        ) : this(limits, usage, mutableMapOf())

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun limits(): Limits = limits.getRequired("limits")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun usage(): Usage = usage.getRequired("usage")

        /**
         * Returns the raw JSON value of [limits].
         *
         * Unlike [limits], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limits") @ExcludeMissing fun _limits(): JsonField<Limits> = limits

        /**
         * Returns the raw JSON value of [usage].
         *
         * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

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
             * Returns a mutable builder for constructing an instance of [Transactional].
             *
             * The following fields are required:
             * ```java
             * .limits()
             * .usage()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Transactional]. */
        class Builder internal constructor() {

            private var limits: JsonField<Limits>? = null
            private var usage: JsonField<Usage>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(transactional: Transactional) = apply {
                limits = transactional.limits
                usage = transactional.usage
                additionalProperties = transactional.additionalProperties.toMutableMap()
            }

            fun limits(limits: Limits) = limits(JsonField.of(limits))

            /**
             * Sets [Builder.limits] to an arbitrary JSON value.
             *
             * You should usually call [Builder.limits] with a well-typed [Limits] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun limits(limits: JsonField<Limits>) = apply { this.limits = limits }

            fun usage(usage: Usage) = usage(JsonField.of(usage))

            /**
             * Sets [Builder.usage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.usage] with a well-typed [Usage] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

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
             * Returns an immutable instance of [Transactional].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .limits()
             * .usage()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Transactional =
                Transactional(
                    checkRequired("limits", limits),
                    checkRequired("usage", usage),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Transactional = apply {
            if (validated) {
                return@apply
            }

            limits().validate()
            usage().validate()
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
            (limits.asKnown().getOrNull()?.validity() ?: 0) +
                (usage.asKnown().getOrNull()?.validity() ?: 0)

        class Limits
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val daily: JsonField<Double>,
            private val monthly: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("daily") @ExcludeMissing daily: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("monthly")
                @ExcludeMissing
                monthly: JsonField<Double> = JsonMissing.of(),
            ) : this(daily, monthly, mutableMapOf())

            /**
             * The daily email limit for the organization
             *
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun daily(): Double = daily.getRequired("daily")

            /**
             * The monthly email limit for the organization
             *
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun monthly(): Double = monthly.getRequired("monthly")

            /**
             * Returns the raw JSON value of [daily].
             *
             * Unlike [daily], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("daily") @ExcludeMissing fun _daily(): JsonField<Double> = daily

            /**
             * Returns the raw JSON value of [monthly].
             *
             * Unlike [monthly], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("monthly") @ExcludeMissing fun _monthly(): JsonField<Double> = monthly

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
                 * Returns a mutable builder for constructing an instance of [Limits].
                 *
                 * The following fields are required:
                 * ```java
                 * .daily()
                 * .monthly()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Limits]. */
            class Builder internal constructor() {

                private var daily: JsonField<Double>? = null
                private var monthly: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(limits: Limits) = apply {
                    daily = limits.daily
                    monthly = limits.monthly
                    additionalProperties = limits.additionalProperties.toMutableMap()
                }

                /** The daily email limit for the organization */
                fun daily(daily: Double) = daily(JsonField.of(daily))

                /**
                 * Sets [Builder.daily] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.daily] with a well-typed [Double] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun daily(daily: JsonField<Double>) = apply { this.daily = daily }

                /** The monthly email limit for the organization */
                fun monthly(monthly: Double) = monthly(JsonField.of(monthly))

                /**
                 * Sets [Builder.monthly] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.monthly] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun monthly(monthly: JsonField<Double>) = apply { this.monthly = monthly }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Limits].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .daily()
                 * .monthly()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Limits =
                    Limits(
                        checkRequired("daily", daily),
                        checkRequired("monthly", monthly),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Limits = apply {
                if (validated) {
                    return@apply
                }

                daily()
                monthly()
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
                (if (daily.asKnown().isPresent) 1 else 0) +
                    (if (monthly.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Limits &&
                    daily == other.daily &&
                    monthly == other.monthly &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(daily, monthly, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Limits{daily=$daily, monthly=$monthly, additionalProperties=$additionalProperties}"
        }

        class Usage
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val daily: JsonField<Double>,
            private val monthly: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("daily") @ExcludeMissing daily: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("monthly")
                @ExcludeMissing
                monthly: JsonField<Double> = JsonMissing.of(),
            ) : this(daily, monthly, mutableMapOf())

            /**
             * The daily email usage for the organization
             *
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun daily(): Double = daily.getRequired("daily")

            /**
             * The monthly email usage for the organization
             *
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun monthly(): Double = monthly.getRequired("monthly")

            /**
             * Returns the raw JSON value of [daily].
             *
             * Unlike [daily], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("daily") @ExcludeMissing fun _daily(): JsonField<Double> = daily

            /**
             * Returns the raw JSON value of [monthly].
             *
             * Unlike [monthly], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("monthly") @ExcludeMissing fun _monthly(): JsonField<Double> = monthly

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
                 * Returns a mutable builder for constructing an instance of [Usage].
                 *
                 * The following fields are required:
                 * ```java
                 * .daily()
                 * .monthly()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Usage]. */
            class Builder internal constructor() {

                private var daily: JsonField<Double>? = null
                private var monthly: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(usage: Usage) = apply {
                    daily = usage.daily
                    monthly = usage.monthly
                    additionalProperties = usage.additionalProperties.toMutableMap()
                }

                /** The daily email usage for the organization */
                fun daily(daily: Double) = daily(JsonField.of(daily))

                /**
                 * Sets [Builder.daily] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.daily] with a well-typed [Double] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun daily(daily: JsonField<Double>) = apply { this.daily = daily }

                /** The monthly email usage for the organization */
                fun monthly(monthly: Double) = monthly(JsonField.of(monthly))

                /**
                 * Sets [Builder.monthly] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.monthly] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun monthly(monthly: JsonField<Double>) = apply { this.monthly = monthly }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Usage].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .daily()
                 * .monthly()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Usage =
                    Usage(
                        checkRequired("daily", daily),
                        checkRequired("monthly", monthly),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Usage = apply {
                if (validated) {
                    return@apply
                }

                daily()
                monthly()
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
                (if (daily.asKnown().isPresent) 1 else 0) +
                    (if (monthly.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Usage &&
                    daily == other.daily &&
                    monthly == other.monthly &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(daily, monthly, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Usage{daily=$daily, monthly=$monthly, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Transactional &&
                limits == other.limits &&
                usage == other.usage &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(limits, usage, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Transactional{limits=$limits, usage=$usage, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsageRetrieveResponse &&
            transactional == other.transactional &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(transactional, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UsageRetrieveResponse{transactional=$transactional, additionalProperties=$additionalProperties}"
}
