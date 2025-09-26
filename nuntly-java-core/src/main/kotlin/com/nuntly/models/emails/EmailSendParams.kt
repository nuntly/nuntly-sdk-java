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
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.Params
import com.nuntly.core.allMaxBy
import com.nuntly.core.checkKnown
import com.nuntly.core.checkRequired
import com.nuntly.core.getOrThrow
import com.nuntly.core.http.Headers
import com.nuntly.core.http.QueryParams
import com.nuntly.core.toImmutable
import com.nuntly.errors.NuntlyInvalidDataException
import com.nuntly.models.shared.EmailHeaders
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Send transactional emails through the Nuntly platform. It supports HTML and plain-text emails,
 * attachments, labels, custom headers and scheduling.
 */
class EmailSendParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The e-mail address of the sender
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun from(): String = body.from()

    /**
     * The subject of the e-mail
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun subject(): String = body.subject()

    /**
     * The primary recipient(s) of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun to(): To = body.to()

    /**
     * The attachements to add to the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun attachments(): Optional<List<Attachment>> = body.attachments()

    /**
     * The blind carbon copy recipient(s) of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bcc(): Optional<Bcc> = body.bcc()

    /**
     * The carbon copy recipient(s) of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cc(): Optional<Cc> = body.cc()

    /** The context for the template */
    fun _context(): JsonValue = body._context()

    /**
     * The headers to add to the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun headers(): Optional<EmailHeaders> = body.headers()

    /**
     * The HTML version of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun html(): Optional<String> = body.html()

    /**
     * The email address where replies should be sent. If a recipient replies, the response will go
     * to this address instead of the sender's email address
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun replyTo(): Optional<ReplyTo> = body.replyTo()

    /**
     * The date at which the email is scheduled to be sent
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun scheduledAt(): Optional<OffsetDateTime> = body.scheduledAt()

    /**
     * The tags to add to the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tags(): Optional<List<Tag>> = body.tags()

    /**
     * The plaintext version of the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<String> = body.text()

    /**
     * Returns the raw JSON value of [from].
     *
     * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _from(): JsonField<String> = body._from()

    /**
     * Returns the raw JSON value of [subject].
     *
     * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _subject(): JsonField<String> = body._subject()

    /**
     * Returns the raw JSON value of [to].
     *
     * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _to(): JsonField<To> = body._to()

    /**
     * Returns the raw JSON value of [attachments].
     *
     * Unlike [attachments], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _attachments(): JsonField<List<Attachment>> = body._attachments()

    /**
     * Returns the raw JSON value of [bcc].
     *
     * Unlike [bcc], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _bcc(): JsonField<Bcc> = body._bcc()

    /**
     * Returns the raw JSON value of [cc].
     *
     * Unlike [cc], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _cc(): JsonField<Cc> = body._cc()

    /**
     * Returns the raw JSON value of [headers].
     *
     * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _headers_(): JsonField<EmailHeaders> = body._headers_()

    /**
     * Returns the raw JSON value of [html].
     *
     * Unlike [html], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _html(): JsonField<String> = body._html()

    /**
     * Returns the raw JSON value of [replyTo].
     *
     * Unlike [replyTo], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _replyTo(): JsonField<ReplyTo> = body._replyTo()

    /**
     * Returns the raw JSON value of [scheduledAt].
     *
     * Unlike [scheduledAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _scheduledAt(): JsonField<OffsetDateTime> = body._scheduledAt()

    /**
     * Returns the raw JSON value of [tags].
     *
     * Unlike [tags], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tags(): JsonField<List<Tag>> = body._tags()

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _text(): JsonField<String> = body._text()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EmailSendParams].
         *
         * The following fields are required:
         * ```java
         * .from()
         * .subject()
         * .to()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EmailSendParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(emailSendParams: EmailSendParams) = apply {
            body = emailSendParams.body.toBuilder()
            additionalHeaders = emailSendParams.additionalHeaders.toBuilder()
            additionalQueryParams = emailSendParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [from]
         * - [subject]
         * - [to]
         * - [attachments]
         * - [bcc]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The e-mail address of the sender */
        fun from(from: String) = apply { body.from(from) }

        /**
         * Sets [Builder.from] to an arbitrary JSON value.
         *
         * You should usually call [Builder.from] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun from(from: JsonField<String>) = apply { body.from(from) }

        /** The subject of the e-mail */
        fun subject(subject: String) = apply { body.subject(subject) }

        /**
         * Sets [Builder.subject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subject] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun subject(subject: JsonField<String>) = apply { body.subject(subject) }

        /** The primary recipient(s) of the email */
        fun to(to: To) = apply { body.to(to) }

        /**
         * Sets [Builder.to] to an arbitrary JSON value.
         *
         * You should usually call [Builder.to] with a well-typed [To] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun to(to: JsonField<To>) = apply { body.to(to) }

        /** Alias for calling [to] with `To.ofStrings(strings)`. */
        fun toOfStrings(strings: List<String>) = apply { body.toOfStrings(strings) }

        /** Alias for calling [to] with `To.ofString(string)`. */
        fun to(string: String) = apply { body.to(string) }

        /** The attachements to add to the email */
        fun attachments(attachments: List<Attachment>) = apply { body.attachments(attachments) }

        /**
         * Sets [Builder.attachments] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attachments] with a well-typed `List<Attachment>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun attachments(attachments: JsonField<List<Attachment>>) = apply {
            body.attachments(attachments)
        }

        /**
         * Adds a single [Attachment] to [attachments].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAttachment(attachment: Attachment) = apply { body.addAttachment(attachment) }

        /** The blind carbon copy recipient(s) of the email */
        fun bcc(bcc: Bcc) = apply { body.bcc(bcc) }

        /**
         * Sets [Builder.bcc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bcc] with a well-typed [Bcc] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bcc(bcc: JsonField<Bcc>) = apply { body.bcc(bcc) }

        /** Alias for calling [bcc] with `Bcc.ofStrings(strings)`. */
        fun bccOfStrings(strings: List<String>) = apply { body.bccOfStrings(strings) }

        /** Alias for calling [bcc] with `Bcc.ofString(string)`. */
        fun bcc(string: String) = apply { body.bcc(string) }

        /** The carbon copy recipient(s) of the email */
        fun cc(cc: Cc) = apply { body.cc(cc) }

        /**
         * Sets [Builder.cc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cc] with a well-typed [Cc] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cc(cc: JsonField<Cc>) = apply { body.cc(cc) }

        /** Alias for calling [cc] with `Cc.ofStrings(strings)`. */
        fun ccOfStrings(strings: List<String>) = apply { body.ccOfStrings(strings) }

        /** Alias for calling [cc] with `Cc.ofString(string)`. */
        fun cc(string: String) = apply { body.cc(string) }

        /** The context for the template */
        fun context(context: JsonValue) = apply { body.context(context) }

        /** The headers to add to the email */
        fun headers(headers: EmailHeaders) = apply { body.headers(headers) }

        /**
         * Sets [Builder.headers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.headers] with a well-typed [EmailHeaders] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun headers(headers: JsonField<EmailHeaders>) = apply { body.headers(headers) }

        /** The HTML version of the email */
        fun html(html: String) = apply { body.html(html) }

        /**
         * Sets [Builder.html] to an arbitrary JSON value.
         *
         * You should usually call [Builder.html] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun html(html: JsonField<String>) = apply { body.html(html) }

        /**
         * The email address where replies should be sent. If a recipient replies, the response will
         * go to this address instead of the sender's email address
         */
        fun replyTo(replyTo: ReplyTo) = apply { body.replyTo(replyTo) }

        /**
         * Sets [Builder.replyTo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.replyTo] with a well-typed [ReplyTo] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun replyTo(replyTo: JsonField<ReplyTo>) = apply { body.replyTo(replyTo) }

        /** Alias for calling [replyTo] with `ReplyTo.ofStrings(strings)`. */
        fun replyToOfStrings(strings: List<String>) = apply { body.replyToOfStrings(strings) }

        /** Alias for calling [replyTo] with `ReplyTo.ofString(string)`. */
        fun replyTo(string: String) = apply { body.replyTo(string) }

        /** The date at which the email is scheduled to be sent */
        fun scheduledAt(scheduledAt: OffsetDateTime) = apply { body.scheduledAt(scheduledAt) }

        /**
         * Sets [Builder.scheduledAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scheduledAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun scheduledAt(scheduledAt: JsonField<OffsetDateTime>) = apply {
            body.scheduledAt(scheduledAt)
        }

        /** The tags to add to the email */
        fun tags(tags: List<Tag>) = apply { body.tags(tags) }

        /**
         * Sets [Builder.tags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tags] with a well-typed `List<Tag>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tags(tags: JsonField<List<Tag>>) = apply { body.tags(tags) }

        /**
         * Adds a single [Tag] to [tags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTag(tag: Tag) = apply { body.addTag(tag) }

        /** The plaintext version of the email */
        fun text(text: String) = apply { body.text(text) }

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { body.text(text) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [EmailSendParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .from()
         * .subject()
         * .to()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EmailSendParams =
            EmailSendParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val from: JsonField<String>,
        private val subject: JsonField<String>,
        private val to: JsonField<To>,
        private val attachments: JsonField<List<Attachment>>,
        private val bcc: JsonField<Bcc>,
        private val cc: JsonField<Cc>,
        private val context: JsonValue,
        private val headers: JsonField<EmailHeaders>,
        private val html: JsonField<String>,
        private val replyTo: JsonField<ReplyTo>,
        private val scheduledAt: JsonField<OffsetDateTime>,
        private val tags: JsonField<List<Tag>>,
        private val text: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
            @JsonProperty("to") @ExcludeMissing to: JsonField<To> = JsonMissing.of(),
            @JsonProperty("attachments")
            @ExcludeMissing
            attachments: JsonField<List<Attachment>> = JsonMissing.of(),
            @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<Bcc> = JsonMissing.of(),
            @JsonProperty("cc") @ExcludeMissing cc: JsonField<Cc> = JsonMissing.of(),
            @JsonProperty("context") @ExcludeMissing context: JsonValue = JsonMissing.of(),
            @JsonProperty("headers")
            @ExcludeMissing
            headers: JsonField<EmailHeaders> = JsonMissing.of(),
            @JsonProperty("html") @ExcludeMissing html: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reply_to")
            @ExcludeMissing
            replyTo: JsonField<ReplyTo> = JsonMissing.of(),
            @JsonProperty("scheduled_at")
            @ExcludeMissing
            scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("tags") @ExcludeMissing tags: JsonField<List<Tag>> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        ) : this(
            from,
            subject,
            to,
            attachments,
            bcc,
            cc,
            context,
            headers,
            html,
            replyTo,
            scheduledAt,
            tags,
            text,
            mutableMapOf(),
        )

        /**
         * The e-mail address of the sender
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun from(): String = from.getRequired("from")

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
         * The attachements to add to the email
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
         * The carbon copy recipient(s) of the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cc(): Optional<Cc> = cc.getOptional("cc")

        /** The context for the template */
        @JsonProperty("context") @ExcludeMissing fun _context(): JsonValue = context

        /**
         * The headers to add to the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun headers(): Optional<EmailHeaders> = headers.getOptional("headers")

        /**
         * The HTML version of the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun html(): Optional<String> = html.getOptional("html")

        /**
         * The email address where replies should be sent. If a recipient replies, the response will
         * go to this address instead of the sender's email address
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
         * The tags to add to the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tags(): Optional<List<Tag>> = tags.getOptional("tags")

        /**
         * The plaintext version of the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun text(): Optional<String> = text.getOptional("text")

        /**
         * Returns the raw JSON value of [from].
         *
         * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

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
        @JsonProperty("headers") @ExcludeMissing fun _headers_(): JsonField<EmailHeaders> = headers

        /**
         * Returns the raw JSON value of [html].
         *
         * Unlike [html], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("html") @ExcludeMissing fun _html(): JsonField<String> = html

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
         * Returns the raw JSON value of [tags].
         *
         * Unlike [tags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tags") @ExcludeMissing fun _tags(): JsonField<List<Tag>> = tags

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .from()
             * .subject()
             * .to()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var from: JsonField<String>? = null
            private var subject: JsonField<String>? = null
            private var to: JsonField<To>? = null
            private var attachments: JsonField<MutableList<Attachment>>? = null
            private var bcc: JsonField<Bcc> = JsonMissing.of()
            private var cc: JsonField<Cc> = JsonMissing.of()
            private var context: JsonValue = JsonMissing.of()
            private var headers: JsonField<EmailHeaders> = JsonMissing.of()
            private var html: JsonField<String> = JsonMissing.of()
            private var replyTo: JsonField<ReplyTo> = JsonMissing.of()
            private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var tags: JsonField<MutableList<Tag>>? = null
            private var text: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                from = body.from
                subject = body.subject
                to = body.to
                attachments = body.attachments.map { it.toMutableList() }
                bcc = body.bcc
                cc = body.cc
                context = body.context
                headers = body.headers
                html = body.html
                replyTo = body.replyTo
                scheduledAt = body.scheduledAt
                tags = body.tags.map { it.toMutableList() }
                text = body.text
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The e-mail address of the sender */
            fun from(from: String) = from(JsonField.of(from))

            /**
             * Sets [Builder.from] to an arbitrary JSON value.
             *
             * You should usually call [Builder.from] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun from(from: JsonField<String>) = apply { this.from = from }

            /** The subject of the e-mail */
            fun subject(subject: String) = subject(JsonField.of(subject))

            /**
             * Sets [Builder.subject] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subject] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subject(subject: JsonField<String>) = apply { this.subject = subject }

            /** The primary recipient(s) of the email */
            fun to(to: To) = to(JsonField.of(to))

            /**
             * Sets [Builder.to] to an arbitrary JSON value.
             *
             * You should usually call [Builder.to] with a well-typed [To] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun to(to: JsonField<To>) = apply { this.to = to }

            /** Alias for calling [to] with `To.ofStrings(strings)`. */
            fun toOfStrings(strings: List<String>) = to(To.ofStrings(strings))

            /** Alias for calling [to] with `To.ofString(string)`. */
            fun to(string: String) = to(To.ofString(string))

            /** The attachements to add to the email */
            fun attachments(attachments: List<Attachment>) = attachments(JsonField.of(attachments))

            /**
             * Sets [Builder.attachments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attachments] with a well-typed `List<Attachment>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
             * You should usually call [Builder.bcc] with a well-typed [Bcc] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun bcc(bcc: JsonField<Bcc>) = apply { this.bcc = bcc }

            /** Alias for calling [bcc] with `Bcc.ofStrings(strings)`. */
            fun bccOfStrings(strings: List<String>) = bcc(Bcc.ofStrings(strings))

            /** Alias for calling [bcc] with `Bcc.ofString(string)`. */
            fun bcc(string: String) = bcc(Bcc.ofString(string))

            /** The carbon copy recipient(s) of the email */
            fun cc(cc: Cc) = cc(JsonField.of(cc))

            /**
             * Sets [Builder.cc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cc] with a well-typed [Cc] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * You should usually call [Builder.headers] with a well-typed [EmailHeaders] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<EmailHeaders>) = apply { this.headers = headers }

            /** The HTML version of the email */
            fun html(html: String) = html(JsonField.of(html))

            /**
             * Sets [Builder.html] to an arbitrary JSON value.
             *
             * You should usually call [Builder.html] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun html(html: JsonField<String>) = apply { this.html = html }

            /**
             * The email address where replies should be sent. If a recipient replies, the response
             * will go to this address instead of the sender's email address
             */
            fun replyTo(replyTo: ReplyTo) = replyTo(JsonField.of(replyTo))

            /**
             * Sets [Builder.replyTo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.replyTo] with a well-typed [ReplyTo] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.scheduledAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun scheduledAt(scheduledAt: JsonField<OffsetDateTime>) = apply {
                this.scheduledAt = scheduledAt
            }

            /** The tags to add to the email */
            fun tags(tags: List<Tag>) = tags(JsonField.of(tags))

            /**
             * Sets [Builder.tags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tags] with a well-typed `List<Tag>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tags(tags: JsonField<List<Tag>>) = apply {
                this.tags = tags.map { it.toMutableList() }
            }

            /**
             * Adds a single [Tag] to [tags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTag(tag: Tag) = apply {
                tags =
                    (tags ?: JsonField.of(mutableListOf())).also { checkKnown("tags", it).add(tag) }
            }

            /** The plaintext version of the email */
            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .from()
             * .subject()
             * .to()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("from", from),
                    checkRequired("subject", subject),
                    checkRequired("to", to),
                    (attachments ?: JsonMissing.of()).map { it.toImmutable() },
                    bcc,
                    cc,
                    context,
                    headers,
                    html,
                    replyTo,
                    scheduledAt,
                    (tags ?: JsonMissing.of()).map { it.toImmutable() },
                    text,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            from()
            subject()
            to().validate()
            attachments().ifPresent { it.forEach { it.validate() } }
            bcc().ifPresent { it.validate() }
            cc().ifPresent { it.validate() }
            headers().ifPresent { it.validate() }
            html()
            replyTo().ifPresent { it.validate() }
            scheduledAt()
            tags().ifPresent { it.forEach { it.validate() } }
            text()
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
            (if (from.asKnown().isPresent) 1 else 0) +
                (if (subject.asKnown().isPresent) 1 else 0) +
                (to.asKnown().getOrNull()?.validity() ?: 0) +
                (attachments.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (bcc.asKnown().getOrNull()?.validity() ?: 0) +
                (cc.asKnown().getOrNull()?.validity() ?: 0) +
                (headers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (html.asKnown().isPresent) 1 else 0) +
                (replyTo.asKnown().getOrNull()?.validity() ?: 0) +
                (if (scheduledAt.asKnown().isPresent) 1 else 0) +
                (tags.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (text.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                from == other.from &&
                subject == other.subject &&
                to == other.to &&
                attachments == other.attachments &&
                bcc == other.bcc &&
                cc == other.cc &&
                context == other.context &&
                headers == other.headers &&
                html == other.html &&
                replyTo == other.replyTo &&
                scheduledAt == other.scheduledAt &&
                tags == other.tags &&
                text == other.text &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                from,
                subject,
                to,
                attachments,
                bcc,
                cc,
                context,
                headers,
                html,
                replyTo,
                scheduledAt,
                tags,
                text,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{from=$from, subject=$subject, to=$to, attachments=$attachments, bcc=$bcc, cc=$cc, context=$context, headers=$headers, html=$html, replyTo=$replyTo, scheduledAt=$scheduledAt, tags=$tags, text=$text, additionalProperties=$additionalProperties}"
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
                            tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                To(strings = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                To(string = it, _json = json)
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
        private val content: JsonField<String>,
        private val contentType: JsonField<String>,
        private val filename: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content") @ExcludeMissing content: JsonField<String> = JsonMissing.of(),
            @JsonProperty("content_type")
            @ExcludeMissing
            contentType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("filename") @ExcludeMissing filename: JsonField<String> = JsonMissing.of(),
        ) : this(content, contentType, filename, mutableMapOf())

        /**
         * The base64-encoded content of the attachment
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun content(): Optional<String> = content.getOptional("content")

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
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

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

            private var content: JsonField<String> = JsonMissing.of()
            private var contentType: JsonField<String> = JsonMissing.of()
            private var filename: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(attachment: Attachment) = apply {
                content = attachment.content
                contentType = attachment.contentType
                filename = attachment.filename
                additionalProperties = attachment.additionalProperties.toMutableMap()
            }

            /** The base64-encoded content of the attachment */
            fun content(content: String) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<String>) = apply { this.content = content }

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
                Attachment(content, contentType, filename, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Attachment = apply {
            if (validated) {
                return@apply
            }

            content()
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
            (if (content.asKnown().isPresent) 1 else 0) +
                (if (contentType.asKnown().isPresent) 1 else 0) +
                (if (filename.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Attachment &&
                content == other.content &&
                contentType == other.contentType &&
                filename == other.filename &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(content, contentType, filename, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Attachment{content=$content, contentType=$contentType, filename=$filename, additionalProperties=$additionalProperties}"
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
                            tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                Bcc(strings = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Bcc(string = it, _json = json)
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
                            tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                Cc(strings = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Cc(string = it, _json = json)
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
                            tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                ReplyTo(strings = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                ReplyTo(string = it, _json = json)
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
                    value.strings != null -> generator.writeObject(value.strings)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ReplyTo")
                }
            }
        }
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

        return other is EmailSendParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "EmailSendParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
