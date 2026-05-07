package com.nuntly.sdk;

import java.net.http.HttpResponse;

public record ResponseWithData<T>(T data, HttpResponse<String> response) {}
