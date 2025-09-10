package com.nuntly.errors

class NuntlyIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : NuntlyException(message, cause)
