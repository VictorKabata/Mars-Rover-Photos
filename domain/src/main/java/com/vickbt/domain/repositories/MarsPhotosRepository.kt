package com.vickbt.domain.repositories

import androidx.paging.Pager
import com.vickbt.domain.models.Photo
import com.vickbt.domain.utils.NetworkResultState
import kotlinx.coroutines.flow.Flow

interface MarsPhotosRepository {

    suspend fun fetchMarsPhotos(
        page: Int = 1,
        roverName: String? = "curiosity"
    ): Flow<NetworkResultState<Pager<Int, Photo>>>
}
