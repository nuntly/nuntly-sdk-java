package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum MessageContentQueryFormat {
  @SerializedName("html")
  HTML("html"),
  @SerializedName("text")
  TEXT("text"),
  @SerializedName("mime")
  MIME("mime");

  private final String value;

  MessageContentQueryFormat(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static MessageContentQueryFormat fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown MessageContentQueryFormat: " + value);
  }
}
