// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListResponseTest {

    @Test
    fun create() {
        val eventListResponse =
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

        assertThat(eventListResponse.id()).isEqualTo("evt_01ka8k8s80gvx9604cn9am5st4")
        assertThat(eventListResponse.data())
            .isEqualTo(
                EventListResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(eventListResponse.event()).isEqualTo(EventType.EMAIL_QUEUED)
        assertThat(eventListResponse.orgId()).isEqualTo("orgId")
        assertThat(eventListResponse.status()).isEqualTo(EventListResponse.Status.SUCCESS)
        assertThat(eventListResponse.webhookId()).isEqualTo("wh_01ka8k8s80gvx9604cn9am5st4")
        assertThat(eventListResponse.successfulAt()).contains("successfulAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventListResponse =
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

        val roundtrippedEventListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventListResponse),
                jacksonTypeRef<EventListResponse>(),
            )

        assertThat(roundtrippedEventListResponse).isEqualTo(eventListResponse)
    }
}
