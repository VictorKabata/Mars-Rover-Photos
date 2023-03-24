package com.vickbt.domain.repositories

import androidx.paging.PagingData
import com.vickbt.domain.models.Photo
import kotlinx.coroutines.flow.Flow

interface MarsPhotosRepository {

    suspend fun fetchMarsPhotos(page: Int = 1): Flow<PagingData<Photo>>

}