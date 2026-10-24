package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * A single item from InboxesResponse.
 *
 * @param id The id of the inbox
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param updatedAt Date at which the object was updated (ISO 8601 format)
 * @param domainId The id of the domain.
 * @param domainName The domain name.
 * @param address The local-part of the email address.
 * @param name The display name of the inbox.
 * @param namespaceId The id of the namespace.
 * @param namespaceName The display name of the namespace.
 * @param agentId The AI agent identifier.
 */
public record InboxesResponseItem(
    String id,
    String createdAt,
    Optional<String> updatedAt,
    String domainId,
    String domainName,
    String address,
    Optional<String> name,
    Optional<String> namespaceId,
    Optional<String> namespaceName,
    Optional<String> agentId) {}
