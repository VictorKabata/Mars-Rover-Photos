package com.vickbt.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**Mars Rover camera properties*/
@Parcelize
data class Camera(
    val fullName: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val roverId: Int? = null
) : Parcelable
