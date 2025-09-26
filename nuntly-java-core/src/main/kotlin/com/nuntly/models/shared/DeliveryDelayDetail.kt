// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.checkKnown
import com.nuntly.core.checkRequired
import com.nuntly.core.toImmutable
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class DeliveryDelayDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val delayType: JsonField<String>,
    private val delayedAt: JsonField<String>,
    private val delayedRecipients: JsonField<List<DelayedRecipient>>,
    private val deliveryStoppedAt: JsonField<String>,
    private val reportingMta: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delay_type") @ExcludeMissing delayType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("delayed_at") @ExcludeMissing delayedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("delayed_recipients")
        @ExcludeMissing
        delayedRecipients: JsonField<List<DelayedRecipient>> = JsonMissing.of(),
        @JsonProperty("delivery_stopped_at")
        @ExcludeMissing
        deliveryStoppedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reporting_mta")
        @ExcludeMissing
        reportingMta: JsonField<String> = JsonMissing.of(),
    ) : this(
        delayType,
        delayedAt,
        delayedRecipients,
        deliveryStoppedAt,
        reportingMta,
        mutableMapOf(),
    )

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delayType(): String = delayType.getRequired("delay_type")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delayedAt(): String = delayedAt.getRequired("delayed_at")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun delayedRecipients(): List<DelayedRecipient> =
        delayedRecipients.getRequired("delayed_recipients")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun deliveryStoppedAt(): String = deliveryStoppedAt.getRequired("delivery_stopped_at")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reportingMta(): String = reportingMta.getRequired("reporting_mta")

    /**
     * Returns the raw JSON value of [delayType].
     *
     * Unlike [delayType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delay_type") @ExcludeMissing fun _delayType(): JsonField<String> = delayType

    /**
     * Returns the raw JSON value of [delayedAt].
     *
     * Unlike [delayedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delayed_at") @ExcludeMissing fun _delayedAt(): JsonField<String> = delayedAt

    /**
     * Returns the raw JSON value of [delayedRecipients].
     *
     * Unlike [delayedRecipients], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("delayed_recipients")
    @ExcludeMissing
    fun _delayedRecipients(): JsonField<List<DelayedRecipient>> = delayedRecipients

    /**
     * Returns the raw JSON value of [deliveryStoppedAt].
     *
     * Unlike [deliveryStoppedAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("delivery_stopped_at")
    @ExcludeMissing
    fun _deliveryStoppedAt(): JsonField<String> = deliveryStoppedAt

    /**
     * Returns the raw JSON value of [reportingMta].
     *
     * Unlike [reportingMta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reporting_mta")
    @ExcludeMissing
    fun _reportingMta(): JsonField<String> = reportingMta

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
         * Returns a mutable builder for constructing an instance of [DeliveryDelayDetail].
         *
         * The following fields are required:
         * ```java
         * .delayType()
         * .delayedAt()
         * .delayedRecipients()
         * .deliveryStoppedAt()
         * .reportingMta()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DeliveryDelayDetail]. */
    class Builder internal constructor() {

        private var delayType: JsonField<String>? = null
        private var delayedAt: JsonField<String>? = null
        private var delayedRecipients: JsonField<MutableList<DelayedRecipient>>? = null
        private var deliveryStoppedAt: JsonField<String>? = null
        private var reportingMta: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(deliveryDelayDetail: DeliveryDelayDetail) = apply {
            delayType = deliveryDelayDetail.delayType
            delayedAt = deliveryDelayDetail.delayedAt
            delayedRecipients = deliveryDelayDetail.delayedRecipients.map { it.toMutableList() }
            deliveryStoppedAt = deliveryDelayDetail.deliveryStoppedAt
            reportingMta = deliveryDelayDetail.reportingMta
            additionalProperties = deliveryDelayDetail.additionalProperties.toMutableMap()
        }

        fun delayType(delayType: String) = delayType(JsonField.of(delayType))

        /**
         * Sets [Builder.delayType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delayType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun delayType(delayType: JsonField<String>) = apply { this.delayType = delayType }

        fun delayedAt(delayedAt: String) = delayedAt(JsonField.of(delayedAt))

        /**
         * Sets [Builder.delayedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delayedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun delayedAt(delayedAt: JsonField<String>) = apply { this.delayedAt = delayedAt }

        fun delayedRecipients(delayedRecipients: List<DelayedRecipient>) =
            delayedRecipients(JsonField.of(delayedRecipients))

        /**
         * Sets [Builder.delayedRecipients] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delayedRecipients] with a well-typed
         * `List<DelayedRecipient>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun delayedRecipients(delayedRecipients: JsonField<List<DelayedRecipient>>) = apply {
            this.delayedRecipients = delayedRecipients.map { it.toMutableList() }
        }

        /**
         * Adds a single [DelayedRecipient] to [delayedRecipients].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDelayedRecipient(delayedRecipient: DelayedRecipient) = apply {
            delayedRecipients =
                (delayedRecipients ?: JsonField.of(mutableListOf())).also {
                    checkKnown("delayedRecipients", it).add(delayedRecipient)
                }
        }

        fun deliveryStoppedAt(deliveryStoppedAt: String) =
            deliveryStoppedAt(JsonField.of(deliveryStoppedAt))

        /**
         * Sets [Builder.deliveryStoppedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deliveryStoppedAt] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deliveryStoppedAt(deliveryStoppedAt: JsonField<String>) = apply {
            this.deliveryStoppedAt = deliveryStoppedAt
        }

        fun reportingMta(reportingMta: String) = reportingMta(JsonField.of(reportingMta))

        /**
         * Sets [Builder.reportingMta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reportingMta] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reportingMta(reportingMta: JsonField<String>) = apply {
            this.reportingMta = reportingMta
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
         * Returns an immutable instance of [DeliveryDelayDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .delayType()
         * .delayedAt()
         * .delayedRecipients()
         * .deliveryStoppedAt()
         * .reportingMta()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DeliveryDelayDetail =
            DeliveryDelayDetail(
                checkRequired("delayType", delayType),
                checkRequired("delayedAt", delayedAt),
                checkRequired("delayedRecipients", delayedRecipients).map { it.toImmutable() },
                checkRequired("deliveryStoppedAt", deliveryStoppedAt),
                checkRequired("reportingMta", reportingMta),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DeliveryDelayDetail = apply {
        if (validated) {
            return@apply
        }

        delayType()
        delayedAt()
        delayedRecipients().forEach { it.validate() }
        deliveryStoppedAt()
        reportingMta()
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
        (if (delayType.asKnown().isPresent) 1 else 0) +
            (if (delayedAt.asKnown().isPresent) 1 else 0) +
            (delayedRecipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (deliveryStoppedAt.asKnown().isPresent) 1 else 0) +
            (if (reportingMta.asKnown().isPresent) 1 else 0)

    class DelayedRecipient
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val email: JsonField<String>,
        private val diagnosticCode: JsonField<String>,
        private val status: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("diagnostic_code")
            @ExcludeMissing
            diagnosticCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        ) : this(email, diagnosticCode, status, mutableMapOf())

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun email(): String = email.getRequired("email")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun diagnosticCode(): Optional<String> = diagnosticCode.getOptional("diagnostic_code")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<String> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [diagnosticCode].
         *
         * Unlike [diagnosticCode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("diagnostic_code")
        @ExcludeMissing
        fun _diagnosticCode(): JsonField<String> = diagnosticCode

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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
             * Returns a mutable builder for constructing an instance of [DelayedRecipient].
             *
             * The following fields are required:
             * ```java
             * .email()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [DelayedRecipient]. */
        class Builder internal constructor() {

            private var email: JsonField<String>? = null
            private var diagnosticCode: JsonField<String> = JsonMissing.of()
            private var status: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(delayedRecipient: DelayedRecipient) = apply {
                email = delayedRecipient.email
                diagnosticCode = delayedRecipient.diagnosticCode
                status = delayedRecipient.status
                additionalProperties = delayedRecipient.additionalProperties.toMutableMap()
            }

            fun email(email: String) = email(JsonField.of(email))

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            fun diagnosticCode(diagnosticCode: String) =
                diagnosticCode(JsonField.of(diagnosticCode))

            /**
             * Sets [Builder.diagnosticCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.diagnosticCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun diagnosticCode(diagnosticCode: JsonField<String>) = apply {
                this.diagnosticCode = diagnosticCode
            }

            fun status(status: String) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<String>) = apply { this.status = status }

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
             * Returns an immutable instance of [DelayedRecipient].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .email()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): DelayedRecipient =
                DelayedRecipient(
                    checkRequired("email", email),
                    diagnosticCode,
                    status,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): DelayedRecipient = apply {
            if (validated) {
                return@apply
            }

            email()
            diagnosticCode()
            status()
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
            (if (email.asKnown().isPresent) 1 else 0) +
                (if (diagnosticCode.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DelayedRecipient &&
                email == other.email &&
                diagnosticCode == other.diagnosticCode &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(email, diagnosticCode, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "DelayedRecipient{email=$email, diagnosticCode=$diagnosticCode, status=$status, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DeliveryDelayDetail &&
            delayType == other.delayType &&
            delayedAt == other.delayedAt &&
            delayedRecipients == other.delayedRecipients &&
            deliveryStoppedAt == other.deliveryStoppedAt &&
            reportingMta == other.reportingMta &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            delayType,
            delayedAt,
            delayedRecipients,
            deliveryStoppedAt,
            reportingMta,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DeliveryDelayDetail{delayType=$delayType, delayedAt=$delayedAt, delayedRecipients=$delayedRecipients, deliveryStoppedAt=$deliveryStoppedAt, reportingMta=$reportingMta, additionalProperties=$additionalProperties}"
}
