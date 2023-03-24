package com.vickbt.domain.repositories

import com.vickbt.domain.models.Photo
import kotlinx.coroutines.flow.Flow

interface MarsPhotosRepository {

    suspend fun fetchMarsPhotos(page: Int = 1, roverName: String? = null): Flow<List<Photo>?>

}