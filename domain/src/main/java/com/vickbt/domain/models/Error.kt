package com.vickbt.domain.models

data class Error(
    val errorCode: String? = null,
    val errorMessage: String? = null
) : Exception()
