package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
public enum TopicMembershipSource {
  @SerializedName("explicit")
  EXPLICIT("explicit"),
  @SerializedName("default")
  DEFAULT("default"),
  @SerializedName("platform_opt_out")
  PLATFORM_OPT_OUT("platform_opt_out"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  TopicMembershipSource(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static TopicMembershipSource fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
