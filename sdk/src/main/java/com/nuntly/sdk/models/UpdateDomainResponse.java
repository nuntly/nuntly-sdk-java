package com.nuntly.sdk.models;

/**
 * @param id The id of the domain
 * @param openTracking Emit an event for each recipient opens an email their email client
 * @param clickTracking Emit an event for each time the recipient clicks a link in the email
 */
public record UpdateDomainResponse(String id, boolean openTracking, boolean clickTracking) {}
