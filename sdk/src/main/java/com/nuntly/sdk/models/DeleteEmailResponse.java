package com.nuntly.sdk.models;

public record DeleteEmailResponse(
    /** The id of the email */
    String id,
    /** The status of the email. */
    EmailStatus status) {}
