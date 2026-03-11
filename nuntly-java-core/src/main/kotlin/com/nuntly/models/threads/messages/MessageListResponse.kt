// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads.messages

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

class MessageListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val attachmentCount: JsonField<Double>,
    private val bcc: JsonField<List<String>>,
    private val cc: JsonField<List<String>>,
    private val createdAt: JsonField<String>,
    private val from: JsonField<String>,
    private val messageId: JsonField<String>,
    private val receivedAt: JsonField<String>,
    private val replyTo: JsonField<List<String>>,
    private val status: JsonField<Status>,
    private val subject: JsonField<String>,
    private val threadId: JsonField<String>,
    private val to: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("attachmentCount")
        @ExcludeMissing
        attachmentCount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("cc") @ExcludeMissing cc: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
        @JsonProperty("messageId") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("receivedAt")
        @ExcludeMissing
        receivedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("replyTo")
        @ExcludeMissing
        replyTo: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
        @JsonProperty("threadId") @ExcludeMissing threadId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("to") @ExcludeMissing to: JsonField<List<String>> = JsonMissing.of(),
    ) : this(
        id,
        attachmentCount,
        bcc,
        cc,
        createdAt,
        from,
        messageId,
        receivedAt,
        replyTo,
        status,
        subject,
        threadId,
        to,
        mutableMapOf(),
    )

    /**
     * The id of the message
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The number of attachments.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun attachmentCount(): Double = attachmentCount.getRequired("attachmentCount")

    /**
     * The BCC addresses.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bcc(): Optional<List<String>> = bcc.getOptional("bcc")

    /**
     * The CC addresses.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cc(): Optional<List<String>> = cc.getOptional("cc")

    /**
     * Date at which the object was created (ISO 8601 format)
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): String = createdAt.getRequired("createdAt")

    /**
     * The sender address (RFC 5322 format, e.g. "Jane Doe <jane@example.com>" or
     * "jane@example.com").
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun from(): String = from.getRequired("from")

    /**
     * The email Message-ID header.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun messageId(): String = messageId.getRequired("messageId")

    /**
     * The original date of the message.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun receivedAt(): String = receivedAt.getRequired("receivedAt")

    /**
     * The Reply-To addresses.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun replyTo(): Optional<List<String>> = replyTo.getOptional("replyTo")

    /**
     * The status of the message
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The message subject.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun subject(): String = subject.getRequired("subject")

    /**
     * The id of the thread.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun threadId(): String = threadId.getRequired("threadId")

    /**
     * The recipient addresses.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun to(): List<String> = to.getRequired("to")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [attachmentCount].
     *
     * Unlike [attachmentCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("attachmentCount")
    @ExcludeMissing
    fun _attachmentCount(): JsonField<Double> = attachmentCount

    /**
     * Returns the raw JSON value of [bcc].
     *
     * Unlike [bcc], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bcc") @ExcludeMissing fun _bcc(): JsonField<List<String>> = bcc

    /**
     * Returns the raw JSON value of [cc].
     *
     * Unlike [cc], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cc") @ExcludeMissing fun _cc(): JsonField<List<String>> = cc

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /**
     * Returns the raw JSON value of [from].
     *
     * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("messageId") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    /**
     * Returns the raw JSON value of [receivedAt].
     *
     * Unlike [receivedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("receivedAt") @ExcludeMissing fun _receivedAt(): JsonField<String> = receivedAt

    /**
     * Returns the raw JSON value of [replyTo].
     *
     * Unlike [replyTo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("replyTo") @ExcludeMissing fun _replyTo(): JsonField<List<String>> = replyTo

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [subject].
     *
     * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

    /**
     * Returns the raw JSON value of [threadId].
     *
     * Unlike [threadId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("threadId") @ExcludeMissing fun _threadId(): JsonField<String> = threadId

    /**
     * Returns the raw JSON value of [to].
     *
     * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<List<String>> = to

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
         * Returns a mutable builder for constructing an instance of [MessageListResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .attachmentCount()
         * .bcc()
         * .cc()
         * .createdAt()
         * .from()
         * .messageId()
         * .receivedAt()
         * .replyTo()
         * .status()
         * .subject()
         * .threadId()
         * .to()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageListResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var attachmentCount: JsonField<Double>? = null
        private var bcc: JsonField<MutableList<String>>? = null
        private var cc: JsonField<MutableList<String>>? = null
        private var createdAt: JsonField<String>? = null
        private var from: JsonField<String>? = null
        private var messageId: JsonField<String>? = null
        private var receivedAt: JsonField<String>? = null
        private var replyTo: JsonField<MutableList<String>>? = null
        private var status: JsonField<Status>? = null
        private var subject: JsonField<String>? = null
        private var threadId: JsonField<String>? = null
        private var to: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageListResponse: MessageListResponse) = apply {
            id = messageListResponse.id
            attachmentCount = messageListResponse.attachmentCount
            bcc = messageListResponse.bcc.map { it.toMutableList() }
            cc = messageListResponse.cc.map { it.toMutableList() }
            createdAt = messageListResponse.createdAt
            from = messageListResponse.from
            messageId = messageListResponse.messageId
            receivedAt = messageListResponse.receivedAt
            replyTo = messageListResponse.replyTo.map { it.toMutableList() }
            status = messageListResponse.status
            subject = messageListResponse.subject
            threadId = messageListResponse.threadId
            to = messageListResponse.to.map { it.toMutableList() }
            additionalProperties = messageListResponse.additionalProperties.toMutableMap()
        }

        /** The id of the message */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The number of attachments. */
        fun attachmentCount(attachmentCount: Double) =
            attachmentCount(JsonField.of(attachmentCount))

        /**
         * Sets [Builder.attachmentCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attachmentCount] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun attachmentCount(attachmentCount: JsonField<Double>) = apply {
            this.attachmentCount = attachmentCount
        }

        /** The BCC addresses. */
        fun bcc(bcc: List<String>?) = bcc(JsonField.ofNullable(bcc))

        /** Alias for calling [Builder.bcc] with `bcc.orElse(null)`. */
        fun bcc(bcc: Optional<List<String>>) = bcc(bcc.getOrNull())

        /**
         * Sets [Builder.bcc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bcc] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bcc(bcc: JsonField<List<String>>) = apply { this.bcc = bcc.map { it.toMutableList() } }

        /**
         * Adds a single [String] to [Builder.bcc].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addBcc(bcc: String) = apply {
            this.bcc =
                (this.bcc ?: JsonField.of(mutableListOf())).also { checkKnown("bcc", it).add(bcc) }
        }

        /** The CC addresses. */
        fun cc(cc: List<String>?) = cc(JsonField.ofNullable(cc))

        /** Alias for calling [Builder.cc] with `cc.orElse(null)`. */
        fun cc(cc: Optional<List<String>>) = cc(cc.getOrNull())

        /**
         * Sets [Builder.cc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cc] with a well-typed `List<String>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cc(cc: JsonField<List<String>>) = apply { this.cc = cc.map { it.toMutableList() } }

        /**
         * Adds a single [String] to [Builder.cc].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCc(cc: String) = apply {
            this.cc =
                (this.cc ?: JsonField.of(mutableListOf())).also { checkKnown("cc", it).add(cc) }
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

        /**
         * The sender address (RFC 5322 format, e.g. "Jane Doe <jane@example.com>" or
         * "jane@example.com").
         */
        fun from(from: String) = from(JsonField.of(from))

        /**
         * Sets [Builder.from] to an arbitrary JSON value.
         *
         * You should usually call [Builder.from] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun from(from: JsonField<String>) = apply { this.from = from }

        /** The email Message-ID header. */
        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        /** The original date of the message. */
        fun receivedAt(receivedAt: String) = receivedAt(JsonField.of(receivedAt))

        /**
         * Sets [Builder.receivedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.receivedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun receivedAt(receivedAt: JsonField<String>) = apply { this.receivedAt = receivedAt }

        /** The Reply-To addresses. */
        fun replyTo(replyTo: List<String>?) = replyTo(JsonField.ofNullable(replyTo))

        /** Alias for calling [Builder.replyTo] with `replyTo.orElse(null)`. */
        fun replyTo(replyTo: Optional<List<String>>) = replyTo(replyTo.getOrNull())

        /**
         * Sets [Builder.replyTo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.replyTo] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun replyTo(replyTo: JsonField<List<String>>) = apply {
            this.replyTo = replyTo.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [Builder.replyTo].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addReplyTo(replyTo: String) = apply {
            this.replyTo =
                (this.replyTo ?: JsonField.of(mutableListOf())).also {
                    checkKnown("replyTo", it).add(replyTo)
                }
        }

        /** The status of the message */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The message subject. */
        fun subject(subject: String) = subject(JsonField.of(subject))

        /**
         * Sets [Builder.subject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subject] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

        /** The id of the thread. */
        fun threadId(threadId: String) = threadId(JsonField.of(threadId))

        /**
         * Sets [Builder.threadId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.threadId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

        /** The recipient addresses. */
        fun to(to: List<String>) = to(JsonField.of(to))

        /**
         * Sets [Builder.to] to an arbitrary JSON value.
         *
         * You should usually call [Builder.to] with a well-typed `List<String>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun to(to: JsonField<List<String>>) = apply { this.to = to.map { it.toMutableList() } }

        /**
         * Adds a single [String] to [Builder.to].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTo(to: String) = apply {
            this.to =
                (this.to ?: JsonField.of(mutableListOf())).also { checkKnown("to", it).add(to) }
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
         * Returns an immutable instance of [MessageListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .attachmentCount()
         * .bcc()
         * .cc()
         * .createdAt()
         * .from()
         * .messageId()
         * .receivedAt()
         * .replyTo()
         * .status()
         * .subject()
         * .threadId()
         * .to()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageListResponse =
            MessageListResponse(
                checkRequired("id", id),
                checkRequired("attachmentCount", attachmentCount),
                checkRequired("bcc", bcc).map { it.toImmutable() },
                checkRequired("cc", cc).map { it.toImmutable() },
                checkRequired("createdAt", createdAt),
                checkRequired("from", from),
                checkRequired("messageId", messageId),
                checkRequired("receivedAt", receivedAt),
                checkRequired("replyTo", replyTo).map { it.toImmutable() },
                checkRequired("status", status),
                checkRequired("subject", subject),
                checkRequired("threadId", threadId),
                checkRequired("to", to).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MessageListResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        attachmentCount()
        bcc()
        cc()
        createdAt()
        from()
        messageId()
        receivedAt()
        replyTo()
        status().validate()
        subject()
        threadId()
        to()
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
            (if (attachmentCount.asKnown().isPresent) 1 else 0) +
            (bcc.asKnown().getOrNull()?.size ?: 0) +
            (cc.asKnown().getOrNull()?.size ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (from.asKnown().isPresent) 1 else 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (receivedAt.asKnown().isPresent) 1 else 0) +
            (replyTo.asKnown().getOrNull()?.size ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (subject.asKnown().isPresent) 1 else 0) +
            (if (threadId.asKnown().isPresent) 1 else 0) +
            (to.asKnown().getOrNull()?.size ?: 0)

    /** The status of the message */
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

            @JvmField val RECEIVED = of("received")

            @JvmField val SENT = of("sent")

            @JvmField val DISCARDED = of("discarded")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            RECEIVED,
            SENT,
            DISCARDED,
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
            RECEIVED,
            SENT,
            DISCARDED,
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
                RECEIVED -> Value.RECEIVED
                SENT -> Value.SENT
                DISCARDED -> Value.DISCARDED
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
                RECEIVED -> Known.RECEIVED
                SENT -> Known.SENT
                DISCARDED -> Known.DISCARDED
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

        return other is MessageListResponse &&
            id == other.id &&
            attachmentCount == other.attachmentCount &&
            bcc == other.bcc &&
            cc == other.cc &&
            createdAt == other.createdAt &&
            from == other.from &&
            messageId == other.messageId &&
            receivedAt == other.receivedAt &&
            replyTo == other.replyTo &&
            status == other.status &&
            subject == other.subject &&
            threadId == other.threadId &&
            to == other.to &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            attachmentCount,
            bcc,
            cc,
            createdAt,
            from,
            messageId,
            receivedAt,
            replyTo,
            status,
            subject,
            threadId,
            to,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageListResponse{id=$id, attachmentCount=$attachmentCount, bcc=$bcc, cc=$cc, createdAt=$createdAt, from=$from, messageId=$messageId, receivedAt=$receivedAt, replyTo=$replyTo, status=$status, subject=$subject, threadId=$threadId, to=$to, additionalProperties=$additionalProperties}"
}
