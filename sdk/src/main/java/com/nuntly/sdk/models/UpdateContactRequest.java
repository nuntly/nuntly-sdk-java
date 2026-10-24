package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.nuntly.sdk.ExplicitNullTypeAdapterFactory;
import java.util.Map;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.contacts().update(UpdateContactRequest.builder()
 *     .build());
 * }</pre>
 *
 * @param email The address cannot be changed.
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

    /** The address cannot be changed. */
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
