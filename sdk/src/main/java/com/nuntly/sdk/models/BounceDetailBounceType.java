package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum BounceDetailBounceType {
  @SerializedName("Permanent")
  PERMANENT("Permanent"),
  @SerializedName("Undetermined")
  UNDETERMINED("Undetermined"),
  @SerializedName("Transient")
  TRANSIENT("Transient");

  private final String value;

  BounceDetailBounceType(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static BounceDetailBounceType fromValue(String value) {
    for (var e : values()) if (e.value.equals(value)) return e;
    throw new IllegalArgumentException("Unknown BounceDetailBounceType: " + value);
  }
}
