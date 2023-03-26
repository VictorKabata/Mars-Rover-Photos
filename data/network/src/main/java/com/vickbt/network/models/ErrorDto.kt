package com.vickbt.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorDto(
    @SerialName("code")
    val errorCode: String? = null,

    @SerialName("message")
    val errorMessage: String? = null
)
