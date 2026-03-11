// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.Params
import com.nuntly.core.checkKnown
import com.nuntly.core.checkRequired
import com.nuntly.core.http.Headers
import com.nuntly.core.http.QueryParams
import com.nuntly.core.toImmutable
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Send a new message from an inbox. */
class InboxSendParams
private constructor(
    private val inboxId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun inboxId(): Optional<String> = Optional.ofNullable(inboxId)

    /**
     * The message subject.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun subject(): String = body.subject()

    /**
     * The recipient addresses.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun to(): List<String> = body.to()

    /**
     * The BCC addresses.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bcc(): Optional<List<String>> = body.bcc()

    /**
     * The CC addresses.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cc(): Optional<List<String>> = body.cc()

    /**
     * The HTML body.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun html(): Optional<String> = body.html()

    /**
     * The plain text body.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<String> = body.text()

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
    fun _to(): JsonField<List<String>> = body._to()

    /**
     * Returns the raw JSON value of [bcc].
     *
     * Unlike [bcc], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _bcc(): JsonField<List<String>> = body._bcc()

    /**
     * Returns the raw JSON value of [cc].
     *
     * Unlike [cc], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _cc(): JsonField<List<String>> = body._cc()

    /**
     * Returns the raw JSON value of [html].
     *
     * Unlike [html], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _html(): JsonField<String> = body._html()

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
         * Returns a mutable builder for constructing an instance of [InboxSendParams].
         *
         * The following fields are required:
         * ```java
         * .subject()
         * .to()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboxSendParams]. */
    class Builder internal constructor() {

        private var inboxId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(inboxSendParams: InboxSendParams) = apply {
            inboxId = inboxSendParams.inboxId
            body = inboxSendParams.body.toBuilder()
            additionalHeaders = inboxSendParams.additionalHeaders.toBuilder()
            additionalQueryParams = inboxSendParams.additionalQueryParams.toBuilder()
        }

        fun inboxId(inboxId: String?) = apply { this.inboxId = inboxId }

        /** Alias for calling [Builder.inboxId] with `inboxId.orElse(null)`. */
        fun inboxId(inboxId: Optional<String>) = inboxId(inboxId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [subject]
         * - [to]
         * - [bcc]
         * - [cc]
         * - [html]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The message subject. */
        fun subject(subject: String) = apply { body.subject(subject) }

        /**
         * Sets [Builder.subject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subject] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun subject(subject: JsonField<String>) = apply { body.subject(subject) }

        /** The recipient addresses. */
        fun to(to: List<String>) = apply { body.to(to) }

        /**
         * Sets [Builder.to] to an arbitrary JSON value.
         *
         * You should usually call [Builder.to] with a well-typed `List<String>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun to(to: JsonField<List<String>>) = apply { body.to(to) }

        /**
         * Adds a single [String] to [Builder.to].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTo(to: String) = apply { body.addTo(to) }

        /** The BCC addresses. */
        fun bcc(bcc: List<String>) = apply { body.bcc(bcc) }

        /**
         * Sets [Builder.bcc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bcc] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bcc(bcc: JsonField<List<String>>) = apply { body.bcc(bcc) }

        /**
         * Adds a single [String] to [Builder.bcc].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addBcc(bcc: String) = apply { body.addBcc(bcc) }

        /** The CC addresses. */
        fun cc(cc: List<String>) = apply { body.cc(cc) }

        /**
         * Sets [Builder.cc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cc] with a well-typed `List<String>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cc(cc: JsonField<List<String>>) = apply { body.cc(cc) }

        /**
         * Adds a single [String] to [Builder.cc].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCc(cc: String) = apply { body.addCc(cc) }

        /** The HTML body. */
        fun html(html: String) = apply { body.html(html) }

        /**
         * Sets [Builder.html] to an arbitrary JSON value.
         *
         * You should usually call [Builder.html] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun html(html: JsonField<String>) = apply { body.html(html) }

        /** The plain text body. */
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
         * Returns an immutable instance of [InboxSendParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .subject()
         * .to()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InboxSendParams =
            InboxSendParams(
                inboxId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> inboxId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val subject: JsonField<String>,
        private val to: JsonField<List<String>>,
        private val bcc: JsonField<List<String>>,
        private val cc: JsonField<List<String>>,
        private val html: JsonField<String>,
        private val text: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
            @JsonProperty("to") @ExcludeMissing to: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("cc") @ExcludeMissing cc: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("html") @ExcludeMissing html: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        ) : this(subject, to, bcc, cc, html, text, mutableMapOf())

        /**
         * The message subject.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun subject(): String = subject.getRequired("subject")

        /**
         * The recipient addresses.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun to(): List<String> = to.getRequired("to")

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
         * The HTML body.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun html(): Optional<String> = html.getOptional("html")

        /**
         * The plain text body.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun text(): Optional<String> = text.getOptional("text")

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
        @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<List<String>> = to

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
         * Returns the raw JSON value of [html].
         *
         * Unlike [html], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("html") @ExcludeMissing fun _html(): JsonField<String> = html

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
             * .subject()
             * .to()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var subject: JsonField<String>? = null
            private var to: JsonField<MutableList<String>>? = null
            private var bcc: JsonField<MutableList<String>>? = null
            private var cc: JsonField<MutableList<String>>? = null
            private var html: JsonField<String> = JsonMissing.of()
            private var text: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                subject = body.subject
                to = body.to.map { it.toMutableList() }
                bcc = body.bcc.map { it.toMutableList() }
                cc = body.cc.map { it.toMutableList() }
                html = body.html
                text = body.text
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The message subject. */
            fun subject(subject: String) = subject(JsonField.of(subject))

            /**
             * Sets [Builder.subject] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subject] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subject(subject: JsonField<String>) = apply { this.subject = subject }

            /** The recipient addresses. */
            fun to(to: List<String>) = to(JsonField.of(to))

            /**
             * Sets [Builder.to] to an arbitrary JSON value.
             *
             * You should usually call [Builder.to] with a well-typed `List<String>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /** The BCC addresses. */
            fun bcc(bcc: List<String>) = bcc(JsonField.of(bcc))

            /**
             * Sets [Builder.bcc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bcc] with a well-typed `List<String>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bcc(bcc: JsonField<List<String>>) = apply {
                this.bcc = bcc.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.bcc].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addBcc(bcc: String) = apply {
                this.bcc =
                    (this.bcc ?: JsonField.of(mutableListOf())).also {
                        checkKnown("bcc", it).add(bcc)
                    }
            }

            /** The CC addresses. */
            fun cc(cc: List<String>) = cc(JsonField.of(cc))

            /**
             * Sets [Builder.cc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cc] with a well-typed `List<String>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /** The HTML body. */
            fun html(html: String) = html(JsonField.of(html))

            /**
             * Sets [Builder.html] to an arbitrary JSON value.
             *
             * You should usually call [Builder.html] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun html(html: JsonField<String>) = apply { this.html = html }

            /** The plain text body. */
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
             * .subject()
             * .to()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("subject", subject),
                    checkRequired("to", to).map { it.toImmutable() },
                    (bcc ?: JsonMissing.of()).map { it.toImmutable() },
                    (cc ?: JsonMissing.of()).map { it.toImmutable() },
                    html,
                    text,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            subject()
            to()
            bcc()
            cc()
            html()
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
            (if (subject.asKnown().isPresent) 1 else 0) +
                (to.asKnown().getOrNull()?.size ?: 0) +
                (bcc.asKnown().getOrNull()?.size ?: 0) +
                (cc.asKnown().getOrNull()?.size ?: 0) +
                (if (html.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                subject == other.subject &&
                to == other.to &&
                bcc == other.bcc &&
                cc == other.cc &&
                html == other.html &&
                text == other.text &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(subject, to, bcc, cc, html, text, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{subject=$subject, to=$to, bcc=$bcc, cc=$cc, html=$html, text=$text, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboxSendParams &&
            inboxId == other.inboxId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(inboxId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "InboxSendParams{inboxId=$inboxId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
