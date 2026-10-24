package com.nuntly.sdk.models;

/**
 * A single item from TemplatesResponse.
 *
 * @param id The id of the template.
 * @param name A name for the template, shown only to your team.
 * @param status The lifecycle state of the template.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 */
public record TemplatesResponseItem(
    String id, String name, TemplateStatus status, String createdAt, String updatedAt) {}
