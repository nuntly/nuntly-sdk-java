package com.nuntly.sdk.models;

/**
 * @param id The id of the email
 * @param status The status of the email.
 */
public record DeleteEmailResponse(String id, EmailStatus status) {}
