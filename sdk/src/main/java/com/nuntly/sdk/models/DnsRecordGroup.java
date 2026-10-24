package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.nuntly.sdk.OpenEnumTypeAdapterFactory;

@JsonAdapter(OpenEnumTypeAdapterFactory.class)
public enum DnsRecordGroup {
  @SerializedName("DKIM")
  DKIM("DKIM"),
  @SerializedName("SPF")
  SPF("SPF"),
  @SerializedName("MX")
  MX("MX"),
  @SerializedName("DMARC")
  DMARC("DMARC"),
  @SerializedName("MX_RECEIVING")
  MX_RECEIVING("MX_RECEIVING"),
  /** A value this SDK version does not know yet; {@link #value()} returns null. */
  UNKNOWN(null);

  private final String value;

  DnsRecordGroup(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static DnsRecordGroup fromValue(String value) {
    for (var e : values()) if (e != UNKNOWN && e.value.equals(value)) return e;
    return UNKNOWN;
  }
}
