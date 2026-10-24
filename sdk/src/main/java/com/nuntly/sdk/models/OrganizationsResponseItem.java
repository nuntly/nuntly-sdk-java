package com.nuntly.sdk.models;

/**
 * A single item from OrganizationsResponse.
 *
 * @param id The id of the organization
 * @param name The name of the organization
 * @param status The status of the organization
 */
public record OrganizationsResponseItem(String id, String name, OrganizationStatus status) {}
