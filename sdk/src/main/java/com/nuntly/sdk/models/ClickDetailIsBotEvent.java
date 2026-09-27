package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum ClickDetailIsBotEvent {
  @SerializedName("Likely")
  LIKELY("Likely"),
  @SerializedName("Unlikely")
  UNLIKELY("Unlikely");

  private final String value;

  ClickDetailIsBotEvent(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static ClickDetailIsBotEvent fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown ClickDetailIsBotEvent: " + value);
  }
}
