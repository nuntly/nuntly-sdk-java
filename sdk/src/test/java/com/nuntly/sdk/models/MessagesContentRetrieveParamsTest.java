package com.nuntly.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nuntly.sdk.NuntlyError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class MessagesContentRetrieveParamsTest {

  @Test
  void anEmptyFormatListFailsWithAClearMessage() {
    var builder = MessagesContentRetrieveParams.builder().format(List.of());

    var error = assertThrows(NuntlyError.class, builder::build);
    assertEquals("format must not be empty: leave it out to get the default.", error.getMessage());
  }

  @Test
  void aNullFormatElementFailsWithAClearMessage() {
    var builder =
        MessagesContentRetrieveParams.builder()
            .format(Arrays.asList(MessageContentQueryFormat.HTML, null));

    var error = assertThrows(NuntlyError.class, builder::build);
    assertEquals("format must not contain null.", error.getMessage());
  }

  // The check runs on the copy kept, not on the caller list, which can say anything about itself.
  @Test
  void checksTheCopyItKeeps() {
    var lying =
        new ArrayList<MessageContentQueryFormat>() {
          @Override
          public boolean isEmpty() {
            return false;
          }
        };
    var builder = MessagesContentRetrieveParams.builder().format(lying);

    assertThrows(NuntlyError.class, builder::build);
  }

  @Test
  void keepsACopyOfTheCallerList() {
    var formats = new ArrayList<>(List.of(MessageContentQueryFormat.HTML));
    var params = MessagesContentRetrieveParams.builder().format(formats).build();

    formats.add(MessageContentQueryFormat.TEXT);

    assertEquals(List.of(MessageContentQueryFormat.HTML), params.format());
  }

  @Test
  void leavingFormatOutOrListingFormatsIsAccepted() {
    MessagesContentRetrieveParams.builder().build();
    var params =
        MessagesContentRetrieveParams.builder()
            .format(List.of(MessageContentQueryFormat.HTML, MessageContentQueryFormat.TEXT))
            .build();
    assertEquals(2, params.format().size());
  }
}
