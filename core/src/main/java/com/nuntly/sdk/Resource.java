package com.nuntly.sdk;

public abstract class Resource {
  protected final NuntlyClient client;

  protected Resource(NuntlyClient client) {
    this.client = client;
  }

  public <T> ResponseWithData<T> withResponse(T data) {
    return new ResponseWithData<>(data, client.lastResponse());
  }
}
