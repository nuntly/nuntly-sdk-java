package com.nuntly.sdk.models;

/**
 * @param id The id of the template.
 * @param templateVersionId The id of the version that was published.
 */
public record TemplateVersionIdResponse(String id, String templateVersionId) {}
