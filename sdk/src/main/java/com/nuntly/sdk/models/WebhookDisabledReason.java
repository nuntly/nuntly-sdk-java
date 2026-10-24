package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
public enum WebhookDisabledReason {
  @SerializedName("manual")
  MANUAL("manual"),
  @SerializedName("auto_consecutive_failures")
  AUTO_CONSECUTIVE_FAILURES("auto_consecutive_failures"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  WebhookDisabledReason(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static WebhookDisabledReason fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
