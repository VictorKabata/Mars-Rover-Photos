package com.vickbt.repository.datasources

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.vickbt.domain.models.Photo
import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.domain.utils.NetworkResultState
import com.vickbt.network.ApiService
import com.vickbt.repository.paging.MarsPhotosPagingSource
import com.vickbt.repository.utils.safeApiCall
import kotlinx.coroutines.flow.Flow

class MarsPhotosRepositoryImpl constructor(private val apiService: ApiService) :
    MarsPhotosRepository {

    override suspend fun fetchMarsPhotos(
        page: Int,
        roverName: String?
    ): Flow<NetworkResultState<Pager<Int, Photo>>> {

        val pagingConfig = PagingConfig(pageSize = 15, enablePlaceholders = false)

        return safeApiCall {
            Pager(
                config = pagingConfig,
                pagingSourceFactory = {
                    MarsPhotosPagingSource(apiService = apiService, roverName = roverName)
                }
            )
        }

    }

}