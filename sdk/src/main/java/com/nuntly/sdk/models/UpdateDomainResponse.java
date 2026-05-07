package com.nuntly.sdk.models;

public record UpdateDomainResponse(
    /** The id of the domain */
    String id,
    /** Emit an event for each recipient opens an email their email client */
    boolean openTracking,
    /** Emit an event for each time the recipient clicks a link in the email */
    boolean clickTracking) {}
