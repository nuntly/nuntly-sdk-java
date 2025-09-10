package com.nuntly.errors

class NuntlyInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : NuntlyException(message, cause)
