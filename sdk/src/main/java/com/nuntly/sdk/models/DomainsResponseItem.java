package com.nuntly.sdk.models;

/**
 * A single item from DomainsResponse.
 *
 * @param id The id of the domain
 * @param name The name of the domain to send e-mails'
 * @param status The status for the domain
 * @param sendingStatus The sending status for the domain
 * @param receivingStatus The receiving status for the domain
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param region The region of the domain data
 */
public record DomainsResponseItem(
    String id,
    String name,
    DomainStatus status,
    DomainSendingStatus sendingStatus,
    DomainReceivingStatus receivingStatus,
    String createdAt,
    String region) {}
