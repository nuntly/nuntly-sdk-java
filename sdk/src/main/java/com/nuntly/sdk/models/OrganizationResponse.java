package com.nuntly.sdk.models;

public record OrganizationResponse(
    /** The id of the organization */
    String id,
    /** The name of the organization */
    String name,
    /** The status of the organization */
    OrganizationStatus status) {}
