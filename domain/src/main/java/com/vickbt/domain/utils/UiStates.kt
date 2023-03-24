package com.vickbt.domain.utils

import com.kuuurt.paging.multiplatform.PagingData
import com.vickbt.domain.models.Photo

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: PagingData<Photo>? = null
)