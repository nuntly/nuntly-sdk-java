// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.Enum
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

class DomainCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val clickTracking: JsonField<Boolean>,
    private val createdAt: JsonField<String>,
    private val name: JsonField<String>,
    private val openTracking: JsonField<Boolean>,
    private val region: JsonField<Region>,
    private val sendingRecords: JsonField<List<SendingRecord>>,
    private val sendingStatus: JsonField<SendingStatus>,
    private val status: JsonField<Status>,
    private val statusAt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("clickTracking")
        @ExcludeMissing
        clickTracking: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("openTracking")
        @ExcludeMissing
        openTracking: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("region") @ExcludeMissing region: JsonField<Region> = JsonMissing.of(),
        @JsonProperty("sendingRecords")
        @ExcludeMissing
        sendingRecords: JsonField<List<SendingRecord>> = JsonMissing.of(),
        @JsonProperty("sendingStatus")
        @ExcludeMissing
        sendingStatus: JsonField<SendingStatus> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("statusAt") @ExcludeMissing statusAt: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        clickTracking,
        createdAt,
        name,
        openTracking,
        region,
        sendingRecords,
        sendingStatus,
        status,
        statusAt,
        mutableMapOf(),
    )

    /**
     * The id of the domain
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Emit an event for each time the recipient clicks a link in the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun clickTracking(): Boolean = clickTracking.getRequired("clickTracking")

    /**
     * Date at which the object was created (ISO 8601 format)
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): String = createdAt.getRequired("createdAt")

    /**
     * The name of the domain to send e-mails'
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * Emit an event for each recipient opens an email their email client
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun openTracking(): Boolean = openTracking.getRequired("openTracking")

    /**
     * The region of the domain data
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun region(): Region = region.getRequired("region")

    /**
     * The records for your domain
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sendingRecords(): List<SendingRecord> = sendingRecords.getRequired("sendingRecords")

    /**
     * The sending status for the domain
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sendingStatus(): SendingStatus = sendingStatus.getRequired("sendingStatus")

    /**
     * The status for the domain
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The date of the lastest verification of this record
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun statusAt(): String = statusAt.getRequired("statusAt")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [clickTracking].
     *
     * Unlike [clickTracking], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("clickTracking")
    @ExcludeMissing
    fun _clickTracking(): JsonField<Boolean> = clickTracking

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [openTracking].
     *
     * Unlike [openTracking], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("openTracking")
    @ExcludeMissing
    fun _openTracking(): JsonField<Boolean> = openTracking

    /**
     * Returns the raw JSON value of [region].
     *
     * Unlike [region], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("region") @ExcludeMissing fun _region(): JsonField<Region> = region

    /**
     * Returns the raw JSON value of [sendingRecords].
     *
     * Unlike [sendingRecords], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sendingRecords")
    @ExcludeMissing
    fun _sendingRecords(): JsonField<List<SendingRecord>> = sendingRecords

    /**
     * Returns the raw JSON value of [sendingStatus].
     *
     * Unlike [sendingStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sendingStatus")
    @ExcludeMissing
    fun _sendingStatus(): JsonField<SendingStatus> = sendingStatus

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [statusAt].
     *
     * Unlike [statusAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("statusAt") @ExcludeMissing fun _statusAt(): JsonField<String> = statusAt

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
         * Returns a mutable builder for constructing an instance of [DomainCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .clickTracking()
         * .createdAt()
         * .name()
         * .openTracking()
         * .region()
         * .sendingRecords()
         * .sendingStatus()
         * .status()
         * .statusAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DomainCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var clickTracking: JsonField<Boolean>? = null
        private var createdAt: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var openTracking: JsonField<Boolean>? = null
        private var region: JsonField<Region>? = null
        private var sendingRecords: JsonField<MutableList<SendingRecord>>? = null
        private var sendingStatus: JsonField<SendingStatus>? = null
        private var status: JsonField<Status>? = null
        private var statusAt: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(domainCreateResponse: DomainCreateResponse) = apply {
            id = domainCreateResponse.id
            clickTracking = domainCreateResponse.clickTracking
            createdAt = domainCreateResponse.createdAt
            name = domainCreateResponse.name
            openTracking = domainCreateResponse.openTracking
            region = domainCreateResponse.region
            sendingRecords = domainCreateResponse.sendingRecords.map { it.toMutableList() }
            sendingStatus = domainCreateResponse.sendingStatus
            status = domainCreateResponse.status
            statusAt = domainCreateResponse.statusAt
            additionalProperties = domainCreateResponse.additionalProperties.toMutableMap()
        }

        /** The id of the domain */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Emit an event for each time the recipient clicks a link in the email */
        fun clickTracking(clickTracking: Boolean) = clickTracking(JsonField.of(clickTracking))

        /**
         * Sets [Builder.clickTracking] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clickTracking] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun clickTracking(clickTracking: JsonField<Boolean>) = apply {
            this.clickTracking = clickTracking
        }

        /** Date at which the object was created (ISO 8601 format) */
        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

        /** The name of the domain to send e-mails' */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Emit an event for each recipient opens an email their email client */
        fun openTracking(openTracking: Boolean) = openTracking(JsonField.of(openTracking))

        /**
         * Sets [Builder.openTracking] to an arbitrary JSON value.
         *
         * You should usually call [Builder.openTracking] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun openTracking(openTracking: JsonField<Boolean>) = apply {
            this.openTracking = openTracking
        }

        /** The region of the domain data */
        fun region(region: Region) = region(JsonField.of(region))

        /**
         * Sets [Builder.region] to an arbitrary JSON value.
         *
         * You should usually call [Builder.region] with a well-typed [Region] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun region(region: JsonField<Region>) = apply { this.region = region }

        /** The records for your domain */
        fun sendingRecords(sendingRecords: List<SendingRecord>) =
            sendingRecords(JsonField.of(sendingRecords))

        /**
         * Sets [Builder.sendingRecords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sendingRecords] with a well-typed `List<SendingRecord>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun sendingRecords(sendingRecords: JsonField<List<SendingRecord>>) = apply {
            this.sendingRecords = sendingRecords.map { it.toMutableList() }
        }

        /**
         * Adds a single [SendingRecord] to [sendingRecords].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSendingRecord(sendingRecord: SendingRecord) = apply {
            sendingRecords =
                (sendingRecords ?: JsonField.of(mutableListOf())).also {
                    checkKnown("sendingRecords", it).add(sendingRecord)
                }
        }

        /** The sending status for the domain */
        fun sendingStatus(sendingStatus: SendingStatus) = sendingStatus(JsonField.of(sendingStatus))

        /**
         * Sets [Builder.sendingStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sendingStatus] with a well-typed [SendingStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sendingStatus(sendingStatus: JsonField<SendingStatus>) = apply {
            this.sendingStatus = sendingStatus
        }

        /** The status for the domain */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The date of the lastest verification of this record */
        fun statusAt(statusAt: String) = statusAt(JsonField.of(statusAt))

        /**
         * Sets [Builder.statusAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusAt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun statusAt(statusAt: JsonField<String>) = apply { this.statusAt = statusAt }

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
         * Returns an immutable instance of [DomainCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .clickTracking()
         * .createdAt()
         * .name()
         * .openTracking()
         * .region()
         * .sendingRecords()
         * .sendingStatus()
         * .status()
         * .statusAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DomainCreateResponse =
            DomainCreateResponse(
                checkRequired("id", id),
                checkRequired("clickTracking", clickTracking),
                checkRequired("createdAt", createdAt),
                checkRequired("name", name),
                checkRequired("openTracking", openTracking),
                checkRequired("region", region),
                checkRequired("sendingRecords", sendingRecords).map { it.toImmutable() },
                checkRequired("sendingStatus", sendingStatus),
                checkRequired("status", status),
                checkRequired("statusAt", statusAt),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DomainCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        clickTracking()
        createdAt()
        name()
        openTracking()
        region().validate()
        sendingRecords().forEach { it.validate() }
        sendingStatus().validate()
        status().validate()
        statusAt()
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
            (if (clickTracking.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (openTracking.asKnown().isPresent) 1 else 0) +
            (region.asKnown().getOrNull()?.validity() ?: 0) +
            (sendingRecords.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (sendingStatus.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (statusAt.asKnown().isPresent) 1 else 0)

    /** The region of the domain data */
    class Region @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val EU_WEST_1 = of("eu-west-1")

            @JvmStatic fun of(value: String) = Region(JsonField.of(value))
        }

        /** An enum containing [Region]'s known values. */
        enum class Known {
            EU_WEST_1
        }

        /**
         * An enum containing [Region]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Region] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            EU_WEST_1,
            /** An enum member indicating that [Region] was instantiated with an unknown value. */
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
                EU_WEST_1 -> Value.EU_WEST_1
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
                EU_WEST_1 -> Known.EU_WEST_1
                else -> throw NuntlyInvalidDataException("Unknown Region: $value")
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

        fun validate(): Region = apply {
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

            return other is Region && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class SendingRecord
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val fullname: JsonField<String>,
        private val group: JsonField<Group>,
        private val name: JsonField<String>,
        private val recordType: JsonField<RecordType>,
        private val status: JsonField<Status>,
        private val statusAt: JsonField<String>,
        private val ttl: JsonField<String>,
        private val value: JsonField<String>,
        private val priority: JsonField<String>,
        private val selector: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("fullname")
            @ExcludeMissing
            fullname: JsonField<String> = JsonMissing.of(),
            @JsonProperty("group") @ExcludeMissing group: JsonField<Group> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("recordType")
            @ExcludeMissing
            recordType: JsonField<RecordType> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("statusAt")
            @ExcludeMissing
            statusAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ttl") @ExcludeMissing ttl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
            @JsonProperty("priority")
            @ExcludeMissing
            priority: JsonField<String> = JsonMissing.of(),
            @JsonProperty("selector") @ExcludeMissing selector: JsonField<String> = JsonMissing.of(),
        ) : this(
            fullname,
            group,
            name,
            recordType,
            status,
            statusAt,
            ttl,
            value,
            priority,
            selector,
            mutableMapOf(),
        )

        /**
         * The FQDN of the domain record
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fullname(): String = fullname.getRequired("fullname")

        /**
         * The group of group: "DKIM", "SPF", "MX" or "DMARC". It is useful to group the records
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun group(): Group = group.getRequired("group")

        /**
         * The name of the record.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * The type of the record: "TXT", "MX" or "CNAME"
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun recordType(): RecordType = recordType.getRequired("recordType")

        /**
         * The status of the record
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * The date of the lastest verification of this record
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun statusAt(): String = statusAt.getRequired("statusAt")

        /**
         * TTL (Time To Live) for this DNS record specifies the duration (in seconds)
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun ttl(): String = ttl.getRequired("ttl")

        /**
         * The value of a DNS record is the data that the record points to
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun value(): String = value.getRequired("value")

        /**
         * Priority in a DNS record, typically used in MX (Mail Exchange) records, specifies the
         * order in which mail servers should be used, with lower values indicating higher priority
         * for email delivery
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun priority(): Optional<String> = priority.getOptional("priority")

        /**
         * A unique identifier in DKIM record to create CNAME records for verifying domain ownership
         * and enabling email authentication
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun selector(): Optional<String> = selector.getOptional("selector")

        /**
         * Returns the raw JSON value of [fullname].
         *
         * Unlike [fullname], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fullname") @ExcludeMissing fun _fullname(): JsonField<String> = fullname

        /**
         * Returns the raw JSON value of [group].
         *
         * Unlike [group], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("group") @ExcludeMissing fun _group(): JsonField<Group> = group

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [recordType].
         *
         * Unlike [recordType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recordType")
        @ExcludeMissing
        fun _recordType(): JsonField<RecordType> = recordType

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [statusAt].
         *
         * Unlike [statusAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("statusAt") @ExcludeMissing fun _statusAt(): JsonField<String> = statusAt

        /**
         * Returns the raw JSON value of [ttl].
         *
         * Unlike [ttl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ttl") @ExcludeMissing fun _ttl(): JsonField<String> = ttl

        /**
         * Returns the raw JSON value of [value].
         *
         * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

        /**
         * Returns the raw JSON value of [priority].
         *
         * Unlike [priority], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("priority") @ExcludeMissing fun _priority(): JsonField<String> = priority

        /**
         * Returns the raw JSON value of [selector].
         *
         * Unlike [selector], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("selector") @ExcludeMissing fun _selector(): JsonField<String> = selector

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
             * Returns a mutable builder for constructing an instance of [SendingRecord].
             *
             * The following fields are required:
             * ```java
             * .fullname()
             * .group()
             * .name()
             * .recordType()
             * .status()
             * .statusAt()
             * .ttl()
             * .value()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SendingRecord]. */
        class Builder internal constructor() {

            private var fullname: JsonField<String>? = null
            private var group: JsonField<Group>? = null
            private var name: JsonField<String>? = null
            private var recordType: JsonField<RecordType>? = null
            private var status: JsonField<Status>? = null
            private var statusAt: JsonField<String>? = null
            private var ttl: JsonField<String>? = null
            private var value: JsonField<String>? = null
            private var priority: JsonField<String> = JsonMissing.of()
            private var selector: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(sendingRecord: SendingRecord) = apply {
                fullname = sendingRecord.fullname
                group = sendingRecord.group
                name = sendingRecord.name
                recordType = sendingRecord.recordType
                status = sendingRecord.status
                statusAt = sendingRecord.statusAt
                ttl = sendingRecord.ttl
                value = sendingRecord.value
                priority = sendingRecord.priority
                selector = sendingRecord.selector
                additionalProperties = sendingRecord.additionalProperties.toMutableMap()
            }

            /** The FQDN of the domain record */
            fun fullname(fullname: String) = fullname(JsonField.of(fullname))

            /**
             * Sets [Builder.fullname] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fullname] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fullname(fullname: JsonField<String>) = apply { this.fullname = fullname }

            /**
             * The group of group: "DKIM", "SPF", "MX" or "DMARC". It is useful to group the records
             */
            fun group(group: Group) = group(JsonField.of(group))

            /**
             * Sets [Builder.group] to an arbitrary JSON value.
             *
             * You should usually call [Builder.group] with a well-typed [Group] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun group(group: JsonField<Group>) = apply { this.group = group }

            /** The name of the record. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The type of the record: "TXT", "MX" or "CNAME" */
            fun recordType(recordType: RecordType) = recordType(JsonField.of(recordType))

            /**
             * Sets [Builder.recordType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recordType] with a well-typed [RecordType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun recordType(recordType: JsonField<RecordType>) = apply {
                this.recordType = recordType
            }

            /** The status of the record */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /** The date of the lastest verification of this record */
            fun statusAt(statusAt: String) = statusAt(JsonField.of(statusAt))

            /**
             * Sets [Builder.statusAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.statusAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun statusAt(statusAt: JsonField<String>) = apply { this.statusAt = statusAt }

            /** TTL (Time To Live) for this DNS record specifies the duration (in seconds) */
            fun ttl(ttl: String) = ttl(JsonField.of(ttl))

            /**
             * Sets [Builder.ttl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ttl] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun ttl(ttl: JsonField<String>) = apply { this.ttl = ttl }

            /** The value of a DNS record is the data that the record points to */
            fun value(value: String) = value(JsonField.of(value))

            /**
             * Sets [Builder.value] to an arbitrary JSON value.
             *
             * You should usually call [Builder.value] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun value(value: JsonField<String>) = apply { this.value = value }

            /**
             * Priority in a DNS record, typically used in MX (Mail Exchange) records, specifies the
             * order in which mail servers should be used, with lower values indicating higher
             * priority for email delivery
             */
            fun priority(priority: String) = priority(JsonField.of(priority))

            /**
             * Sets [Builder.priority] to an arbitrary JSON value.
             *
             * You should usually call [Builder.priority] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun priority(priority: JsonField<String>) = apply { this.priority = priority }

            /**
             * A unique identifier in DKIM record to create CNAME records for verifying domain
             * ownership and enabling email authentication
             */
            fun selector(selector: String) = selector(JsonField.of(selector))

            /**
             * Sets [Builder.selector] to an arbitrary JSON value.
             *
             * You should usually call [Builder.selector] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun selector(selector: JsonField<String>) = apply { this.selector = selector }

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
             * Returns an immutable instance of [SendingRecord].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .fullname()
             * .group()
             * .name()
             * .recordType()
             * .status()
             * .statusAt()
             * .ttl()
             * .value()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): SendingRecord =
                SendingRecord(
                    checkRequired("fullname", fullname),
                    checkRequired("group", group),
                    checkRequired("name", name),
                    checkRequired("recordType", recordType),
                    checkRequired("status", status),
                    checkRequired("statusAt", statusAt),
                    checkRequired("ttl", ttl),
                    checkRequired("value", value),
                    priority,
                    selector,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): SendingRecord = apply {
            if (validated) {
                return@apply
            }

            fullname()
            group().validate()
            name()
            recordType().validate()
            status().validate()
            statusAt()
            ttl()
            value()
            priority()
            selector()
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
            (if (fullname.asKnown().isPresent) 1 else 0) +
                (group.asKnown().getOrNull()?.validity() ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (recordType.asKnown().getOrNull()?.validity() ?: 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (statusAt.asKnown().isPresent) 1 else 0) +
                (if (ttl.asKnown().isPresent) 1 else 0) +
                (if (value.asKnown().isPresent) 1 else 0) +
                (if (priority.asKnown().isPresent) 1 else 0) +
                (if (selector.asKnown().isPresent) 1 else 0)

        /** The group of group: "DKIM", "SPF", "MX" or "DMARC". It is useful to group the records */
        class Group @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val DKIM = of("DKIM")

                @JvmField val SPF = of("SPF")

                @JvmField val MX = of("MX")

                @JvmField val DMARC = of("DMARC")

                @JvmStatic fun of(value: String) = Group(JsonField.of(value))
            }

            /** An enum containing [Group]'s known values. */
            enum class Known {
                DKIM,
                SPF,
                MX,
                DMARC,
            }

            /**
             * An enum containing [Group]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Group] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                DKIM,
                SPF,
                MX,
                DMARC,
                /**
                 * An enum member indicating that [Group] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    DKIM -> Value.DKIM
                    SPF -> Value.SPF
                    MX -> Value.MX
                    DMARC -> Value.DMARC
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws NuntlyInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    DKIM -> Known.DKIM
                    SPF -> Known.SPF
                    MX -> Known.MX
                    DMARC -> Known.DMARC
                    else -> throw NuntlyInvalidDataException("Unknown Group: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws NuntlyInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    NuntlyInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Group = apply {
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

                return other is Group && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The type of the record: "TXT", "MX" or "CNAME" */
        class RecordType @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TXT = of("TXT")

                @JvmField val MX = of("MX")

                @JvmField val CNAME = of("CNAME")

                @JvmStatic fun of(value: String) = RecordType(JsonField.of(value))
            }

            /** An enum containing [RecordType]'s known values. */
            enum class Known {
                TXT,
                MX,
                CNAME,
            }

            /**
             * An enum containing [RecordType]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [RecordType] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TXT,
                MX,
                CNAME,
                /**
                 * An enum member indicating that [RecordType] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    TXT -> Value.TXT
                    MX -> Value.MX
                    CNAME -> Value.CNAME
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws NuntlyInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    TXT -> Known.TXT
                    MX -> Known.MX
                    CNAME -> Known.CNAME
                    else -> throw NuntlyInvalidDataException("Unknown RecordType: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws NuntlyInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    NuntlyInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): RecordType = apply {
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

                return other is RecordType && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The status of the record */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val BOOTSTRAPPING = of("bootstrapping")

                @JvmField val PENDING = of("pending")

                @JvmField val SUCCESS = of("success")

                @JvmField val FAILED = of("failed")

                @JvmField val TEMPORARY_FAILURE = of("temporary_failure")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                BOOTSTRAPPING,
                PENDING,
                SUCCESS,
                FAILED,
                TEMPORARY_FAILURE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                BOOTSTRAPPING,
                PENDING,
                SUCCESS,
                FAILED,
                TEMPORARY_FAILURE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    BOOTSTRAPPING -> Value.BOOTSTRAPPING
                    PENDING -> Value.PENDING
                    SUCCESS -> Value.SUCCESS
                    FAILED -> Value.FAILED
                    TEMPORARY_FAILURE -> Value.TEMPORARY_FAILURE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws NuntlyInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    BOOTSTRAPPING -> Known.BOOTSTRAPPING
                    PENDING -> Known.PENDING
                    SUCCESS -> Known.SUCCESS
                    FAILED -> Known.FAILED
                    TEMPORARY_FAILURE -> Known.TEMPORARY_FAILURE
                    else -> throw NuntlyInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws NuntlyInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    NuntlyInvalidDataException("Value is not a String")
                }

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

            return other is SendingRecord &&
                fullname == other.fullname &&
                group == other.group &&
                name == other.name &&
                recordType == other.recordType &&
                status == other.status &&
                statusAt == other.statusAt &&
                ttl == other.ttl &&
                value == other.value &&
                priority == other.priority &&
                selector == other.selector &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                fullname,
                group,
                name,
                recordType,
                status,
                statusAt,
                ttl,
                value,
                priority,
                selector,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SendingRecord{fullname=$fullname, group=$group, name=$name, recordType=$recordType, status=$status, statusAt=$statusAt, ttl=$ttl, value=$value, priority=$priority, selector=$selector, additionalProperties=$additionalProperties}"
    }

    /** The sending status for the domain */
    class SendingStatus @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val ENABLED = of("enabled")

            @JvmField val DISABLED = of("disabled")

            @JvmStatic fun of(value: String) = SendingStatus(JsonField.of(value))
        }

        /** An enum containing [SendingStatus]'s known values. */
        enum class Known {
            ENABLED,
            DISABLED,
        }

        /**
         * An enum containing [SendingStatus]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [SendingStatus] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ENABLED,
            DISABLED,
            /**
             * An enum member indicating that [SendingStatus] was instantiated with an unknown
             * value.
             */
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
                ENABLED -> Value.ENABLED
                DISABLED -> Value.DISABLED
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
                ENABLED -> Known.ENABLED
                DISABLED -> Known.DISABLED
                else -> throw NuntlyInvalidDataException("Unknown SendingStatus: $value")
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

        fun validate(): SendingStatus = apply {
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

            return other is SendingStatus && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The status for the domain */
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

            @JvmField val BOOTSTRAPPING = of("bootstrapping")

            @JvmField val PENDING = of("pending")

            @JvmField val SUCCESS = of("success")

            @JvmField val FAILED = of("failed")

            @JvmField val TEMPORARY_FAILURE = of("temporary_failure")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            BOOTSTRAPPING,
            PENDING,
            SUCCESS,
            FAILED,
            TEMPORARY_FAILURE,
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
            BOOTSTRAPPING,
            PENDING,
            SUCCESS,
            FAILED,
            TEMPORARY_FAILURE,
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
                BOOTSTRAPPING -> Value.BOOTSTRAPPING
                PENDING -> Value.PENDING
                SUCCESS -> Value.SUCCESS
                FAILED -> Value.FAILED
                TEMPORARY_FAILURE -> Value.TEMPORARY_FAILURE
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
                BOOTSTRAPPING -> Known.BOOTSTRAPPING
                PENDING -> Known.PENDING
                SUCCESS -> Known.SUCCESS
                FAILED -> Known.FAILED
                TEMPORARY_FAILURE -> Known.TEMPORARY_FAILURE
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

        return other is DomainCreateResponse &&
            id == other.id &&
            clickTracking == other.clickTracking &&
            createdAt == other.createdAt &&
            name == other.name &&
            openTracking == other.openTracking &&
            region == other.region &&
            sendingRecords == other.sendingRecords &&
            sendingStatus == other.sendingStatus &&
            status == other.status &&
            statusAt == other.statusAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            clickTracking,
            createdAt,
            name,
            openTracking,
            region,
            sendingRecords,
            sendingStatus,
            status,
            statusAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DomainCreateResponse{id=$id, clickTracking=$clickTracking, createdAt=$createdAt, name=$name, openTracking=$openTracking, region=$region, sendingRecords=$sendingRecords, sendingStatus=$sendingStatus, status=$status, statusAt=$statusAt, additionalProperties=$additionalProperties}"
}
