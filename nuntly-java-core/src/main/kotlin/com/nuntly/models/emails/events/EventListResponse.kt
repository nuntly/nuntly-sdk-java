// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.events

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.Enum
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.checkRequired
import com.nuntly.core.toImmutable
import com.nuntly.errors.NuntlyInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class EventListResponse
private constructor(
    private val id: JsonField<String>,
    private val details: JsonField<Details>,
    private val emailId: JsonField<String>,
    private val eventAt: JsonField<OffsetDateTime>,
    private val kind: JsonField<Kind>,
    private val orgId: JsonField<String>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("details") @ExcludeMissing details: JsonField<Details> = JsonMissing.of(),
        @JsonProperty("email_id") @ExcludeMissing emailId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("event_at")
        @ExcludeMissing
        eventAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("kind") @ExcludeMissing kind: JsonField<Kind> = JsonMissing.of(),
        @JsonProperty("org_id") @ExcludeMissing orgId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(id, details, emailId, eventAt, kind, orgId, type, mutableMapOf())

    /**
     * The email event id
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Detail of the event
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun details(): Details = details.getRequired("details")

    /**
     * The id of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun emailId(): String = emailId.getRequired("email_id")

    /**
     * Date at which the events occurs (ISO 8601 format)
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventAt(): OffsetDateTime = eventAt.getRequired("event_at")

    /**
     * The kind of object returned
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun kind(): Kind = kind.getRequired("kind")

    /**
     * The id of the organization
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orgId(): String = orgId.getRequired("org_id")

    /**
     * The type of the email event
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [details].
     *
     * Unlike [details], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("details") @ExcludeMissing fun _details(): JsonField<Details> = details

    /**
     * Returns the raw JSON value of [emailId].
     *
     * Unlike [emailId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email_id") @ExcludeMissing fun _emailId(): JsonField<String> = emailId

    /**
     * Returns the raw JSON value of [eventAt].
     *
     * Unlike [eventAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_at") @ExcludeMissing fun _eventAt(): JsonField<OffsetDateTime> = eventAt

    /**
     * Returns the raw JSON value of [kind].
     *
     * Unlike [kind], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<Kind> = kind

    /**
     * Returns the raw JSON value of [orgId].
     *
     * Unlike [orgId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("org_id") @ExcludeMissing fun _orgId(): JsonField<String> = orgId

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
         * Returns a mutable builder for constructing an instance of [EventListResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .details()
         * .emailId()
         * .eventAt()
         * .kind()
         * .orgId()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EventListResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var details: JsonField<Details>? = null
        private var emailId: JsonField<String>? = null
        private var eventAt: JsonField<OffsetDateTime>? = null
        private var kind: JsonField<Kind>? = null
        private var orgId: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eventListResponse: EventListResponse) = apply {
            id = eventListResponse.id
            details = eventListResponse.details
            emailId = eventListResponse.emailId
            eventAt = eventListResponse.eventAt
            kind = eventListResponse.kind
            orgId = eventListResponse.orgId
            type = eventListResponse.type
            additionalProperties = eventListResponse.additionalProperties.toMutableMap()
        }

        /** The email event id */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Detail of the event */
        fun details(details: Details) = details(JsonField.of(details))

        /**
         * Sets [Builder.details] to an arbitrary JSON value.
         *
         * You should usually call [Builder.details] with a well-typed [Details] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun details(details: JsonField<Details>) = apply { this.details = details }

        /** The id of the email */
        fun emailId(emailId: String) = emailId(JsonField.of(emailId))

        /**
         * Sets [Builder.emailId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.emailId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun emailId(emailId: JsonField<String>) = apply { this.emailId = emailId }

        /** Date at which the events occurs (ISO 8601 format) */
        fun eventAt(eventAt: OffsetDateTime) = eventAt(JsonField.of(eventAt))

        /**
         * Sets [Builder.eventAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun eventAt(eventAt: JsonField<OffsetDateTime>) = apply { this.eventAt = eventAt }

        /** The kind of object returned */
        fun kind(kind: Kind) = kind(JsonField.of(kind))

        /**
         * Sets [Builder.kind] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kind] with a well-typed [Kind] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun kind(kind: JsonField<Kind>) = apply { this.kind = kind }

        /** The id of the organization */
        fun orgId(orgId: String) = orgId(JsonField.of(orgId))

        /**
         * Sets [Builder.orgId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orgId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun orgId(orgId: JsonField<String>) = apply { this.orgId = orgId }

        /** The type of the email event */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
         * Returns an immutable instance of [EventListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .details()
         * .emailId()
         * .eventAt()
         * .kind()
         * .orgId()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EventListResponse =
            EventListResponse(
                checkRequired("id", id),
                checkRequired("details", details),
                checkRequired("emailId", emailId),
                checkRequired("eventAt", eventAt),
                checkRequired("kind", kind),
                checkRequired("orgId", orgId),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EventListResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        details().validate()
        emailId()
        eventAt()
        kind().validate()
        orgId()
        type().validate()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (details.asKnown().getOrNull()?.validity() ?: 0) +
            (if (emailId.asKnown().isPresent) 1 else 0) +
            (if (eventAt.asKnown().isPresent) 1 else 0) +
            (kind.asKnown().getOrNull()?.validity() ?: 0) +
            (if (orgId.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /** Detail of the event */
    class Details
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

            /** Returns a mutable builder for constructing an instance of [Details]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Details]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(details: Details) = apply {
                additionalProperties = details.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Details].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Details = Details(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Details = apply {
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

            return other is Details && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Details{additionalProperties=$additionalProperties}"
    }

    /** The kind of object returned */
    class Kind @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val EVENT_EMAIL = of("event-email")

            @JvmStatic fun of(value: String) = Kind(JsonField.of(value))
        }

        /** An enum containing [Kind]'s known values. */
        enum class Known {
            EVENT_EMAIL
        }

        /**
         * An enum containing [Kind]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Kind] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            EVENT_EMAIL,
            /** An enum member indicating that [Kind] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                EVENT_EMAIL -> Value.EVENT_EMAIL
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws NuntlyInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                EVENT_EMAIL -> Known.EVENT_EMAIL
                else -> throw NuntlyInvalidDataException("Unknown Kind: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws NuntlyInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { NuntlyInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Kind = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Kind && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The type of the email event */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val EMAIL_QUEUED = of("email.queued")

            @JvmField val EMAIL_SCHEDULED = of("email.scheduled")

            @JvmField val EMAIL_PROCESSED = of("email.processed")

            @JvmField val EMAIL_SENDING = of("email.sending")

            @JvmField val EMAIL_SENT = of("email.sent")

            @JvmField val EMAIL_DELIVERED = of("email.delivered")

            @JvmField val EMAIL_OPENED = of("email.opened")

            @JvmField val EMAIL_CLICKED = of("email.clicked")

            @JvmField val EMAIL_BOUNCED = of("email.bounced")

            @JvmField val EMAIL_COMPLAINED = of("email.complained")

            @JvmField val EMAIL_REJECTED = of("email.rejected")

            @JvmField val EMAIL_DELIVERY_DELAYED = of("email.delivery_delayed")

            @JvmField val EMAIL_FAILED = of("email.failed")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            EMAIL_QUEUED,
            EMAIL_SCHEDULED,
            EMAIL_PROCESSED,
            EMAIL_SENDING,
            EMAIL_SENT,
            EMAIL_DELIVERED,
            EMAIL_OPENED,
            EMAIL_CLICKED,
            EMAIL_BOUNCED,
            EMAIL_COMPLAINED,
            EMAIL_REJECTED,
            EMAIL_DELIVERY_DELAYED,
            EMAIL_FAILED,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            EMAIL_QUEUED,
            EMAIL_SCHEDULED,
            EMAIL_PROCESSED,
            EMAIL_SENDING,
            EMAIL_SENT,
            EMAIL_DELIVERED,
            EMAIL_OPENED,
            EMAIL_CLICKED,
            EMAIL_BOUNCED,
            EMAIL_COMPLAINED,
            EMAIL_REJECTED,
            EMAIL_DELIVERY_DELAYED,
            EMAIL_FAILED,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                EMAIL_QUEUED -> Value.EMAIL_QUEUED
                EMAIL_SCHEDULED -> Value.EMAIL_SCHEDULED
                EMAIL_PROCESSED -> Value.EMAIL_PROCESSED
                EMAIL_SENDING -> Value.EMAIL_SENDING
                EMAIL_SENT -> Value.EMAIL_SENT
                EMAIL_DELIVERED -> Value.EMAIL_DELIVERED
                EMAIL_OPENED -> Value.EMAIL_OPENED
                EMAIL_CLICKED -> Value.EMAIL_CLICKED
                EMAIL_BOUNCED -> Value.EMAIL_BOUNCED
                EMAIL_COMPLAINED -> Value.EMAIL_COMPLAINED
                EMAIL_REJECTED -> Value.EMAIL_REJECTED
                EMAIL_DELIVERY_DELAYED -> Value.EMAIL_DELIVERY_DELAYED
                EMAIL_FAILED -> Value.EMAIL_FAILED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws NuntlyInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                EMAIL_QUEUED -> Known.EMAIL_QUEUED
                EMAIL_SCHEDULED -> Known.EMAIL_SCHEDULED
                EMAIL_PROCESSED -> Known.EMAIL_PROCESSED
                EMAIL_SENDING -> Known.EMAIL_SENDING
                EMAIL_SENT -> Known.EMAIL_SENT
                EMAIL_DELIVERED -> Known.EMAIL_DELIVERED
                EMAIL_OPENED -> Known.EMAIL_OPENED
                EMAIL_CLICKED -> Known.EMAIL_CLICKED
                EMAIL_BOUNCED -> Known.EMAIL_BOUNCED
                EMAIL_COMPLAINED -> Known.EMAIL_COMPLAINED
                EMAIL_REJECTED -> Known.EMAIL_REJECTED
                EMAIL_DELIVERY_DELAYED -> Known.EMAIL_DELIVERY_DELAYED
                EMAIL_FAILED -> Known.EMAIL_FAILED
                else -> throw NuntlyInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws NuntlyInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { NuntlyInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Type = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EventListResponse &&
            id == other.id &&
            details == other.details &&
            emailId == other.emailId &&
            eventAt == other.eventAt &&
            kind == other.kind &&
            orgId == other.orgId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, details, emailId, eventAt, kind, orgId, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EventListResponse{id=$id, details=$details, emailId=$emailId, eventAt=$eventAt, kind=$kind, orgId=$orgId, type=$type, additionalProperties=$additionalProperties}"
}
