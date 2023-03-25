package com.vickbt.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**Mars photo properties*/
@Parcelize
data class Photo(
    val camera: Camera? = null,
    val earthDate: String? = null,
    val id: Int? = null,
    val imgSrc: String? = null,
    val rover: Rover? = null,
    val sol: Int? = null
) : Parcelable
