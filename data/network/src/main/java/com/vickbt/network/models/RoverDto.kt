package com.vickbt.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoverDto(
    @SerialName("id")
    val id: Int,

    @SerialName("landing_date")
    val landingDate: String,

    @SerialName("launch_date")
    val launchDate: String,

    @SerialName("name")
    val name: String,

    @SerialName("status")
    val status: String
)