package com.vickbt.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhotosDto(
    @SerialName("photos")
    val photosDto: List<PhotoDto>
)