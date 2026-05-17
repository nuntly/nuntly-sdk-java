package com.nuntly.sdk.models;

/** A single item from DomainsResponse. */
public record DomainsResponseItem(
    /** The id of the domain */
    String id,
    /** The name of the domain to send e-mails' */
    String name,
    /** The status for the domain */
    DomainStatus status,
    /** The sending status for the domain */
    DomainRecordsResponseSendingStatus sendingStatus,
    /** The receiving status for the domain */
    DomainStatus receivingStatus,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** The region of the domain data */
    String region) {}
