// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.checkRequired
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class MessageContent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val html: JsonField<MessageContentItem>,
    private val mime: JsonField<MessageContentItem>,
    private val text: JsonField<MessageContentItem>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("html")
        @ExcludeMissing
        html: JsonField<MessageContentItem> = JsonMissing.of(),
        @JsonProperty("mime")
        @ExcludeMissing
        mime: JsonField<MessageContentItem> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<MessageContentItem> = JsonMissing.of(),
    ) : this(html, mime, text, mutableMapOf())

    /**
     * HTML content, or `null` if not requested or unavailable.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun html(): Optional<MessageContentItem> = html.getOptional("html")

    /**
     * Raw MIME (.eml) content, or `null` if not requested or unavailable. Returned for received
     * messages only.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mime(): Optional<MessageContentItem> = mime.getOptional("mime")

    /**
     * Plain text content, or `null` if not requested or unavailable.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<MessageContentItem> = text.getOptional("text")

    /**
     * Returns the raw JSON value of [html].
     *
     * Unlike [html], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("html") @ExcludeMissing fun _html(): JsonField<MessageContentItem> = html

    /**
     * Returns the raw JSON value of [mime].
     *
     * Unlike [mime], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mime") @ExcludeMissing fun _mime(): JsonField<MessageContentItem> = mime

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<MessageContentItem> = text

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
         * Returns a mutable builder for constructing an instance of [MessageContent].
         *
         * The following fields are required:
         * ```java
         * .html()
         * .mime()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageContent]. */
    class Builder internal constructor() {

        private var html: JsonField<MessageContentItem>? = null
        private var mime: JsonField<MessageContentItem>? = null
        private var text: JsonField<MessageContentItem>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageContent: MessageContent) = apply {
            html = messageContent.html
            mime = messageContent.mime
            text = messageContent.text
            additionalProperties = messageContent.additionalProperties.toMutableMap()
        }

        /** HTML content, or `null` if not requested or unavailable. */
        fun html(html: MessageContentItem?) = html(JsonField.ofNullable(html))

        /** Alias for calling [Builder.html] with `html.orElse(null)`. */
        fun html(html: Optional<MessageContentItem>) = html(html.getOrNull())

        /**
         * Sets [Builder.html] to an arbitrary JSON value.
         *
         * You should usually call [Builder.html] with a well-typed [MessageContentItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun html(html: JsonField<MessageContentItem>) = apply { this.html = html }

        /**
         * Raw MIME (.eml) content, or `null` if not requested or unavailable. Returned for received
         * messages only.
         */
        fun mime(mime: MessageContentItem?) = mime(JsonField.ofNullable(mime))

        /** Alias for calling [Builder.mime] with `mime.orElse(null)`. */
        fun mime(mime: Optional<MessageContentItem>) = mime(mime.getOrNull())

        /**
         * Sets [Builder.mime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mime] with a well-typed [MessageContentItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun mime(mime: JsonField<MessageContentItem>) = apply { this.mime = mime }

        /** Plain text content, or `null` if not requested or unavailable. */
        fun text(text: MessageContentItem?) = text(JsonField.ofNullable(text))

        /** Alias for calling [Builder.text] with `text.orElse(null)`. */
        fun text(text: Optional<MessageContentItem>) = text(text.getOrNull())

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [MessageContentItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun text(text: JsonField<MessageContentItem>) = apply { this.text = text }

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
         * Returns an immutable instance of [MessageContent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .html()
         * .mime()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageContent =
            MessageContent(
                checkRequired("html", html),
                checkRequired("mime", mime),
                checkRequired("text", text),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MessageContent = apply {
        if (validated) {
            return@apply
        }

        html().ifPresent { it.validate() }
        mime().ifPresent { it.validate() }
        text().ifPresent { it.validate() }
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
        (html.asKnown().getOrNull()?.validity() ?: 0) +
            (mime.asKnown().getOrNull()?.validity() ?: 0) +
            (text.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageContent &&
            html == other.html &&
            mime == other.mime &&
            text == other.text &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(html, mime, text, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageContent{html=$html, mime=$mime, text=$text, additionalProperties=$additionalProperties}"
}
