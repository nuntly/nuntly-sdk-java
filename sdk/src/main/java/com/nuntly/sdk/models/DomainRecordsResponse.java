package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;

public record DomainRecordsResponse(
    /** The id of the domain */
    String id,
    /** The name of the domain to send e-mails' */
    String name,
    /** Date at which the object was created (ISO 8601 format) */
    String createdAt,
    /** The status for the domain */
    DomainStatus status,
    /** The region of the domain data */
    String region,
    /** The date of the lastest verification of this record */
    String statusAt,
    /** Whether sending is enabled for the domain */
    boolean sending,
    /** Whether receiving is enabled for the domain */
    boolean receiving,
    /** The sending status for the domain */
    DomainRecordsResponseSendingStatus sendingStatus,
    /** The date of the latest sending status change */
    String sendingStatusAt,
    /** The receiving status for the domain */
    DomainStatus receivingStatus,
    /** The date of the latest receiving status change */
    String receivingStatusAt,
    /** Emit an event for each recipient opens an email their email client */
    boolean openTracking,
    /** Emit an event for each time the recipient clicks a link in the email */
    boolean clickTracking,
    /** The DNS records for your domain. */
    List<Map<String, Object>> records) {}
