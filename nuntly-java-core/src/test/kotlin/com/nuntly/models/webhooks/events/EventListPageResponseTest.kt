// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListPageResponseTest {

    @Test
    fun create() {
        val eventListPageResponse =
            EventListPageResponse.builder()
                .addData(
                    EventListResponse.builder()
                        .id("evt_01ka8k8s80gvx9604cn9am5st4")
                        .data(
                            EventListResponse.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .event(EventType.EMAIL_QUEUED)
                        .orgId("orgId")
                        .status(EventListResponse.Status.SUCCESS)
                        .webhookId("wh_01ka8k8s80gvx9604cn9am5st4")
                        .successfulAt("successfulAt")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(eventListPageResponse.data())
            .containsExactly(
                EventListResponse.builder()
                    .id("evt_01ka8k8s80gvx9604cn9am5st4")
                    .data(
                        EventListResponse.Data.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .event(EventType.EMAIL_QUEUED)
                    .orgId("orgId")
                    .status(EventListResponse.Status.SUCCESS)
                    .webhookId("wh_01ka8k8s80gvx9604cn9am5st4")
                    .successfulAt("successfulAt")
                    .build()
            )
        assertThat(eventListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventListPageResponse =
            EventListPageResponse.builder()
                .addData(
                    EventListResponse.builder()
                        .id("evt_01ka8k8s80gvx9604cn9am5st4")
                        .data(
                            EventListResponse.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .event(EventType.EMAIL_QUEUED)
                        .orgId("orgId")
                        .status(EventListResponse.Status.SUCCESS)
                        .webhookId("wh_01ka8k8s80gvx9604cn9am5st4")
                        .successfulAt("successfulAt")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedEventListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventListPageResponse),
                jacksonTypeRef<EventListPageResponse>(),
            )

        assertThat(roundtrippedEventListPageResponse).isEqualTo(eventListPageResponse)
    }
}
