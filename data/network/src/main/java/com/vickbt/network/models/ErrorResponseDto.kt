package com.vickbt.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("error")
data class ErrorResponseDto(
    @SerialName("code")
    val errorCode: String,

    @SerialName("message")
    val errorMessage: String
)
