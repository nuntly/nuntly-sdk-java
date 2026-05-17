package com.nuntly.sdk.models;

/** A single item from OrganizationsResponse. */
public record OrganizationsResponseItem(
    /** The id of the organization */
    String id,
    /** The name of the organization */
    String name,
    /** The status of the organization */
    CreateWebhookRequestStatus status) {}
