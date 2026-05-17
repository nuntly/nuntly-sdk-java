package com.nuntly.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Regression test for the JDK 17+ failure mode "module java.base does not opens
 * java.util to unnamed module" that bricked v1.0.0-alpha.14 on every JDK that
 * any sane consumer would run.
 */
class OptionalTypeAdapterFactoryTest {

    public record SamplePayload(
        String from,
        Optional<String> subject,
        Optional<List<String>> tags
    ) {}

    private static Gson gsonWithAdapter() {
        return new GsonBuilder()
            .registerTypeAdapterFactory(new OptionalTypeAdapterFactory())
            .create();
    }

    @Test
    void serializesPresentOptionalAsValue() {
        var json = gsonWithAdapter().toJson(new SamplePayload(
            "a@b.com",
            Optional.of("hello"),
            Optional.of(List.of("billing", "ops"))
        ));
        assertTrue(json.contains("\"subject\":\"hello\""), json);
        assertTrue(json.contains("\"tags\":[\"billing\",\"ops\"]"), json);
    }

    @Test
    void omitsEmptyOptionalFromOutput() {
        // serializeNulls is OFF by default -> the field is dropped entirely.
        var json = gsonWithAdapter().toJson(new SamplePayload(
            "a@b.com",
            Optional.empty(),
            Optional.empty()
        ));
        assertEquals("{\"from\":\"a@b.com\"}", json);
    }

    @Test
    void deserializesNullAsEmptyOptional() {
        var payload = gsonWithAdapter().fromJson(
            "{\"from\":\"x\",\"subject\":null,\"tags\":null}",
            SamplePayload.class
        );
        assertEquals(Optional.empty(), payload.subject());
        assertEquals(Optional.empty(), payload.tags());
    }

    // NOTE: Gson record deserialization does NOT call this adapter for fields
    // that are absent from the JSON (Optional<T> stays null in the record).
    // Read-side absent-as-empty is a separate fix (post-construction record
    // hook or custom record factory); the WRITE side, which is the primary
    // blocker, works correctly.

    @Test
    void deserializesPresentValue() {
        var payload = gsonWithAdapter().fromJson(
            "{\"from\":\"x\",\"subject\":\"hi\",\"tags\":[\"a\"]}",
            SamplePayload.class
        );
        assertEquals(Optional.of("hi"), payload.subject());
        assertEquals(Optional.of(List.of("a")), payload.tags());
    }
}
