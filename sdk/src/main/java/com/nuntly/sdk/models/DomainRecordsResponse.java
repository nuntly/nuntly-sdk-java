package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 * @param id The id of the domain
 * @param name The name of the domain to send e-mails'
 * @param createdAt Date at which the object was created (ISO 8601 format)
 * @param status The status for the domain
 * @param region The region of the domain data
 * @param statusAt The date of the lastest verification of this record
 * @param sending Whether sending is enabled for the domain
 * @param receiving Whether receiving is enabled for the domain
 * @param sendingStatus The sending status for the domain
 * @param sendingStatusAt The date of the latest sending status change
 * @param receivingStatus The receiving status for the domain
 * @param receivingStatusAt The date of the latest receiving status change
 * @param openTracking Emit an event for each recipient opens an email their email client
 * @param clickTracking Emit an event for each time the recipient clicks a link in the email
 * @param records The DNS records for your domain.
 */
public record DomainRecordsResponse(
    String id,
    String name,
    String createdAt,
    DomainStatus status,
    String region,
    String statusAt,
    boolean sending,
    boolean receiving,
    DomainSendingStatus sendingStatus,
    String sendingStatusAt,
    DomainReceivingStatus receivingStatus,
    String receivingStatusAt,
    boolean openTracking,
    boolean clickTracking,
    List<RecordsItem> records) {

  /**
   * @param name The name of the record.
   * @param fullname The FQDN of the domain record
   * @param recordType The type of the record: "TXT", "MX" or "CNAME"
   * @param ttl TTL (Time To Live) for this DNS record specifies the duration (in seconds)
   * @param group The group of group: "DKIM", "SPF", "MX" or "DMARC". It is useful to group the
   *     records
   * @param selector A unique identifier in DKIM record to create CNAME records for verifying domain
   *     ownership and enabling email authentication
   * @param priority Priority in a DNS record, typically used in MX (Mail Exchange) records,
   *     specifies the order in which mail servers should be used, with lower values indicating
   *     higher priority for email delivery
   * @param value The value of a DNS record is the data that the record points to
   * @param status The status of the record
   * @param statusAt The date of the lastest verification of this record
   */
  public record RecordsItem(
      String name,
      String fullname,
      DnsRecordType recordType,
      String ttl,
      DnsRecordGroup group,
      Optional<String> selector,
      Optional<String> priority,
      String value,
      DomainStatus status,
      String statusAt) {}
}
