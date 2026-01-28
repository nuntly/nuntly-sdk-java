// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

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
import com.nuntly.models.shared.EmailHeaders
import com.nuntly.models.shared.EmailStatus
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class EmailRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val from: JsonField<String>,
    private val kind: JsonField<Kind>,
    private val orgId: JsonField<String>,
    private val region: JsonField<Region>,
    private val status: JsonField<EmailStatus>,
    private val statusAt: JsonField<String>,
    private val subject: JsonField<String>,
    private val to: JsonField<To>,
    private val attachments: JsonField<List<Attachment>>,
    private val bcc: JsonField<Bcc>,
    private val bulkId: JsonField<String>,
    private val cc: JsonField<Cc>,
    private val context: JsonValue,
    private val headers: JsonField<EmailHeaders>,
    private val messageId: JsonField<String>,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val replyTo: JsonField<ReplyTo>,
    private val scheduledAt: JsonField<OffsetDateTime>,
    private val statusReason: JsonField<StatusReason>,
    private val tags: JsonField<List<Tag>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
        @JsonProperty("kind") @ExcludeMissing kind: JsonField<Kind> = JsonMissing.of(),
        @JsonProperty("org_id") @ExcludeMissing orgId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("region") @ExcludeMissing region: JsonField<Region> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<EmailStatus> = JsonMissing.of(),
        @JsonProperty("status_at") @ExcludeMissing statusAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
        @JsonProperty("to") @ExcludeMissing to: JsonField<To> = JsonMissing.of(),
        @JsonProperty("attachments")
        @ExcludeMissing
        attachments: JsonField<List<Attachment>> = JsonMissing.of(),
        @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<Bcc> = JsonMissing.of(),
        @JsonProperty("bulk_id") @ExcludeMissing bulkId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cc") @ExcludeMissing cc: JsonField<Cc> = JsonMissing.of(),
        @JsonProperty("context") @ExcludeMissing context: JsonValue = JsonMissing.of(),
        @JsonProperty("headers")
        @ExcludeMissing
        headers: JsonField<EmailHeaders> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("modified_at")
        @ExcludeMissing
        modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("reply_to") @ExcludeMissing replyTo: JsonField<ReplyTo> = JsonMissing.of(),
        @JsonProperty("scheduled_at")
        @ExcludeMissing
        scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("status_reason")
        @ExcludeMissing
        statusReason: JsonField<StatusReason> = JsonMissing.of(),
        @JsonProperty("tags") @ExcludeMissing tags: JsonField<List<Tag>> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        from,
        kind,
        orgId,
        region,
        status,
        statusAt,
        subject,
        to,
        attachments,
        bcc,
        bulkId,
        cc,
        context,
        headers,
        messageId,
        modifiedAt,
        replyTo,
        scheduledAt,
        statusReason,
        tags,
        mutableMapOf(),
    )

    /**
     * The id of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Date at which the object was created (ISO 8601 format)
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

    /**
     * The e-mail address of the sender
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun from(): String = from.getRequired("from")

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
     * The region of the related data
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun region(): Region = region.getRequired("region")

    /**
     * The status of the email.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): EmailStatus = status.getRequired("status")

    /**
     * Date xhen the status changed
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun statusAt(): String = statusAt.getRequired("status_at")

    /**
     * The subject of the e-mail
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun subject(): String = subject.getRequired("subject")

    /**
     * The primary recipient(s) of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun to(): To = to.getRequired("to")

    /**
     * The attachements
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun attachments(): Optional<List<Attachment>> = attachments.getOptional("attachments")

    /**
     * The blind carbon copy recipient(s) of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bcc(): Optional<Bcc> = bcc.getOptional("bcc")

    /**
     * The bulk id
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bulkId(): Optional<String> = bulkId.getOptional("bulk_id")

    /**
     * The carbon copy recipient(s) of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cc(): Optional<Cc> = cc.getOptional("cc")

    /**
     * The context for the template
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = emailRetrieveResponse.context().convert(MyClass.class);
     * ```
     */
    @JsonProperty("context") @ExcludeMissing fun _context(): JsonValue = context

    /**
     * The headers to add to the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun headers(): Optional<EmailHeaders> = headers.getOptional("headers")

    /**
     * The id from email provider
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("message_id")

    /**
     * Date at which the object was modified (ISO 8601 format)
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun modifiedAt(): Optional<OffsetDateTime> = modifiedAt.getOptional("modified_at")

    /**
     * The email address where replies should be sent. If a recipient replies, the response will go
     * to this address instead of the sender's email address
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun replyTo(): Optional<ReplyTo> = replyTo.getOptional("reply_to")

    /**
     * The date at which the email is scheduled to be sent
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun scheduledAt(): Optional<OffsetDateTime> = scheduledAt.getOptional("scheduled_at")

    /**
     * May provide more informations about the status
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun statusReason(): Optional<StatusReason> = statusReason.getOptional("status_reason")

    /**
     * The tags to add to the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tags(): Optional<List<Tag>> = tags.getOptional("tags")

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
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [from].
     *
     * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

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
     * Returns the raw JSON value of [region].
     *
     * Unlike [region], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("region") @ExcludeMissing fun _region(): JsonField<Region> = region

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<EmailStatus> = status

    /**
     * Returns the raw JSON value of [statusAt].
     *
     * Unlike [statusAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status_at") @ExcludeMissing fun _statusAt(): JsonField<String> = statusAt

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
     * Returns the raw JSON value of [attachments].
     *
     * Unlike [attachments], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("attachments")
    @ExcludeMissing
    fun _attachments(): JsonField<List<Attachment>> = attachments

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
    @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<EmailHeaders> = headers

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    /**
     * Returns the raw JSON value of [modifiedAt].
     *
     * Unlike [modifiedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("modified_at")
    @ExcludeMissing
    fun _modifiedAt(): JsonField<OffsetDateTime> = modifiedAt

    /**
     * Returns the raw JSON value of [replyTo].
     *
     * Unlike [replyTo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reply_to") @ExcludeMissing fun _replyTo(): JsonField<ReplyTo> = replyTo

    /**
     * Returns the raw JSON value of [scheduledAt].
     *
     * Unlike [scheduledAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("scheduled_at")
    @ExcludeMissing
    fun _scheduledAt(): JsonField<OffsetDateTime> = scheduledAt

    /**
     * Returns the raw JSON value of [statusReason].
     *
     * Unlike [statusReason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status_reason")
    @ExcludeMissing
    fun _statusReason(): JsonField<StatusReason> = statusReason

    /**
     * Returns the raw JSON value of [tags].
     *
     * Unlike [tags], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tags") @ExcludeMissing fun _tags(): JsonField<List<Tag>> = tags

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
         * Returns a mutable builder for constructing an instance of [EmailRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .from()
         * .kind()
         * .orgId()
         * .region()
         * .status()
         * .statusAt()
         * .subject()
         * .to()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EmailRetrieveResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var from: JsonField<String>? = null
        private var kind: JsonField<Kind>? = null
        private var orgId: JsonField<String>? = null
        private var region: JsonField<Region>? = null
        private var status: JsonField<EmailStatus>? = null
        private var statusAt: JsonField<String>? = null
        private var subject: JsonField<String>? = null
        private var to: JsonField<To>? = null
        private var attachments: JsonField<MutableList<Attachment>>? = null
        private var bcc: JsonField<Bcc> = JsonMissing.of()
        private var bulkId: JsonField<String> = JsonMissing.of()
        private var cc: JsonField<Cc> = JsonMissing.of()
        private var context: JsonValue = JsonMissing.of()
        private var headers: JsonField<EmailHeaders> = JsonMissing.of()
        private var messageId: JsonField<String> = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var replyTo: JsonField<ReplyTo> = JsonMissing.of()
        private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var statusReason: JsonField<StatusReason> = JsonMissing.of()
        private var tags: JsonField<MutableList<Tag>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(emailRetrieveResponse: EmailRetrieveResponse) = apply {
            id = emailRetrieveResponse.id
            createdAt = emailRetrieveResponse.createdAt
            from = emailRetrieveResponse.from
            kind = emailRetrieveResponse.kind
            orgId = emailRetrieveResponse.orgId
            region = emailRetrieveResponse.region
            status = emailRetrieveResponse.status
            statusAt = emailRetrieveResponse.statusAt
            subject = emailRetrieveResponse.subject
            to = emailRetrieveResponse.to
            attachments = emailRetrieveResponse.attachments.map { it.toMutableList() }
            bcc = emailRetrieveResponse.bcc
            bulkId = emailRetrieveResponse.bulkId
            cc = emailRetrieveResponse.cc
            context = emailRetrieveResponse.context
            headers = emailRetrieveResponse.headers
            messageId = emailRetrieveResponse.messageId
            modifiedAt = emailRetrieveResponse.modifiedAt
            replyTo = emailRetrieveResponse.replyTo
            scheduledAt = emailRetrieveResponse.scheduledAt
            statusReason = emailRetrieveResponse.statusReason
            tags = emailRetrieveResponse.tags.map { it.toMutableList() }
            additionalProperties = emailRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** The id of the email */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Date at which the object was created (ISO 8601 format) */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** The e-mail address of the sender */
        fun from(from: String) = from(JsonField.of(from))

        /**
         * Sets [Builder.from] to an arbitrary JSON value.
         *
         * You should usually call [Builder.from] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun from(from: JsonField<String>) = apply { this.from = from }

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

        /** The region of the related data */
        fun region(region: Region) = region(JsonField.of(region))

        /**
         * Sets [Builder.region] to an arbitrary JSON value.
         *
         * You should usually call [Builder.region] with a well-typed [Region] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun region(region: JsonField<Region>) = apply { this.region = region }

        /** The status of the email. */
        fun status(status: EmailStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [EmailStatus] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun status(status: JsonField<EmailStatus>) = apply { this.status = status }

        /** Date xhen the status changed */
        fun statusAt(statusAt: String) = statusAt(JsonField.of(statusAt))

        /**
         * Sets [Builder.statusAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusAt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun statusAt(statusAt: JsonField<String>) = apply { this.statusAt = statusAt }

        /** The subject of the e-mail */
        fun subject(subject: String) = subject(JsonField.of(subject))

        /**
         * Sets [Builder.subject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subject] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

        /** The primary recipient(s) of the email */
        fun to(to: To) = to(JsonField.of(to))

        /**
         * Sets [Builder.to] to an arbitrary JSON value.
         *
         * You should usually call [Builder.to] with a well-typed [To] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun to(to: JsonField<To>) = apply { this.to = to }

        /** Alias for calling [to] with `To.ofStrings(strings)`. */
        fun toOfStrings(strings: List<String>) = to(To.ofStrings(strings))

        /** Alias for calling [to] with `To.ofString(string)`. */
        fun to(string: String) = to(To.ofString(string))

        /** The attachements */
        fun attachments(attachments: List<Attachment>) = attachments(JsonField.of(attachments))

        /**
         * Sets [Builder.attachments] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attachments] with a well-typed `List<Attachment>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun attachments(attachments: JsonField<List<Attachment>>) = apply {
            this.attachments = attachments.map { it.toMutableList() }
        }

        /**
         * Adds a single [Attachment] to [attachments].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAttachment(attachment: Attachment) = apply {
            attachments =
                (attachments ?: JsonField.of(mutableListOf())).also {
                    checkKnown("attachments", it).add(attachment)
                }
        }

        /** The blind carbon copy recipient(s) of the email */
        fun bcc(bcc: Bcc) = bcc(JsonField.of(bcc))

        /**
         * Sets [Builder.bcc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bcc] with a well-typed [Bcc] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bcc(bcc: JsonField<Bcc>) = apply { this.bcc = bcc }

        /** Alias for calling [bcc] with `Bcc.ofStrings(strings)`. */
        fun bccOfStrings(strings: List<String>) = bcc(Bcc.ofStrings(strings))

        /** Alias for calling [bcc] with `Bcc.ofString(string)`. */
        fun bcc(string: String) = bcc(Bcc.ofString(string))

        /** The bulk id */
        fun bulkId(bulkId: String) = bulkId(JsonField.of(bulkId))

        /**
         * Sets [Builder.bulkId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bulkId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bulkId(bulkId: JsonField<String>) = apply { this.bulkId = bulkId }

        /** The carbon copy recipient(s) of the email */
        fun cc(cc: Cc) = cc(JsonField.of(cc))

        /**
         * Sets [Builder.cc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cc] with a well-typed [Cc] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cc(cc: JsonField<Cc>) = apply { this.cc = cc }

        /** Alias for calling [cc] with `Cc.ofStrings(strings)`. */
        fun ccOfStrings(strings: List<String>) = cc(Cc.ofStrings(strings))

        /** Alias for calling [cc] with `Cc.ofString(string)`. */
        fun cc(string: String) = cc(Cc.ofString(string))

        /** The context for the template */
        fun context(context: JsonValue) = apply { this.context = context }

        /** The headers to add to the email */
        fun headers(headers: EmailHeaders) = headers(JsonField.of(headers))

        /**
         * Sets [Builder.headers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.headers] with a well-typed [EmailHeaders] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun headers(headers: JsonField<EmailHeaders>) = apply { this.headers = headers }

        /** The id from email provider */
        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        /** Date at which the object was modified (ISO 8601 format) */
        fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

        /**
         * Sets [Builder.modifiedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.modifiedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
            this.modifiedAt = modifiedAt
        }

        /**
         * The email address where replies should be sent. If a recipient replies, the response will
         * go to this address instead of the sender's email address
         */
        fun replyTo(replyTo: ReplyTo) = replyTo(JsonField.of(replyTo))

        /**
         * Sets [Builder.replyTo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.replyTo] with a well-typed [ReplyTo] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun replyTo(replyTo: JsonField<ReplyTo>) = apply { this.replyTo = replyTo }

        /** Alias for calling [replyTo] with `ReplyTo.ofStrings(strings)`. */
        fun replyToOfStrings(strings: List<String>) = replyTo(ReplyTo.ofStrings(strings))

        /** Alias for calling [replyTo] with `ReplyTo.ofString(string)`. */
        fun replyTo(string: String) = replyTo(ReplyTo.ofString(string))

        /** The date at which the email is scheduled to be sent */
        fun scheduledAt(scheduledAt: OffsetDateTime) = scheduledAt(JsonField.of(scheduledAt))

        /**
         * Sets [Builder.scheduledAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scheduledAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun scheduledAt(scheduledAt: JsonField<OffsetDateTime>) = apply {
            this.scheduledAt = scheduledAt
        }

        /** May provide more informations about the status */
        fun statusReason(statusReason: StatusReason) = statusReason(JsonField.of(statusReason))

        /**
         * Sets [Builder.statusReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusReason] with a well-typed [StatusReason] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun statusReason(statusReason: JsonField<StatusReason>) = apply {
            this.statusReason = statusReason
        }

        /** The tags to add to the email */
        fun tags(tags: List<Tag>) = tags(JsonField.of(tags))

        /**
         * Sets [Builder.tags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tags] with a well-typed `List<Tag>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tags(tags: JsonField<List<Tag>>) = apply { this.tags = tags.map { it.toMutableList() } }

        /**
         * Adds a single [Tag] to [tags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTag(tag: Tag) = apply {
            tags = (tags ?: JsonField.of(mutableListOf())).also { checkKnown("tags", it).add(tag) }
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
         * Returns an immutable instance of [EmailRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .from()
         * .kind()
         * .orgId()
         * .region()
         * .status()
         * .statusAt()
         * .subject()
         * .to()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EmailRetrieveResponse =
            EmailRetrieveResponse(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("from", from),
                checkRequired("kind", kind),
                checkRequired("orgId", orgId),
                checkRequired("region", region),
                checkRequired("status", status),
                checkRequired("statusAt", statusAt),
                checkRequired("subject", subject),
                checkRequired("to", to),
                (attachments ?: JsonMissing.of()).map { it.toImmutable() },
                bcc,
                bulkId,
                cc,
                context,
                headers,
                messageId,
                modifiedAt,
                replyTo,
                scheduledAt,
                statusReason,
                (tags ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EmailRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        from()
        kind().validate()
        orgId()
        region().validate()
        status().validate()
        statusAt()
        subject()
        to().validate()
        attachments().ifPresent { it.forEach { it.validate() } }
        bcc().ifPresent { it.validate() }
        bulkId()
        cc().ifPresent { it.validate() }
        headers().ifPresent { it.validate() }
        messageId()
        modifiedAt()
        replyTo().ifPresent { it.validate() }
        scheduledAt()
        statusReason().ifPresent { it.validate() }
        tags().ifPresent { it.forEach { it.validate() } }
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
            (if (from.asKnown().isPresent) 1 else 0) +
            (kind.asKnown().getOrNull()?.validity() ?: 0) +
            (if (orgId.asKnown().isPresent) 1 else 0) +
            (region.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (statusAt.asKnown().isPresent) 1 else 0) +
            (if (subject.asKnown().isPresent) 1 else 0) +
            (to.asKnown().getOrNull()?.validity() ?: 0) +
            (attachments.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (bcc.asKnown().getOrNull()?.validity() ?: 0) +
            (if (bulkId.asKnown().isPresent) 1 else 0) +
            (cc.asKnown().getOrNull()?.validity() ?: 0) +
            (headers.asKnown().getOrNull()?.validity() ?: 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (modifiedAt.asKnown().isPresent) 1 else 0) +
            (replyTo.asKnown().getOrNull()?.validity() ?: 0) +
            (if (scheduledAt.asKnown().isPresent) 1 else 0) +
            (statusReason.asKnown().getOrNull()?.validity() ?: 0) +
            (tags.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

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

            @JvmField val EMAIL = of("email")

            @JvmStatic fun of(value: String) = Kind(JsonField.of(value))
        }

        /** An enum containing [Kind]'s known values. */
        enum class Known {
            EMAIL
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
            EMAIL,
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
                EMAIL -> Value.EMAIL
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
                EMAIL -> Known.EMAIL
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

    /** The region of the related data */
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

    /** The primary recipient(s) of the email */
    @JsonDeserialize(using = To.Deserializer::class)
    @JsonSerialize(using = To.Serializer::class)
    class To
    private constructor(
        private val strings: List<String>? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isStrings(): Boolean = strings != null

        fun isString(): Boolean = string != null

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                strings != null -> visitor.visitStrings(strings)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): To = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitStrings(strings: List<String>) {}

                    override fun visitString(string: String) {}
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
                    override fun visitStrings(strings: List<String>) = strings.size

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is To && strings == other.strings && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(strings, string)

        override fun toString(): String =
            when {
                strings != null -> "To{strings=$strings}"
                string != null -> "To{string=$string}"
                _json != null -> "To{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid To")
            }

        companion object {

            @JvmStatic fun ofStrings(strings: List<String>) = To(strings = strings.toImmutable())

            @JvmStatic fun ofString(string: String) = To(string = string)
        }

        /** An interface that defines how to map each variant of [To] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitStrings(strings: List<String>): T

            fun visitString(string: String): T

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
                    // all the possible variants (e.g. deserializing from boolean).
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
                    value.strings != null -> generator.writeObject(value.strings)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid To")
                }
            }
        }
    }

    /** The attachment */
    class Attachment
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentType: JsonField<String>,
        private val filename: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content_type")
            @ExcludeMissing
            contentType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("filename") @ExcludeMissing filename: JsonField<String> = JsonMissing.of(),
        ) : this(contentType, filename, mutableMapOf())

        /**
         * Content type of the attachment (the MIME type)
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun contentType(): Optional<String> = contentType.getOptional("content_type")

        /**
         * The name of the attached file to be displayed to the recipient
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun filename(): Optional<String> = filename.getOptional("filename")

        /**
         * Returns the raw JSON value of [contentType].
         *
         * Unlike [contentType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content_type")
        @ExcludeMissing
        fun _contentType(): JsonField<String> = contentType

        /**
         * Returns the raw JSON value of [filename].
         *
         * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

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

            /** Returns a mutable builder for constructing an instance of [Attachment]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Attachment]. */
        class Builder internal constructor() {

            private var contentType: JsonField<String> = JsonMissing.of()
            private var filename: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(attachment: Attachment) = apply {
                contentType = attachment.contentType
                filename = attachment.filename
                additionalProperties = attachment.additionalProperties.toMutableMap()
            }

            /** Content type of the attachment (the MIME type) */
            fun contentType(contentType: String) = contentType(JsonField.of(contentType))

            /**
             * Sets [Builder.contentType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentType(contentType: JsonField<String>) = apply {
                this.contentType = contentType
            }

            /** The name of the attached file to be displayed to the recipient */
            fun filename(filename: String) = filename(JsonField.of(filename))

            /**
             * Sets [Builder.filename] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filename] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filename(filename: JsonField<String>) = apply { this.filename = filename }

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
             * Returns an immutable instance of [Attachment].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Attachment =
                Attachment(contentType, filename, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Attachment = apply {
            if (validated) {
                return@apply
            }

            contentType()
            filename()
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
            (if (contentType.asKnown().isPresent) 1 else 0) +
                (if (filename.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Attachment &&
                contentType == other.contentType &&
                filename == other.filename &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(contentType, filename, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Attachment{contentType=$contentType, filename=$filename, additionalProperties=$additionalProperties}"
    }

    /** The blind carbon copy recipient(s) of the email */
    @JsonDeserialize(using = Bcc.Deserializer::class)
    @JsonSerialize(using = Bcc.Serializer::class)
    class Bcc
    private constructor(
        private val strings: List<String>? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isStrings(): Boolean = strings != null

        fun isString(): Boolean = string != null

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                strings != null -> visitor.visitStrings(strings)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Bcc = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitStrings(strings: List<String>) {}

                    override fun visitString(string: String) {}
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
                    override fun visitStrings(strings: List<String>) = strings.size

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Bcc && strings == other.strings && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(strings, string)

        override fun toString(): String =
            when {
                strings != null -> "Bcc{strings=$strings}"
                string != null -> "Bcc{string=$string}"
                _json != null -> "Bcc{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Bcc")
            }

        companion object {

            @JvmStatic fun ofStrings(strings: List<String>) = Bcc(strings = strings.toImmutable())

            @JvmStatic fun ofString(string: String) = Bcc(string = string)
        }

        /** An interface that defines how to map each variant of [Bcc] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitStrings(strings: List<String>): T

            fun visitString(string: String): T

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
                    // all the possible variants (e.g. deserializing from boolean).
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
                    value.strings != null -> generator.writeObject(value.strings)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Bcc")
                }
            }
        }
    }

    /** The carbon copy recipient(s) of the email */
    @JsonDeserialize(using = Cc.Deserializer::class)
    @JsonSerialize(using = Cc.Serializer::class)
    class Cc
    private constructor(
        private val strings: List<String>? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isStrings(): Boolean = strings != null

        fun isString(): Boolean = string != null

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                strings != null -> visitor.visitStrings(strings)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Cc = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitStrings(strings: List<String>) {}

                    override fun visitString(string: String) {}
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
                    override fun visitStrings(strings: List<String>) = strings.size

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Cc && strings == other.strings && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(strings, string)

        override fun toString(): String =
            when {
                strings != null -> "Cc{strings=$strings}"
                string != null -> "Cc{string=$string}"
                _json != null -> "Cc{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Cc")
            }

        companion object {

            @JvmStatic fun ofStrings(strings: List<String>) = Cc(strings = strings.toImmutable())

            @JvmStatic fun ofString(string: String) = Cc(string = string)
        }

        /** An interface that defines how to map each variant of [Cc] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitStrings(strings: List<String>): T

            fun visitString(string: String): T

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
                    // all the possible variants (e.g. deserializing from boolean).
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
                    value.strings != null -> generator.writeObject(value.strings)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Cc")
                }
            }
        }
    }

    /**
     * The email address where replies should be sent. If a recipient replies, the response will go
     * to this address instead of the sender's email address
     */
    @JsonDeserialize(using = ReplyTo.Deserializer::class)
    @JsonSerialize(using = ReplyTo.Serializer::class)
    class ReplyTo
    private constructor(
        private val strings: List<String>? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isStrings(): Boolean = strings != null

        fun isString(): Boolean = string != null

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                strings != null -> visitor.visitStrings(strings)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): ReplyTo = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitStrings(strings: List<String>) {}

                    override fun visitString(string: String) {}
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
                    override fun visitStrings(strings: List<String>) = strings.size

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ReplyTo && strings == other.strings && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(strings, string)

        override fun toString(): String =
            when {
                strings != null -> "ReplyTo{strings=$strings}"
                string != null -> "ReplyTo{string=$string}"
                _json != null -> "ReplyTo{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ReplyTo")
            }

        companion object {

            @JvmStatic
            fun ofStrings(strings: List<String>) = ReplyTo(strings = strings.toImmutable())

            @JvmStatic fun ofString(string: String) = ReplyTo(string = string)
        }

        /**
         * An interface that defines how to map each variant of [ReplyTo] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitStrings(strings: List<String>): T

            fun visitString(string: String): T

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
                    // all the possible variants (e.g. deserializing from boolean).
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
                    value.strings != null -> generator.writeObject(value.strings)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ReplyTo")
                }
            }
        }
    }

    /** May provide more informations about the status */
    class StatusReason
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

            /** Returns a mutable builder for constructing an instance of [StatusReason]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [StatusReason]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(statusReason: StatusReason) = apply {
                additionalProperties = statusReason.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [StatusReason].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): StatusReason = StatusReason(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): StatusReason = apply {
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

            return other is StatusReason && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "StatusReason{additionalProperties=$additionalProperties}"
    }

    /** The tag to add to the email and you can get via email id or in webhook events */
    class Tag
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
         * The name of the tag
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * The tag to add to the email
         *
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
             * Returns a mutable builder for constructing an instance of [Tag].
             *
             * The following fields are required:
             * ```java
             * .name()
             * .value()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Tag]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var value: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(tag: Tag) = apply {
                name = tag.name
                value = tag.value
                additionalProperties = tag.additionalProperties.toMutableMap()
            }

            /** The name of the tag */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The tag to add to the email */
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
             * Returns an immutable instance of [Tag].
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
            fun build(): Tag =
                Tag(
                    checkRequired("name", name),
                    checkRequired("value", value),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Tag = apply {
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

            return other is Tag &&
                name == other.name &&
                value == other.value &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(name, value, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Tag{name=$name, value=$value, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EmailRetrieveResponse &&
            id == other.id &&
            createdAt == other.createdAt &&
            from == other.from &&
            kind == other.kind &&
            orgId == other.orgId &&
            region == other.region &&
            status == other.status &&
            statusAt == other.statusAt &&
            subject == other.subject &&
            to == other.to &&
            attachments == other.attachments &&
            bcc == other.bcc &&
            bulkId == other.bulkId &&
            cc == other.cc &&
            context == other.context &&
            headers == other.headers &&
            messageId == other.messageId &&
            modifiedAt == other.modifiedAt &&
            replyTo == other.replyTo &&
            scheduledAt == other.scheduledAt &&
            statusReason == other.statusReason &&
            tags == other.tags &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            from,
            kind,
            orgId,
            region,
            status,
            statusAt,
            subject,
            to,
            attachments,
            bcc,
            bulkId,
            cc,
            context,
            headers,
            messageId,
            modifiedAt,
            replyTo,
            scheduledAt,
            statusReason,
            tags,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EmailRetrieveResponse{id=$id, createdAt=$createdAt, from=$from, kind=$kind, orgId=$orgId, region=$region, status=$status, statusAt=$statusAt, subject=$subject, to=$to, attachments=$attachments, bcc=$bcc, bulkId=$bulkId, cc=$cc, context=$context, headers=$headers, messageId=$messageId, modifiedAt=$modifiedAt, replyTo=$replyTo, scheduledAt=$scheduledAt, statusReason=$statusReason, tags=$tags, additionalProperties=$additionalProperties}"
}
