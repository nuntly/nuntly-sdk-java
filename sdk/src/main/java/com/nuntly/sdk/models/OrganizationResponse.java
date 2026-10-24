package com.nuntly.sdk.models;

/**
 * @param id The id of the organization
 * @param name The name of the organization
 * @param status The status of the organization
 */
public record OrganizationResponse(String id, String name, OrganizationStatus status) {}
