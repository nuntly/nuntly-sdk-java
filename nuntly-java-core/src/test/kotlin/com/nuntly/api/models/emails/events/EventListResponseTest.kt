// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListResponseTest {

    @Test
    fun create() {
        val eventListResponse =
            EventListResponse.builder()
                .id("evt_01jmwk9690775vgaqnwty4hkxb")
                .details(EventListResponse.Details.builder().build())
                .emailId("em_01jnvnn9avq52k5mrhn1gab0ch")
                .eventAt(OffsetDateTime.parse("2025-02-24T18:25:03.264Z"))
                .kind(EventListResponse.Kind.EVENT_EMAIL)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .type(EventListResponse.Type.EMAIL_CLICKED)
                .build()

        assertThat(eventListResponse.id()).isEqualTo("evt_01jmwk9690775vgaqnwty4hkxb")
        assertThat(eventListResponse.details())
            .isEqualTo(EventListResponse.Details.builder().build())
        assertThat(eventListResponse.emailId()).isEqualTo("em_01jnvnn9avq52k5mrhn1gab0ch")
        assertThat(eventListResponse.eventAt())
            .isEqualTo(OffsetDateTime.parse("2025-02-24T18:25:03.264Z"))
        assertThat(eventListResponse.kind()).isEqualTo(EventListResponse.Kind.EVENT_EMAIL)
        assertThat(eventListResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(eventListResponse.type()).isEqualTo(EventListResponse.Type.EMAIL_CLICKED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventListResponse =
            EventListResponse.builder()
                .id("evt_01jmwk9690775vgaqnwty4hkxb")
                .details(EventListResponse.Details.builder().build())
                .emailId("em_01jnvnn9avq52k5mrhn1gab0ch")
                .eventAt(OffsetDateTime.parse("2025-02-24T18:25:03.264Z"))
                .kind(EventListResponse.Kind.EVENT_EMAIL)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .type(EventListResponse.Type.EMAIL_CLICKED)
                .build()

        val roundtrippedEventListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventListResponse),
                jacksonTypeRef<EventListResponse>(),
            )

        assertThat(roundtrippedEventListResponse).isEqualTo(eventListResponse)
    }
}
