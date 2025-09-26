// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.stats

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.checkKnown
import com.nuntly.core.checkRequired
import com.nuntly.core.toImmutable
import com.nuntly.errors.NuntlyInvalidDataException
import java.time.LocalDate
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The emails stats */
class StatListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val end: JsonField<LocalDate>,
    private val start: JsonField<LocalDate>,
    private val stats: JsonField<List<Stat>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("end") @ExcludeMissing end: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("start") @ExcludeMissing start: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("stats") @ExcludeMissing stats: JsonField<List<Stat>> = JsonMissing.of(),
    ) : this(end, start, stats, mutableMapOf())

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun end(): LocalDate = end.getRequired("end")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun start(): LocalDate = start.getRequired("start")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stats(): List<Stat> = stats.getRequired("stats")

    /**
     * Returns the raw JSON value of [end].
     *
     * Unlike [end], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("end") @ExcludeMissing fun _end(): JsonField<LocalDate> = end

    /**
     * Returns the raw JSON value of [start].
     *
     * Unlike [start], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("start") @ExcludeMissing fun _start(): JsonField<LocalDate> = start

    /**
     * Returns the raw JSON value of [stats].
     *
     * Unlike [stats], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stats") @ExcludeMissing fun _stats(): JsonField<List<Stat>> = stats

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
         * Returns a mutable builder for constructing an instance of [StatListResponse].
         *
         * The following fields are required:
         * ```java
         * .end()
         * .start()
         * .stats()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StatListResponse]. */
    class Builder internal constructor() {

        private var end: JsonField<LocalDate>? = null
        private var start: JsonField<LocalDate>? = null
        private var stats: JsonField<MutableList<Stat>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(statListResponse: StatListResponse) = apply {
            end = statListResponse.end
            start = statListResponse.start
            stats = statListResponse.stats.map { it.toMutableList() }
            additionalProperties = statListResponse.additionalProperties.toMutableMap()
        }

        fun end(end: LocalDate) = end(JsonField.of(end))

        /**
         * Sets [Builder.end] to an arbitrary JSON value.
         *
         * You should usually call [Builder.end] with a well-typed [LocalDate] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun end(end: JsonField<LocalDate>) = apply { this.end = end }

        fun start(start: LocalDate) = start(JsonField.of(start))

        /**
         * Sets [Builder.start] to an arbitrary JSON value.
         *
         * You should usually call [Builder.start] with a well-typed [LocalDate] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun start(start: JsonField<LocalDate>) = apply { this.start = start }

        fun stats(stats: List<Stat>) = stats(JsonField.of(stats))

        /**
         * Sets [Builder.stats] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stats] with a well-typed `List<Stat>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun stats(stats: JsonField<List<Stat>>) = apply {
            this.stats = stats.map { it.toMutableList() }
        }

        /**
         * Adds a single [Stat] to [stats].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addStat(stat: Stat) = apply {
            stats =
                (stats ?: JsonField.of(mutableListOf())).also { checkKnown("stats", it).add(stat) }
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
         * Returns an immutable instance of [StatListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .end()
         * .start()
         * .stats()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StatListResponse =
            StatListResponse(
                checkRequired("end", end),
                checkRequired("start", start),
                checkRequired("stats", stats).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StatListResponse = apply {
        if (validated) {
            return@apply
        }

        end()
        start()
        stats().forEach { it.validate() }
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
        (if (end.asKnown().isPresent) 1 else 0) +
            (if (start.asKnown().isPresent) 1 else 0) +
            (stats.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Stat
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val occurredOn: JsonField<LocalDate>,
        private val bounced: JsonField<Double>,
        private val clicked: JsonField<Double>,
        private val complaintReceived: JsonField<Double>,
        private val delivered: JsonField<Double>,
        private val deliveryDelayed: JsonField<Double>,
        private val opened: JsonField<Double>,
        private val rejected: JsonField<Double>,
        private val renderingFailed: JsonField<Double>,
        private val sent: JsonField<Double>,
        private val subscribed: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("occurred_on")
            @ExcludeMissing
            occurredOn: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("bounced") @ExcludeMissing bounced: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("clicked") @ExcludeMissing clicked: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("complaint_received")
            @ExcludeMissing
            complaintReceived: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("delivered")
            @ExcludeMissing
            delivered: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("delivery_delayed")
            @ExcludeMissing
            deliveryDelayed: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("opened") @ExcludeMissing opened: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("rejected")
            @ExcludeMissing
            rejected: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("rendering_failed")
            @ExcludeMissing
            renderingFailed: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("sent") @ExcludeMissing sent: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("subscribed")
            @ExcludeMissing
            subscribed: JsonField<Double> = JsonMissing.of(),
        ) : this(
            occurredOn,
            bounced,
            clicked,
            complaintReceived,
            delivered,
            deliveryDelayed,
            opened,
            rejected,
            renderingFailed,
            sent,
            subscribed,
            mutableMapOf(),
        )

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun occurredOn(): LocalDate = occurredOn.getRequired("occurred_on")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bounced(): Optional<Double> = bounced.getOptional("bounced")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun clicked(): Optional<Double> = clicked.getOptional("clicked")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun complaintReceived(): Optional<Double> =
            complaintReceived.getOptional("complaint_received")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun delivered(): Optional<Double> = delivered.getOptional("delivered")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun deliveryDelayed(): Optional<Double> = deliveryDelayed.getOptional("delivery_delayed")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun opened(): Optional<Double> = opened.getOptional("opened")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun rejected(): Optional<Double> = rejected.getOptional("rejected")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun renderingFailed(): Optional<Double> = renderingFailed.getOptional("rendering_failed")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sent(): Optional<Double> = sent.getOptional("sent")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun subscribed(): Optional<Double> = subscribed.getOptional("subscribed")

        /**
         * Returns the raw JSON value of [occurredOn].
         *
         * Unlike [occurredOn], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("occurred_on")
        @ExcludeMissing
        fun _occurredOn(): JsonField<LocalDate> = occurredOn

        /**
         * Returns the raw JSON value of [bounced].
         *
         * Unlike [bounced], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bounced") @ExcludeMissing fun _bounced(): JsonField<Double> = bounced

        /**
         * Returns the raw JSON value of [clicked].
         *
         * Unlike [clicked], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("clicked") @ExcludeMissing fun _clicked(): JsonField<Double> = clicked

        /**
         * Returns the raw JSON value of [complaintReceived].
         *
         * Unlike [complaintReceived], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("complaint_received")
        @ExcludeMissing
        fun _complaintReceived(): JsonField<Double> = complaintReceived

        /**
         * Returns the raw JSON value of [delivered].
         *
         * Unlike [delivered], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delivered") @ExcludeMissing fun _delivered(): JsonField<Double> = delivered

        /**
         * Returns the raw JSON value of [deliveryDelayed].
         *
         * Unlike [deliveryDelayed], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("delivery_delayed")
        @ExcludeMissing
        fun _deliveryDelayed(): JsonField<Double> = deliveryDelayed

        /**
         * Returns the raw JSON value of [opened].
         *
         * Unlike [opened], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("opened") @ExcludeMissing fun _opened(): JsonField<Double> = opened

        /**
         * Returns the raw JSON value of [rejected].
         *
         * Unlike [rejected], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rejected") @ExcludeMissing fun _rejected(): JsonField<Double> = rejected

        /**
         * Returns the raw JSON value of [renderingFailed].
         *
         * Unlike [renderingFailed], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("rendering_failed")
        @ExcludeMissing
        fun _renderingFailed(): JsonField<Double> = renderingFailed

        /**
         * Returns the raw JSON value of [sent].
         *
         * Unlike [sent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sent") @ExcludeMissing fun _sent(): JsonField<Double> = sent

        /**
         * Returns the raw JSON value of [subscribed].
         *
         * Unlike [subscribed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subscribed")
        @ExcludeMissing
        fun _subscribed(): JsonField<Double> = subscribed

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
             * Returns a mutable builder for constructing an instance of [Stat].
             *
             * The following fields are required:
             * ```java
             * .occurredOn()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Stat]. */
        class Builder internal constructor() {

            private var occurredOn: JsonField<LocalDate>? = null
            private var bounced: JsonField<Double> = JsonMissing.of()
            private var clicked: JsonField<Double> = JsonMissing.of()
            private var complaintReceived: JsonField<Double> = JsonMissing.of()
            private var delivered: JsonField<Double> = JsonMissing.of()
            private var deliveryDelayed: JsonField<Double> = JsonMissing.of()
            private var opened: JsonField<Double> = JsonMissing.of()
            private var rejected: JsonField<Double> = JsonMissing.of()
            private var renderingFailed: JsonField<Double> = JsonMissing.of()
            private var sent: JsonField<Double> = JsonMissing.of()
            private var subscribed: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(stat: Stat) = apply {
                occurredOn = stat.occurredOn
                bounced = stat.bounced
                clicked = stat.clicked
                complaintReceived = stat.complaintReceived
                delivered = stat.delivered
                deliveryDelayed = stat.deliveryDelayed
                opened = stat.opened
                rejected = stat.rejected
                renderingFailed = stat.renderingFailed
                sent = stat.sent
                subscribed = stat.subscribed
                additionalProperties = stat.additionalProperties.toMutableMap()
            }

            fun occurredOn(occurredOn: LocalDate) = occurredOn(JsonField.of(occurredOn))

            /**
             * Sets [Builder.occurredOn] to an arbitrary JSON value.
             *
             * You should usually call [Builder.occurredOn] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun occurredOn(occurredOn: JsonField<LocalDate>) = apply {
                this.occurredOn = occurredOn
            }

            fun bounced(bounced: Double) = bounced(JsonField.of(bounced))

            /**
             * Sets [Builder.bounced] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bounced] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bounced(bounced: JsonField<Double>) = apply { this.bounced = bounced }

            fun clicked(clicked: Double) = clicked(JsonField.of(clicked))

            /**
             * Sets [Builder.clicked] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clicked] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clicked(clicked: JsonField<Double>) = apply { this.clicked = clicked }

            fun complaintReceived(complaintReceived: Double) =
                complaintReceived(JsonField.of(complaintReceived))

            /**
             * Sets [Builder.complaintReceived] to an arbitrary JSON value.
             *
             * You should usually call [Builder.complaintReceived] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun complaintReceived(complaintReceived: JsonField<Double>) = apply {
                this.complaintReceived = complaintReceived
            }

            fun delivered(delivered: Double) = delivered(JsonField.of(delivered))

            /**
             * Sets [Builder.delivered] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delivered] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delivered(delivered: JsonField<Double>) = apply { this.delivered = delivered }

            fun deliveryDelayed(deliveryDelayed: Double) =
                deliveryDelayed(JsonField.of(deliveryDelayed))

            /**
             * Sets [Builder.deliveryDelayed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deliveryDelayed] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deliveryDelayed(deliveryDelayed: JsonField<Double>) = apply {
                this.deliveryDelayed = deliveryDelayed
            }

            fun opened(opened: Double) = opened(JsonField.of(opened))

            /**
             * Sets [Builder.opened] to an arbitrary JSON value.
             *
             * You should usually call [Builder.opened] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun opened(opened: JsonField<Double>) = apply { this.opened = opened }

            fun rejected(rejected: Double) = rejected(JsonField.of(rejected))

            /**
             * Sets [Builder.rejected] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rejected] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rejected(rejected: JsonField<Double>) = apply { this.rejected = rejected }

            fun renderingFailed(renderingFailed: Double) =
                renderingFailed(JsonField.of(renderingFailed))

            /**
             * Sets [Builder.renderingFailed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.renderingFailed] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun renderingFailed(renderingFailed: JsonField<Double>) = apply {
                this.renderingFailed = renderingFailed
            }

            fun sent(sent: Double) = sent(JsonField.of(sent))

            /**
             * Sets [Builder.sent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sent] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun sent(sent: JsonField<Double>) = apply { this.sent = sent }

            fun subscribed(subscribed: Double) = subscribed(JsonField.of(subscribed))

            /**
             * Sets [Builder.subscribed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscribed] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subscribed(subscribed: JsonField<Double>) = apply { this.subscribed = subscribed }

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
             * Returns an immutable instance of [Stat].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .occurredOn()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Stat =
                Stat(
                    checkRequired("occurredOn", occurredOn),
                    bounced,
                    clicked,
                    complaintReceived,
                    delivered,
                    deliveryDelayed,
                    opened,
                    rejected,
                    renderingFailed,
                    sent,
                    subscribed,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Stat = apply {
            if (validated) {
                return@apply
            }

            occurredOn()
            bounced()
            clicked()
            complaintReceived()
            delivered()
            deliveryDelayed()
            opened()
            rejected()
            renderingFailed()
            sent()
            subscribed()
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
            (if (occurredOn.asKnown().isPresent) 1 else 0) +
                (if (bounced.asKnown().isPresent) 1 else 0) +
                (if (clicked.asKnown().isPresent) 1 else 0) +
                (if (complaintReceived.asKnown().isPresent) 1 else 0) +
                (if (delivered.asKnown().isPresent) 1 else 0) +
                (if (deliveryDelayed.asKnown().isPresent) 1 else 0) +
                (if (opened.asKnown().isPresent) 1 else 0) +
                (if (rejected.asKnown().isPresent) 1 else 0) +
                (if (renderingFailed.asKnown().isPresent) 1 else 0) +
                (if (sent.asKnown().isPresent) 1 else 0) +
                (if (subscribed.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Stat &&
                occurredOn == other.occurredOn &&
                bounced == other.bounced &&
                clicked == other.clicked &&
                complaintReceived == other.complaintReceived &&
                delivered == other.delivered &&
                deliveryDelayed == other.deliveryDelayed &&
                opened == other.opened &&
                rejected == other.rejected &&
                renderingFailed == other.renderingFailed &&
                sent == other.sent &&
                subscribed == other.subscribed &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                occurredOn,
                bounced,
                clicked,
                complaintReceived,
                delivered,
                deliveryDelayed,
                opened,
                rejected,
                renderingFailed,
                sent,
                subscribed,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Stat{occurredOn=$occurredOn, bounced=$bounced, clicked=$clicked, complaintReceived=$complaintReceived, delivered=$delivered, deliveryDelayed=$deliveryDelayed, opened=$opened, rejected=$rejected, renderingFailed=$renderingFailed, sent=$sent, subscribed=$subscribed, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StatListResponse &&
            end == other.end &&
            start == other.start &&
            stats == other.stats &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(end, start, stats, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StatListResponse{end=$end, start=$start, stats=$stats, additionalProperties=$additionalProperties}"
}
