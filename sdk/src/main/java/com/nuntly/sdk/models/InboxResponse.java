package com.nuntly.sdk.models;

public record InboxResponse(
    /** The id of the inbox */
    String id,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** Date at which the object was updated (ISO 8601 format) */
    java.util.Optional<String> updatedAt,
    /** The id of the domain. */
    String domainId,
    /** The domain name. */
    String domainName,
    /** The local-part of the email address. */
    String address,
    /** The display name of the inbox. */
    String name,
    /** The id of the namespace. */
    String namespaceId,
    /** The display name of the namespace. */
    String namespaceName,
    /** The AI agent identifier. */
    String agentId) {}
