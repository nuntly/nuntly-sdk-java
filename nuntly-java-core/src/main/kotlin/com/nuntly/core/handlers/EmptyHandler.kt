@file:JvmName("EmptyHandler")

package com.nuntly.core.handlers

import com.nuntly.core.http.HttpResponse
import com.nuntly.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
