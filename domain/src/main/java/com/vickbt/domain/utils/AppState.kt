package com.vickbt.domain.utils

import com.vickbt.domain.models.Photo

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: List<Photo>? = null
)