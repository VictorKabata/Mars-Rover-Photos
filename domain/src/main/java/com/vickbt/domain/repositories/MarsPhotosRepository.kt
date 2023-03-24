package com.vickbt.domain.repositories

import com.vickbt.domain.models.Photo
import com.vickbt.domain.utils.NetworkResultState
import kotlinx.coroutines.flow.Flow

interface MarsPhotosRepository {

    suspend fun fetchMarsPhotos(page: Int = 1): Flow<NetworkResultState<List<Photo>>>

}