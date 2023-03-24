package com.vickbt.domain.models

/**Mars photo properties*/
data class Photo(
    val camera: Camera? = null,
    val earthDate: String? = null,
    val id: Int? = null,
    val imgSrc: String? = null,
    val rover: Rover? = null,
    val sol: Int? = null
)