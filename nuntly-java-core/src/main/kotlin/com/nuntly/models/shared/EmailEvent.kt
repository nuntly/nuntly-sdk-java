// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

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

class EmailEvent
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
        @JsonProperty("domain") @ExcludeMissing domain: JsonField<String> = JsonMissing.of(),
        @JsonProperty("domain_id") @ExcludeMissing domainId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("enqueue_at") @ExcludeMissing enqueueAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("org_id") @ExcludeMissing orgId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sent_at") @ExcludeMissing sentAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
        @JsonProperty("to") @ExcludeMissing to: JsonField<To> = JsonMissing.of(),
        @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<Bcc> = JsonMissing.of(),
        @JsonProperty("bulk_id") @ExcludeMissing bulkId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cc") @ExcludeMissing cc: JsonField<Cc> = JsonMissing.of(),
        @JsonProperty("headers")
        @ExcludeMissing
        headers: JsonField<List<Header>> = JsonMissing.of(),
        @JsonProperty("reply_to") @ExcludeMissing replyTo: JsonField<ReplyTo> = JsonMissing.of(),
        @JsonProperty("tags") @ExcludeMissing tags: JsonField<Tags> = JsonMissing.of(),
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
    fun bulkId(): Optional<String> = bulkId.getOptional("bulk_id")

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
    fun replyTo(): Optional<ReplyTo> = replyTo.getOptional("reply_to")

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
    @JsonProperty("bulk_id") @ExcludeMissing fun _bulkId(): JsonField<String> = bulkId

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
    @JsonProperty("reply_to") @ExcludeMissing fun _replyTo(): JsonField<ReplyTo> = replyTo

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
         * Returns a mutable builder for constructing an instance of [EmailEvent].
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
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EmailEvent]. */
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
        private var to: JsonField<To>? = null
        private var bcc: JsonField<Bcc> = JsonMissing.of()
        private var bulkId: JsonField<String> = JsonMissing.of()
        private var cc: JsonField<Cc> = JsonMissing.of()
        private var headers: JsonField<MutableList<Header>>? = null
        private var replyTo: JsonField<ReplyTo> = JsonMissing.of()
        private var tags: JsonField<Tags> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(emailEvent: EmailEvent) = apply {
            id = emailEvent.id
            domain = emailEvent.domain
            domainId = emailEvent.domainId
            enqueueAt = emailEvent.enqueueAt
            from = emailEvent.from
            messageId = emailEvent.messageId
            orgId = emailEvent.orgId
            sentAt = emailEvent.sentAt
            subject = emailEvent.subject
            to = emailEvent.to
            bcc = emailEvent.bcc
            bulkId = emailEvent.bulkId
            cc = emailEvent.cc
            headers = emailEvent.headers.map { it.toMutableList() }
            replyTo = emailEvent.replyTo
            tags = emailEvent.tags
            additionalProperties = emailEvent.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun domain(domain: String) = domain(JsonField.of(domain))

        /**
         * Sets [Builder.domain] to an arbitrary JSON value.
         *
         * You should usually call [Builder.domain] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun domain(domain: JsonField<String>) = apply { this.domain = domain }

        fun domainId(domainId: String) = domainId(JsonField.of(domainId))

        /**
         * Sets [Builder.domainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.domainId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun domainId(domainId: JsonField<String>) = apply { this.domainId = domainId }

        fun enqueueAt(enqueueAt: String) = enqueueAt(JsonField.of(enqueueAt))

        /**
         * Sets [Builder.enqueueAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enqueueAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun enqueueAt(enqueueAt: JsonField<String>) = apply { this.enqueueAt = enqueueAt }

        fun from(from: String) = from(JsonField.of(from))

        /**
         * Sets [Builder.from] to an arbitrary JSON value.
         *
         * You should usually call [Builder.from] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun from(from: JsonField<String>) = apply { this.from = from }

        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        fun orgId(orgId: String) = orgId(JsonField.of(orgId))

        /**
         * Sets [Builder.orgId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orgId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun orgId(orgId: JsonField<String>) = apply { this.orgId = orgId }

        fun sentAt(sentAt: String) = sentAt(JsonField.of(sentAt))

        /**
         * Sets [Builder.sentAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sentAt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sentAt(sentAt: JsonField<String>) = apply { this.sentAt = sentAt }

        fun subject(subject: String) = subject(JsonField.of(subject))

        /**
         * Sets [Builder.subject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subject] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

        fun to(to: To) = to(JsonField.of(to))

        /**
         * Sets [Builder.to] to an arbitrary JSON value.
         *
         * You should usually call [Builder.to] with a well-typed [To] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
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
         * You should usually call [Builder.bcc] with a well-typed [Bcc] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
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
         * You should usually call [Builder.bulkId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bulkId(bulkId: JsonField<String>) = apply { this.bulkId = bulkId }

        fun cc(cc: Cc) = cc(JsonField.of(cc))

        /**
         * Sets [Builder.cc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cc] with a well-typed [Cc] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
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
         * You should usually call [Builder.headers] with a well-typed `List<Header>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * You should usually call [Builder.replyTo] with a well-typed [ReplyTo] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [EmailEvent].
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
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EmailEvent =
            EmailEvent(
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
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EmailEvent = apply {
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
            (tags.asKnown().getOrNull()?.validity() ?: 0)

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

            @JvmStatic fun ofStrings(strings: List<String>) = To(strings = strings.toImmutable())
        }

        /** An interface that defines how to map each variant of [To] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            /**
             * Maps an unknown variant of [To] to a value of type [T].
             *
             * An instance of [To] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
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
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> To(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
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

            @JvmStatic fun ofStrings(strings: List<String>) = Bcc(strings = strings.toImmutable())
        }

        /** An interface that defines how to map each variant of [Bcc] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            /**
             * Maps an unknown variant of [Bcc] to a value of type [T].
             *
             * An instance of [Bcc] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
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
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Bcc(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
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

            @JvmStatic fun ofStrings(strings: List<String>) = Cc(strings = strings.toImmutable())
        }

        /** An interface that defines how to map each variant of [Cc] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            /**
             * Maps an unknown variant of [Cc] to a value of type [T].
             *
             * An instance of [Cc] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
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
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Cc(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
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
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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
         * An interface that defines how to map each variant of [ReplyTo] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            /**
             * Maps an unknown variant of [ReplyTo] to a value of type [T].
             *
             * An instance of [ReplyTo] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
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
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> ReplyTo(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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

        return other is EmailEvent &&
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
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EmailEvent{id=$id, domain=$domain, domainId=$domainId, enqueueAt=$enqueueAt, from=$from, messageId=$messageId, orgId=$orgId, sentAt=$sentAt, subject=$subject, to=$to, bcc=$bcc, bulkId=$bulkId, cc=$cc, headers=$headers, replyTo=$replyTo, tags=$tags, additionalProperties=$additionalProperties}"
}
