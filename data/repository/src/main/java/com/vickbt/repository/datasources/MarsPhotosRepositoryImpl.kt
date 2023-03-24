package com.vickbt.repository.datasources

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vickbt.domain.models.Photo
import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.network.ApiService
import com.vickbt.repository.paging.MarsPhotosPagingSource
import kotlinx.coroutines.flow.Flow

class MarsPhotosRepositoryImpl constructor(private val apiService: ApiService) :
    MarsPhotosRepository {

    override suspend fun fetchMarsPhotos(page: Int): Flow<PagingData<Photo>> {
        val pagingConfig = PagingConfig(
            pageSize = 30,
            enablePlaceholders = false
        )

        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { MarsPhotosPagingSource(apiService = apiService) }
        ).flow
    }

}