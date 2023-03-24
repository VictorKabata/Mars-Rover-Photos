package com.vickbt.repository.datasources

import com.vickbt.domain.models.Photo
import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.domain.utils.NetworkResultState
import com.vickbt.network.ApiService
import com.vickbt.repository.mappers.toDomain
import com.vickbt.repository.utils.safeApiCall
import kotlinx.coroutines.flow.Flow

class MarsPhotosRepositoryImpl constructor(private val apiService: ApiService) :
    MarsPhotosRepository {

    override suspend fun fetchMarsPhotos(page: Int): Flow<NetworkResultState<List<Photo>>> =
        safeApiCall {
            return@safeApiCall apiService.fetchMarsPhotos().map { it.toDomain() }
        }

}