package com.vickbt.domain.models

data class ErrorResponse(
    val errorCode: String? = null,
    val errorMessage: String? = null
) : Exception()
