// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

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
import com.nuntly.models.shared.BounceDetail
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class EmailBouncedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val type: JsonField<EventType>,
    private val kind: JsonField<BaseEvent.Kind>,
    private val data: JsonField<Data>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<EventType> = JsonMissing.of(),
        @JsonProperty("kind") @ExcludeMissing kind: JsonField<BaseEvent.Kind> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
    ) : this(id, createdAt, type, kind, data, mutableMapOf())

    fun toBaseEvent(): BaseEvent =
        BaseEvent.builder().id(id).createdAt(createdAt).type(type).kind(kind).build()

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): String = createdAt.getRequired("created_at")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): EventType = type.getRequired("type")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun kind(): Optional<BaseEvent.Kind> = kind.getOptional("kind")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): Data = data.getRequired("data")

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
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<EventType> = type

    /**
     * Returns the raw JSON value of [kind].
     *
     * Unlike [kind], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<BaseEvent.Kind> = kind

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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
         * Returns a mutable builder for constructing an instance of [EmailBouncedEvent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .type()
         * .data()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EmailBouncedEvent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<String>? = null
        private var type: JsonField<EventType>? = null
        private var kind: JsonField<BaseEvent.Kind> = JsonMissing.of()
        private var data: JsonField<Data>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(emailBouncedEvent: EmailBouncedEvent) = apply {
            id = emailBouncedEvent.id
            createdAt = emailBouncedEvent.createdAt
            type = emailBouncedEvent.type
            kind = emailBouncedEvent.kind
            data = emailBouncedEvent.data
            additionalProperties = emailBouncedEvent.additionalProperties.toMutableMap()
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

        fun type(type: EventType) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [EventType] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<EventType>) = apply { this.type = type }

        fun kind(kind: BaseEvent.Kind) = kind(JsonField.of(kind))

        /**
         * Sets [Builder.kind] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kind] with a well-typed [BaseEvent.Kind] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun kind(kind: JsonField<BaseEvent.Kind>) = apply { this.kind = kind }

        fun data(data: Data) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

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
         * Returns an immutable instance of [EmailBouncedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .type()
         * .data()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EmailBouncedEvent =
            EmailBouncedEvent(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("type", type),
                kind,
                checkRequired("data", data),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EmailBouncedEvent = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        type().validate()
        kind().ifPresent { it.validate() }
        data().validate()
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
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (kind.asKnown().getOrNull()?.validity() ?: 0) +
            (data.asKnown().getOrNull()?.validity() ?: 0)

    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val domain: JsonField<String>,
        private val domainId: JsonField<String>,
        private val enqueueAt: JsonField<String>,
        private val from: JsonField<String>,
        private val messageId: JsonField<String>,
        private val orgId: JsonField<String>,
        private val sentAt: JsonField<String>,
        private val subject: JsonField<String>,
        private val to: JsonField<EmailEvent.To>,
        private val bcc: JsonField<EmailEvent.Bcc>,
        private val bulkId: JsonField<String>,
        private val cc: JsonField<EmailEvent.Cc>,
        private val headers: JsonField<List<EmailEvent.Header>>,
        private val replyTo: JsonField<EmailEvent.ReplyTo>,
        private val tags: JsonField<EmailEvent.Tags>,
        private val bounce: JsonField<BounceDetail>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("domain") @ExcludeMissing domain: JsonField<String> = JsonMissing.of(),
            @JsonProperty("domain_id")
            @ExcludeMissing
            domainId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("enqueue_at")
            @ExcludeMissing
            enqueueAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message_id")
            @ExcludeMissing
            messageId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("org_id") @ExcludeMissing orgId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sent_at") @ExcludeMissing sentAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
            @JsonProperty("to") @ExcludeMissing to: JsonField<EmailEvent.To> = JsonMissing.of(),
            @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<EmailEvent.Bcc> = JsonMissing.of(),
            @JsonProperty("bulk_id") @ExcludeMissing bulkId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cc") @ExcludeMissing cc: JsonField<EmailEvent.Cc> = JsonMissing.of(),
            @JsonProperty("headers")
            @ExcludeMissing
            headers: JsonField<List<EmailEvent.Header>> = JsonMissing.of(),
            @JsonProperty("reply_to")
            @ExcludeMissing
            replyTo: JsonField<EmailEvent.ReplyTo> = JsonMissing.of(),
            @JsonProperty("tags")
            @ExcludeMissing
            tags: JsonField<EmailEvent.Tags> = JsonMissing.of(),
            @JsonProperty("bounce")
            @ExcludeMissing
            bounce: JsonField<BounceDetail> = JsonMissing.of(),
        ) : this(
            id,
            domain,
            domainId,
            enqueueAt,
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
            bounce,
            mutableMapOf(),
        )

        fun toEmailEvent(): EmailEvent =
            EmailEvent.builder()
                .id(id)
                .domain(domain)
                .domainId(domainId)
                .enqueueAt(enqueueAt)
                .from(from)
                .messageId(messageId)
                .orgId(orgId)
                .sentAt(sentAt)
                .subject(subject)
                .to(to)
                .bcc(bcc)
                .bulkId(bulkId)
                .cc(cc)
                .headers(headers)
                .replyTo(replyTo)
                .tags(tags)
                .build()

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun domain(): String = domain.getRequired("domain")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun domainId(): String = domainId.getRequired("domain_id")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun enqueueAt(): String = enqueueAt.getRequired("enqueue_at")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun from(): String = from.getRequired("from")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun messageId(): String = messageId.getRequired("message_id")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orgId(): String = orgId.getRequired("org_id")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sentAt(): String = sentAt.getRequired("sent_at")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun subject(): String = subject.getRequired("subject")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun to(): EmailEvent.To = to.getRequired("to")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bcc(): Optional<EmailEvent.Bcc> = bcc.getOptional("bcc")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bulkId(): Optional<String> = bulkId.getOptional("bulk_id")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cc(): Optional<EmailEvent.Cc> = cc.getOptional("cc")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun headers(): Optional<List<EmailEvent.Header>> = headers.getOptional("headers")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun replyTo(): Optional<EmailEvent.ReplyTo> = replyTo.getOptional("reply_to")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tags(): Optional<EmailEvent.Tags> = tags.getOptional("tags")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bounce(): BounceDetail = bounce.getRequired("bounce")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [domain].
         *
         * Unlike [domain], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("domain") @ExcludeMissing fun _domain(): JsonField<String> = domain

        /**
         * Returns the raw JSON value of [domainId].
         *
         * Unlike [domainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("domain_id") @ExcludeMissing fun _domainId(): JsonField<String> = domainId

        /**
         * Returns the raw JSON value of [enqueueAt].
         *
         * Unlike [enqueueAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enqueue_at") @ExcludeMissing fun _enqueueAt(): JsonField<String> = enqueueAt

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
        @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

        /**
         * Returns the raw JSON value of [orgId].
         *
         * Unlike [orgId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("org_id") @ExcludeMissing fun _orgId(): JsonField<String> = orgId

        /**
         * Returns the raw JSON value of [sentAt].
         *
         * Unlike [sentAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sent_at") @ExcludeMissing fun _sentAt(): JsonField<String> = sentAt

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
        @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<EmailEvent.To> = to

        /**
         * Returns the raw JSON value of [bcc].
         *
         * Unlike [bcc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bcc") @ExcludeMissing fun _bcc(): JsonField<EmailEvent.Bcc> = bcc

        /**
         * Returns the raw JSON value of [bulkId].
         *
         * Unlike [bulkId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bulk_id") @ExcludeMissing fun _bulkId(): JsonField<String> = bulkId

        /**
         * Returns the raw JSON value of [cc].
         *
         * Unlike [cc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cc") @ExcludeMissing fun _cc(): JsonField<EmailEvent.Cc> = cc

        /**
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers")
        @ExcludeMissing
        fun _headers(): JsonField<List<EmailEvent.Header>> = headers

        /**
         * Returns the raw JSON value of [replyTo].
         *
         * Unlike [replyTo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reply_to")
        @ExcludeMissing
        fun _replyTo(): JsonField<EmailEvent.ReplyTo> = replyTo

        /**
         * Returns the raw JSON value of [tags].
         *
         * Unlike [tags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tags") @ExcludeMissing fun _tags(): JsonField<EmailEvent.Tags> = tags

        /**
         * Returns the raw JSON value of [bounce].
         *
         * Unlike [bounce], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bounce") @ExcludeMissing fun _bounce(): JsonField<BounceDetail> = bounce

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
             * .domain()
             * .domainId()
             * .enqueueAt()
             * .from()
             * .messageId()
             * .orgId()
             * .sentAt()
             * .subject()
             * .to()
             * .bounce()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var domain: JsonField<String>? = null
            private var domainId: JsonField<String>? = null
            private var enqueueAt: JsonField<String>? = null
            private var from: JsonField<String>? = null
            private var messageId: JsonField<String>? = null
            private var orgId: JsonField<String>? = null
            private var sentAt: JsonField<String>? = null
            private var subject: JsonField<String>? = null
            private var to: JsonField<EmailEvent.To>? = null
            private var bcc: JsonField<EmailEvent.Bcc> = JsonMissing.of()
            private var bulkId: JsonField<String> = JsonMissing.of()
            private var cc: JsonField<EmailEvent.Cc> = JsonMissing.of()
            private var headers: JsonField<MutableList<EmailEvent.Header>>? = null
            private var replyTo: JsonField<EmailEvent.ReplyTo> = JsonMissing.of()
            private var tags: JsonField<EmailEvent.Tags> = JsonMissing.of()
            private var bounce: JsonField<BounceDetail>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                domain = data.domain
                domainId = data.domainId
                enqueueAt = data.enqueueAt
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
                bounce = data.bounce
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

            fun domain(domain: String) = domain(JsonField.of(domain))

            /**
             * Sets [Builder.domain] to an arbitrary JSON value.
             *
             * You should usually call [Builder.domain] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun domain(domain: JsonField<String>) = apply { this.domain = domain }

            fun domainId(domainId: String) = domainId(JsonField.of(domainId))

            /**
             * Sets [Builder.domainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.domainId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun domainId(domainId: JsonField<String>) = apply { this.domainId = domainId }

            fun enqueueAt(enqueueAt: String) = enqueueAt(JsonField.of(enqueueAt))

            /**
             * Sets [Builder.enqueueAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enqueueAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enqueueAt(enqueueAt: JsonField<String>) = apply { this.enqueueAt = enqueueAt }

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

            fun to(to: EmailEvent.To) = to(JsonField.of(to))

            /**
             * Sets [Builder.to] to an arbitrary JSON value.
             *
             * You should usually call [Builder.to] with a well-typed [EmailEvent.To] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun to(to: JsonField<EmailEvent.To>) = apply { this.to = to }

            /** Alias for calling [to] with `EmailEvent.To.ofString(string)`. */
            fun to(string: String) = to(EmailEvent.To.ofString(string))

            /** Alias for calling [to] with `EmailEvent.To.ofStrings(strings)`. */
            fun toOfStrings(strings: List<String>) = to(EmailEvent.To.ofStrings(strings))

            fun bcc(bcc: EmailEvent.Bcc) = bcc(JsonField.of(bcc))

            /**
             * Sets [Builder.bcc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bcc] with a well-typed [EmailEvent.Bcc] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bcc(bcc: JsonField<EmailEvent.Bcc>) = apply { this.bcc = bcc }

            /** Alias for calling [bcc] with `EmailEvent.Bcc.ofString(string)`. */
            fun bcc(string: String) = bcc(EmailEvent.Bcc.ofString(string))

            /** Alias for calling [bcc] with `EmailEvent.Bcc.ofStrings(strings)`. */
            fun bccOfStrings(strings: List<String>) = bcc(EmailEvent.Bcc.ofStrings(strings))

            fun bulkId(bulkId: String) = bulkId(JsonField.of(bulkId))

            /**
             * Sets [Builder.bulkId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bulkId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bulkId(bulkId: JsonField<String>) = apply { this.bulkId = bulkId }

            fun cc(cc: EmailEvent.Cc) = cc(JsonField.of(cc))

            /**
             * Sets [Builder.cc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cc] with a well-typed [EmailEvent.Cc] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cc(cc: JsonField<EmailEvent.Cc>) = apply { this.cc = cc }

            /** Alias for calling [cc] with `EmailEvent.Cc.ofString(string)`. */
            fun cc(string: String) = cc(EmailEvent.Cc.ofString(string))

            /** Alias for calling [cc] with `EmailEvent.Cc.ofStrings(strings)`. */
            fun ccOfStrings(strings: List<String>) = cc(EmailEvent.Cc.ofStrings(strings))

            fun headers(headers: List<EmailEvent.Header>) = headers(JsonField.of(headers))

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed `List<EmailEvent.Header>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun headers(headers: JsonField<List<EmailEvent.Header>>) = apply {
                this.headers = headers.map { it.toMutableList() }
            }

            /**
             * Adds a single [EmailEvent.Header] to [headers].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addHeader(header: EmailEvent.Header) = apply {
                headers =
                    (headers ?: JsonField.of(mutableListOf())).also {
                        checkKnown("headers", it).add(header)
                    }
            }

            fun replyTo(replyTo: EmailEvent.ReplyTo) = replyTo(JsonField.of(replyTo))

            /**
             * Sets [Builder.replyTo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.replyTo] with a well-typed [EmailEvent.ReplyTo]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun replyTo(replyTo: JsonField<EmailEvent.ReplyTo>) = apply { this.replyTo = replyTo }

            /** Alias for calling [replyTo] with `EmailEvent.ReplyTo.ofString(string)`. */
            fun replyTo(string: String) = replyTo(EmailEvent.ReplyTo.ofString(string))

            /** Alias for calling [replyTo] with `EmailEvent.ReplyTo.ofStrings(strings)`. */
            fun replyToOfStrings(strings: List<String>) =
                replyTo(EmailEvent.ReplyTo.ofStrings(strings))

            fun tags(tags: EmailEvent.Tags) = tags(JsonField.of(tags))

            /**
             * Sets [Builder.tags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tags] with a well-typed [EmailEvent.Tags] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tags(tags: JsonField<EmailEvent.Tags>) = apply { this.tags = tags }

            fun bounce(bounce: BounceDetail) = bounce(JsonField.of(bounce))

            /**
             * Sets [Builder.bounce] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bounce] with a well-typed [BounceDetail] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bounce(bounce: JsonField<BounceDetail>) = apply { this.bounce = bounce }

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
             * .domain()
             * .domainId()
             * .enqueueAt()
             * .from()
             * .messageId()
             * .orgId()
             * .sentAt()
             * .subject()
             * .to()
             * .bounce()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Data =
                Data(
                    checkRequired("id", id),
                    checkRequired("domain", domain),
                    checkRequired("domainId", domainId),
                    checkRequired("enqueueAt", enqueueAt),
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
                    checkRequired("bounce", bounce),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            id()
            domain()
            domainId()
            enqueueAt()
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
            bounce().validate()
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
                (if (domain.asKnown().isPresent) 1 else 0) +
                (if (domainId.asKnown().isPresent) 1 else 0) +
                (if (enqueueAt.asKnown().isPresent) 1 else 0) +
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
                (tags.asKnown().getOrNull()?.validity() ?: 0) +
                (bounce.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                id == other.id &&
                domain == other.domain &&
                domainId == other.domainId &&
                enqueueAt == other.enqueueAt &&
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
                bounce == other.bounce &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                domain,
                domainId,
                enqueueAt,
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
                bounce,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, domain=$domain, domainId=$domainId, enqueueAt=$enqueueAt, from=$from, messageId=$messageId, orgId=$orgId, sentAt=$sentAt, subject=$subject, to=$to, bcc=$bcc, bulkId=$bulkId, cc=$cc, headers=$headers, replyTo=$replyTo, tags=$tags, bounce=$bounce, additionalProperties=$additionalProperties}"
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

            @JvmField val EMAIL_BOUNCED = of("email.bounced")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            EMAIL_BOUNCED
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
            EMAIL_BOUNCED,
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
                EMAIL_BOUNCED -> Value.EMAIL_BOUNCED
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
                EMAIL_BOUNCED -> Known.EMAIL_BOUNCED
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

        return other is EmailBouncedEvent &&
            id == other.id &&
            createdAt == other.createdAt &&
            type == other.type &&
            kind == other.kind &&
            data == other.data &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, createdAt, type, kind, data, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EmailBouncedEvent{id=$id, createdAt=$createdAt, type=$type, kind=$kind, data=$data, additionalProperties=$additionalProperties}"
}
