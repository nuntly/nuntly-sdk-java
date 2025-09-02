// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails.bulk

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
import com.nuntly.api.core.BaseDeserializer
import com.nuntly.api.core.BaseSerializer
import com.nuntly.api.core.ExcludeMissing
import com.nuntly.api.core.JsonField
import com.nuntly.api.core.JsonMissing
import com.nuntly.api.core.JsonValue
import com.nuntly.api.core.Params
import com.nuntly.api.core.allMaxBy
import com.nuntly.api.core.checkKnown
import com.nuntly.api.core.checkRequired
import com.nuntly.api.core.getOrThrow
import com.nuntly.api.core.http.Headers
import com.nuntly.api.core.http.QueryParams
import com.nuntly.api.core.toImmutable
import com.nuntly.api.errors.NuntlyInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Send bulk emails */
class BulkSendParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The emails to send
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun emails(): List<Email> = body.emails()

    /**
     * Used as a fallback field email value if no value is present in emails
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fallback(): Optional<Fallback> = body.fallback()

    /**
     * Returns the raw JSON value of [emails].
     *
     * Unlike [emails], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _emails(): JsonField<List<Email>> = body._emails()

    /**
     * Returns the raw JSON value of [fallback].
     *
     * Unlike [fallback], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _fallback(): JsonField<Fallback> = body._fallback()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BulkSendParams].
         *
         * The following fields are required:
         * ```java
         * .emails()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkSendParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(bulkSendParams: BulkSendParams) = apply {
            body = bulkSendParams.body.toBuilder()
            additionalHeaders = bulkSendParams.additionalHeaders.toBuilder()
            additionalQueryParams = bulkSendParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [emails]
         * - [fallback]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The emails to send */
        fun emails(emails: List<Email>) = apply { body.emails(emails) }

        /**
         * Sets [Builder.emails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.emails] with a well-typed `List<Email>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun emails(emails: JsonField<List<Email>>) = apply { body.emails(emails) }

        /**
         * Adds a single [Email] to [emails].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEmail(email: Email) = apply { body.addEmail(email) }

        /** Used as a fallback field email value if no value is present in emails */
        fun fallback(fallback: Fallback) = apply { body.fallback(fallback) }

        /**
         * Sets [Builder.fallback] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fallback] with a well-typed [Fallback] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fallback(fallback: JsonField<Fallback>) = apply { body.fallback(fallback) }

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
         * Returns an immutable instance of [BulkSendParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .emails()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BulkSendParams =
            BulkSendParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val emails: JsonField<List<Email>>,
        private val fallback: JsonField<Fallback>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("emails")
            @ExcludeMissing
            emails: JsonField<List<Email>> = JsonMissing.of(),
            @JsonProperty("fallback")
            @ExcludeMissing
            fallback: JsonField<Fallback> = JsonMissing.of(),
        ) : this(emails, fallback, mutableMapOf())

        /**
         * The emails to send
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun emails(): List<Email> = emails.getRequired("emails")

        /**
         * Used as a fallback field email value if no value is present in emails
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fallback(): Optional<Fallback> = fallback.getOptional("fallback")

        /**
         * Returns the raw JSON value of [emails].
         *
         * Unlike [emails], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("emails") @ExcludeMissing fun _emails(): JsonField<List<Email>> = emails

        /**
         * Returns the raw JSON value of [fallback].
         *
         * Unlike [fallback], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fallback") @ExcludeMissing fun _fallback(): JsonField<Fallback> = fallback

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
             * .emails()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var emails: JsonField<MutableList<Email>>? = null
            private var fallback: JsonField<Fallback> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                emails = body.emails.map { it.toMutableList() }
                fallback = body.fallback
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The emails to send */
            fun emails(emails: List<Email>) = emails(JsonField.of(emails))

            /**
             * Sets [Builder.emails] to an arbitrary JSON value.
             *
             * You should usually call [Builder.emails] with a well-typed `List<Email>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun emails(emails: JsonField<List<Email>>) = apply {
                this.emails = emails.map { it.toMutableList() }
            }

            /**
             * Adds a single [Email] to [emails].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEmail(email: Email) = apply {
                emails =
                    (emails ?: JsonField.of(mutableListOf())).also {
                        checkKnown("emails", it).add(email)
                    }
            }

            /** Used as a fallback field email value if no value is present in emails */
            fun fallback(fallback: Fallback) = fallback(JsonField.of(fallback))

            /**
             * Sets [Builder.fallback] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fallback] with a well-typed [Fallback] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fallback(fallback: JsonField<Fallback>) = apply { this.fallback = fallback }

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
             * .emails()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("emails", emails).map { it.toImmutable() },
                    fallback,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            emails().forEach { it.validate() }
            fallback().ifPresent { it.validate() }
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
            (emails.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (fallback.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                emails == other.emails &&
                fallback == other.fallback &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(emails, fallback, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{emails=$emails, fallback=$fallback, additionalProperties=$additionalProperties}"
    }

    class Email
    private constructor(
        private val to: JsonField<To>,
        private val bcc: JsonField<Bcc>,
        private val cc: JsonField<Cc>,
        private val context: JsonValue,
        private val from: JsonField<String>,
        private val headers: JsonField<Headers>,
        private val html: JsonField<String>,
        private val replyTo: JsonField<ReplyTo>,
        private val scheduledAt: JsonField<OffsetDateTime>,
        private val subject: JsonField<String>,
        private val tags: JsonField<List<Tag>>,
        private val text: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("to") @ExcludeMissing to: JsonField<To> = JsonMissing.of(),
            @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<Bcc> = JsonMissing.of(),
            @JsonProperty("cc") @ExcludeMissing cc: JsonField<Cc> = JsonMissing.of(),
            @JsonProperty("context") @ExcludeMissing context: JsonValue = JsonMissing.of(),
            @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
            @JsonProperty("html") @ExcludeMissing html: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reply_to")
            @ExcludeMissing
            replyTo: JsonField<ReplyTo> = JsonMissing.of(),
            @JsonProperty("scheduled_at")
            @ExcludeMissing
            scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tags") @ExcludeMissing tags: JsonField<List<Tag>> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        ) : this(
            to,
            bcc,
            cc,
            context,
            from,
            headers,
            html,
            replyTo,
            scheduledAt,
            subject,
            tags,
            text,
            mutableMapOf(),
        )

        /**
         * The primary recipient(s) of the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun to(): To = to.getRequired("to")

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
         * The e-mail address of the sender
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun from(): Optional<String> = from.getOptional("from")

        /**
         * The headers to add to the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun headers(): Optional<Headers> = headers.getOptional("headers")

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
         * The subject of the e-mail
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun subject(): Optional<String> = subject.getOptional("subject")

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
         * Returns the raw JSON value of [cc].
         *
         * Unlike [cc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cc") @ExcludeMissing fun _cc(): JsonField<Cc> = cc

        /**
         * Returns the raw JSON value of [from].
         *
         * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

        /**
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

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
         * Returns the raw JSON value of [subject].
         *
         * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

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
             * Returns a mutable builder for constructing an instance of [Email].
             *
             * The following fields are required:
             * ```java
             * .to()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Email]. */
        class Builder internal constructor() {

            private var to: JsonField<To>? = null
            private var bcc: JsonField<Bcc> = JsonMissing.of()
            private var cc: JsonField<Cc> = JsonMissing.of()
            private var context: JsonValue = JsonMissing.of()
            private var from: JsonField<String> = JsonMissing.of()
            private var headers: JsonField<Headers> = JsonMissing.of()
            private var html: JsonField<String> = JsonMissing.of()
            private var replyTo: JsonField<ReplyTo> = JsonMissing.of()
            private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var subject: JsonField<String> = JsonMissing.of()
            private var tags: JsonField<MutableList<Tag>>? = null
            private var text: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(email: Email) = apply {
                to = email.to
                bcc = email.bcc
                cc = email.cc
                context = email.context
                from = email.from
                headers = email.headers
                html = email.html
                replyTo = email.replyTo
                scheduledAt = email.scheduledAt
                subject = email.subject
                tags = email.tags.map { it.toMutableList() }
                text = email.text
                additionalProperties = email.additionalProperties.toMutableMap()
            }

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

            /** The headers to add to the email */
            fun headers(headers: Headers) = headers(JsonField.of(headers))

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed [Headers] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

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
             * Returns an immutable instance of [Email].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .to()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Email =
                Email(
                    checkRequired("to", to),
                    bcc,
                    cc,
                    context,
                    from,
                    headers,
                    html,
                    replyTo,
                    scheduledAt,
                    subject,
                    (tags ?: JsonMissing.of()).map { it.toImmutable() },
                    text,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Email = apply {
            if (validated) {
                return@apply
            }

            to().validate()
            bcc().ifPresent { it.validate() }
            cc().ifPresent { it.validate() }
            from()
            headers().ifPresent { it.validate() }
            html()
            replyTo().ifPresent { it.validate() }
            scheduledAt()
            subject()
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
            (to.asKnown().getOrNull()?.validity() ?: 0) +
                (bcc.asKnown().getOrNull()?.validity() ?: 0) +
                (cc.asKnown().getOrNull()?.validity() ?: 0) +
                (if (from.asKnown().isPresent) 1 else 0) +
                (headers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (html.asKnown().isPresent) 1 else 0) +
                (replyTo.asKnown().getOrNull()?.validity() ?: 0) +
                (if (scheduledAt.asKnown().isPresent) 1 else 0) +
                (if (subject.asKnown().isPresent) 1 else 0) +
                (tags.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (text.asKnown().isPresent) 1 else 0)

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

                @JvmStatic
                fun ofStrings(strings: List<String>) = To(strings = strings.toImmutable())

                @JvmStatic fun ofString(string: String) = To(string = string)
            }

            /** An interface that defines how to map each variant of [To] to a value of type [T]. */
            interface Visitor<out T> {

                fun visitStrings(strings: List<String>): T

                fun visitString(string: String): T

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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
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
                        value.strings != null -> generator.writeObject(value.strings)
                        value.string != null -> generator.writeObject(value.string)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid To")
                    }
                }
            }
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

                @JvmStatic
                fun ofStrings(strings: List<String>) = Bcc(strings = strings.toImmutable())

                @JvmStatic fun ofString(string: String) = Bcc(string = string)
            }

            /**
             * An interface that defines how to map each variant of [Bcc] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitStrings(strings: List<String>): T

                fun visitString(string: String): T

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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
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

                @JvmStatic
                fun ofStrings(strings: List<String>) = Cc(strings = strings.toImmutable())

                @JvmStatic fun ofString(string: String) = Cc(string = string)
            }

            /** An interface that defines how to map each variant of [Cc] to a value of type [T]. */
            interface Visitor<out T> {

                fun visitStrings(strings: List<String>): T

                fun visitString(string: String): T

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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
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
                        value.strings != null -> generator.writeObject(value.strings)
                        value.string != null -> generator.writeObject(value.string)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Cc")
                    }
                }
            }
        }

        /** The headers to add to the email */
        class Headers
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

                /** Returns a mutable builder for constructing an instance of [Headers]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Headers]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(headers: Headers) = apply {
                    additionalProperties = headers.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Headers].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Headers = Headers(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Headers = apply {
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

                return other is Headers && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Headers{additionalProperties=$additionalProperties}"
        }

        /**
         * The email address where replies should be sent. If a recipient replies, the response will
         * go to this address instead of the sender's email address
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
             * An interface that defines how to map each variant of [ReplyTo] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitStrings(strings: List<String>): T

                fun visitString(string: String): T

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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
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
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * The tag to add to the email
             *
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
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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

            return other is Email &&
                to == other.to &&
                bcc == other.bcc &&
                cc == other.cc &&
                context == other.context &&
                from == other.from &&
                headers == other.headers &&
                html == other.html &&
                replyTo == other.replyTo &&
                scheduledAt == other.scheduledAt &&
                subject == other.subject &&
                tags == other.tags &&
                text == other.text &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                to,
                bcc,
                cc,
                context,
                from,
                headers,
                html,
                replyTo,
                scheduledAt,
                subject,
                tags,
                text,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Email{to=$to, bcc=$bcc, cc=$cc, context=$context, from=$from, headers=$headers, html=$html, replyTo=$replyTo, scheduledAt=$scheduledAt, subject=$subject, tags=$tags, text=$text, additionalProperties=$additionalProperties}"
    }

    /** Used as a fallback field email value if no value is present in emails */
    class Fallback
    private constructor(
        private val bcc: JsonField<Bcc>,
        private val cc: JsonField<Cc>,
        private val context: JsonValue,
        private val from: JsonField<String>,
        private val headers: JsonField<Headers>,
        private val html: JsonField<String>,
        private val replyTo: JsonField<ReplyTo>,
        private val scheduledAt: JsonField<OffsetDateTime>,
        private val subject: JsonField<String>,
        private val tags: JsonField<List<Tag>>,
        private val text: JsonField<String>,
        private val to: JsonField<To>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<Bcc> = JsonMissing.of(),
            @JsonProperty("cc") @ExcludeMissing cc: JsonField<Cc> = JsonMissing.of(),
            @JsonProperty("context") @ExcludeMissing context: JsonValue = JsonMissing.of(),
            @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
            @JsonProperty("html") @ExcludeMissing html: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reply_to")
            @ExcludeMissing
            replyTo: JsonField<ReplyTo> = JsonMissing.of(),
            @JsonProperty("scheduled_at")
            @ExcludeMissing
            scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tags") @ExcludeMissing tags: JsonField<List<Tag>> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("to") @ExcludeMissing to: JsonField<To> = JsonMissing.of(),
        ) : this(
            bcc,
            cc,
            context,
            from,
            headers,
            html,
            replyTo,
            scheduledAt,
            subject,
            tags,
            text,
            to,
            mutableMapOf(),
        )

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
         * The e-mail address of the sender
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun from(): Optional<String> = from.getOptional("from")

        /**
         * The headers to add to the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun headers(): Optional<Headers> = headers.getOptional("headers")

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
         * The subject of the e-mail
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun subject(): Optional<String> = subject.getOptional("subject")

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
         * The primary recipient(s) of the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun to(): Optional<To> = to.getOptional("to")

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
         * Returns the raw JSON value of [from].
         *
         * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

        /**
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

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
         * Returns the raw JSON value of [subject].
         *
         * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

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

        /**
         * Returns the raw JSON value of [to].
         *
         * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<To> = to

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

            /** Returns a mutable builder for constructing an instance of [Fallback]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Fallback]. */
        class Builder internal constructor() {

            private var bcc: JsonField<Bcc> = JsonMissing.of()
            private var cc: JsonField<Cc> = JsonMissing.of()
            private var context: JsonValue = JsonMissing.of()
            private var from: JsonField<String> = JsonMissing.of()
            private var headers: JsonField<Headers> = JsonMissing.of()
            private var html: JsonField<String> = JsonMissing.of()
            private var replyTo: JsonField<ReplyTo> = JsonMissing.of()
            private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var subject: JsonField<String> = JsonMissing.of()
            private var tags: JsonField<MutableList<Tag>>? = null
            private var text: JsonField<String> = JsonMissing.of()
            private var to: JsonField<To> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fallback: Fallback) = apply {
                bcc = fallback.bcc
                cc = fallback.cc
                context = fallback.context
                from = fallback.from
                headers = fallback.headers
                html = fallback.html
                replyTo = fallback.replyTo
                scheduledAt = fallback.scheduledAt
                subject = fallback.subject
                tags = fallback.tags.map { it.toMutableList() }
                text = fallback.text
                to = fallback.to
                additionalProperties = fallback.additionalProperties.toMutableMap()
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

            /** The headers to add to the email */
            fun headers(headers: Headers) = headers(JsonField.of(headers))

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed [Headers] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

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
             * Returns an immutable instance of [Fallback].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Fallback =
                Fallback(
                    bcc,
                    cc,
                    context,
                    from,
                    headers,
                    html,
                    replyTo,
                    scheduledAt,
                    subject,
                    (tags ?: JsonMissing.of()).map { it.toImmutable() },
                    text,
                    to,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Fallback = apply {
            if (validated) {
                return@apply
            }

            bcc().ifPresent { it.validate() }
            cc().ifPresent { it.validate() }
            from()
            headers().ifPresent { it.validate() }
            html()
            replyTo().ifPresent { it.validate() }
            scheduledAt()
            subject()
            tags().ifPresent { it.forEach { it.validate() } }
            text()
            to().ifPresent { it.validate() }
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
            (bcc.asKnown().getOrNull()?.validity() ?: 0) +
                (cc.asKnown().getOrNull()?.validity() ?: 0) +
                (if (from.asKnown().isPresent) 1 else 0) +
                (headers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (html.asKnown().isPresent) 1 else 0) +
                (replyTo.asKnown().getOrNull()?.validity() ?: 0) +
                (if (scheduledAt.asKnown().isPresent) 1 else 0) +
                (if (subject.asKnown().isPresent) 1 else 0) +
                (tags.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (to.asKnown().getOrNull()?.validity() ?: 0)

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

                @JvmStatic
                fun ofStrings(strings: List<String>) = Bcc(strings = strings.toImmutable())

                @JvmStatic fun ofString(string: String) = Bcc(string = string)
            }

            /**
             * An interface that defines how to map each variant of [Bcc] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitStrings(strings: List<String>): T

                fun visitString(string: String): T

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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
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

                @JvmStatic
                fun ofStrings(strings: List<String>) = Cc(strings = strings.toImmutable())

                @JvmStatic fun ofString(string: String) = Cc(string = string)
            }

            /** An interface that defines how to map each variant of [Cc] to a value of type [T]. */
            interface Visitor<out T> {

                fun visitStrings(strings: List<String>): T

                fun visitString(string: String): T

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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
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
                        value.strings != null -> generator.writeObject(value.strings)
                        value.string != null -> generator.writeObject(value.string)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Cc")
                    }
                }
            }
        }

        /** The headers to add to the email */
        class Headers
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

                /** Returns a mutable builder for constructing an instance of [Headers]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Headers]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(headers: Headers) = apply {
                    additionalProperties = headers.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Headers].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Headers = Headers(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Headers = apply {
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

                return other is Headers && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Headers{additionalProperties=$additionalProperties}"
        }

        /**
         * The email address where replies should be sent. If a recipient replies, the response will
         * go to this address instead of the sender's email address
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
             * An interface that defines how to map each variant of [ReplyTo] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitStrings(strings: List<String>): T

                fun visitString(string: String): T

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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
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
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * The tag to add to the email
             *
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
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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

                @JvmStatic
                fun ofStrings(strings: List<String>) = To(strings = strings.toImmutable())

                @JvmStatic fun ofString(string: String) = To(string = string)
            }

            /** An interface that defines how to map each variant of [To] to a value of type [T]. */
            interface Visitor<out T> {

                fun visitStrings(strings: List<String>): T

                fun visitString(string: String): T

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
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from object).
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
                        value.strings != null -> generator.writeObject(value.strings)
                        value.string != null -> generator.writeObject(value.string)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid To")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Fallback &&
                bcc == other.bcc &&
                cc == other.cc &&
                context == other.context &&
                from == other.from &&
                headers == other.headers &&
                html == other.html &&
                replyTo == other.replyTo &&
                scheduledAt == other.scheduledAt &&
                subject == other.subject &&
                tags == other.tags &&
                text == other.text &&
                to == other.to &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                bcc,
                cc,
                context,
                from,
                headers,
                html,
                replyTo,
                scheduledAt,
                subject,
                tags,
                text,
                to,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Fallback{bcc=$bcc, cc=$cc, context=$context, from=$from, headers=$headers, html=$html, replyTo=$replyTo, scheduledAt=$scheduledAt, subject=$subject, tags=$tags, text=$text, to=$to, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BulkSendParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "BulkSendParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
