package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.nuntly.sdk.ExplicitNullTypeAdapterFactory;
import java.util.Map;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.contacts().create(CreateContactRequest.builder()
 *     .email("jane@example.com")
 *     .build());
 * }</pre>
 *
 * @param email The contact email address. Stored lowercased and trimmed.
 * @param properties Contact properties keyed by name. A null value means not supplied.
 */
public record CreateContactRequest(
    String email,
    @JsonAdapter(ExplicitNullTypeAdapterFactory.MapNullValues.class)
        Map<String, Object> properties) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String email;
    private Map<String, Object> properties;

    /** The contact email address. Stored lowercased and trimmed. */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /** Contact properties keyed by name. A null value means not supplied. */
    public Builder properties(Map<String, Object> properties) {
      this.properties = properties;
      return this;
    }

    public CreateContactRequest build() {
      return new CreateContactRequest(email, properties);
    }
  }
}
