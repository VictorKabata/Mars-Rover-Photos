package com.vickbt.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDto(
    @SerialName("camera")
    val cameraDto: CameraDto,

    @SerialName("earth_date")
    val earthDate: String,

    @SerialName("id")
    val id: Int,

    @SerialName("img_src")
    val imgSrc: String,

    @SerialName("rover")
    val rover: RoverDto,

    @SerialName("sol")
    val sol: Int
)