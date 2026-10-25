package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.nuntly.sdk.ExplicitNullTypeAdapterFactory;
import java.util.Map;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.contacts().update("ct_01kabn43yqyxn2bx4ve84mczd3", UpdateContactRequest.builder()
 *     .properties(java.util.Map.of("plan", "pro"))
 *     .build());
 * }</pre>
 *
 * @param email The contact's current address, in any letter case. The address cannot be changed: a
 *     different address is refused with the error code contact_email_immutable.
 * @param properties Contact properties keyed by name, matched exactly. A null value removes the
 *     property.
 */
public record UpdateContactRequest(
    Optional<String> email,
    @JsonAdapter(ExplicitNullTypeAdapterFactory.MapNullValues.class)
        Map<String, Object> properties) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String email;
    private Map<String, Object> properties;

    /**
     * The contact's current address, in any letter case. The address cannot be changed: a different
     * address is refused with the error code contact_email_immutable.
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /** Contact properties keyed by name, matched exactly. A null value removes the property. */
    public Builder properties(Map<String, Object> properties) {
      this.properties = properties;
      return this;
    }

    public UpdateContactRequest build() {
      return new UpdateContactRequest(Optional.ofNullable(email), properties);
    }
  }
}
