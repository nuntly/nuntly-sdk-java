package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 * A single item from TemplateVersionsResponse.
 *
 * @param id The id of the content version.
 * @param templateId The id of the template.
 * @param status The lifecycle state of the content version.
 * @param publishedAt Date at which this version was published.
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 * @param variables The declared variables.
 */
public record TemplateVersionsResponseItem(
    String id,
    String templateId,
    TemplateVersionStatus status,
    String subject,
    Optional<String> publishedAt,
    String createdAt,
    String updatedAt,
    List<VariableDeclaration> variables) {}
