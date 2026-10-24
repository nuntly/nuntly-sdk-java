package com.nuntly.sdk.models;

import java.util.Optional;

public record OrganizationUsageResponse(Email email) {

  public record Email(Daily daily, Monthly monthly) {

    /**
     * @param used Emails counted against the limit in this window: the sum of breakdown.
     * @param limit Maximum emails for this window after any per-organization adjustment. null means
     *     the window is unlimited. 0 means every transactional send is refused.
     * @param breakdown Emails counted in this window, per channel. used is the sum of all its
     *     values.
     * @param resetsAt When the daily window resets (next midnight UTC).
     */
    public record Daily(long used, Optional<Long> limit, Breakdown breakdown, String resetsAt) {

      public record Breakdown(Transactional transactional, Broadcast broadcast) {

        /**
         * @param sent Transactional emails sent
         * @param received Emails received
         */
        public record Transactional(long sent, long received) {}

        /**
         * @param sent Broadcast emails sent
         */
        public record Broadcast(long sent) {}
      }
    }

    /**
     * @param used Emails counted against the limit in this window: the sum of breakdown.
     * @param limit Maximum emails for this window after any per-organization adjustment. null means
     *     the window is unlimited. 0 means every transactional send is refused.
     * @param breakdown Emails counted in this window, per channel. used is the sum of all its
     *     values.
     * @param resetsAt When the monthly window resets (end of the billing period). null when the
     *     subscription records no period end.
     */
    public record Monthly(
        long used, Optional<Long> limit, Breakdown breakdown, Optional<String> resetsAt) {

      public record Breakdown(Transactional transactional, Broadcast broadcast) {

        /**
         * @param sent Transactional emails sent
         * @param received Emails received
         */
        public record Transactional(long sent, long received) {}

        /**
         * @param sent Broadcast emails sent
         */
        public record Broadcast(long sent) {}
      }
    }
  }
}
