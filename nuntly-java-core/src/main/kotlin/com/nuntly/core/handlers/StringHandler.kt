@file:JvmName("StringHandler")

package com.nuntly.core.handlers

import com.nuntly.core.http.HttpResponse
import com.nuntly.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
