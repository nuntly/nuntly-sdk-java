package com.nuntly.sdk.models;

/**
 * @param id The id of the broadcast.
 * @param status The lifecycle state of the broadcast.
 */
public record SendBroadcastResponse(String id, BroadcastStatus status) {}
