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

class ComplaintDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val complainedAt: JsonField<String>,
    private val feedbackId: JsonField<String>,
    private val complainedRecipients: JsonField<List<ComplainedRecipient>>,
    private val complaintFeedbackType: JsonField<String>,
    private val complaintSubtype: JsonField<String>,
    private val receivedAt: JsonField<String>,
    private val userAgent: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("complained_at")
        @ExcludeMissing
        complainedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("feedback_id")
        @ExcludeMissing
        feedbackId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("complained_recipients")
        @ExcludeMissing
        complainedRecipients: JsonField<List<ComplainedRecipient>> = JsonMissing.of(),
        @JsonProperty("complaint_feedback_type")
        @ExcludeMissing
        complaintFeedbackType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("complaint_subtype")
        @ExcludeMissing
        complaintSubtype: JsonField<String> = JsonMissing.of(),
        @JsonProperty("received_at")
        @ExcludeMissing
        receivedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("user_agent") @ExcludeMissing userAgent: JsonField<String> = JsonMissing.of(),
    ) : this(
        complainedAt,
        feedbackId,
        complainedRecipients,
        complaintFeedbackType,
        complaintSubtype,
        receivedAt,
        userAgent,
        mutableMapOf(),
    )

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun complainedAt(): String = complainedAt.getRequired("complained_at")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun feedbackId(): String = feedbackId.getRequired("feedback_id")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun complainedRecipients(): Optional<List<ComplainedRecipient>> =
        complainedRecipients.getOptional("complained_recipients")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun complaintFeedbackType(): Optional<String> =
        complaintFeedbackType.getOptional("complaint_feedback_type")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun complaintSubtype(): Optional<String> = complaintSubtype.getOptional("complaint_subtype")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun receivedAt(): Optional<String> = receivedAt.getOptional("received_at")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun userAgent(): Optional<String> = userAgent.getOptional("user_agent")

    /**
     * Returns the raw JSON value of [complainedAt].
     *
     * Unlike [complainedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("complained_at")
    @ExcludeMissing
    fun _complainedAt(): JsonField<String> = complainedAt

    /**
     * Returns the raw JSON value of [feedbackId].
     *
     * Unlike [feedbackId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("feedback_id") @ExcludeMissing fun _feedbackId(): JsonField<String> = feedbackId

    /**
     * Returns the raw JSON value of [complainedRecipients].
     *
     * Unlike [complainedRecipients], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("complained_recipients")
    @ExcludeMissing
    fun _complainedRecipients(): JsonField<List<ComplainedRecipient>> = complainedRecipients

    /**
     * Returns the raw JSON value of [complaintFeedbackType].
     *
     * Unlike [complaintFeedbackType], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("complaint_feedback_type")
    @ExcludeMissing
    fun _complaintFeedbackType(): JsonField<String> = complaintFeedbackType

    /**
     * Returns the raw JSON value of [complaintSubtype].
     *
     * Unlike [complaintSubtype], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("complaint_subtype")
    @ExcludeMissing
    fun _complaintSubtype(): JsonField<String> = complaintSubtype

    /**
     * Returns the raw JSON value of [receivedAt].
     *
     * Unlike [receivedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("received_at") @ExcludeMissing fun _receivedAt(): JsonField<String> = receivedAt

    /**
     * Returns the raw JSON value of [userAgent].
     *
     * Unlike [userAgent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user_agent") @ExcludeMissing fun _userAgent(): JsonField<String> = userAgent

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
         * Returns a mutable builder for constructing an instance of [ComplaintDetail].
         *
         * The following fields are required:
         * ```java
         * .complainedAt()
         * .feedbackId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComplaintDetail]. */
    class Builder internal constructor() {

        private var complainedAt: JsonField<String>? = null
        private var feedbackId: JsonField<String>? = null
        private var complainedRecipients: JsonField<MutableList<ComplainedRecipient>>? = null
        private var complaintFeedbackType: JsonField<String> = JsonMissing.of()
        private var complaintSubtype: JsonField<String> = JsonMissing.of()
        private var receivedAt: JsonField<String> = JsonMissing.of()
        private var userAgent: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(complaintDetail: ComplaintDetail) = apply {
            complainedAt = complaintDetail.complainedAt
            feedbackId = complaintDetail.feedbackId
            complainedRecipients = complaintDetail.complainedRecipients.map { it.toMutableList() }
            complaintFeedbackType = complaintDetail.complaintFeedbackType
            complaintSubtype = complaintDetail.complaintSubtype
            receivedAt = complaintDetail.receivedAt
            userAgent = complaintDetail.userAgent
            additionalProperties = complaintDetail.additionalProperties.toMutableMap()
        }

        fun complainedAt(complainedAt: String) = complainedAt(JsonField.of(complainedAt))

        /**
         * Sets [Builder.complainedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.complainedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun complainedAt(complainedAt: JsonField<String>) = apply {
            this.complainedAt = complainedAt
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

        fun complainedRecipients(complainedRecipients: List<ComplainedRecipient>) =
            complainedRecipients(JsonField.of(complainedRecipients))

        /**
         * Sets [Builder.complainedRecipients] to an arbitrary JSON value.
         *
         * You should usually call [Builder.complainedRecipients] with a well-typed
         * `List<ComplainedRecipient>` value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun complainedRecipients(complainedRecipients: JsonField<List<ComplainedRecipient>>) =
            apply {
                this.complainedRecipients = complainedRecipients.map { it.toMutableList() }
            }

        /**
         * Adds a single [ComplainedRecipient] to [complainedRecipients].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addComplainedRecipient(complainedRecipient: ComplainedRecipient) = apply {
            complainedRecipients =
                (complainedRecipients ?: JsonField.of(mutableListOf())).also {
                    checkKnown("complainedRecipients", it).add(complainedRecipient)
                }
        }

        fun complaintFeedbackType(complaintFeedbackType: String) =
            complaintFeedbackType(JsonField.of(complaintFeedbackType))

        /**
         * Sets [Builder.complaintFeedbackType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.complaintFeedbackType] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun complaintFeedbackType(complaintFeedbackType: JsonField<String>) = apply {
            this.complaintFeedbackType = complaintFeedbackType
        }

        fun complaintSubtype(complaintSubtype: String) =
            complaintSubtype(JsonField.of(complaintSubtype))

        /**
         * Sets [Builder.complaintSubtype] to an arbitrary JSON value.
         *
         * You should usually call [Builder.complaintSubtype] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun complaintSubtype(complaintSubtype: JsonField<String>) = apply {
            this.complaintSubtype = complaintSubtype
        }

        fun receivedAt(receivedAt: String) = receivedAt(JsonField.of(receivedAt))

        /**
         * Sets [Builder.receivedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.receivedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun receivedAt(receivedAt: JsonField<String>) = apply { this.receivedAt = receivedAt }

        fun userAgent(userAgent: String) = userAgent(JsonField.of(userAgent))

        /**
         * Sets [Builder.userAgent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userAgent] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun userAgent(userAgent: JsonField<String>) = apply { this.userAgent = userAgent }

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
         * Returns an immutable instance of [ComplaintDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .complainedAt()
         * .feedbackId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ComplaintDetail =
            ComplaintDetail(
                checkRequired("complainedAt", complainedAt),
                checkRequired("feedbackId", feedbackId),
                (complainedRecipients ?: JsonMissing.of()).map { it.toImmutable() },
                complaintFeedbackType,
                complaintSubtype,
                receivedAt,
                userAgent,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ComplaintDetail = apply {
        if (validated) {
            return@apply
        }

        complainedAt()
        feedbackId()
        complainedRecipients().ifPresent { it.forEach { it.validate() } }
        complaintFeedbackType()
        complaintSubtype()
        receivedAt()
        userAgent()
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
        (if (complainedAt.asKnown().isPresent) 1 else 0) +
            (if (feedbackId.asKnown().isPresent) 1 else 0) +
            (complainedRecipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (complaintFeedbackType.asKnown().isPresent) 1 else 0) +
            (if (complaintSubtype.asKnown().isPresent) 1 else 0) +
            (if (receivedAt.asKnown().isPresent) 1 else 0) +
            (if (userAgent.asKnown().isPresent) 1 else 0)

    class ComplainedRecipient
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val email: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of()
        ) : this(email, mutableMapOf())

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun email(): String = email.getRequired("email")

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

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
             * Returns a mutable builder for constructing an instance of [ComplainedRecipient].
             *
             * The following fields are required:
             * ```java
             * .email()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ComplainedRecipient]. */
        class Builder internal constructor() {

            private var email: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(complainedRecipient: ComplainedRecipient) = apply {
                email = complainedRecipient.email
                additionalProperties = complainedRecipient.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [ComplainedRecipient].
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
            fun build(): ComplainedRecipient =
                ComplainedRecipient(
                    checkRequired("email", email),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ComplainedRecipient = apply {
            if (validated) {
                return@apply
            }

            email()
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
        @JvmSynthetic internal fun validity(): Int = (if (email.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComplainedRecipient &&
                email == other.email &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(email, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ComplainedRecipient{email=$email, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComplaintDetail &&
            complainedAt == other.complainedAt &&
            feedbackId == other.feedbackId &&
            complainedRecipients == other.complainedRecipients &&
            complaintFeedbackType == other.complaintFeedbackType &&
            complaintSubtype == other.complaintSubtype &&
            receivedAt == other.receivedAt &&
            userAgent == other.userAgent &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            complainedAt,
            feedbackId,
            complainedRecipients,
            complaintFeedbackType,
            complaintSubtype,
            receivedAt,
            userAgent,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ComplaintDetail{complainedAt=$complainedAt, feedbackId=$feedbackId, complainedRecipients=$complainedRecipients, complaintFeedbackType=$complaintFeedbackType, complaintSubtype=$complaintSubtype, receivedAt=$receivedAt, userAgent=$userAgent, additionalProperties=$additionalProperties}"
}
