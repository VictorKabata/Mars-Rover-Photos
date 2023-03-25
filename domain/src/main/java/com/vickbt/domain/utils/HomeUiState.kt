package com.vickbt.domain.utils

import androidx.paging.PagingData
import com.vickbt.domain.models.Photo
import kotlinx.coroutines.flow.Flow

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: Flow<PagingData<Photo>>? = null
)
