package com.nuntly.api.errors

class NuntlyIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : NuntlyException(message, cause)
