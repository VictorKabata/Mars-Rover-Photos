package com.vickbt.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CameraDto(
    @SerialName("full_name")
    val fullName: String,

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("rover_id")
    val roverId: Int
)