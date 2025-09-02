package com.nuntly.api.errors

open class NuntlyException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
