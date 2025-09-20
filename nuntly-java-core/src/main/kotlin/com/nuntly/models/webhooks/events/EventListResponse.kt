// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks.events

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
import com.nuntly.errors.NuntlyInvalidDataException
import com.nuntly.models.shared.EventType
import com.nuntly.models.webhooks.EmailBouncedEvent
import com.nuntly.models.webhooks.EmailClickedEvent
import com.nuntly.models.webhooks.EmailComplainedEvent
import com.nuntly.models.webhooks.EmailDeliveredEvent
import com.nuntly.models.webhooks.EmailDeliveryDelayedEvent
import com.nuntly.models.webhooks.EmailFailedEvent
import com.nuntly.models.webhooks.EmailOpenedEvent
import com.nuntly.models.webhooks.EmailRejectedEvent
import com.nuntly.models.webhooks.EmailSentEvent
import com.nuntly.models.webhooks.Event
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class EventListResponse
private constructor(
    private val id: JsonField<String>,
    private val data: JsonField<Event>,
    private val event: JsonField<EventType>,
    private val orgId: JsonField<String>,
    private val receivedAt: JsonField<OffsetDateTime>,
    private val status: JsonField<Status>,
    private val webhookId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Event> = JsonMissing.of(),
        @JsonProperty("event") @ExcludeMissing event: JsonField<EventType> = JsonMissing.of(),
        @JsonProperty("org_id") @ExcludeMissing orgId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("received_at")
        @ExcludeMissing
        receivedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("webhook_id") @ExcludeMissing webhookId: JsonField<String> = JsonMissing.of(),
    ) : this(id, data, event, orgId, receivedAt, status, webhookId, mutableMapOf())

    /**
     * The id of the webhook event
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The event payload
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): Event = data.getRequired("data")

    /**
     * Type of the event
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun event(): EventType = event.getRequired("event")

    /**
     * The id of the organization
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orgId(): String = orgId.getRequired("org_id")

    /**
     * The timestamp when the event was received by the webhook system
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun receivedAt(): OffsetDateTime = receivedAt.getRequired("received_at")

    /**
     * Status of the webhook delivery attempt
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The id of the webhook
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun webhookId(): String = webhookId.getRequired("webhook_id")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Event> = data

    /**
     * Returns the raw JSON value of [event].
     *
     * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event") @ExcludeMissing fun _event(): JsonField<EventType> = event

    /**
     * Returns the raw JSON value of [orgId].
     *
     * Unlike [orgId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("org_id") @ExcludeMissing fun _orgId(): JsonField<String> = orgId

    /**
     * Returns the raw JSON value of [receivedAt].
     *
     * Unlike [receivedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("received_at")
    @ExcludeMissing
    fun _receivedAt(): JsonField<OffsetDateTime> = receivedAt

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [webhookId].
     *
     * Unlike [webhookId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("webhook_id") @ExcludeMissing fun _webhookId(): JsonField<String> = webhookId

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
         * .data()
         * .event()
         * .orgId()
         * .receivedAt()
         * .status()
         * .webhookId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EventListResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var data: JsonField<Event>? = null
        private var event: JsonField<EventType>? = null
        private var orgId: JsonField<String>? = null
        private var receivedAt: JsonField<OffsetDateTime>? = null
        private var status: JsonField<Status>? = null
        private var webhookId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eventListResponse: EventListResponse) = apply {
            id = eventListResponse.id
            data = eventListResponse.data
            event = eventListResponse.event
            orgId = eventListResponse.orgId
            receivedAt = eventListResponse.receivedAt
            status = eventListResponse.status
            webhookId = eventListResponse.webhookId
            additionalProperties = eventListResponse.additionalProperties.toMutableMap()
        }

        /** The id of the webhook event */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The event payload */
        fun data(data: Event) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Event] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Event>) = apply { this.data = data }

        /** Alias for calling [data] with `Event.ofEmailSent(emailSent)`. */
        fun data(emailSent: EmailSentEvent) = data(Event.ofEmailSent(emailSent))

        /** Alias for calling [data] with `Event.ofEmailDelivered(emailDelivered)`. */
        fun data(emailDelivered: EmailDeliveredEvent) = data(Event.ofEmailDelivered(emailDelivered))

        /** Alias for calling [data] with `Event.ofEmailOpened(emailOpened)`. */
        fun data(emailOpened: EmailOpenedEvent) = data(Event.ofEmailOpened(emailOpened))

        /** Alias for calling [data] with `Event.ofEmailClicked(emailClicked)`. */
        fun data(emailClicked: EmailClickedEvent) = data(Event.ofEmailClicked(emailClicked))

        /** Alias for calling [data] with `Event.ofEmailBounced(emailBounced)`. */
        fun data(emailBounced: EmailBouncedEvent) = data(Event.ofEmailBounced(emailBounced))

        /** Alias for calling [data] with `Event.ofEmailComplained(emailComplained)`. */
        fun data(emailComplained: EmailComplainedEvent) =
            data(Event.ofEmailComplained(emailComplained))

        /** Alias for calling [data] with `Event.ofEmailRejected(emailRejected)`. */
        fun data(emailRejected: EmailRejectedEvent) = data(Event.ofEmailRejected(emailRejected))

        /** Alias for calling [data] with `Event.ofEmailDeliveryDelayed(emailDeliveryDelayed)`. */
        fun data(emailDeliveryDelayed: EmailDeliveryDelayedEvent) =
            data(Event.ofEmailDeliveryDelayed(emailDeliveryDelayed))

        /** Alias for calling [data] with `Event.ofEmailFailed(emailFailed)`. */
        fun data(emailFailed: EmailFailedEvent) = data(Event.ofEmailFailed(emailFailed))

        /** Type of the event */
        fun event(event: EventType) = event(JsonField.of(event))

        /**
         * Sets [Builder.event] to an arbitrary JSON value.
         *
         * You should usually call [Builder.event] with a well-typed [EventType] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun event(event: JsonField<EventType>) = apply { this.event = event }

        /** The id of the organization */
        fun orgId(orgId: String) = orgId(JsonField.of(orgId))

        /**
         * Sets [Builder.orgId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orgId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun orgId(orgId: JsonField<String>) = apply { this.orgId = orgId }

        /** The timestamp when the event was received by the webhook system */
        fun receivedAt(receivedAt: OffsetDateTime) = receivedAt(JsonField.of(receivedAt))

        /**
         * Sets [Builder.receivedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.receivedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun receivedAt(receivedAt: JsonField<OffsetDateTime>) = apply {
            this.receivedAt = receivedAt
        }

        /** Status of the webhook delivery attempt */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The id of the webhook */
        fun webhookId(webhookId: String) = webhookId(JsonField.of(webhookId))

        /**
         * Sets [Builder.webhookId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.webhookId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun webhookId(webhookId: JsonField<String>) = apply { this.webhookId = webhookId }

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
         * .data()
         * .event()
         * .orgId()
         * .receivedAt()
         * .status()
         * .webhookId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EventListResponse =
            EventListResponse(
                checkRequired("id", id),
                checkRequired("data", data),
                checkRequired("event", event),
                checkRequired("orgId", orgId),
                checkRequired("receivedAt", receivedAt),
                checkRequired("status", status),
                checkRequired("webhookId", webhookId),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EventListResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        data().validate()
        event().validate()
        orgId()
        receivedAt()
        status().validate()
        webhookId()
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
            (data.asKnown().getOrNull()?.validity() ?: 0) +
            (event.asKnown().getOrNull()?.validity() ?: 0) +
            (if (orgId.asKnown().isPresent) 1 else 0) +
            (if (receivedAt.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (webhookId.asKnown().isPresent) 1 else 0)

    /** Status of the webhook delivery attempt */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SUCCESS = of("success")

            @JvmField val PENDING = of("pending")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            SUCCESS,
            PENDING,
            FAILED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SUCCESS,
            PENDING,
            FAILED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                SUCCESS -> Value.SUCCESS
                PENDING -> Value.PENDING
                FAILED -> Value.FAILED
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
                SUCCESS -> Known.SUCCESS
                PENDING -> Known.PENDING
                FAILED -> Known.FAILED
                else -> throw NuntlyInvalidDataException("Unknown Status: $value")
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

        fun validate(): Status = apply {
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

            return other is Status && value == other.value
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
            data == other.data &&
            event == other.event &&
            orgId == other.orgId &&
            receivedAt == other.receivedAt &&
            status == other.status &&
            webhookId == other.webhookId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, data, event, orgId, receivedAt, status, webhookId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EventListResponse{id=$id, data=$data, event=$event, orgId=$orgId, receivedAt=$receivedAt, status=$status, webhookId=$webhookId, additionalProperties=$additionalProperties}"
}
