package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ResourceTest {

  @Test
  void pathParamEncodesASegmentThatWouldReachAnotherRoute() {
    assertEquals("x%2F..%2F..%2Fsegments", Resource.pathParam("contactId", "x/../../segments"));
    assertEquals("a%3Fb%23c", Resource.pathParam("contactId", "a?b#c"));
  }

  @Test
  void pathParamEncodesASpaceAndAPercentLikeEncodeUriComponent() {
    assertEquals("a%20b%25c", Resource.pathParam("contactId", "a b%c"));
  }

  @Test
  void pathParamKeepsAnIdUnchanged() {
    assertEquals("ct_01m5dfzmcy", Resource.pathParam("contactId", "ct_01m5dfzmcy"));
  }

  @Test
  void pathParamRejectsADotSegment() {
    assertThrows(NuntlyError.class, () -> Resource.pathParam("contactId", ".."));
  }
}
