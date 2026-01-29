// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.events

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
                .createdAt("createdAt")
                .emailId("em_01ka8k8s80gvx9604cn9am5st4")
                .eventType(EventType.EMAIL_QUEUED)
                .orgId("orgId")
                .payload(JsonValue.from(mapOf<String, Any>()))
                .occurredAt("occurredAt")
                .build()

        assertThat(eventListResponse.id()).isEqualTo("evt_01ka8k8s80gvx9604cn9am5st4")
        assertThat(eventListResponse.createdAt()).isEqualTo("createdAt")
        assertThat(eventListResponse.emailId()).isEqualTo("em_01ka8k8s80gvx9604cn9am5st4")
        assertThat(eventListResponse.eventType()).isEqualTo(EventType.EMAIL_QUEUED)
        assertThat(eventListResponse.orgId()).isEqualTo("orgId")
        assertThat(eventListResponse._payload()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(eventListResponse.occurredAt()).contains("occurredAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventListResponse =
            EventListResponse.builder()
                .id("evt_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .emailId("em_01ka8k8s80gvx9604cn9am5st4")
                .eventType(EventType.EMAIL_QUEUED)
                .orgId("orgId")
                .payload(JsonValue.from(mapOf<String, Any>()))
                .occurredAt("occurredAt")
                .build()

        val roundtrippedEventListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventListResponse),
                jacksonTypeRef<EventListResponse>(),
            )

        assertThat(roundtrippedEventListResponse).isEqualTo(eventListResponse)
    }
}
