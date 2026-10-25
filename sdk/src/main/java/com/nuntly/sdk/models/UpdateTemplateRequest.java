package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.templates().update("tpl_01kabn43yqyxn2bx4ve84mczd3", UpdateTemplateRequest.builder()
 *     .name("Welcome email")
 *     .build());
 * }</pre>
 *
 * @param name A name for the template, shown only to your team.
 */
public record UpdateTemplateRequest(Optional<String> name) {

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

    public UpdateTemplateRequest build() {
      return new UpdateTemplateRequest(Optional.ofNullable(name));
    }
  }
}
