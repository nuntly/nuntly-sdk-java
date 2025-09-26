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
    private val daily: JsonField<Daily>,
    private val monthly: JsonField<Monthly>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("daily") @ExcludeMissing daily: JsonField<Daily> = JsonMissing.of(),
        @JsonProperty("monthly") @ExcludeMissing monthly: JsonField<Monthly> = JsonMissing.of(),
    ) : this(daily, monthly, mutableMapOf())

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun daily(): Daily = daily.getRequired("daily")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun monthly(): Monthly = monthly.getRequired("monthly")

    /**
     * Returns the raw JSON value of [daily].
     *
     * Unlike [daily], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("daily") @ExcludeMissing fun _daily(): JsonField<Daily> = daily

    /**
     * Returns the raw JSON value of [monthly].
     *
     * Unlike [monthly], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monthly") @ExcludeMissing fun _monthly(): JsonField<Monthly> = monthly

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
         * .daily()
         * .monthly()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsageRetrieveResponse]. */
    class Builder internal constructor() {

        private var daily: JsonField<Daily>? = null
        private var monthly: JsonField<Monthly>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(usageRetrieveResponse: UsageRetrieveResponse) = apply {
            daily = usageRetrieveResponse.daily
            monthly = usageRetrieveResponse.monthly
            additionalProperties = usageRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun daily(daily: Daily) = daily(JsonField.of(daily))

        /**
         * Sets [Builder.daily] to an arbitrary JSON value.
         *
         * You should usually call [Builder.daily] with a well-typed [Daily] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun daily(daily: JsonField<Daily>) = apply { this.daily = daily }

        fun monthly(monthly: Monthly) = monthly(JsonField.of(monthly))

        /**
         * Sets [Builder.monthly] to an arbitrary JSON value.
         *
         * You should usually call [Builder.monthly] with a well-typed [Monthly] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun monthly(monthly: JsonField<Monthly>) = apply { this.monthly = monthly }

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
         * .daily()
         * .monthly()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UsageRetrieveResponse =
            UsageRetrieveResponse(
                checkRequired("daily", daily),
                checkRequired("monthly", monthly),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): UsageRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        daily().validate()
        monthly().validate()
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
    internal fun validity(): Int =
        (daily.asKnown().getOrNull()?.validity() ?: 0) +
            (monthly.asKnown().getOrNull()?.validity() ?: 0)

    class Daily
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val consumed: JsonField<Consumed>,
        private val period: JsonField<String>,
        private val quota: JsonField<Quota>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("consumed")
            @ExcludeMissing
            consumed: JsonField<Consumed> = JsonMissing.of(),
            @JsonProperty("period") @ExcludeMissing period: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quota") @ExcludeMissing quota: JsonField<Quota> = JsonMissing.of(),
        ) : this(consumed, period, quota, mutableMapOf())

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun consumed(): Consumed = consumed.getRequired("consumed")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun period(): String = period.getRequired("period")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun quota(): Quota = quota.getRequired("quota")

        /**
         * Returns the raw JSON value of [consumed].
         *
         * Unlike [consumed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("consumed") @ExcludeMissing fun _consumed(): JsonField<Consumed> = consumed

        /**
         * Returns the raw JSON value of [period].
         *
         * Unlike [period], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("period") @ExcludeMissing fun _period(): JsonField<String> = period

        /**
         * Returns the raw JSON value of [quota].
         *
         * Unlike [quota], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quota") @ExcludeMissing fun _quota(): JsonField<Quota> = quota

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
             * Returns a mutable builder for constructing an instance of [Daily].
             *
             * The following fields are required:
             * ```java
             * .consumed()
             * .period()
             * .quota()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Daily]. */
        class Builder internal constructor() {

            private var consumed: JsonField<Consumed>? = null
            private var period: JsonField<String>? = null
            private var quota: JsonField<Quota>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(daily: Daily) = apply {
                consumed = daily.consumed
                period = daily.period
                quota = daily.quota
                additionalProperties = daily.additionalProperties.toMutableMap()
            }

            fun consumed(consumed: Consumed) = consumed(JsonField.of(consumed))

            /**
             * Sets [Builder.consumed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.consumed] with a well-typed [Consumed] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun consumed(consumed: JsonField<Consumed>) = apply { this.consumed = consumed }

            fun period(period: String) = period(JsonField.of(period))

            /**
             * Sets [Builder.period] to an arbitrary JSON value.
             *
             * You should usually call [Builder.period] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun period(period: JsonField<String>) = apply { this.period = period }

            fun quota(quota: Quota) = quota(JsonField.of(quota))

            /**
             * Sets [Builder.quota] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quota] with a well-typed [Quota] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun quota(quota: JsonField<Quota>) = apply { this.quota = quota }

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
             * Returns an immutable instance of [Daily].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .consumed()
             * .period()
             * .quota()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Daily =
                Daily(
                    checkRequired("consumed", consumed),
                    checkRequired("period", period),
                    checkRequired("quota", quota),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Daily = apply {
            if (validated) {
                return@apply
            }

            consumed().validate()
            period()
            quota().validate()
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
            (consumed.asKnown().getOrNull()?.validity() ?: 0) +
                (if (period.asKnown().isPresent) 1 else 0) +
                (quota.asKnown().getOrNull()?.validity() ?: 0)

        class Consumed
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val transacEmails: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("transac_emails")
                @ExcludeMissing
                transacEmails: JsonField<Double> = JsonMissing.of()
            ) : this(transacEmails, mutableMapOf())

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun transacEmails(): Double = transacEmails.getRequired("transac_emails")

            /**
             * Returns the raw JSON value of [transacEmails].
             *
             * Unlike [transacEmails], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("transac_emails")
            @ExcludeMissing
            fun _transacEmails(): JsonField<Double> = transacEmails

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
                 * Returns a mutable builder for constructing an instance of [Consumed].
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Consumed]. */
            class Builder internal constructor() {

                private var transacEmails: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(consumed: Consumed) = apply {
                    transacEmails = consumed.transacEmails
                    additionalProperties = consumed.additionalProperties.toMutableMap()
                }

                fun transacEmails(transacEmails: Double) =
                    transacEmails(JsonField.of(transacEmails))

                /**
                 * Sets [Builder.transacEmails] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transacEmails] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun transacEmails(transacEmails: JsonField<Double>) = apply {
                    this.transacEmails = transacEmails
                }

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
                 * Returns an immutable instance of [Consumed].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Consumed =
                    Consumed(
                        checkRequired("transacEmails", transacEmails),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Consumed = apply {
                if (validated) {
                    return@apply
                }

                transacEmails()
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
            internal fun validity(): Int = (if (transacEmails.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Consumed &&
                    transacEmails == other.transacEmails &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(transacEmails, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Consumed{transacEmails=$transacEmails, additionalProperties=$additionalProperties}"
        }

        class Quota
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val transacEmails: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("transac_emails")
                @ExcludeMissing
                transacEmails: JsonField<Double> = JsonMissing.of()
            ) : this(transacEmails, mutableMapOf())

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun transacEmails(): Double = transacEmails.getRequired("transac_emails")

            /**
             * Returns the raw JSON value of [transacEmails].
             *
             * Unlike [transacEmails], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("transac_emails")
            @ExcludeMissing
            fun _transacEmails(): JsonField<Double> = transacEmails

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
                 * Returns a mutable builder for constructing an instance of [Quota].
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Quota]. */
            class Builder internal constructor() {

                private var transacEmails: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(quota: Quota) = apply {
                    transacEmails = quota.transacEmails
                    additionalProperties = quota.additionalProperties.toMutableMap()
                }

                fun transacEmails(transacEmails: Double) =
                    transacEmails(JsonField.of(transacEmails))

                /**
                 * Sets [Builder.transacEmails] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transacEmails] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun transacEmails(transacEmails: JsonField<Double>) = apply {
                    this.transacEmails = transacEmails
                }

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
                 * Returns an immutable instance of [Quota].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Quota =
                    Quota(
                        checkRequired("transacEmails", transacEmails),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Quota = apply {
                if (validated) {
                    return@apply
                }

                transacEmails()
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
            internal fun validity(): Int = (if (transacEmails.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Quota &&
                    transacEmails == other.transacEmails &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(transacEmails, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Quota{transacEmails=$transacEmails, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Daily &&
                consumed == other.consumed &&
                period == other.period &&
                quota == other.quota &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(consumed, period, quota, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Daily{consumed=$consumed, period=$period, quota=$quota, additionalProperties=$additionalProperties}"
    }

    class Monthly
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val consumed: JsonField<Consumed>,
        private val period: JsonField<String>,
        private val quota: JsonField<Quota>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("consumed")
            @ExcludeMissing
            consumed: JsonField<Consumed> = JsonMissing.of(),
            @JsonProperty("period") @ExcludeMissing period: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quota") @ExcludeMissing quota: JsonField<Quota> = JsonMissing.of(),
        ) : this(consumed, period, quota, mutableMapOf())

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun consumed(): Consumed = consumed.getRequired("consumed")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun period(): String = period.getRequired("period")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun quota(): Quota = quota.getRequired("quota")

        /**
         * Returns the raw JSON value of [consumed].
         *
         * Unlike [consumed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("consumed") @ExcludeMissing fun _consumed(): JsonField<Consumed> = consumed

        /**
         * Returns the raw JSON value of [period].
         *
         * Unlike [period], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("period") @ExcludeMissing fun _period(): JsonField<String> = period

        /**
         * Returns the raw JSON value of [quota].
         *
         * Unlike [quota], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quota") @ExcludeMissing fun _quota(): JsonField<Quota> = quota

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
             * Returns a mutable builder for constructing an instance of [Monthly].
             *
             * The following fields are required:
             * ```java
             * .consumed()
             * .period()
             * .quota()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Monthly]. */
        class Builder internal constructor() {

            private var consumed: JsonField<Consumed>? = null
            private var period: JsonField<String>? = null
            private var quota: JsonField<Quota>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(monthly: Monthly) = apply {
                consumed = monthly.consumed
                period = monthly.period
                quota = monthly.quota
                additionalProperties = monthly.additionalProperties.toMutableMap()
            }

            fun consumed(consumed: Consumed) = consumed(JsonField.of(consumed))

            /**
             * Sets [Builder.consumed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.consumed] with a well-typed [Consumed] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun consumed(consumed: JsonField<Consumed>) = apply { this.consumed = consumed }

            fun period(period: String) = period(JsonField.of(period))

            /**
             * Sets [Builder.period] to an arbitrary JSON value.
             *
             * You should usually call [Builder.period] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun period(period: JsonField<String>) = apply { this.period = period }

            fun quota(quota: Quota) = quota(JsonField.of(quota))

            /**
             * Sets [Builder.quota] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quota] with a well-typed [Quota] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun quota(quota: JsonField<Quota>) = apply { this.quota = quota }

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
             * Returns an immutable instance of [Monthly].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .consumed()
             * .period()
             * .quota()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Monthly =
                Monthly(
                    checkRequired("consumed", consumed),
                    checkRequired("period", period),
                    checkRequired("quota", quota),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Monthly = apply {
            if (validated) {
                return@apply
            }

            consumed().validate()
            period()
            quota().validate()
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
            (consumed.asKnown().getOrNull()?.validity() ?: 0) +
                (if (period.asKnown().isPresent) 1 else 0) +
                (quota.asKnown().getOrNull()?.validity() ?: 0)

        class Consumed
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val transacEmails: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("transac_emails")
                @ExcludeMissing
                transacEmails: JsonField<Double> = JsonMissing.of()
            ) : this(transacEmails, mutableMapOf())

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun transacEmails(): Double = transacEmails.getRequired("transac_emails")

            /**
             * Returns the raw JSON value of [transacEmails].
             *
             * Unlike [transacEmails], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("transac_emails")
            @ExcludeMissing
            fun _transacEmails(): JsonField<Double> = transacEmails

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
                 * Returns a mutable builder for constructing an instance of [Consumed].
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Consumed]. */
            class Builder internal constructor() {

                private var transacEmails: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(consumed: Consumed) = apply {
                    transacEmails = consumed.transacEmails
                    additionalProperties = consumed.additionalProperties.toMutableMap()
                }

                fun transacEmails(transacEmails: Double) =
                    transacEmails(JsonField.of(transacEmails))

                /**
                 * Sets [Builder.transacEmails] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transacEmails] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun transacEmails(transacEmails: JsonField<Double>) = apply {
                    this.transacEmails = transacEmails
                }

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
                 * Returns an immutable instance of [Consumed].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Consumed =
                    Consumed(
                        checkRequired("transacEmails", transacEmails),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Consumed = apply {
                if (validated) {
                    return@apply
                }

                transacEmails()
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
            internal fun validity(): Int = (if (transacEmails.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Consumed &&
                    transacEmails == other.transacEmails &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(transacEmails, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Consumed{transacEmails=$transacEmails, additionalProperties=$additionalProperties}"
        }

        class Quota
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val transacEmails: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("transac_emails")
                @ExcludeMissing
                transacEmails: JsonField<Double> = JsonMissing.of()
            ) : this(transacEmails, mutableMapOf())

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun transacEmails(): Double = transacEmails.getRequired("transac_emails")

            /**
             * Returns the raw JSON value of [transacEmails].
             *
             * Unlike [transacEmails], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("transac_emails")
            @ExcludeMissing
            fun _transacEmails(): JsonField<Double> = transacEmails

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
                 * Returns a mutable builder for constructing an instance of [Quota].
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Quota]. */
            class Builder internal constructor() {

                private var transacEmails: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(quota: Quota) = apply {
                    transacEmails = quota.transacEmails
                    additionalProperties = quota.additionalProperties.toMutableMap()
                }

                fun transacEmails(transacEmails: Double) =
                    transacEmails(JsonField.of(transacEmails))

                /**
                 * Sets [Builder.transacEmails] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transacEmails] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun transacEmails(transacEmails: JsonField<Double>) = apply {
                    this.transacEmails = transacEmails
                }

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
                 * Returns an immutable instance of [Quota].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Quota =
                    Quota(
                        checkRequired("transacEmails", transacEmails),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Quota = apply {
                if (validated) {
                    return@apply
                }

                transacEmails()
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
            internal fun validity(): Int = (if (transacEmails.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Quota &&
                    transacEmails == other.transacEmails &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(transacEmails, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Quota{transacEmails=$transacEmails, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Monthly &&
                consumed == other.consumed &&
                period == other.period &&
                quota == other.quota &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(consumed, period, quota, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Monthly{consumed=$consumed, period=$period, quota=$quota, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsageRetrieveResponse &&
            daily == other.daily &&
            monthly == other.monthly &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(daily, monthly, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UsageRetrieveResponse{daily=$daily, monthly=$monthly, additionalProperties=$additionalProperties}"
}
