package com.vickbt.domain.repositories

import com.kuuurt.paging.multiplatform.PagingData
import com.vickbt.domain.models.Photo
import kotlinx.coroutines.flow.Flow

interface MarsPhotosRepository {

    suspend fun fetchMarsPhotos(page: Int = 1): Flow<PagingData<Photo>>

}