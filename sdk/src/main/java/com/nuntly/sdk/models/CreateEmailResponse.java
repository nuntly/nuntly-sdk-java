package com.nuntly.sdk.models;

public record CreateEmailResponse(
    /** The id of the email */
    String id,
    /** The status of the email. */
    String status) {}
