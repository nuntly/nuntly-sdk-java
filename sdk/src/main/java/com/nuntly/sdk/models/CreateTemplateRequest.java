package com.nuntly.sdk.models;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.templates().create(CreateTemplateRequest.builder()
 *     .name("example.com")
 *     .build());
 * }</pre>
 *
 * @param name A name for the template, shown only to your team.
 */
public record CreateTemplateRequest(String name) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;

    /** A name for the template, shown only to your team. */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public CreateTemplateRequest build() {
      return new CreateTemplateRequest(name);
    }
  }
}
