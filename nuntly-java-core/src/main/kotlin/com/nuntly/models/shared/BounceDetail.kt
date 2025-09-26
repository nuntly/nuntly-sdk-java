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

class BounceDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val bounceSubtype: JsonField<String>,
    private val bounceType: JsonField<String>,
    private val bouncedAt: JsonField<String>,
    private val bouncedRecipients: JsonField<List<BouncedRecipient>>,
    private val feedbackId: JsonField<String>,
    private val reportingMta: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("bounce_subtype")
        @ExcludeMissing
        bounceSubtype: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bounce_type")
        @ExcludeMissing
        bounceType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bounced_at") @ExcludeMissing bouncedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bounced_recipients")
        @ExcludeMissing
        bouncedRecipients: JsonField<List<BouncedRecipient>> = JsonMissing.of(),
        @JsonProperty("feedback_id")
        @ExcludeMissing
        feedbackId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reporting_mta")
        @ExcludeMissing
        reportingMta: JsonField<String> = JsonMissing.of(),
    ) : this(
        bounceSubtype,
        bounceType,
        bouncedAt,
        bouncedRecipients,
        feedbackId,
        reportingMta,
        mutableMapOf(),
    )

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bounceSubtype(): String = bounceSubtype.getRequired("bounce_subtype")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bounceType(): String = bounceType.getRequired("bounce_type")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bouncedAt(): String = bouncedAt.getRequired("bounced_at")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bouncedRecipients(): List<BouncedRecipient> =
        bouncedRecipients.getRequired("bounced_recipients")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun feedbackId(): String = feedbackId.getRequired("feedback_id")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reportingMta(): Optional<String> = reportingMta.getOptional("reporting_mta")

    /**
     * Returns the raw JSON value of [bounceSubtype].
     *
     * Unlike [bounceSubtype], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bounce_subtype")
    @ExcludeMissing
    fun _bounceSubtype(): JsonField<String> = bounceSubtype

    /**
     * Returns the raw JSON value of [bounceType].
     *
     * Unlike [bounceType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bounce_type") @ExcludeMissing fun _bounceType(): JsonField<String> = bounceType

    /**
     * Returns the raw JSON value of [bouncedAt].
     *
     * Unlike [bouncedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bounced_at") @ExcludeMissing fun _bouncedAt(): JsonField<String> = bouncedAt

    /**
     * Returns the raw JSON value of [bouncedRecipients].
     *
     * Unlike [bouncedRecipients], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("bounced_recipients")
    @ExcludeMissing
    fun _bouncedRecipients(): JsonField<List<BouncedRecipient>> = bouncedRecipients

    /**
     * Returns the raw JSON value of [feedbackId].
     *
     * Unlike [feedbackId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("feedback_id") @ExcludeMissing fun _feedbackId(): JsonField<String> = feedbackId

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
         * Returns a mutable builder for constructing an instance of [BounceDetail].
         *
         * The following fields are required:
         * ```java
         * .bounceSubtype()
         * .bounceType()
         * .bouncedAt()
         * .bouncedRecipients()
         * .feedbackId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BounceDetail]. */
    class Builder internal constructor() {

        private var bounceSubtype: JsonField<String>? = null
        private var bounceType: JsonField<String>? = null
        private var bouncedAt: JsonField<String>? = null
        private var bouncedRecipients: JsonField<MutableList<BouncedRecipient>>? = null
        private var feedbackId: JsonField<String>? = null
        private var reportingMta: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(bounceDetail: BounceDetail) = apply {
            bounceSubtype = bounceDetail.bounceSubtype
            bounceType = bounceDetail.bounceType
            bouncedAt = bounceDetail.bouncedAt
            bouncedRecipients = bounceDetail.bouncedRecipients.map { it.toMutableList() }
            feedbackId = bounceDetail.feedbackId
            reportingMta = bounceDetail.reportingMta
            additionalProperties = bounceDetail.additionalProperties.toMutableMap()
        }

        fun bounceSubtype(bounceSubtype: String) = bounceSubtype(JsonField.of(bounceSubtype))

        /**
         * Sets [Builder.bounceSubtype] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bounceSubtype] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bounceSubtype(bounceSubtype: JsonField<String>) = apply {
            this.bounceSubtype = bounceSubtype
        }

        fun bounceType(bounceType: String) = bounceType(JsonField.of(bounceType))

        /**
         * Sets [Builder.bounceType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bounceType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bounceType(bounceType: JsonField<String>) = apply { this.bounceType = bounceType }

        fun bouncedAt(bouncedAt: String) = bouncedAt(JsonField.of(bouncedAt))

        /**
         * Sets [Builder.bouncedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bouncedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bouncedAt(bouncedAt: JsonField<String>) = apply { this.bouncedAt = bouncedAt }

        fun bouncedRecipients(bouncedRecipients: List<BouncedRecipient>) =
            bouncedRecipients(JsonField.of(bouncedRecipients))

        /**
         * Sets [Builder.bouncedRecipients] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bouncedRecipients] with a well-typed
         * `List<BouncedRecipient>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun bouncedRecipients(bouncedRecipients: JsonField<List<BouncedRecipient>>) = apply {
            this.bouncedRecipients = bouncedRecipients.map { it.toMutableList() }
        }

        /**
         * Adds a single [BouncedRecipient] to [bouncedRecipients].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addBouncedRecipient(bouncedRecipient: BouncedRecipient) = apply {
            bouncedRecipients =
                (bouncedRecipients ?: JsonField.of(mutableListOf())).also {
                    checkKnown("bouncedRecipients", it).add(bouncedRecipient)
                }
        }

        fun feedbackId(feedbackId: String) = feedbackId(JsonField.of(feedbackId))

        /**
         * Sets [Builder.feedbackId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.feedbackId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun feedbackId(feedbackId: JsonField<String>) = apply { this.feedbackId = feedbackId }

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
         * Returns an immutable instance of [BounceDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .bounceSubtype()
         * .bounceType()
         * .bouncedAt()
         * .bouncedRecipients()
         * .feedbackId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BounceDetail =
            BounceDetail(
                checkRequired("bounceSubtype", bounceSubtype),
                checkRequired("bounceType", bounceType),
                checkRequired("bouncedAt", bouncedAt),
                checkRequired("bouncedRecipients", bouncedRecipients).map { it.toImmutable() },
                checkRequired("feedbackId", feedbackId),
                reportingMta,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BounceDetail = apply {
        if (validated) {
            return@apply
        }

        bounceSubtype()
        bounceType()
        bouncedAt()
        bouncedRecipients().forEach { it.validate() }
        feedbackId()
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
        (if (bounceSubtype.asKnown().isPresent) 1 else 0) +
            (if (bounceType.asKnown().isPresent) 1 else 0) +
            (if (bouncedAt.asKnown().isPresent) 1 else 0) +
            (bouncedRecipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (feedbackId.asKnown().isPresent) 1 else 0) +
            (if (reportingMta.asKnown().isPresent) 1 else 0)

    class BouncedRecipient
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val email: JsonField<String>,
        private val action: JsonField<String>,
        private val diagnosticCode: JsonField<String>,
        private val status: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("action") @ExcludeMissing action: JsonField<String> = JsonMissing.of(),
            @JsonProperty("diagnostic_code")
            @ExcludeMissing
            diagnosticCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        ) : this(email, action, diagnosticCode, status, mutableMapOf())

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun email(): String = email.getRequired("email")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun action(): Optional<String> = action.getOptional("action")

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
         * Returns the raw JSON value of [action].
         *
         * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<String> = action

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
             * Returns a mutable builder for constructing an instance of [BouncedRecipient].
             *
             * The following fields are required:
             * ```java
             * .email()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BouncedRecipient]. */
        class Builder internal constructor() {

            private var email: JsonField<String>? = null
            private var action: JsonField<String> = JsonMissing.of()
            private var diagnosticCode: JsonField<String> = JsonMissing.of()
            private var status: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(bouncedRecipient: BouncedRecipient) = apply {
                email = bouncedRecipient.email
                action = bouncedRecipient.action
                diagnosticCode = bouncedRecipient.diagnosticCode
                status = bouncedRecipient.status
                additionalProperties = bouncedRecipient.additionalProperties.toMutableMap()
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

            fun action(action: String) = action(JsonField.of(action))

            /**
             * Sets [Builder.action] to an arbitrary JSON value.
             *
             * You should usually call [Builder.action] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun action(action: JsonField<String>) = apply { this.action = action }

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
             * Returns an immutable instance of [BouncedRecipient].
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
            fun build(): BouncedRecipient =
                BouncedRecipient(
                    checkRequired("email", email),
                    action,
                    diagnosticCode,
                    status,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): BouncedRecipient = apply {
            if (validated) {
                return@apply
            }

            email()
            action()
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
                (if (action.asKnown().isPresent) 1 else 0) +
                (if (diagnosticCode.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is BouncedRecipient &&
                email == other.email &&
                action == other.action &&
                diagnosticCode == other.diagnosticCode &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(email, action, diagnosticCode, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BouncedRecipient{email=$email, action=$action, diagnosticCode=$diagnosticCode, status=$status, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BounceDetail &&
            bounceSubtype == other.bounceSubtype &&
            bounceType == other.bounceType &&
            bouncedAt == other.bouncedAt &&
            bouncedRecipients == other.bouncedRecipients &&
            feedbackId == other.feedbackId &&
            reportingMta == other.reportingMta &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            bounceSubtype,
            bounceType,
            bouncedAt,
            bouncedRecipients,
            feedbackId,
            reportingMta,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BounceDetail{bounceSubtype=$bounceSubtype, bounceType=$bounceType, bouncedAt=$bouncedAt, bouncedRecipients=$bouncedRecipients, feedbackId=$feedbackId, reportingMta=$reportingMta, additionalProperties=$additionalProperties}"
}
