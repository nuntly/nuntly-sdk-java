// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.errors

import com.nuntly.api.core.JsonValue
import com.nuntly.api.core.http.Headers

abstract class NuntlyServiceException
protected constructor(message: String, cause: Throwable? = null) : NuntlyException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
