package com.nuntly.sdk.models;

import java.util.List;

/**
 * @param start The start date of the stats range
 * @param end The end date of the stats range
 */
public record EmailsStatsResponse(String start, String end, List<StatsItem> stats) {

  /**
   * @param occurredOn The date of the stats
   * @param queued Number of emails queued
   * @param scheduled Number of emails scheduled
   * @param processed Number of emails processed
   * @param sending Number of emails sending
   * @param sent Number of emails sent
   * @param delivered Number of emails delivered
   * @param deliveryDelayed Number of emails whose delivery was delayed
   * @param bounced Number of emails bounced
   * @param failed Number of emails failed
   * @param rejected Number of emails rejected
   * @param canceled Number of emails canceled
   * @param complaintReceived Number of complaint received
   * @param renderingFailed Number of emails with rendering failed
   * @param opened Number of emails opened
   * @param uniqueOpened Number of unique emails opened
   * @param clicked Number of emails clicked
   * @param uniqueClicked Number of unique emails clicked
   */
  public record StatsItem(
      String occurredOn,
      long queued,
      long scheduled,
      long processed,
      long sending,
      long sent,
      long delivered,
      long deliveryDelayed,
      long bounced,
      long failed,
      long rejected,
      long canceled,
      long complaintReceived,
      long renderingFailed,
      long opened,
      long uniqueOpened,
      long clicked,
      long uniqueClicked) {}
}
