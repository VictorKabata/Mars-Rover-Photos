package com.vickbt.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**Mars Rover properties*/
@Parcelize
data class Rover(
    val id: Int? = null,
    val landingDate: String? = null,
    val launchDate: String? = null,
    val name: String? = null,
    val status: String? = null
) : Parcelable
