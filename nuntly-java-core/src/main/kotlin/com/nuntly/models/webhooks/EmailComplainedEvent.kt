// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.BaseDeserializer
import com.nuntly.core.BaseSerializer
import com.nuntly.core.Enum
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.allMaxBy
import com.nuntly.core.checkKnown
import com.nuntly.core.checkRequired
import com.nuntly.core.getOrThrow
import com.nuntly.core.toImmutable
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Event triggered when an email is marked as complained by the recipient. */
class EmailComplainedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val data: JsonField<Data>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(id, createdAt, data, type, mutableMapOf())

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): String = createdAt.getRequired("createdAt")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): Data = data.getRequired("data")

    /**
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
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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
         * Returns a mutable builder for constructing an instance of [EmailComplainedEvent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .data()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EmailComplainedEvent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<String>? = null
        private var data: JsonField<Data>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(emailComplainedEvent: EmailComplainedEvent) = apply {
            id = emailComplainedEvent.id
            createdAt = emailComplainedEvent.createdAt
            data = emailComplainedEvent.data
            type = emailComplainedEvent.type
            additionalProperties = emailComplainedEvent.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

        fun data(data: Data) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

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
         * Returns an immutable instance of [EmailComplainedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .data()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EmailComplainedEvent =
            EmailComplainedEvent(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("data", data),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EmailComplainedEvent = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        data().validate()
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (data.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val complaint: JsonField<Complaint>,
        private val domainId: JsonField<String>,
        private val domainName: JsonField<String>,
        private val enqueuedAt: JsonField<String>,
        private val from: JsonField<String>,
        private val messageId: JsonField<String>,
        private val orgId: JsonField<String>,
        private val sentAt: JsonField<String>,
        private val subject: JsonField<String>,
        private val to: JsonField<To>,
        private val bcc: JsonField<Bcc>,
        private val bulkId: JsonField<String>,
        private val cc: JsonField<Cc>,
        private val headers: JsonField<List<Header>>,
        private val replyTo: JsonField<ReplyTo>,
        private val tags: JsonField<Tags>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("complaint")
            @ExcludeMissing
            complaint: JsonField<Complaint> = JsonMissing.of(),
            @JsonProperty("domainId")
            @ExcludeMissing
            domainId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("domainName")
            @ExcludeMissing
            domainName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("enqueuedAt")
            @ExcludeMissing
            enqueuedAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
            @JsonProperty("messageId")
            @ExcludeMissing
            messageId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("orgId") @ExcludeMissing orgId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sentAt") @ExcludeMissing sentAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
            @JsonProperty("to") @ExcludeMissing to: JsonField<To> = JsonMissing.of(),
            @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<Bcc> = JsonMissing.of(),
            @JsonProperty("bulkId") @ExcludeMissing bulkId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cc") @ExcludeMissing cc: JsonField<Cc> = JsonMissing.of(),
            @JsonProperty("headers")
            @ExcludeMissing
            headers: JsonField<List<Header>> = JsonMissing.of(),
            @JsonProperty("replyTo") @ExcludeMissing replyTo: JsonField<ReplyTo> = JsonMissing.of(),
            @JsonProperty("tags") @ExcludeMissing tags: JsonField<Tags> = JsonMissing.of(),
        ) : this(
            id,
            complaint,
            domainId,
            domainName,
            enqueuedAt,
            from,
            messageId,
            orgId,
            sentAt,
            subject,
            to,
            bcc,
            bulkId,
            cc,
            headers,
            replyTo,
            tags,
            mutableMapOf(),
        )

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun complaint(): Complaint = complaint.getRequired("complaint")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun domainId(): String = domainId.getRequired("domainId")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun domainName(): String = domainName.getRequired("domainName")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun enqueuedAt(): String = enqueuedAt.getRequired("enqueuedAt")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun from(): String = from.getRequired("from")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun messageId(): String = messageId.getRequired("messageId")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orgId(): String = orgId.getRequired("orgId")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sentAt(): String = sentAt.getRequired("sentAt")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun subject(): String = subject.getRequired("subject")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun to(): To = to.getRequired("to")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bcc(): Optional<Bcc> = bcc.getOptional("bcc")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bulkId(): Optional<String> = bulkId.getOptional("bulkId")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cc(): Optional<Cc> = cc.getOptional("cc")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun headers(): Optional<List<Header>> = headers.getOptional("headers")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun replyTo(): Optional<ReplyTo> = replyTo.getOptional("replyTo")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tags(): Optional<Tags> = tags.getOptional("tags")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [complaint].
         *
         * Unlike [complaint], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("complaint")
        @ExcludeMissing
        fun _complaint(): JsonField<Complaint> = complaint

        /**
         * Returns the raw JSON value of [domainId].
         *
         * Unlike [domainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("domainId") @ExcludeMissing fun _domainId(): JsonField<String> = domainId

        /**
         * Returns the raw JSON value of [domainName].
         *
         * Unlike [domainName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("domainName")
        @ExcludeMissing
        fun _domainName(): JsonField<String> = domainName

        /**
         * Returns the raw JSON value of [enqueuedAt].
         *
         * Unlike [enqueuedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enqueuedAt")
        @ExcludeMissing
        fun _enqueuedAt(): JsonField<String> = enqueuedAt

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
         * Returns the raw JSON value of [orgId].
         *
         * Unlike [orgId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("orgId") @ExcludeMissing fun _orgId(): JsonField<String> = orgId

        /**
         * Returns the raw JSON value of [sentAt].
         *
         * Unlike [sentAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sentAt") @ExcludeMissing fun _sentAt(): JsonField<String> = sentAt

        /**
         * Returns the raw JSON value of [subject].
         *
         * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

        /**
         * Returns the raw JSON value of [to].
         *
         * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<To> = to

        /**
         * Returns the raw JSON value of [bcc].
         *
         * Unlike [bcc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bcc") @ExcludeMissing fun _bcc(): JsonField<Bcc> = bcc

        /**
         * Returns the raw JSON value of [bulkId].
         *
         * Unlike [bulkId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bulkId") @ExcludeMissing fun _bulkId(): JsonField<String> = bulkId

        /**
         * Returns the raw JSON value of [cc].
         *
         * Unlike [cc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cc") @ExcludeMissing fun _cc(): JsonField<Cc> = cc

        /**
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<List<Header>> = headers

        /**
         * Returns the raw JSON value of [replyTo].
         *
         * Unlike [replyTo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("replyTo") @ExcludeMissing fun _replyTo(): JsonField<ReplyTo> = replyTo

        /**
         * Returns the raw JSON value of [tags].
         *
         * Unlike [tags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tags") @ExcludeMissing fun _tags(): JsonField<Tags> = tags

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
             * Returns a mutable builder for constructing an instance of [Data].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .complaint()
             * .domainId()
             * .domainName()
             * .enqueuedAt()
             * .from()
             * .messageId()
             * .orgId()
             * .sentAt()
             * .subject()
             * .to()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var complaint: JsonField<Complaint>? = null
            private var domainId: JsonField<String>? = null
            private var domainName: JsonField<String>? = null
            private var enqueuedAt: JsonField<String>? = null
            private var from: JsonField<String>? = null
            private var messageId: JsonField<String>? = null
            private var orgId: JsonField<String>? = null
            private var sentAt: JsonField<String>? = null
            private var subject: JsonField<String>? = null
            private var to: JsonField<To>? = null
            private var bcc: JsonField<Bcc> = JsonMissing.of()
            private var bulkId: JsonField<String> = JsonMissing.of()
            private var cc: JsonField<Cc> = JsonMissing.of()
            private var headers: JsonField<MutableList<Header>>? = null
            private var replyTo: JsonField<ReplyTo> = JsonMissing.of()
            private var tags: JsonField<Tags> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                complaint = data.complaint
                domainId = data.domainId
                domainName = data.domainName
                enqueuedAt = data.enqueuedAt
                from = data.from
                messageId = data.messageId
                orgId = data.orgId
                sentAt = data.sentAt
                subject = data.subject
                to = data.to
                bcc = data.bcc
                bulkId = data.bulkId
                cc = data.cc
                headers = data.headers.map { it.toMutableList() }
                replyTo = data.replyTo
                tags = data.tags
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun complaint(complaint: Complaint) = complaint(JsonField.of(complaint))

            /**
             * Sets [Builder.complaint] to an arbitrary JSON value.
             *
             * You should usually call [Builder.complaint] with a well-typed [Complaint] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun complaint(complaint: JsonField<Complaint>) = apply { this.complaint = complaint }

            fun domainId(domainId: String) = domainId(JsonField.of(domainId))

            /**
             * Sets [Builder.domainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.domainId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun domainId(domainId: JsonField<String>) = apply { this.domainId = domainId }

            fun domainName(domainName: String) = domainName(JsonField.of(domainName))

            /**
             * Sets [Builder.domainName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.domainName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun domainName(domainName: JsonField<String>) = apply { this.domainName = domainName }

            fun enqueuedAt(enqueuedAt: String) = enqueuedAt(JsonField.of(enqueuedAt))

            /**
             * Sets [Builder.enqueuedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enqueuedAt] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enqueuedAt(enqueuedAt: JsonField<String>) = apply { this.enqueuedAt = enqueuedAt }

            fun from(from: String) = from(JsonField.of(from))

            /**
             * Sets [Builder.from] to an arbitrary JSON value.
             *
             * You should usually call [Builder.from] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun from(from: JsonField<String>) = apply { this.from = from }

            fun messageId(messageId: String) = messageId(JsonField.of(messageId))

            /**
             * Sets [Builder.messageId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messageId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

            fun orgId(orgId: String) = orgId(JsonField.of(orgId))

            /**
             * Sets [Builder.orgId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orgId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orgId(orgId: JsonField<String>) = apply { this.orgId = orgId }

            fun sentAt(sentAt: String) = sentAt(JsonField.of(sentAt))

            /**
             * Sets [Builder.sentAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sentAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sentAt(sentAt: JsonField<String>) = apply { this.sentAt = sentAt }

            fun subject(subject: String) = subject(JsonField.of(subject))

            /**
             * Sets [Builder.subject] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subject] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subject(subject: JsonField<String>) = apply { this.subject = subject }

            fun to(to: To) = to(JsonField.of(to))

            /**
             * Sets [Builder.to] to an arbitrary JSON value.
             *
             * You should usually call [Builder.to] with a well-typed [To] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun to(to: JsonField<To>) = apply { this.to = to }

            /** Alias for calling [to] with `To.ofString(string)`. */
            fun to(string: String) = to(To.ofString(string))

            /** Alias for calling [to] with `To.ofStrings(strings)`. */
            fun toOfStrings(strings: List<String>) = to(To.ofStrings(strings))

            fun bcc(bcc: Bcc) = bcc(JsonField.of(bcc))

            /**
             * Sets [Builder.bcc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bcc] with a well-typed [Bcc] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun bcc(bcc: JsonField<Bcc>) = apply { this.bcc = bcc }

            /** Alias for calling [bcc] with `Bcc.ofString(string)`. */
            fun bcc(string: String) = bcc(Bcc.ofString(string))

            /** Alias for calling [bcc] with `Bcc.ofStrings(strings)`. */
            fun bccOfStrings(strings: List<String>) = bcc(Bcc.ofStrings(strings))

            fun bulkId(bulkId: String) = bulkId(JsonField.of(bulkId))

            /**
             * Sets [Builder.bulkId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bulkId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bulkId(bulkId: JsonField<String>) = apply { this.bulkId = bulkId }

            fun cc(cc: Cc) = cc(JsonField.of(cc))

            /**
             * Sets [Builder.cc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cc] with a well-typed [Cc] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun cc(cc: JsonField<Cc>) = apply { this.cc = cc }

            /** Alias for calling [cc] with `Cc.ofString(string)`. */
            fun cc(string: String) = cc(Cc.ofString(string))

            /** Alias for calling [cc] with `Cc.ofStrings(strings)`. */
            fun ccOfStrings(strings: List<String>) = cc(Cc.ofStrings(strings))

            fun headers(headers: List<Header>) = headers(JsonField.of(headers))

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed `List<Header>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<List<Header>>) = apply {
                this.headers = headers.map { it.toMutableList() }
            }

            /**
             * Adds a single [Header] to [headers].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addHeader(header: Header) = apply {
                headers =
                    (headers ?: JsonField.of(mutableListOf())).also {
                        checkKnown("headers", it).add(header)
                    }
            }

            fun replyTo(replyTo: ReplyTo) = replyTo(JsonField.of(replyTo))

            /**
             * Sets [Builder.replyTo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.replyTo] with a well-typed [ReplyTo] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun replyTo(replyTo: JsonField<ReplyTo>) = apply { this.replyTo = replyTo }

            /** Alias for calling [replyTo] with `ReplyTo.ofString(string)`. */
            fun replyTo(string: String) = replyTo(ReplyTo.ofString(string))

            /** Alias for calling [replyTo] with `ReplyTo.ofStrings(strings)`. */
            fun replyToOfStrings(strings: List<String>) = replyTo(ReplyTo.ofStrings(strings))

            fun tags(tags: Tags) = tags(JsonField.of(tags))

            /**
             * Sets [Builder.tags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tags] with a well-typed [Tags] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun tags(tags: JsonField<Tags>) = apply { this.tags = tags }

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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .complaint()
             * .domainId()
             * .domainName()
             * .enqueuedAt()
             * .from()
             * .messageId()
             * .orgId()
             * .sentAt()
             * .subject()
             * .to()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Data =
                Data(
                    checkRequired("id", id),
                    checkRequired("complaint", complaint),
                    checkRequired("domainId", domainId),
                    checkRequired("domainName", domainName),
                    checkRequired("enqueuedAt", enqueuedAt),
                    checkRequired("from", from),
                    checkRequired("messageId", messageId),
                    checkRequired("orgId", orgId),
                    checkRequired("sentAt", sentAt),
                    checkRequired("subject", subject),
                    checkRequired("to", to),
                    bcc,
                    bulkId,
                    cc,
                    (headers ?: JsonMissing.of()).map { it.toImmutable() },
                    replyTo,
                    tags,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            id()
            complaint().validate()
            domainId()
            domainName()
            enqueuedAt()
            from()
            messageId()
            orgId()
            sentAt()
            subject()
            to().validate()
            bcc().ifPresent { it.validate() }
            bulkId()
            cc().ifPresent { it.validate() }
            headers().ifPresent { it.forEach { it.validate() } }
            replyTo().ifPresent { it.validate() }
            tags().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (complaint.asKnown().getOrNull()?.validity() ?: 0) +
                (if (domainId.asKnown().isPresent) 1 else 0) +
                (if (domainName.asKnown().isPresent) 1 else 0) +
                (if (enqueuedAt.asKnown().isPresent) 1 else 0) +
                (if (from.asKnown().isPresent) 1 else 0) +
                (if (messageId.asKnown().isPresent) 1 else 0) +
                (if (orgId.asKnown().isPresent) 1 else 0) +
                (if (sentAt.asKnown().isPresent) 1 else 0) +
                (if (subject.asKnown().isPresent) 1 else 0) +
                (to.asKnown().getOrNull()?.validity() ?: 0) +
                (bcc.asKnown().getOrNull()?.validity() ?: 0) +
                (if (bulkId.asKnown().isPresent) 1 else 0) +
                (cc.asKnown().getOrNull()?.validity() ?: 0) +
                (headers.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (replyTo.asKnown().getOrNull()?.validity() ?: 0) +
                (tags.asKnown().getOrNull()?.validity() ?: 0)

        class Complaint
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val complainedAt: JsonField<String>,
            private val feedbackId: JsonField<String>,
            private val complainedRecipients: JsonField<List<ComplainedRecipient>>,
            private val complaintFeedbackType: JsonField<ComplaintFeedbackType>,
            private val complaintSubType: JsonField<ComplaintSubType>,
            private val receivedAt: JsonField<String>,
            private val userAgent: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("complainedAt")
                @ExcludeMissing
                complainedAt: JsonField<String> = JsonMissing.of(),
                @JsonProperty("feedbackId")
                @ExcludeMissing
                feedbackId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("complainedRecipients")
                @ExcludeMissing
                complainedRecipients: JsonField<List<ComplainedRecipient>> = JsonMissing.of(),
                @JsonProperty("complaintFeedbackType")
                @ExcludeMissing
                complaintFeedbackType: JsonField<ComplaintFeedbackType> = JsonMissing.of(),
                @JsonProperty("complaintSubType")
                @ExcludeMissing
                complaintSubType: JsonField<ComplaintSubType> = JsonMissing.of(),
                @JsonProperty("receivedAt")
                @ExcludeMissing
                receivedAt: JsonField<String> = JsonMissing.of(),
                @JsonProperty("userAgent")
                @ExcludeMissing
                userAgent: JsonField<String> = JsonMissing.of(),
            ) : this(
                complainedAt,
                feedbackId,
                complainedRecipients,
                complaintFeedbackType,
                complaintSubType,
                receivedAt,
                userAgent,
                mutableMapOf(),
            )

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun complainedAt(): String = complainedAt.getRequired("complainedAt")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun feedbackId(): String = feedbackId.getRequired("feedbackId")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun complainedRecipients(): Optional<List<ComplainedRecipient>> =
                complainedRecipients.getOptional("complainedRecipients")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun complaintFeedbackType(): Optional<ComplaintFeedbackType> =
                complaintFeedbackType.getOptional("complaintFeedbackType")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun complaintSubType(): Optional<ComplaintSubType> =
                complaintSubType.getOptional("complaintSubType")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun receivedAt(): Optional<String> = receivedAt.getOptional("receivedAt")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun userAgent(): Optional<String> = userAgent.getOptional("userAgent")

            /**
             * Returns the raw JSON value of [complainedAt].
             *
             * Unlike [complainedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("complainedAt")
            @ExcludeMissing
            fun _complainedAt(): JsonField<String> = complainedAt

            /**
             * Returns the raw JSON value of [feedbackId].
             *
             * Unlike [feedbackId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("feedbackId")
            @ExcludeMissing
            fun _feedbackId(): JsonField<String> = feedbackId

            /**
             * Returns the raw JSON value of [complainedRecipients].
             *
             * Unlike [complainedRecipients], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("complainedRecipients")
            @ExcludeMissing
            fun _complainedRecipients(): JsonField<List<ComplainedRecipient>> = complainedRecipients

            /**
             * Returns the raw JSON value of [complaintFeedbackType].
             *
             * Unlike [complaintFeedbackType], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("complaintFeedbackType")
            @ExcludeMissing
            fun _complaintFeedbackType(): JsonField<ComplaintFeedbackType> = complaintFeedbackType

            /**
             * Returns the raw JSON value of [complaintSubType].
             *
             * Unlike [complaintSubType], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("complaintSubType")
            @ExcludeMissing
            fun _complaintSubType(): JsonField<ComplaintSubType> = complaintSubType

            /**
             * Returns the raw JSON value of [receivedAt].
             *
             * Unlike [receivedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("receivedAt")
            @ExcludeMissing
            fun _receivedAt(): JsonField<String> = receivedAt

            /**
             * Returns the raw JSON value of [userAgent].
             *
             * Unlike [userAgent], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("userAgent")
            @ExcludeMissing
            fun _userAgent(): JsonField<String> = userAgent

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
                 * Returns a mutable builder for constructing an instance of [Complaint].
                 *
                 * The following fields are required:
                 * ```java
                 * .complainedAt()
                 * .feedbackId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Complaint]. */
            class Builder internal constructor() {

                private var complainedAt: JsonField<String>? = null
                private var feedbackId: JsonField<String>? = null
                private var complainedRecipients: JsonField<MutableList<ComplainedRecipient>>? =
                    null
                private var complaintFeedbackType: JsonField<ComplaintFeedbackType> =
                    JsonMissing.of()
                private var complaintSubType: JsonField<ComplaintSubType> = JsonMissing.of()
                private var receivedAt: JsonField<String> = JsonMissing.of()
                private var userAgent: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(complaint: Complaint) = apply {
                    complainedAt = complaint.complainedAt
                    feedbackId = complaint.feedbackId
                    complainedRecipients = complaint.complainedRecipients.map { it.toMutableList() }
                    complaintFeedbackType = complaint.complaintFeedbackType
                    complaintSubType = complaint.complaintSubType
                    receivedAt = complaint.receivedAt
                    userAgent = complaint.userAgent
                    additionalProperties = complaint.additionalProperties.toMutableMap()
                }

                fun complainedAt(complainedAt: String) = complainedAt(JsonField.of(complainedAt))

                /**
                 * Sets [Builder.complainedAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.complainedAt] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun complainedAt(complainedAt: JsonField<String>) = apply {
                    this.complainedAt = complainedAt
                }

                fun feedbackId(feedbackId: String) = feedbackId(JsonField.of(feedbackId))

                /**
                 * Sets [Builder.feedbackId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.feedbackId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun feedbackId(feedbackId: JsonField<String>) = apply {
                    this.feedbackId = feedbackId
                }

                fun complainedRecipients(complainedRecipients: List<ComplainedRecipient>) =
                    complainedRecipients(JsonField.of(complainedRecipients))

                /**
                 * Sets [Builder.complainedRecipients] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.complainedRecipients] with a well-typed
                 * `List<ComplainedRecipient>` value instead. This method is primarily for setting
                 * the field to an undocumented or not yet supported value.
                 */
                fun complainedRecipients(
                    complainedRecipients: JsonField<List<ComplainedRecipient>>
                ) = apply {
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

                fun complaintFeedbackType(complaintFeedbackType: ComplaintFeedbackType) =
                    complaintFeedbackType(JsonField.of(complaintFeedbackType))

                /**
                 * Sets [Builder.complaintFeedbackType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.complaintFeedbackType] with a well-typed
                 * [ComplaintFeedbackType] value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun complaintFeedbackType(complaintFeedbackType: JsonField<ComplaintFeedbackType>) =
                    apply {
                        this.complaintFeedbackType = complaintFeedbackType
                    }

                fun complaintSubType(complaintSubType: ComplaintSubType) =
                    complaintSubType(JsonField.of(complaintSubType))

                /**
                 * Sets [Builder.complaintSubType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.complaintSubType] with a well-typed
                 * [ComplaintSubType] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun complaintSubType(complaintSubType: JsonField<ComplaintSubType>) = apply {
                    this.complaintSubType = complaintSubType
                }

                fun receivedAt(receivedAt: String) = receivedAt(JsonField.of(receivedAt))

                /**
                 * Sets [Builder.receivedAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.receivedAt] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun receivedAt(receivedAt: JsonField<String>) = apply {
                    this.receivedAt = receivedAt
                }

                fun userAgent(userAgent: String) = userAgent(JsonField.of(userAgent))

                /**
                 * Sets [Builder.userAgent] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.userAgent] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun userAgent(userAgent: JsonField<String>) = apply { this.userAgent = userAgent }

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
                 * Returns an immutable instance of [Complaint].
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
                fun build(): Complaint =
                    Complaint(
                        checkRequired("complainedAt", complainedAt),
                        checkRequired("feedbackId", feedbackId),
                        (complainedRecipients ?: JsonMissing.of()).map { it.toImmutable() },
                        complaintFeedbackType,
                        complaintSubType,
                        receivedAt,
                        userAgent,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Complaint = apply {
                if (validated) {
                    return@apply
                }

                complainedAt()
                feedbackId()
                complainedRecipients().ifPresent { it.forEach { it.validate() } }
                complaintFeedbackType().ifPresent { it.validate() }
                complaintSubType().ifPresent { it.validate() }
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (complainedAt.asKnown().isPresent) 1 else 0) +
                    (if (feedbackId.asKnown().isPresent) 1 else 0) +
                    (complainedRecipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() }
                        ?: 0) +
                    (complaintFeedbackType.asKnown().getOrNull()?.validity() ?: 0) +
                    (complaintSubType.asKnown().getOrNull()?.validity() ?: 0) +
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
                    @JsonProperty("email")
                    @ExcludeMissing
                    email: JsonField<String> = JsonMissing.of()
                ) : this(email, mutableMapOf())

                /**
                 * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun email(): String = email.getRequired("email")

                /**
                 * Returns the raw JSON value of [email].
                 *
                 * Unlike [email], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                     * Returns a mutable builder for constructing an instance of
                     * [ComplainedRecipient].
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
                        additionalProperties =
                            complainedRecipient.additionalProperties.toMutableMap()
                    }

                    fun email(email: String) = email(JsonField.of(email))

                    /**
                     * Sets [Builder.email] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.email] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun email(email: JsonField<String>) = apply { this.email = email }

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
                @JvmSynthetic
                internal fun validity(): Int = (if (email.asKnown().isPresent) 1 else 0)

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

            class ComplaintFeedbackType
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val ABUSE = of("abuse")

                    @JvmField val AUTH_FAILURE = of("auth-failure")

                    @JvmField val FRAUD = of("fraud")

                    @JvmField val NOT_SPAM = of("not-spam")

                    @JvmField val OTHER = of("other")

                    @JvmField val VIRUS = of("virus")

                    @JvmStatic fun of(value: String) = ComplaintFeedbackType(JsonField.of(value))
                }

                /** An enum containing [ComplaintFeedbackType]'s known values. */
                enum class Known {
                    ABUSE,
                    AUTH_FAILURE,
                    FRAUD,
                    NOT_SPAM,
                    OTHER,
                    VIRUS,
                }

                /**
                 * An enum containing [ComplaintFeedbackType]'s known values, as well as an
                 * [_UNKNOWN] member.
                 *
                 * An instance of [ComplaintFeedbackType] can contain an unknown value in a couple
                 * of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    ABUSE,
                    AUTH_FAILURE,
                    FRAUD,
                    NOT_SPAM,
                    OTHER,
                    VIRUS,
                    /**
                     * An enum member indicating that [ComplaintFeedbackType] was instantiated with
                     * an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        ABUSE -> Value.ABUSE
                        AUTH_FAILURE -> Value.AUTH_FAILURE
                        FRAUD -> Value.FRAUD
                        NOT_SPAM -> Value.NOT_SPAM
                        OTHER -> Value.OTHER
                        VIRUS -> Value.VIRUS
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws NuntlyInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        ABUSE -> Known.ABUSE
                        AUTH_FAILURE -> Known.AUTH_FAILURE
                        FRAUD -> Known.FRAUD
                        NOT_SPAM -> Known.NOT_SPAM
                        OTHER -> Known.OTHER
                        VIRUS -> Known.VIRUS
                        else ->
                            throw NuntlyInvalidDataException(
                                "Unknown ComplaintFeedbackType: $value"
                            )
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws NuntlyInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        NuntlyInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): ComplaintFeedbackType = apply {
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

                    return other is ComplaintFeedbackType && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            class ComplaintSubType
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val ON_ACCOUNT_SUPPRESSION_LIST = of("OnAccountSuppressionList")

                    @JvmStatic fun of(value: String) = ComplaintSubType(JsonField.of(value))
                }

                /** An enum containing [ComplaintSubType]'s known values. */
                enum class Known {
                    ON_ACCOUNT_SUPPRESSION_LIST
                }

                /**
                 * An enum containing [ComplaintSubType]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [ComplaintSubType] can contain an unknown value in a couple of
                 * cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    ON_ACCOUNT_SUPPRESSION_LIST,
                    /**
                     * An enum member indicating that [ComplaintSubType] was instantiated with an
                     * unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        ON_ACCOUNT_SUPPRESSION_LIST -> Value.ON_ACCOUNT_SUPPRESSION_LIST
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws NuntlyInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        ON_ACCOUNT_SUPPRESSION_LIST -> Known.ON_ACCOUNT_SUPPRESSION_LIST
                        else -> throw NuntlyInvalidDataException("Unknown ComplaintSubType: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws NuntlyInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        NuntlyInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): ComplaintSubType = apply {
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

                    return other is ComplaintSubType && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Complaint &&
                    complainedAt == other.complainedAt &&
                    feedbackId == other.feedbackId &&
                    complainedRecipients == other.complainedRecipients &&
                    complaintFeedbackType == other.complaintFeedbackType &&
                    complaintSubType == other.complaintSubType &&
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
                    complaintSubType,
                    receivedAt,
                    userAgent,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Complaint{complainedAt=$complainedAt, feedbackId=$feedbackId, complainedRecipients=$complainedRecipients, complaintFeedbackType=$complaintFeedbackType, complaintSubType=$complaintSubType, receivedAt=$receivedAt, userAgent=$userAgent, additionalProperties=$additionalProperties}"
        }

        @JsonDeserialize(using = To.Deserializer::class)
        @JsonSerialize(using = To.Serializer::class)
        class To
        private constructor(
            private val string: String? = null,
            private val strings: List<String>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

            fun isString(): Boolean = string != null

            fun isStrings(): Boolean = strings != null

            fun asString(): String = string.getOrThrow("string")

            fun asStrings(): List<String> = strings.getOrThrow("strings")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    strings != null -> visitor.visitStrings(strings)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): To = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitStrings(strings: List<String>) {}
                    }
                )
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
                accept(
                    object : Visitor<Int> {
                        override fun visitString(string: String) = 1

                        override fun visitStrings(strings: List<String>) = strings.size

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is To && string == other.string && strings == other.strings
            }

            override fun hashCode(): Int = Objects.hash(string, strings)

            override fun toString(): String =
                when {
                    string != null -> "To{string=$string}"
                    strings != null -> "To{strings=$strings}"
                    _json != null -> "To{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid To")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = To(string = string)

                @JvmStatic
                fun ofStrings(strings: List<String>) = To(strings = strings.toImmutable())
            }

            /** An interface that defines how to map each variant of [To] to a value of type [T]. */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitStrings(strings: List<String>): T

                /**
                 * Maps an unknown variant of [To] to a value of type [T].
                 *
                 * An instance of [To] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws NuntlyInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw NuntlyInvalidDataException("Unknown To: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<To>(To::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): To {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    To(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                    To(strings = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> To(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<To>(To::class) {

                override fun serialize(
                    value: To,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.strings != null -> generator.writeObject(value.strings)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid To")
                    }
                }
            }
        }

        @JsonDeserialize(using = Bcc.Deserializer::class)
        @JsonSerialize(using = Bcc.Serializer::class)
        class Bcc
        private constructor(
            private val string: String? = null,
            private val strings: List<String>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

            fun isString(): Boolean = string != null

            fun isStrings(): Boolean = strings != null

            fun asString(): String = string.getOrThrow("string")

            fun asStrings(): List<String> = strings.getOrThrow("strings")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    strings != null -> visitor.visitStrings(strings)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Bcc = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitStrings(strings: List<String>) {}
                    }
                )
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
                accept(
                    object : Visitor<Int> {
                        override fun visitString(string: String) = 1

                        override fun visitStrings(strings: List<String>) = strings.size

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Bcc && string == other.string && strings == other.strings
            }

            override fun hashCode(): Int = Objects.hash(string, strings)

            override fun toString(): String =
                when {
                    string != null -> "Bcc{string=$string}"
                    strings != null -> "Bcc{strings=$strings}"
                    _json != null -> "Bcc{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Bcc")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = Bcc(string = string)

                @JvmStatic
                fun ofStrings(strings: List<String>) = Bcc(strings = strings.toImmutable())
            }

            /**
             * An interface that defines how to map each variant of [Bcc] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitStrings(strings: List<String>): T

                /**
                 * Maps an unknown variant of [Bcc] to a value of type [T].
                 *
                 * An instance of [Bcc] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws NuntlyInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw NuntlyInvalidDataException("Unknown Bcc: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Bcc>(Bcc::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Bcc {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Bcc(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                    Bcc(strings = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Bcc(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Bcc>(Bcc::class) {

                override fun serialize(
                    value: Bcc,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.strings != null -> generator.writeObject(value.strings)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Bcc")
                    }
                }
            }
        }

        @JsonDeserialize(using = Cc.Deserializer::class)
        @JsonSerialize(using = Cc.Serializer::class)
        class Cc
        private constructor(
            private val string: String? = null,
            private val strings: List<String>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

            fun isString(): Boolean = string != null

            fun isStrings(): Boolean = strings != null

            fun asString(): String = string.getOrThrow("string")

            fun asStrings(): List<String> = strings.getOrThrow("strings")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    strings != null -> visitor.visitStrings(strings)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Cc = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitStrings(strings: List<String>) {}
                    }
                )
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
                accept(
                    object : Visitor<Int> {
                        override fun visitString(string: String) = 1

                        override fun visitStrings(strings: List<String>) = strings.size

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Cc && string == other.string && strings == other.strings
            }

            override fun hashCode(): Int = Objects.hash(string, strings)

            override fun toString(): String =
                when {
                    string != null -> "Cc{string=$string}"
                    strings != null -> "Cc{strings=$strings}"
                    _json != null -> "Cc{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Cc")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = Cc(string = string)

                @JvmStatic
                fun ofStrings(strings: List<String>) = Cc(strings = strings.toImmutable())
            }

            /** An interface that defines how to map each variant of [Cc] to a value of type [T]. */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitStrings(strings: List<String>): T

                /**
                 * Maps an unknown variant of [Cc] to a value of type [T].
                 *
                 * An instance of [Cc] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws NuntlyInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw NuntlyInvalidDataException("Unknown Cc: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Cc>(Cc::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Cc {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Cc(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                    Cc(strings = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Cc(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Cc>(Cc::class) {

                override fun serialize(
                    value: Cc,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.strings != null -> generator.writeObject(value.strings)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Cc")
                    }
                }
            }
        }

        class Header
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val value: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
            ) : this(name, value, mutableMapOf())

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun value(): String = value.getRequired("value")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [value].
             *
             * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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
                 * Returns a mutable builder for constructing an instance of [Header].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .value()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Header]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var value: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(header: Header) = apply {
                    name = header.name
                    value = header.value
                    additionalProperties = header.additionalProperties.toMutableMap()
                }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun value(value: String) = value(JsonField.of(value))

                /**
                 * Sets [Builder.value] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.value] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun value(value: JsonField<String>) = apply { this.value = value }

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
                 * Returns an immutable instance of [Header].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .value()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Header =
                    Header(
                        checkRequired("name", name),
                        checkRequired("value", value),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Header = apply {
                if (validated) {
                    return@apply
                }

                name()
                value()
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
                (if (name.asKnown().isPresent) 1 else 0) + (if (value.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Header &&
                    name == other.name &&
                    value == other.value &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, value, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Header{name=$name, value=$value, additionalProperties=$additionalProperties}"
        }

        @JsonDeserialize(using = ReplyTo.Deserializer::class)
        @JsonSerialize(using = ReplyTo.Serializer::class)
        class ReplyTo
        private constructor(
            private val string: String? = null,
            private val strings: List<String>? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

            fun isString(): Boolean = string != null

            fun isStrings(): Boolean = strings != null

            fun asString(): String = string.getOrThrow("string")

            fun asStrings(): List<String> = strings.getOrThrow("strings")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    strings != null -> visitor.visitStrings(strings)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): ReplyTo = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitStrings(strings: List<String>) {}
                    }
                )
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
                accept(
                    object : Visitor<Int> {
                        override fun visitString(string: String) = 1

                        override fun visitStrings(strings: List<String>) = strings.size

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ReplyTo && string == other.string && strings == other.strings
            }

            override fun hashCode(): Int = Objects.hash(string, strings)

            override fun toString(): String =
                when {
                    string != null -> "ReplyTo{string=$string}"
                    strings != null -> "ReplyTo{strings=$strings}"
                    _json != null -> "ReplyTo{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid ReplyTo")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = ReplyTo(string = string)

                @JvmStatic
                fun ofStrings(strings: List<String>) = ReplyTo(strings = strings.toImmutable())
            }

            /**
             * An interface that defines how to map each variant of [ReplyTo] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitStrings(strings: List<String>): T

                /**
                 * Maps an unknown variant of [ReplyTo] to a value of type [T].
                 *
                 * An instance of [ReplyTo] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws NuntlyInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw NuntlyInvalidDataException("Unknown ReplyTo: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<ReplyTo>(ReplyTo::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): ReplyTo {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    ReplyTo(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                    ReplyTo(strings = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> ReplyTo(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<ReplyTo>(ReplyTo::class) {

                override fun serialize(
                    value: ReplyTo,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.strings != null -> generator.writeObject(value.strings)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid ReplyTo")
                    }
                }
            }
        }

        class Tags
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

                /** Returns a mutable builder for constructing an instance of [Tags]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Tags]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(tags: Tags) = apply {
                    additionalProperties = tags.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Tags].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Tags = Tags(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Tags = apply {
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

                return other is Tags && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Tags{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                id == other.id &&
                complaint == other.complaint &&
                domainId == other.domainId &&
                domainName == other.domainName &&
                enqueuedAt == other.enqueuedAt &&
                from == other.from &&
                messageId == other.messageId &&
                orgId == other.orgId &&
                sentAt == other.sentAt &&
                subject == other.subject &&
                to == other.to &&
                bcc == other.bcc &&
                bulkId == other.bulkId &&
                cc == other.cc &&
                headers == other.headers &&
                replyTo == other.replyTo &&
                tags == other.tags &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                complaint,
                domainId,
                domainName,
                enqueuedAt,
                from,
                messageId,
                orgId,
                sentAt,
                subject,
                to,
                bcc,
                bulkId,
                cc,
                headers,
                replyTo,
                tags,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, complaint=$complaint, domainId=$domainId, domainName=$domainName, enqueuedAt=$enqueuedAt, from=$from, messageId=$messageId, orgId=$orgId, sentAt=$sentAt, subject=$subject, to=$to, bcc=$bcc, bulkId=$bulkId, cc=$cc, headers=$headers, replyTo=$replyTo, tags=$tags, additionalProperties=$additionalProperties}"
    }

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

            @JvmField val EMAIL_COMPLAINED = of("email.complained")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            EMAIL_COMPLAINED
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
            EMAIL_COMPLAINED,
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
                EMAIL_COMPLAINED -> Value.EMAIL_COMPLAINED
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
                EMAIL_COMPLAINED -> Known.EMAIL_COMPLAINED
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

        return other is EmailComplainedEvent &&
            id == other.id &&
            createdAt == other.createdAt &&
            data == other.data &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, createdAt, data, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EmailComplainedEvent{id=$id, createdAt=$createdAt, data=$data, type=$type, additionalProperties=$additionalProperties}"
}
