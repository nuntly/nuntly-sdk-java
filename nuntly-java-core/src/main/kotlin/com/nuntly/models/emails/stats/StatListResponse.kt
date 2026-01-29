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
import kotlin.jvm.optionals.getOrNull

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
     * The end date of the stats range
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun end(): LocalDate = end.getRequired("end")

    /**
     * The start date of the stats range
     *
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

        /** The end date of the stats range */
        fun end(end: LocalDate) = end(JsonField.of(end))

        /**
         * Sets [Builder.end] to an arbitrary JSON value.
         *
         * You should usually call [Builder.end] with a well-typed [LocalDate] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun end(end: JsonField<LocalDate>) = apply { this.end = end }

        /** The start date of the stats range */
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
        private val bounced: JsonField<Double>,
        private val canceled: JsonField<Double>,
        private val clicked: JsonField<Double>,
        private val complaintReceived: JsonField<Double>,
        private val delivered: JsonField<Double>,
        private val deliveredDelayed: JsonField<Double>,
        private val failed: JsonField<Double>,
        private val occurredOn: JsonField<LocalDate>,
        private val opened: JsonField<Double>,
        private val processed: JsonField<Double>,
        private val queued: JsonField<Double>,
        private val rejected: JsonField<Double>,
        private val renderingFailed: JsonField<Double>,
        private val scheduled: JsonField<Double>,
        private val sending: JsonField<Double>,
        private val sent: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("bounced") @ExcludeMissing bounced: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("canceled")
            @ExcludeMissing
            canceled: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("clicked") @ExcludeMissing clicked: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("complaintReceived")
            @ExcludeMissing
            complaintReceived: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("delivered")
            @ExcludeMissing
            delivered: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("deliveredDelayed")
            @ExcludeMissing
            deliveredDelayed: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("failed") @ExcludeMissing failed: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("occurredOn")
            @ExcludeMissing
            occurredOn: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("opened") @ExcludeMissing opened: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("processed")
            @ExcludeMissing
            processed: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("queued") @ExcludeMissing queued: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("rejected")
            @ExcludeMissing
            rejected: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("renderingFailed")
            @ExcludeMissing
            renderingFailed: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("scheduled")
            @ExcludeMissing
            scheduled: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("sending") @ExcludeMissing sending: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("sent") @ExcludeMissing sent: JsonField<Double> = JsonMissing.of(),
        ) : this(
            bounced,
            canceled,
            clicked,
            complaintReceived,
            delivered,
            deliveredDelayed,
            failed,
            occurredOn,
            opened,
            processed,
            queued,
            rejected,
            renderingFailed,
            scheduled,
            sending,
            sent,
            mutableMapOf(),
        )

        /**
         * Number of emails bounced
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bounced(): Double = bounced.getRequired("bounced")

        /**
         * Number of emails canceled
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun canceled(): Double = canceled.getRequired("canceled")

        /**
         * Number of emails clicked
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun clicked(): Double = clicked.getRequired("clicked")

        /**
         * Number of complaint received
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun complaintReceived(): Double = complaintReceived.getRequired("complaintReceived")

        /**
         * Number of emails delivered
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun delivered(): Double = delivered.getRequired("delivered")

        /**
         * Number of emails delivered with delay
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun deliveredDelayed(): Double = deliveredDelayed.getRequired("deliveredDelayed")

        /**
         * Number of emails failed
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun failed(): Double = failed.getRequired("failed")

        /**
         * The date of the stats
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun occurredOn(): LocalDate = occurredOn.getRequired("occurredOn")

        /**
         * Number of emails opened
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun opened(): Double = opened.getRequired("opened")

        /**
         * Number of emails processed
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun processed(): Double = processed.getRequired("processed")

        /**
         * Number of emails queued
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun queued(): Double = queued.getRequired("queued")

        /**
         * Number of emails rejected
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun rejected(): Double = rejected.getRequired("rejected")

        /**
         * Number of emails with rendering failed
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun renderingFailed(): Double = renderingFailed.getRequired("renderingFailed")

        /**
         * Number of emails scheduled
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun scheduled(): Double = scheduled.getRequired("scheduled")

        /**
         * Number of emails sending
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sending(): Double = sending.getRequired("sending")

        /**
         * Number of emails sent
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sent(): Double = sent.getRequired("sent")

        /**
         * Returns the raw JSON value of [bounced].
         *
         * Unlike [bounced], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bounced") @ExcludeMissing fun _bounced(): JsonField<Double> = bounced

        /**
         * Returns the raw JSON value of [canceled].
         *
         * Unlike [canceled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("canceled") @ExcludeMissing fun _canceled(): JsonField<Double> = canceled

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
        @JsonProperty("complaintReceived")
        @ExcludeMissing
        fun _complaintReceived(): JsonField<Double> = complaintReceived

        /**
         * Returns the raw JSON value of [delivered].
         *
         * Unlike [delivered], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("delivered") @ExcludeMissing fun _delivered(): JsonField<Double> = delivered

        /**
         * Returns the raw JSON value of [deliveredDelayed].
         *
         * Unlike [deliveredDelayed], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("deliveredDelayed")
        @ExcludeMissing
        fun _deliveredDelayed(): JsonField<Double> = deliveredDelayed

        /**
         * Returns the raw JSON value of [failed].
         *
         * Unlike [failed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("failed") @ExcludeMissing fun _failed(): JsonField<Double> = failed

        /**
         * Returns the raw JSON value of [occurredOn].
         *
         * Unlike [occurredOn], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("occurredOn")
        @ExcludeMissing
        fun _occurredOn(): JsonField<LocalDate> = occurredOn

        /**
         * Returns the raw JSON value of [opened].
         *
         * Unlike [opened], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("opened") @ExcludeMissing fun _opened(): JsonField<Double> = opened

        /**
         * Returns the raw JSON value of [processed].
         *
         * Unlike [processed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("processed") @ExcludeMissing fun _processed(): JsonField<Double> = processed

        /**
         * Returns the raw JSON value of [queued].
         *
         * Unlike [queued], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("queued") @ExcludeMissing fun _queued(): JsonField<Double> = queued

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
        @JsonProperty("renderingFailed")
        @ExcludeMissing
        fun _renderingFailed(): JsonField<Double> = renderingFailed

        /**
         * Returns the raw JSON value of [scheduled].
         *
         * Unlike [scheduled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("scheduled") @ExcludeMissing fun _scheduled(): JsonField<Double> = scheduled

        /**
         * Returns the raw JSON value of [sending].
         *
         * Unlike [sending], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sending") @ExcludeMissing fun _sending(): JsonField<Double> = sending

        /**
         * Returns the raw JSON value of [sent].
         *
         * Unlike [sent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sent") @ExcludeMissing fun _sent(): JsonField<Double> = sent

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
             * .bounced()
             * .canceled()
             * .clicked()
             * .complaintReceived()
             * .delivered()
             * .deliveredDelayed()
             * .failed()
             * .occurredOn()
             * .opened()
             * .processed()
             * .queued()
             * .rejected()
             * .renderingFailed()
             * .scheduled()
             * .sending()
             * .sent()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Stat]. */
        class Builder internal constructor() {

            private var bounced: JsonField<Double>? = null
            private var canceled: JsonField<Double>? = null
            private var clicked: JsonField<Double>? = null
            private var complaintReceived: JsonField<Double>? = null
            private var delivered: JsonField<Double>? = null
            private var deliveredDelayed: JsonField<Double>? = null
            private var failed: JsonField<Double>? = null
            private var occurredOn: JsonField<LocalDate>? = null
            private var opened: JsonField<Double>? = null
            private var processed: JsonField<Double>? = null
            private var queued: JsonField<Double>? = null
            private var rejected: JsonField<Double>? = null
            private var renderingFailed: JsonField<Double>? = null
            private var scheduled: JsonField<Double>? = null
            private var sending: JsonField<Double>? = null
            private var sent: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(stat: Stat) = apply {
                bounced = stat.bounced
                canceled = stat.canceled
                clicked = stat.clicked
                complaintReceived = stat.complaintReceived
                delivered = stat.delivered
                deliveredDelayed = stat.deliveredDelayed
                failed = stat.failed
                occurredOn = stat.occurredOn
                opened = stat.opened
                processed = stat.processed
                queued = stat.queued
                rejected = stat.rejected
                renderingFailed = stat.renderingFailed
                scheduled = stat.scheduled
                sending = stat.sending
                sent = stat.sent
                additionalProperties = stat.additionalProperties.toMutableMap()
            }

            /** Number of emails bounced */
            fun bounced(bounced: Double) = bounced(JsonField.of(bounced))

            /**
             * Sets [Builder.bounced] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bounced] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bounced(bounced: JsonField<Double>) = apply { this.bounced = bounced }

            /** Number of emails canceled */
            fun canceled(canceled: Double) = canceled(JsonField.of(canceled))

            /**
             * Sets [Builder.canceled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.canceled] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun canceled(canceled: JsonField<Double>) = apply { this.canceled = canceled }

            /** Number of emails clicked */
            fun clicked(clicked: Double) = clicked(JsonField.of(clicked))

            /**
             * Sets [Builder.clicked] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clicked] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clicked(clicked: JsonField<Double>) = apply { this.clicked = clicked }

            /** Number of complaint received */
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

            /** Number of emails delivered */
            fun delivered(delivered: Double) = delivered(JsonField.of(delivered))

            /**
             * Sets [Builder.delivered] to an arbitrary JSON value.
             *
             * You should usually call [Builder.delivered] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun delivered(delivered: JsonField<Double>) = apply { this.delivered = delivered }

            /** Number of emails delivered with delay */
            fun deliveredDelayed(deliveredDelayed: Double) =
                deliveredDelayed(JsonField.of(deliveredDelayed))

            /**
             * Sets [Builder.deliveredDelayed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deliveredDelayed] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deliveredDelayed(deliveredDelayed: JsonField<Double>) = apply {
                this.deliveredDelayed = deliveredDelayed
            }

            /** Number of emails failed */
            fun failed(failed: Double) = failed(JsonField.of(failed))

            /**
             * Sets [Builder.failed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.failed] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun failed(failed: JsonField<Double>) = apply { this.failed = failed }

            /** The date of the stats */
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

            /** Number of emails opened */
            fun opened(opened: Double) = opened(JsonField.of(opened))

            /**
             * Sets [Builder.opened] to an arbitrary JSON value.
             *
             * You should usually call [Builder.opened] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun opened(opened: JsonField<Double>) = apply { this.opened = opened }

            /** Number of emails processed */
            fun processed(processed: Double) = processed(JsonField.of(processed))

            /**
             * Sets [Builder.processed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.processed] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun processed(processed: JsonField<Double>) = apply { this.processed = processed }

            /** Number of emails queued */
            fun queued(queued: Double) = queued(JsonField.of(queued))

            /**
             * Sets [Builder.queued] to an arbitrary JSON value.
             *
             * You should usually call [Builder.queued] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun queued(queued: JsonField<Double>) = apply { this.queued = queued }

            /** Number of emails rejected */
            fun rejected(rejected: Double) = rejected(JsonField.of(rejected))

            /**
             * Sets [Builder.rejected] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rejected] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rejected(rejected: JsonField<Double>) = apply { this.rejected = rejected }

            /** Number of emails with rendering failed */
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

            /** Number of emails scheduled */
            fun scheduled(scheduled: Double) = scheduled(JsonField.of(scheduled))

            /**
             * Sets [Builder.scheduled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scheduled] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun scheduled(scheduled: JsonField<Double>) = apply { this.scheduled = scheduled }

            /** Number of emails sending */
            fun sending(sending: Double) = sending(JsonField.of(sending))

            /**
             * Sets [Builder.sending] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sending] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sending(sending: JsonField<Double>) = apply { this.sending = sending }

            /** Number of emails sent */
            fun sent(sent: Double) = sent(JsonField.of(sent))

            /**
             * Sets [Builder.sent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sent] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun sent(sent: JsonField<Double>) = apply { this.sent = sent }

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
             * .bounced()
             * .canceled()
             * .clicked()
             * .complaintReceived()
             * .delivered()
             * .deliveredDelayed()
             * .failed()
             * .occurredOn()
             * .opened()
             * .processed()
             * .queued()
             * .rejected()
             * .renderingFailed()
             * .scheduled()
             * .sending()
             * .sent()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Stat =
                Stat(
                    checkRequired("bounced", bounced),
                    checkRequired("canceled", canceled),
                    checkRequired("clicked", clicked),
                    checkRequired("complaintReceived", complaintReceived),
                    checkRequired("delivered", delivered),
                    checkRequired("deliveredDelayed", deliveredDelayed),
                    checkRequired("failed", failed),
                    checkRequired("occurredOn", occurredOn),
                    checkRequired("opened", opened),
                    checkRequired("processed", processed),
                    checkRequired("queued", queued),
                    checkRequired("rejected", rejected),
                    checkRequired("renderingFailed", renderingFailed),
                    checkRequired("scheduled", scheduled),
                    checkRequired("sending", sending),
                    checkRequired("sent", sent),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Stat = apply {
            if (validated) {
                return@apply
            }

            bounced()
            canceled()
            clicked()
            complaintReceived()
            delivered()
            deliveredDelayed()
            failed()
            occurredOn()
            opened()
            processed()
            queued()
            rejected()
            renderingFailed()
            scheduled()
            sending()
            sent()
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
            (if (bounced.asKnown().isPresent) 1 else 0) +
                (if (canceled.asKnown().isPresent) 1 else 0) +
                (if (clicked.asKnown().isPresent) 1 else 0) +
                (if (complaintReceived.asKnown().isPresent) 1 else 0) +
                (if (delivered.asKnown().isPresent) 1 else 0) +
                (if (deliveredDelayed.asKnown().isPresent) 1 else 0) +
                (if (failed.asKnown().isPresent) 1 else 0) +
                (if (occurredOn.asKnown().isPresent) 1 else 0) +
                (if (opened.asKnown().isPresent) 1 else 0) +
                (if (processed.asKnown().isPresent) 1 else 0) +
                (if (queued.asKnown().isPresent) 1 else 0) +
                (if (rejected.asKnown().isPresent) 1 else 0) +
                (if (renderingFailed.asKnown().isPresent) 1 else 0) +
                (if (scheduled.asKnown().isPresent) 1 else 0) +
                (if (sending.asKnown().isPresent) 1 else 0) +
                (if (sent.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Stat &&
                bounced == other.bounced &&
                canceled == other.canceled &&
                clicked == other.clicked &&
                complaintReceived == other.complaintReceived &&
                delivered == other.delivered &&
                deliveredDelayed == other.deliveredDelayed &&
                failed == other.failed &&
                occurredOn == other.occurredOn &&
                opened == other.opened &&
                processed == other.processed &&
                queued == other.queued &&
                rejected == other.rejected &&
                renderingFailed == other.renderingFailed &&
                scheduled == other.scheduled &&
                sending == other.sending &&
                sent == other.sent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                bounced,
                canceled,
                clicked,
                complaintReceived,
                delivered,
                deliveredDelayed,
                failed,
                occurredOn,
                opened,
                processed,
                queued,
                rejected,
                renderingFailed,
                scheduled,
                sending,
                sent,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Stat{bounced=$bounced, canceled=$canceled, clicked=$clicked, complaintReceived=$complaintReceived, delivered=$delivered, deliveredDelayed=$deliveredDelayed, failed=$failed, occurredOn=$occurredOn, opened=$opened, processed=$processed, queued=$queued, rejected=$rejected, renderingFailed=$renderingFailed, scheduled=$scheduled, sending=$sending, sent=$sent, additionalProperties=$additionalProperties}"
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
